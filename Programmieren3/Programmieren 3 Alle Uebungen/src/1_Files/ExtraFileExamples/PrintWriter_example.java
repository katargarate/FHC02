package at.campus02.pr3.fileio.textoutput;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_example {
    /*
    print() Method
        print() - prints the specified data to the writer
        println() - prints the data to the writer along with a new line character at the end

    // Creates a PrintWriter using some character encoding
    PrintWriter output = new PrintWriter(String file, boolean autoFlush, Charset cs);
        Note: The PrintWriter class also has a feature of auto flushing.
            This means it forces the writer to write all data to the destination if
            one of the println() or printf() methods is called.

            BufferedWriter is more efficient if you have multiple writes between flush/close the writes are small compared with the buffer size.
PrintWriter just exposes the print methods on any Writer in character mode.
     */

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("neue_datei_18mai.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        // Mittels println(...) werden Zwei Zeilen geschrieben. Jede Zeile wird richtig abgeschlosen.
        printWriter.println("FirstLine");
        printWriter.println("SecondLine");
        printWriter.print(1);
        printWriter.print(2);
        printWriter.println();
        printWriter.format("This is a %s program with %d", "Hello World", 100);
        // printWriter.printf()

        // flush() löst das Schreiben aus
        // Flushing a stream ensures that all data that has been written
        // to that stream is output, including clearing any that may have been buffered.
        printWriter.flush();
        // close() gibt die Datei wieder frei
        printWriter.close();
        System.out.println("Fertig");

    }
}
