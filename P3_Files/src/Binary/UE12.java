package Binary;

import java.io.*;

public class UE12 {

    static void readBinaryFile() throws IOException {
        File file = new File("campus02-test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        int byteRead; // really saved as a byte

        while ((byteRead = fileInputStream.read()) != -1){
            char[] ch = Character.toChars(byteRead); // char array with each byte that is read
            System.out.println("Char: " +ch[0] + " - als Byte: " + byteRead); // print the first byte of the char array
        }
    }

    static void main(String[] args) throws IOException {
        File file = new File("campus02-test.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        pw.append("Hello World!\rThis is a test file for binary reading.");
        pw.close();

        readBinaryFile();
    }
}
