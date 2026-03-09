package Programmieruebungen3Arrays;
import java.util.Random;

// AUFGABE:
//Schreibe ein Programm, das ein Array von 10 Ganzzahlen erzeugt und diese
//anschließend, Element für Element (nicht alles auf einmal), in der Konsole ausgibt.

public class RandomIntArray1 {
    static int[] nums = new int[10];

    public static void main() {
        fillNumsArray(); // fill array with random nums

        // print each element with a foreach loops
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static void fillNumsArray() {
        Random r = new Random(); // initialize Random instance

        for (int i = 1; i < nums.length; i++) {
            nums[i] = r.nextInt(101); // insert a random num up to 100;
        }
    }
}
