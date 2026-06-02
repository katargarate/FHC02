package Binary;

import java.io.*;

public class UE13 {
    static void readBinaryFile() throws IOException {
        File file = new File("campus02-test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        int byteRead; // really saved as a byte
        int counter = 0;
        int counterMinusWhiteSpace = 0;

        while ((byteRead = fileInputStream.read()) != -1){
            char[] ch = Character.toChars(byteRead); // char array with each byte that is read
            System.out.print(ch[0]); // print the first byte of the char array
            counter++;
            if (!Character.isWhitespace(ch[0])) {
                counterMinusWhiteSpace++;
            }
        }

        System.out.println("\nTotal chars: " + counter);
        System.out.println("Total chars (excluding whitespace): " + counterMinusWhiteSpace);
    }

    static void writeBinaryFile() throws IOException {
        File file = new File("test-output.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        String outputTest = "hello File - first output";
        for (char ch : outputTest.toCharArray()) {
            fileOutputStream.write(ch);
        }

        fileOutputStream.close();
    }

    static void main(String[] args) throws IOException {
        File file = new File("campus02-test.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        pw.append("Hello World! This is a test file for binary reading.");
        pw.close();

        readBinaryFile();
        writeBinaryFile();
    }

}
