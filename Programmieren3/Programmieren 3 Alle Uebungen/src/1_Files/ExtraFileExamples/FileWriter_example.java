package at.campus02.pr3.fileio.textoutput;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_example {
    public static void main(String args[]) {
        String data = "This is the data in the output file";

        try {
            // Creates a FileWriter
            FileWriter fileWriter = new FileWriter("neue_datei_18mai.txt");
            fileWriter.write(data);
            // Writes the string to the file
            fileWriter.flush();
            // Closes the writer
            fileWriter.close();
            System.out.println("File created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
