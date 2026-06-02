package Programmieruebungen3Arrays;

import java.util.Random;

//AUFGABE:
//Schreibe ein Programm, das ein Array von 20 Ganzzahlen erzeugt (Kein Einlesen
//von der Konsole) und nur die geraden Zahlen im Array ausgibt.

public class RandomArrayWithEvenOutput6 {
    static int[] nums = new int[20];

    public static void main() {
        fillNumsArray(); // fill array with random nums

        // print each even integer with a foreach loops
        for (int num : nums) {
            if (num % 2 == 0) System.out.println(num);
        }

    }

    public static void fillNumsArray() {
        Random r = new Random(); // initialize Random instance

        for (int i = 1; i < nums.length; i++) {
            nums[i] = r.nextInt(300); // insert a random num, max 300
        }

    }
}
