package UE0P9;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main2 {
    static void main(String[] args) throws IOException {
        // readFromhardcodedURL();
        //readFromURLInFile();
        readFromUserInputtedFilePath();
    }

    public static void readFromhardcodedURL() throws IOException {
        URL myURL = new URL("https://www.spacequads.com/rollerdisco");

        myURL.openConnection().getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(myURL.openStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("content.html")));


        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line); // line in der Konsole ausgeben
            bw.write(line + "\n"); // line in der Datei schreiben

        }

        bw.flush();
        bw.close();
    }

    public static void readFromURLInFile() throws IOException {
        File file = new File("src/UE0P9/urlPath.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String URLPathFromFile = br.readLine();

        URL fileURL = new URL(URLPathFromFile);
        InputStreamReader isr = new InputStreamReader(fileURL.openStream());

        BufferedReader br2 = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("contentFromFileURL.html")));

        String line;

        while ((line = br2.readLine()) != null) {
            System.out.println(line); // line in der Konsole ausgeben
            bw.write(line + "\n"); // line in der Datei schreiben
        }

        bw.flush();
        bw.close();
    }

    public static void readFromUserInputtedFilePath() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the path to the file: ");
        String filePath =  sc.nextLine().trim();

        try {
            URL myURL = new URL(filePath);
            myURL.openConnection().getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(myURL.openStream()));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("content-from-user-path-input.html")));


            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // line in der Konsole ausgeben
                bw.write(line + "\n"); // line in der Datei schreiben

            }

            bw.flush();
            bw.close();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
