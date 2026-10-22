import java.io.*;
import java.nio.charset.StandardCharsets;

public class UE14_BinaryOutput {
    static void main(String[] args) throws IOException {
//        withBufferedOutputStream();
//        withFileOutputStream();
//        withPrintStream();
    }

    // Faster/more efficient for many writes because it uses a buffer
    public static void withBufferedOutputStream() throws IOException {
        File file = new File("test.neu");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        // The BufferedOutputStream temporarily stores the data in a buffer instead of writing every small piece directly to the file.
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        // convert the string into UTF-8 Bytes and write those bytes into the buffer
        bufferedOutputStream.write("Hello World".getBytes(StandardCharsets.UTF_8));

        // get the correct line separator for the OS (e.g. "\n" on macOS/Linux or "\r\n" on Windows).
        // Convert it to UTF-8 bytes and write it into the buffer.
        bufferedOutputStream.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
        bufferedOutputStream.write("New - line".getBytes(StandardCharsets.UTF_8));

        // Make sure everything currently stored in the buffer
        // is actually written to the file.
        bufferedOutputStream.flush();

        bufferedOutputStream.close();

    }

    // Simple, low-level, good for writing bytes
    public static void withFileOutputStream() throws IOException {

        // Create the file
        File file = new File("test-output.txt");

        // Open the file for writing
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        // Text we want to write
        String outputText = "Hello File - first output";

        // Go through each character and write it to the file
        for (char c : outputText.toCharArray()) {
            fileOutputStream.write(c);
        }

        // Write any remaining data to the file
        fileOutputStream.flush();

        // Close the stream
        fileOutputStream.close();
    }

    // Very easy for writing text; print()/println() are convenient
    public static void withPrintStream() throws IOException {

        // Text we want to write
        String data = "das ist ein Test";

        // Create a PrintStream for the file
        PrintStream output = new PrintStream("test.txt");

        // Write the text
        output.print(data);

        // Write buffered data to the file
        output.flush();

        // Close the stream
        output.close();
    }
}
