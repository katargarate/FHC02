package Netzwerk;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    // Port wird mit new ServerSocket(8787) geöffnet.
    // Der Server wartet dann auf eine eingehende Verbindung (mit serverSocket.accept())
    // Ports: 0 – 65535

    private ArrayList<Thread> clients = new ArrayList<Thread>();

    static void main(String[] args) {
        System.out.println("Hallo, heir ist das Netzwerk-Projekt");

        try {
            // ServerSocket öffnet Port 8787 und wartet auf Clients
            ServerSocket serverSocket = new ServerSocket(8787);

            // accept() wartet, bis sich ein Client verbindet
            Socket socket = serverSocket.accept();

            System.out.println("Ein Client hat sich verbunden.");

            // Daten zum Client schicken
            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            // Daten vom Client empfangen
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Client begrüßen
            out.write("Hallo Client!");
            out.newLine();
            out.flush();

            String eingabe;

            // So lange wiederholen, bis der Client "q" eingibt
            do {
                // Client auffordern, einen Buchstaben einzugeben
                out.write("Bitte geben Sie einen Buchstaben ein: ");
                out.flush();

                eingabe = in.readLine().trim();

                if (eingabe.equalsIgnoreCase("h")) {
                    out.write("Das ist die Hilfe");
                    out.newLine();
                    out.flush();
                }

                else if (!eingabe.equalsIgnoreCase("q")) {
                    out.write("Fehler - Entweder q oder h eingeben.");
                    out.newLine();
                    out.flush();
                }

            } while (!eingabe.equalsIgnoreCase("q"));

            // Wenn "q" eingegeben wurde
            out.write("Auf Wiedersehen");
            out.newLine();
            out.flush();

            // Socket + Server schließen
            socket.close();
            serverSocket.close();

            System.out.println("Ende des Netzwerk-Projekts");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}