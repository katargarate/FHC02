package ProgrammierUebungen1;

import java.util.Scanner;

public class ProgrammauswahlMenu {
    static Scanner sc = new Scanner(System.in);
    static void main() {
        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Reverse a string");
            System.out.println("2. Check if a number is even or odd");
            System.out.println("3. Count vowels of a string");
            System.out.println("4. Calculate Faculty");
            System.out.println("5. End Program");

            System.out.print("\nYour choice: ");

            if (!sc.hasNextInt()) { // handle non-number input
                System.out.println("Please enter a number.");
                sc.next();
                continue; // restart while loop
            }

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    reverseString();
                    break;
                case 2:
                    checkEvenOrOdd();
                    break;
                case 3:
                    countVowels();
                    break;
                case 4:
                    calculateFactorial();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return; // end program
                default:
                    System.out.println("\nInvalid input - please enter a number between 1-5.\n");
                    // no break so it continues
            }

        }

    }


    public static void reverseString() {
        System.out.print("\nString to reverse: ");
        String og = sc.nextLine();
        String reversed = "";

        // for loop goes through each char of the string and adds the char to the beginning of reversed
        for (int i = 0; i < og.length(); i++) {
            reversed = og.charAt(i) + reversed;
        }

        System.out.println("Reversed string: " + reversed);
    }


    public static void checkEvenOrOdd() {
        System.out.println("Enter a number to find out it is even or odd: ");

        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println(num + "is even!\n");
        } else System.out.println(num + "is odd!\n");
    }


    public static void countVowels() {
        System.out.print("\nEnter a string to find out how many vowels it contains: ");
        String str = sc.nextLine();

        int vowelCount = 0;

        System.out.println(str);

        // check if each char is a vowel, increment the counter if true
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'y') {
                vowelCount++;
            }
        }

        System.out.printf("\nYour string contained %d vowels.\n", vowelCount);

    }


    public static void calculateFactorial() {
        System.out.print("\nEnter an integer to calculate it's factorial: ");
        int num = sc.nextInt();

        System.out.println(); // blank line
        int factorial = 1;

        // start at the number and multiply it by the running factorial, decrease by 1 till the final loop at 1
        for (int i = num; i >= 1; i--) {
            factorial = i * factorial; // calculate
            if (i != 1){ // except for the last loop:
                System.out.print(i+"*"); // print i*
            } else System.out.print(i); // else (last loop) just print i
        }
        System.out.print("="+factorial+"\n"); // print result

    }

}
