package UE3Beispiel;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class WorkerThread implements Runnable {
    BufferedWriter out;

    public WorkerThread(BufferedWriter out) {
        this.out = out;
    }

    @Override
    public void run() {
        while (Thread.currentThread().isInterrupted() == false) {
            String message = Thread.currentThread().getName() + ": Ich bin ein Hintergrundthread";

            // out.write(message); // Message zum server schicken
            // out.write(System.lineSeparator());
            // out.flush();
            //System.out.println(message); // Message auf Konsole schreiben

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // Aufgabe 1)
        // verbinden zu bernhardfuchs.at und "Hallo von NAME"
        // an den Serverschreiben.

        // Aufgabe 2)
        // alle Nachrichten vom Server anzeigen
        // Aufgabe 3) Inputs von Konsole an server senden
        // Aufgabe 4) Erstellem Sie einen WorkerThread der alle 2 Sek
        // seinen Namen und "Ich bin ein Hintergrundthread" ausgibt.


        //Connecting to Server
        Socket socket = new Socket("bernhardfuchs.at", 41400);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        //Starting Thread START
        Thread t1 = new Thread(new WorkerThread(out));
        t1.start();
        //Starting Thread FERTIG

        out.write("Hallo von Kat" + System.lineSeparator());
        out.flush();
        String line;
        Scanner scanner = new Scanner(System.in);

        while ((line = in.readLine()) != null) // Alle Textnachrichten anzeigen
        {
            System.out.println(line);
            if (System.in.available() > 0) {
                out.write("Bernhard: "); //mein Name
                out.write(scanner.nextLine()); //Text von Konsole
                out.write(System.lineSeparator()); // Newline / Enter
                out.flush();
            }
        }
    }
}