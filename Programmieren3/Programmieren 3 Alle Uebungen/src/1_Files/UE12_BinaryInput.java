import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class UE12_BinaryInput {

    public static void main(String[] args) throws IOException {
        File file = new File("src/1_Files/new-file-to-inspect.txt");
        // FileInputStream stellt eine Verbindung zur Datei her. Datei wird geöffnet.
        FileInputStream fileInputStream = new FileInputStream(file);
        // Für Optimierung der Performance -> BufferedInputStream
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        // read() liefert Byte for Byte aus der Datei. Wenn das Ende erreicht ist, dann liefert die Methode -1 als Ergebnis.
        // While-Schleife liest somit Zeichen um Zeichen aus.
        int byteRead;
        int i = 1;
        while ((byteRead = bufferedInputStream.read()) != -1) {
            System.out.println("Zeichen Nr. " + i + ": "
                    + byteRead + " als char: '" + (char) byteRead + '\'');
            i++;
        }
        // close() gibt die Datei wieder frei.
        bufferedInputStream.close();
    }

}