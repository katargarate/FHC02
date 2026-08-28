import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class UE03_Get_Time_As_String {
    static void main(String[] args) {
        String serverAdresse = "time-a.timefreq.bldrdoc.gov";
        int port = 13;

        try (Socket socket = new Socket(serverAdresse,port)) {
            // Der Socket soll höchstens 10 Sekunden auf Daten warten.
            // Dadurch bleibt das Programm nicht unbegrenzt hängen, wenn der Server nicht antwortet.
            socket.setSoTimeout(10_000);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            System.out.println("Die Verbindung zum Zeitserver wurde hergestellt.");
            System.out.print("Aktuelle Zeit vom Server: ");

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (SocketTimeoutException e) {
            System.out.println("Zeitüberschreitung: Der Server antwortet nicht.");
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Server: " + e.getMessage());
        }
    }
}
