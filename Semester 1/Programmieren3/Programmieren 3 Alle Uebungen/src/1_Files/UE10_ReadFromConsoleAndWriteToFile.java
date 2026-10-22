import java.io.*;

public class UE10_ReadFromConsoleAndWriteToFile {
    static void main(String[] args) throws IOException {
        File file = new File("src/1_Files/noten_von_der_konsole.text");

        if (!file.exists()) {
            file.createNewFile();
        }

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        System.out.println("Enter your grades like this: subject - grade.");

        String line = br.readLine();
        while (line != null && !line.equalsIgnoreCase("STOP")) {
            // write the line into the file
            pw.println(line);
            // read next line
            line = br.readLine();
        }

        br.close();
        pw.close();
    }
}
