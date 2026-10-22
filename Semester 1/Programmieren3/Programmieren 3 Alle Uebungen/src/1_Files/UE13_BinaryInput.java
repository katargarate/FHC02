import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class UE13_BinaryInput {

    public static void main(String[] args) throws IOException {
        File file = new File("src/1_Files/new-file-to-inspect.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        int byteRead;
        int counter = 0;
        while ((byteRead = bufferedInputStream.read()) != -1) {
            System.out.print((int) byteRead + " ");
            counter++;

            // Whitespaces nicht mitzählen
            if (Character.isWhitespace((char) byteRead)) {
                counter--;
            }
        }
        bufferedInputStream.close();
        System.out.println();
        System.out.println("Anzahl der eingelesenen Zeichen: " + counter);
    }
}