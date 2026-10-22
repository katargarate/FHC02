package FileHandling;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void main(String[] args) throws IOException {
        File file;
        try {
            file = new File("src/Probeklausur2/FileHandling/hallo.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            System.out.println("Datei erfolgreiche erstellt/gefunden.");

            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Hallo Zeile1");
            bw.newLine();
            bw.write("Hallo Zeile2");

            bw.close();

        } catch (IOException e) {
            System.err.println("Fehler beim Erstellen der Datei");
            e.printStackTrace();
            return;
        }

        Scanner sc = new Scanner(System.in);
        int awaitedInput = 33;
        int input;
        boolean correctNumberEntered = false;

        do {
            System.out.print("Geben Sie eine nummer ein: ");

            try {
                input = sc.nextInt();

                if (input == awaitedInput) {
                    correctNumberEntered = true; // von der Schleife ausbrechen
                }

            } catch (InputMismatchException e) {
                System.out.println("Bitte geben Sie eine nummer ein, keine andere Zeichen erlaubt:");
                sc.nextLine(); // buffer clearen
            }
        }
        while (!correctNumberEntered);

        // nachdem 33 eingegeben wurde:
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        System.out.println("hallo.txt Inhalt:");
        String line;
        // Alle Linien von der Datei in die Konsole ausgeben
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
