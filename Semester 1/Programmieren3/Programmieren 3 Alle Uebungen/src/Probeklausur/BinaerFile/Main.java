package BinaerFile;

import java.io.*;

import static java.lang.System.out;

public class Main {
    static void main(String[] args) throws IOException {
        //TODO: neue datei "hallo.txt" öffnen
        // folgender Binärzahl in die Datei reinschreiben: 43 (Dezimal), in Hex: 0x2B
        // Dieses Zeichen zoll 20-mal in die Datei geschrieben werden.

        File file = new File("src/Probeklausur/BinaerFile/hallo.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream out = new FileOutputStream(file);

        for (int i = 0; i < 20; i++) {
            out.write(43);
            // out.write(0x2B);
        }

        out.close();


    }
}
