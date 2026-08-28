package Abschlussbeispiel;

import java.io.*;
import java.net.Socket;

public class MainABSCHLUSS {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket chatSocket = new Socket(
                "bernhardfuchs.at", 41400);

        System.out.println("Verbunden mit Server!");

        // Reader für Input von der Konsole (User tippt hier)
        BufferedReader userInput = new BufferedReader(
                new InputStreamReader(System.in)
        );
        // Writer zum Chat-Server (schickt Daten raus)
        PrintWriter chatOutput = new PrintWriter(
                new OutputStreamWriter(chatSocket.getOutputStream())
        );
        // Reader VOM Chat-Server (empfängt Daten)
        BufferedReader chatInput = new BufferedReader(
                new InputStreamReader(chatSocket.getInputStream())
        );

        // WICHTIG: Pfad muss wirklich existieren, sonst crasht createNewFile() mit IOException.
        // Vorher war der Pfad "src/4_Netzwerk/Abschlussbeispiel/logfile.txt" -> Ordner gibt's nicht -> Crash beim Start.
        // Einfach relativ zum Projektordner ablegen:
        File logfile = new File("logfile.txt");
        logfile.createNewFile(); // legt Datei an, falls sie noch nicht existiert
        FileWriter logfileWriter = new FileWriter(logfile);

        // Hintergrundthread starten, der alle 5 Sek. die Dateigröße ausgibt
        Thread logfilesizeThread = new Thread(new MyFilesizeThread(logfile));
        logfilesizeThread.start();

        // Label für die äußere Schleife, damit wir mit "break aussen;" aus BEIDEN Schleifen springen können
        aussen:
        while (true) {

            // --- USER INPUT PRÜFEN ---
            String userInputString = "";
            while (userInput.ready()) {
                userInputString = userInput.readLine();

                // Check auf "ende" JETZT, BEVOR irgendwas gesendet/geschrieben wird!
                // Vorher wurde "ende" zuerst verschickt und erst danach geprüft -> Aufgabe 4 war nicht erfüllt.
                if (userInputString.equalsIgnoreCase("ende")) {
                    System.out.println("USER HAT ENDE EINGEGEBEN; BEENDE ALLES.");
                    System.out.println("Beende logfilesizeThread...");
                    logfilesizeThread.interrupt(); // Thread höflich stoppen (siehe InterruptedException im Thread)
                    System.out.println("ChatProgramm beendet sich.");
                    break aussen; // raus aus BEIDEN Schleifen, nicht nur der inneren
                }

                // normaler Text -> an Chat senden, auf Konsole zeigen, in Logfile schreiben
                chatOutput.println("---> DATEN GESENDET VON USER: " + userInputString);
                System.out.println("---> DATEN GESENDET VON USER: " + userInputString);
                chatOutput.flush(); // sofort rausschicken, nicht im Buffer hängen lassen
                logfileWriter.write("---> DATEN GESENDET VON USER: " + userInputString + "\n");
                logfileWriter.flush();
            }

            // --- CHAT INPUT PRÜFEN ---
            if (chatInput.ready()) {
                // FEHLER VORHER: readLine() wurde 2x aufgerufen (einmal für System.out, einmal für logfileWriter).
                // ready() garantiert aber nur EINE verfügbare Zeile -> der zweite readLine() Aufruf blockiert
                // und wartet ewig auf eine neue Zeile vom Server -> ganzes Programm hängt/"macht nichts mehr".
                // FIX: einmal lesen, in Variable speichern, Variable 2x verwenden.
                String chatLine = chatInput.readLine();
                System.out.println("<--- DATEN VON CHAT: " + chatLine);
                logfileWriter.write("<--- DATEN VON CHAT: " + chatLine + "\n");
                logfileWriter.flush();
            }

            Thread.sleep(1000); // kurz warten, damit die Schleife nicht die CPU auffrisst
        }

        // Aufräumen: alles schön schließen, bevor das Programm endet
        logfileWriter.close();
        chatOutput.close();
        chatInput.close();
        chatSocket.close();
    }
}