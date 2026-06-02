import java.io.*;

public class UE10 {
    // alle noten einlesen und anschließend als .txt datei speichern
    // Beispiel: PR1: 1, ALD: 1

    static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        File gradesFile = new File("grades.txt");

        FileWriter fw = new FileWriter(gradesFile);
        PrintWriter pw = new PrintWriter(fw);

        System.out.println("Noten Eingeben: ");

        String line = br.readLine(); // save user input
        int counter = 1;

        while (!line.equalsIgnoreCase("STOP")) {
            fw.write("Note " + counter++ + ": " +line + "\n"); // write user input with new line to file
            line = br.readLine(); // read next line

        }

        pw.close(); // close print writer
        br.close(); // close buffered reader

    }
}
