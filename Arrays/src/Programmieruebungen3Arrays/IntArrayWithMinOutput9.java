package Programmieruebungen3Arrays;
//AUSGABE:
//Schreibe ein Programm, das ein Array von 6 Ganzzahlen erzeugt (Kein Einlesen
//von der Konsole!) und das kleinste Element im Array findet und ausgibt.

import java.util.Arrays;
import java.util.Random;

public class IntArrayWithMinOutput9 {
    static int[] nums = new int[6];
    static int min = 0;

    public static void main() {
        fillNumsArray();
        System.out.println("Smallest Number: " + min);

        System.out.println("All Numbers for Proofing: " + Arrays.toString(nums));
    }

    private static void fillNumsArray() {
        Random r = new Random(); // initialize Random instance

        for (int i = 1; i < nums.length; i++) {
            int num = r.nextInt(100) + 1; // insert a random num up to 100;
            nums[i] = num;
            if (num < min) min = num; // replace min with num, if its smaller than min
        }
    }
}
