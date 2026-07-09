package Binary;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PrintStreamUebung {

    static void main(String[] args) throws IOException {
        String data = "das ist ein Test";


        BufferedOutputStream bufferedOutput = new BufferedOutputStream(new FileOutputStream("printstream_test.txt"));

        // turn the string into a byte array and write them into the file
        byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
        bufferedOutput.write(bytes);
        bufferedOutput.close();

    }
}
