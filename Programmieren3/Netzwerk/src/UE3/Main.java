package UE3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main() throws IOException {
        get_time_as_string();

//        final SimpleDateFormat DATUMFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        // Zeitserver zählt ab 1900, Java ab 1970
//        final long SEKUNDEN_1900_1970 = 2208988800L;
//
//        long time = 0;
//
//        Socket so = null;
//        InputStream in = null;
//
//        try {
//            // Verbindung zum Time-Server über Port 37 herstellen
//            so = new Socket("time-a.timefreq.bldrdoc.gov", 37);
//            in = so.getInputStream();
//
//            // Die Zeit wird als 4 Bytes übertragen und zusammengesetzt
//            for (int i = 3; i >= 0; i--) {
//                time ^= (long) in.read() << i * 8;
//            }
//
//            // Sekunden seit 1900 in Millisekunden seit 1970 umrechnen
//            System.out.println(DATUMFORMAT.format(
//                    new Date((time - SEKUNDEN_1900_1970) * 1000)
//            ));
//
//        } catch (Exception ex) {
//            // Fehlermeldung ausgeben
//            System.out.println(ex);
//
//        } finally {
//            // InputStream und Socket schließen
//            if (in != null) try { in.close(); } catch (IOException ex) {/*ok*/}
//            if (so != null) try { so.close(); } catch (IOException ex) {/*ok*/}
//        }
    }

    public static void get_time_as_string() throws IOException {
        Socket socket = new Socket("time-a.timefreq.bldrdoc.gov", 13);
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String zeile;
        while ((zeile = br.readLine()) != null) {
            System.out.println(zeile);
        }
    }
}