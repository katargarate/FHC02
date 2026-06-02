package UE7FIles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static void main(String[] args) throws IOException {
        File file = new File("a.txt");
        //file.createNewFile();

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        int lineCounter = 0;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println("Zeile " + ++lineCounter + ": " + line);
        }

        System.out.println("Bytes read: " + file.length());

        bufferedReader.close(); // tells fileReader to close too, dont have to close them all
    }
}
