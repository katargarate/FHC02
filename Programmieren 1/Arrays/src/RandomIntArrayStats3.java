import java.util.Arrays;
import java.util.Random;


public class RandomIntArrayStats3 {
    static int[] nums = new int[10];

    static void main() {
        // fill array with random Numbers
        fillNumsArray();

        // initialize calc. variable at 0
        int sum = 0;
        int min = 0;
        int max = 0;

        // loop through the array and find all the values
        for (int num : nums) {
            sum += num; // running sum
            if (num < min) min = num; // check for min
            if (num > max) max = num; // check for max
        }

        // Output all the info
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Sum: " + sum);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Average: " + sum/nums.length);

    }


    private static void fillNumsArray() {
        Random r = new Random(); // initialize Random instance

        for (int i = 1; i < nums.length; i++) {
           nums[i] = r.nextInt(21); // insert a random num up to 20;
        }
    }


}
