import java.io.*;
import java.util.Scanner;

public class UE15 {
    /*
    Lesen Sie Zeichen für Zeichen von der Konsole ein und schreiben Sie die einzelnen Bytes in eine Datei.
    Von der Konsole kann mittels System.in.read() ein Zeichen gelesen werden
    Brechen Sie ab, wenn ein ‘x‘ eingegeben wird
     */
    static void main(String[] args) throws IOException {
        File file = new File("console_byte_input.txt");

        FileOutputStream fos = new FileOutputStream(file, true);

        char c;

        do {
            c =  (char) System.in.read();
            System.out.println("READ: " + c);
            fos.write(c);
        } while (c != 'x');

        fos.flush();
        fos.close();
    }
}
