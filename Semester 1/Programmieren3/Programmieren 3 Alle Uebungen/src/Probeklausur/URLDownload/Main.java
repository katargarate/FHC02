package URLDownload;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    static void main(String[] args) {
        try {
            URL url = new URL("https://www.spacequads.com/rollerdisco");
            File file = new File("src/Probeklausur/URLDownload/content.html");

            if (!file.exists()) {
                file.createNewFile();
            }

            InputStreamReader isr = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(isr);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

            String line;

            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine(); // wichtig für die Zeilenumbrüche
            }

            bw.close();
            br.close();


        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
