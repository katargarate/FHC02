package Programmieruebungen3Arrays;

//AUFGABE:
//Schreibe ein Programm, das ein Array von 15 Zufallszahlen zwischen 1 und 100
//erzeugt (Kein Einlesen von der Konsole) und alle Elemente, einzeln (nicht alles
//auf einmal) im Array ausgibt.

import java.util.Random;

public class RandomIntegerArrayAgain5 {
    static int[] nums = new int[15];

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
