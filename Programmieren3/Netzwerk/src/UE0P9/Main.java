package UE0P9;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    static void main(String[] args) throws IOException {
        //readFromHardcodedURL();
        //readFromInputtedURL();
        readPathFromFile();

    }

    static void readFromInputtedURL() throws IOException {
        // Pfad einlesen
        System.out.print("Enter URL: ");
        String path = new Scanner(System.in).next();

        try {
            // URL mit Pfad erstellen
            URL myURL = new URL(path);
            myURL.openConnection().getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(myURL.openStream()));

            // Output Datei
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("content.html")));

            // In der Konsole ausgeben und in die Datei reinschreiben
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line + "\n"); // in die Datei reinschreiben
            }

            bw.flush();
            bw.close();
        }  catch (MalformedURLException e) {
            System.out.println("Invalid URL");
        }


    }

    static void readPathFromFile() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("path-file.txt")));
        String path = br.readLine();

        URL myURL = new URL(path);

        InputStreamReader isr = new InputStreamReader(myURL.openStream());
        BufferedReader br2 = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(new FileWriter("content-from-file-url.html"));

        String line;
        // Linie pro Linie ausgeben
        while ((line = br2.readLine()) != null) {
            System.out.println(line);
            bw.write(line + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void readFromHardcodedURL() throws IOException {
        URL myURL = new URL("https://www.spacequads.com/rollerdisco");
        myURL.openConnection().getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(myURL.openStream()));

        // Output Datei
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("inputtedLinkContent.html")));

        // In der Konsole ausgeben und in die Datei reinschreiben
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            bw.write(line + "\n"); // in die Datei reinschreiben
        }

        bw.flush();
        bw.close();
    }
}
