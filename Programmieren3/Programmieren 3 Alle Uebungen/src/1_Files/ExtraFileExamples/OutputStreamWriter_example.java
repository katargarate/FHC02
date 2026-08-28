package at.campus02.pr3.fileio.textoutput;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_example {
    public static void main(String args[]) throws IOException {
        /*
        The OutputStreamWriter class works with other output streams.
        It is also known as a bridge between byte streams and character streams.
        This is because the OutputStreamWriter converts its characters into bytes.

        For example, some characters require 2 bytes to be stored in the storage.
        To write such data we can use the output stream writer that converts the character into
        corresponding bytes and stores the bytes together.
         */

        String data = "example";

        FileOutputStream file = new FileOutputStream("output.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(file);

        outputStreamWriter.write(data);
        outputStreamWriter.flush();
        outputStreamWriter.close();

    }
}
