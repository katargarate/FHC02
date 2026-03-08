package practice;
import java.util.Scanner;

public class calculator {
    static Scanner sc = new Scanner(System.in);

    static void main() {
        do {
            System.out.println("\nCalculator Menu");
            System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Exit");
            System.out.print("\nYour choice: ");

            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    addition();
                    break;
                case 2:
                    subtraction();
                    break;
                case 3:
                    multiplication();
                    break;
                case 4:
                    division();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice - try again.");
            }
            System.out.println();
        } while (true);
    }

    public static double getDouble(int iter) {
        while (true) {
            System.out.printf("Enter %d. number: ", iter);
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            }
            System.out.print("Invalid number - try again\n");
            sc.next(); //  clear buffer
        }
    }


    public static void addition() {
        double x = getDouble(1);
        double y = getDouble(2);

        System.out.printf("\n%f + %f = %f", x,y,x+y);

    }


    public static void subtraction() {
        double x = getDouble(1);
        double y = getDouble(2);

        System.out.printf("\n%f - %f = %f", x,y,x-y);
    }

    public static void multiplication() {
        double x = getDouble(1);
        double y = getDouble(2);

        System.out.printf("\n%f * %f = %f", x,y,x*y);
    }

    public static void division() {
        double x = getDouble(1);
        double y = getDouble(2);

        System.out.printf("\n%f / %f = %f", x,y,x/y);
    }
}
