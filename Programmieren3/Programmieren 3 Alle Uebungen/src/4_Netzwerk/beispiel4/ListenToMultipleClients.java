package beispiel4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
// startet eine Verbindung zum Server, hat ien Timeout nach 30 Sekunden (wenn mann 30 sekunden nichts tut, schliesst er die Verbindung)
// für jede Client wird ein Thread erstellt (in der while Schleife)
public class ListenToMultipleClients {

    // main wartet immer auf eine neue Verbindung und gibt sie dann an CommunicationTask weiter (= not my problem)
    public static void main(String[] args) {
        List<Thread> clients = new ArrayList<>();

        System.out.println("Starte Server ...");

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9090);
            serverSocket.setSoTimeout(30000); // 30 sek
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (true) {
            try {
                Socket socket = serverSocket.accept(); // Main bleibt hier hängen, solange sich einer verbindet
                Thread thread = new Thread(new CommunicationTask(socket)); // Worker Class -> Runnable implementation (gibt die Verbindung zu den einen Client weiter)
                thread.start(); // tut es in die Warteschlange rein (also indirekt aufgerufen)
                clients.add(thread);
            } catch (SocketTimeoutException e) {
                System.out.println("Server TIMEOUT"); // nach 30 Sekunden, timeout
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // joined alle Threads
        for (Thread t : clients) {
            try {
                t.join(); // wartet bis alle Clients verbunden sind
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("ENDE");
    }
}

