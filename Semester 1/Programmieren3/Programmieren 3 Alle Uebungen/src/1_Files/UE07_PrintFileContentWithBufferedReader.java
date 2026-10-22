import java.io.*;

public class UE07_PrintFileContentWithBufferedReader {

    static void main(String[] args) {
        File file = new File("src/1_Files/new-file-to-inspect.txt");
        printFileContentWithBufferedReader(file);
    }

    public static void printFileContentWithBufferedReader(File file) {

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;

            if (br.readLine() == null) {
                System.out.println("File is empty");
                return;
            }

            // so long as there's a line to read, iterate through the file and print the line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // close the buffered reader and the file reader
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
