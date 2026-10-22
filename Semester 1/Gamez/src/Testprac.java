import java.util.Arrays;
import java.util.Scanner;

public class Testprac {
    static Scanner sc  = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr ={4, 7, 2, 9, 1};
        int n = 10;

        printEvenNumbers();

        System.out.printf("The max number in the array was: %d\n", findMaxNum(arr));
        System.out.printf("The square of %d is %d\n", n, square(n));
        System.out.printf("There are %d even numbers in the array\n", countEvenNumbers(arr));
        System.out.printf("The min number in the array was: %d\n", findMin(arr));

        reverseANumber(1234);
        getValidInt();
        getArrayIntInput();
    }

    public static void printEvenNumbers() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println("Even");
        } else System.out.println("Odd");
    }

    public static int findMaxNum(int[] arr) {
        int max = arr[0]; // initialiaze as first num for a comparison value

        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static int square(int x) {
        return x * x;
    }

    public static int countEvenNumbers(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
        } return count;
    }

    public static void reverseANumber(int n) {
        // revers a multidigit number, e.g. 1234 -> 4321
        int rev = 0; // reversed number
        int rem; // remainder

        while (n > 0) {
            rem = n % 10;
            rev = (rev * 10) + rem;
            n = n / 10;
        }

        System.out.println("Reversed number: " + rev);
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr){
            if (num < min){
                min = num;
            }
        } return min;
    }

    public static int getValidInt() {
        int num;
        while(true) {
            System.out.print("Enter a positive integer: ");
            num = sc.nextInt();
            // if num above 0
            if (num > 0) return num;
            //otherwise:
            System.out.println("Invalid input. The number must be above 0. Please try again.");
        }
    }

    public static void getArrayIntInput() {
        int size = 5; // length of array
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Array: " + Arrays.toString(arr));

    }


}
