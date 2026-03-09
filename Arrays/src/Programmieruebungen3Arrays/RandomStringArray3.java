package Programmieruebungen3Arrays;
import java.util.Random;

//AUFGABE:
//Schreibe ein Programm, das ein Array von 8 Strings erzeugt (Kein Einlesen von
//der Konsole) und die Länge jedes Strings im Array ausgibt.

public class RandomStringArray3 {

    public static void main() {
        String[] randStrings = new String[8];

        // fill with 8 random strings using my helper method
        for (int i=0; i<randStrings.length; i++) {
            randStrings[i] = getRandomString();
        }

        // print with foreach loop

        for (String str : randStrings) {
            System.out.println(str);
        }
    }

    public static String getRandomString() {
        String availableChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder str = new StringBuilder();
        Random r = new Random(); // create instance of Random

        // Loop until string length is no longer smaller than the max of 15 chars
        while (str.length() < r.nextInt(3, 16)) { // random length of the string, min = 3, max = 15 chars
            int index = r.nextInt(availableChars.length()); // get a random index, max = length of possible chars
            str.append(availableChars.charAt(index));
        }

        return str.toString();

    }
}
