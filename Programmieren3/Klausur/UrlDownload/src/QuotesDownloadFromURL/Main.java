package QuotesDownloadFromURL;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        String url = "https://quotes.toscrape.com/";
        URL quotesURL = new URL(url);

        File quotesFile = new File("src/QuotesDownloadFromURL/content.html");


        try {
            // Wenn die Datei noch nicht vorhanden ist, versuchen wir es zu erstellen
            if (!quotesFile.exists()) {
                if (quotesFile.createNewFile()) {
                    System.out.println("File created: " + quotesFile.getAbsolutePath());
                } else throw new IOException("File could not be created");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        writeContentIntoFileAndOntoConsole(quotesURL, quotesFile);

    }

    public static void writeContentIntoFileAndOntoConsole (URL url, File file) {
        int lineCounter = 0;

        try {
            InputStreamReader isr = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(isr);

            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.println("Hole Daten von toscrape.com...");

            String line;
            // alles Zeilenweise auslesen von der Seite
            while ((line = br.readLine()) != null) {
                // Konsolenausgabe + Counter erhöhen
                System.out.printf("Zeile %d: %s\n", lineCounter++, line);

                // in die Datei reinschreiben inkl. Zeilenumbrüche und jedes Mal flushen
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            // äußerte Reader/Writer schließen
            bw.close();
            br.close();

            System.out.println("Fertig!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}