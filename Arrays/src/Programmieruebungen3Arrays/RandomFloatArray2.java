package Programmieruebungen3Arrays;

import java.util.Random;

public class RandomFloatArray2 {
    static float[] nums = new float[10];

    public static void main() {
        fillNumsArray(nums.length); // fill array with random nums

        // print each element with a foreach loops
        for (float num : nums) {
            System.out.printf("%.2f\n",num); // print with only 2 decimal places
        }
    }

    static void fillNumsArray(int len) {
        Random r = new Random(); // initialize Random instance

        for (int i = 1; i < len; i++) {
            nums[i] = r.nextFloat(101); // insert a random float num up to 100;
        }
    }
}
