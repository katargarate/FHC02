import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Zeit_von_Time_Server {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        final String DEFAULT_TIME_SERVER = "time.nist.gov"; //"ptbtime1.ptb.de";
        final SimpleDateFormat DATUMFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Zeitserver zählt ab 1900, Java ab 1970
        final long SEKUNDEN_1900_1970 = 2208988800L;

        Socket so = null;
        InputStream in = null;
        long time = 0;

        try {
            // Verbindung zum Time-Server über Port 37 herstellen
            so = new Socket("time.nist.gov", 37);
            in = so.getInputStream();

            // Die Zeit wird vom Server als 4 Bytes übertragen
            for (int i = 3; i >= 0; i--) {
                // Bytes an die richtige Position verschieben und zusammensetzen
                time ^= (long) in.read() << i * 8;
            }

            // Sekunden seit 1900 in Millisekunden seit 1970 umrechnen
            System.out.println(DATUMFORMAT.format(
                    new Date((time - SEKUNDEN_1900_1970) * 1000)
            ));

        } catch (Exception ex) {
            // Fehler ausgeben, falls die Verbindung oder Übertragung fehlschlägt
            System.out.println(ex);

        } finally {
            // Verbindungen wieder schließen
            if (in != null) try { in.close(); } catch (IOException ex) {/*ok*/}
            if (so != null) try { so.close(); } catch (IOException ex) {/*ok*/}
        }
    }
}