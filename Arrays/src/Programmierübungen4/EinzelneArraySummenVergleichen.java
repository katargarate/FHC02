package Programmierübungen4;

import java.util.Arrays;


public class EinzelneArraySummenVergleichen {


    static void main() {
        int[][] arrSame = {{2, 5, 3, 2}, {6, 4, 2}, {2, 10}, {2, 2, 2, 6}};
        int[][] arrDifferent = {{2, 4, 3, 2}, {6, 3, 2}, {2, 10}, {2, 2, 2, 6}};

        System.out.println("Array mit die gleichen Summen:\n");
        printArrays(arrSame);
        int[] sumsSame = getArraySums(arrSame);
        printResultMessage(sumsSame);

        System.out.println("\n--------------------------------------\n");

        System.out.println("Array mit unterschiedliche Summen:\n");
        printArrays(arrDifferent);
        int[] sumsDifferent= getArraySums(arrDifferent);
        printResultMessage(sumsDifferent);

    }

    private static void printResultMessage(int[] sums) {
        if (compareArraySums(sums)) {
            System.out.println("Die Summen aller 4 eindimensionalen Arrays sind dieselbe");
        } else {
            System.out.println("Die Summen aller 4 eindimensionalen Arrays sind NICHT dieselbe");
        }
    }

    public static int[] getArraySums(int[][] arr) {
        int[] sums = new int[arr.length]; // initialize array to hold sums of each array

        for (int i = 0; i < arr.length; i++) {
            sums[i] = calculateArraySum(arr[i]); // calculate the sum of the array and save it in the sums array
        }

        return sums; // return the array filled with the sums
    }

    public static boolean compareArraySums(int[] sums) {
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] != sums [0]) {
                return false;
            }
        }
        return true; // if they were all the same, return true;
    }

    public static int calculateArraySum(int[] oneArray) {
        int sum = 0;

        // calculate sum of each individual 1d array
        for (int num : oneArray) {
            sum +=num;
        }

        return sum;
    }

    public static void printArrays(int[][] arr) {
        for (int row[] : arr) {
            for (int num : row) {
                System.out.printf("%d  ", num);
            }
            System.out.printf("= %d",calculateArraySum(row));
            System.out.println();
        }
    }

}
