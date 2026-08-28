import java.io.*;

public class WriteIntoFile {
    static void main(String[] args) throws IOException {
        File file = new File("src/1_Files/file-to-write-into.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        //writeIntoFileWithoutBufferedWriter(file);
        writeIntoFileWithBufferedWriter(file);
    }

    // Without the buffered writer, every time we  write, we're sending it to the file
    public static void writeIntoFileWithoutBufferedWriter(File file) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("Hello World");
        pw.close();
    }

    // With the Buffered Writer we can write multiple strings and the flush (actually send it and clear the buffer) all at the end
    public static void writeIntoFileWithBufferedWriter(File file) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);
        BufferedWriter bw = new BufferedWriter(pw);

        bw.write("Hello World");
        bw.newLine();
        bw.write("I'm writing this using a buffered writer");
        bw.newLine();

        bw.flush();
        bw.close();
    }
}
