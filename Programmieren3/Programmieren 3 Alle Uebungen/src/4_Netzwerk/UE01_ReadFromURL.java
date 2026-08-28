import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class UE01_ReadFromURL {
    static void main(String[] args) throws MalformedURLException {
        String path = "https://www.spacequads.com/rollerdisco";
        URL url = new URL(path);

        File file = createFileIfNotExists("src/4_Netzwerk/content.html");

        if (file == null) {
            System.err.println("Could not create content.html");
            return;
        }


        // print the content of the website
        try {
            InputStreamReader isr = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(isr);

            FileWriter fw = new FileWriter("src/4_Netzwerk/index.html");
            BufferedWriter bw = new BufferedWriter(fw);

            String line;

            while ((line = br.readLine()) != null) {
                bw.write(line);
            }

            bw.flush();
            bw.close();

            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static File createFileIfNotExists(String filePath) {
        try {
            File f = new File(filePath);
            if (f.exists()) {
                return f;
            } else {
                if (f.createNewFile()) {
                    return f;
                } else return null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
