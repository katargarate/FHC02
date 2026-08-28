package at.campus02.pr3.fileio.textoutput;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class OutputStreamWriter_example2 {
    public static void main(String args[]) {

        try {
            // Creates an output stream
            FileOutputStream file = new FileOutputStream("output.txt");

            // Creates an output stream reader with default encoding
            OutputStreamWriter output1 = new OutputStreamWriter(file);

            // Creates an output stream reader specifying the encoding
            OutputStreamWriter output2 = new OutputStreamWriter(file, Charset.forName("UTF8"));

            // Returns the character encoding of the output stream
            System.out.println("Character encoding of output1: " + output1.getEncoding());
            System.out.println("Character encoding of output2: " + output2.getEncoding());

            // Closes the reader
            output1.close();
            output2.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}

