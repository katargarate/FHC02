package Netzwerk;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainMultiClients {

    public static void main(String[] args) {
        System.out.println("Hallo, hier ist das Netzwerk-Projekt");

        try {
            // ServerSocket öffnet Port 8787
            ServerSocket serverSocket = new ServerSocket(8787);

            // Server läuft so lange, bis das Programm beendet wird
            while (true) {

                // Warten, bis sich ein Client verbindet
                Socket socket = serverSocket.accept();

                System.out.println("Ein Client hat sich verbunden.");

                // Für jeden Client einen eigenen Thread erstellen
                ClientThread clientThread = new ClientThread(socket);
                clientThread.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
