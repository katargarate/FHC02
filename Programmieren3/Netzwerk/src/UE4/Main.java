package UE4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {

    static void main(String[] args) throws IOException {
        String serverAdresse = "bernhardfuchs.at";
        int port = 41400;

        // Verbindung zum Server herstellen
        Socket socket = new Socket(serverAdresse, port);

        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        // Zeilen vom Server lesen und ausgeben
        String zeile;
        while ((zeile = br.readLine()) != null) {
            System.out.println(zeile);
        }

        // Verbindung wieder schließen
        socket.close();
    }
}