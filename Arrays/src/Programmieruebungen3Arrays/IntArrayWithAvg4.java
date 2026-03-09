package Programmieruebungen3Arrays;

import java.util.Random;

public class IntArrayWithAvg4 {
    static int[] nums = new int[12];

    public static void main() {
        fillNumsArray(); // fill array with random nums
        int sum = 0;

        // print each element with a foreach loops
        System.out.println("Array of Random Integers: ");
        for (int num : nums) {
            System.out.println(num);
            sum += num;
        }

        // print average of all the numbers
        System.out.println("\nArray Average: " + sum/nums.length);
    }

    private static void fillNumsArray() {
        Random r = new Random(); // initialize Random instance

        for (int i = 1; i < nums.length; i++) {
            nums[i] = r.nextInt(101); // insert a random num up to 100;
        }
    }
}
