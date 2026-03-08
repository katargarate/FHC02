package Schleifen;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class FilesEinlesen {
    static String path = "/Users/katargarate/Faust.txt";
    static Scanner text;

    static {
        try {
            text = new Scanner(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Scanner sc = new Scanner(System.in);
    // sie = 263
    static void main() {
        System.out.print("Welches Wort wollen Sie im Dokument suchen?: ");
        String input = sc.next().toLowerCase();

        int counter = 0;

        while (text.hasNext()) {
            String word = text.next().toLowerCase();
            if (word.equals(input)) counter++;
        }

        System.out.printf("%s wurde %dx im Text gefunden.", input, counter);
    }
}
