package Netzwerk;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {

    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
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

            // So lange wiederholen, bis dieser Client "q" eingibt
            do {
                out.write("Bitte geben Sie einen Buchstaben ein:");
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

            // Client verabschieden
            out.write("Auf Wiedersehen");
            out.newLine();
            out.flush();

            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}