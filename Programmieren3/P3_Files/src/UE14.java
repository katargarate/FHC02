import java.io.*;

public class UE14 {
    static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("ue14-output.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        String outputTest = "hello File - first output";
        for (char ch : outputTest.toCharArray()) {
            fileOutputStream.write(ch);
        }

        fileOutputStream.close();

        FileInputStream  fileInputStream = new FileInputStream(file);
        int byteRead; // really saved as a byte

        while ((byteRead = fileInputStream.read()) != -1){
            char[] ch = Character.toChars(byteRead); // char array with each byte that is read
            System.out.print(ch[0]); // print the first byte of the char array
            Thread.sleep(1000);
        }

        fileInputStream.close();
    }
}
