package Uebungsbeispiel;

import java.io.*;
import java.net.Socket;

/*
 * ÄHNLICHES BEISPIEL, ABER NICHT IDENTISCH - für Referenz/Copy-Paste in der Prüfung.
 *
 * Unterschied zum Chat-Programm:
 * - Hintergrundthread zählt hier NICHT die Dateigröße, sondern eine gemeinsame Variable
 *   (Nachrichten-Counter) -> zeigt "synchronized" / Thread-safety, was im Chat-Beispiel
 *   nicht vorkommt.
 * - Beenden funktioniert hier über eine "volatile boolean" Flag statt Thread.interrupt().
 *   -> Zwei verschiedene Arten, einen Thread "freundlich" zu stoppen. Beide Varianten
 *      solltest du kennen, weil unterschiedliche Angaben unterschiedliche Lösungen verlangen.
 *
 * Grundstruktur (Socket, BufferedReader/Writer, File-Logging, Schleife mit ready())
 * ist bewusst gleich geblieben, weil DAS die Technik ist, die in der Prüfung wahrscheinlich
 * wieder drankommt.
 */
public class MainUEBUNG {

    // "volatile" = alle Threads sehen sofort den aktuellen Wert dieser Variable
    // (wichtig bei Variablen, die von mehreren Threads gelesen/geschrieben werden)
    private static volatile boolean running = true;

    // gemeinsamer Zähler, den Main-Thread UND Hintergrundthread benutzen
    // -> deshalb "synchronized" beim Zugriff (siehe MessageCounter Klasse unten)
    private static final MessageCounter counter = new MessageCounter();

    public static void main(String[] args) throws IOException, InterruptedException {

        // Verbindung zum Server aufbauen
        Socket socket = new Socket("bernhardfuchs.at", 41400);
        System.out.println("Verbunden mit Server!");

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter serverOutput = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Logfile
        File logfile = new File("uebung_logfile.txt");
        logfile.createNewFile(); // legt Datei an, falls nicht vorhanden, tut nichts falls sie existiert
        FileWriter logWriter = new FileWriter(logfile);

        // Hintergrundthread starten - gibt alle 5 Sek. aus, wie viele Nachrichten insgesamt
        // empfangen wurden (nicht Dateigröße wie im anderen Beispiel!)
        Thread counterThread = new Thread(new MessageCounterThread(counter));
        counterThread.start();

        // Label, damit wir aus beiden Schleifen auf einmal rausspringen können
        aussen:
        while (running) {

            // --- User Input prüfen ---
            while (userInput.ready()) {
                String line = userInput.readLine();

                // Abbruchbedingung ZUERST prüfen, bevor irgendwas gesendet wird!
                if (line.equalsIgnoreCase("stop")) {
                    System.out.println("Stop-Befehl erkannt, beende Programm...");
                    running = false; // Flag umschalten -> äußere while-Schleife stoppt beim nächsten Check
                    break aussen;    // sofort aus beiden Schleifen raus
                }

                serverOutput.println(line);
                serverOutput.flush(); // ohne flush() bleibt der Text evtl. im Buffer hängen und wird nie geschickt
                System.out.println("---> GESENDET: " + line);
                logWriter.write("---> GESENDET: " + line + "\n");
                logWriter.flush();
            }

            // --- Server Input prüfen ---
            if (serverInput.ready()) {
                // NUR EINMAL readLine() aufrufen und in Variable speichern!
                // (Wenn man readLine() zweimal aufruft, blockiert der zweite Aufruf,
                //  weil ready() nur eine Zeile garantiert - klassischer Bug, siehe Chat-Beispiel)
                String received = serverInput.readLine();
                System.out.println("<--- EMPFANGEN: " + received);
                logWriter.write("<--- EMPFANGEN: " + received + "\n");
                logWriter.flush();

                counter.increment(); // gemeinsamen Zähler erhöhen (thread-safe, siehe Klasse unten)
            }

            Thread.sleep(1000); // CPU nicht unnötig belasten
        }

        // Hintergrundthread sauber stoppen und warten bis er wirklich fertig ist
        counterThread.interrupt();
        counterThread.join(); // wartet, bis der Thread sich beendet hat, bevor main() weitermacht

        // Aufräumen
        logWriter.close();
        serverOutput.close();
        serverInput.close();
        socket.close();

        System.out.println("Programm sauber beendet.");
    }
}