package Programmieruebungen3Arrays;
//AUFGABE:
//Schreibe ein Programm, das ein Array von 9 Gleitkommazahlen erzeugt (Kein Einlesen von der Konsole)
// und das durchschnittliche Element im Array berechnet und ausgibt.

import java.util.Arrays;
import java.util.Random;

public class RandomFloatArrayWithAvgOutput10 {
    static float[] nums = new float[10];


    public static void main() {
        float sum  = 0;

        fillNumsArray(nums.length); // fill array with random floats

        // print each element with a foreach loops
        for (float num : nums) {
            sum += num;
        }

        System.out.println("All floats for proofing: " + Arrays.toString(nums));

        System.out.println("Average of all floats: " + sum/nums.length);
    }

    static void fillNumsArray(int len) {
        Random r = new Random(); // initialize Random instance

        for (int i = 1; i < len; i++) {
            nums[i] = r.nextFloat(101); // insert a random float num up to 100;
        }
    }


}
