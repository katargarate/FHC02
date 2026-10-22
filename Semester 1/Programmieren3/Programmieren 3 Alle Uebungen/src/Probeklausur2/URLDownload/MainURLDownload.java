package URLDownload;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MainURLDownload {
    static void main(String[] args) throws IOException {
        File file = new File("src/Probeklausur2/URLDownload/content.html");
        URL url = new URL("https://orf.at/");

        InputStreamReader isr = new InputStreamReader(url.openStream());
        BufferedReader br = new BufferedReader(isr);

        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);

        int lineCounter = 0;

       try {
           if (!file.exists()) {
               file.createNewFile();
           }
       } catch (IOException e) {
           System.err.println("File could not be created: " + e.getMessage());
           return;
       }

        System.out.println("Hole Daten von ORF.at..");
        System.out.println("Output Datei ist hier: " + file.getAbsolutePath());

        String line;
        while ((line = br.readLine()) != null) {

            //Linie ausgeben und Counter erhöhen
            System.out.printf("Zeile %d: %s\n", lineCounter++, line);

            // Linie in die Datei reinschreiben
            bw.write(line);
            bw.newLine();
            bw.flush();

        }

        System.out.println("Fertig!");


    }
}
