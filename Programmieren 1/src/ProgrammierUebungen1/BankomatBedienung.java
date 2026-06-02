package ProgrammierUebungen1;
import java.util.Scanner;

public class BankomatBedienung {
    static Scanner sc = new Scanner(System.in);

    static void main() {
        System.out.print("Enter your balance: €");
        double balance = sc.nextDouble();

        int choice;

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");

            if (!sc.hasNextInt()) { // handle non-number input
                System.out.println("Please enter a number.");
                sc.next();
                continue; // restart while loop
            }

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    balance = deposit(balance);
                    break;
                case 2:
                    balance = withdraw(balance);
                    break;
                case 3:
                    System.out.printf("\nYour current balance is %.2f\n", balance);
                    break;
                case 4:
                    System.out.println("\nGoodbye!\n");
                    return; // end program
                default:
                    System.out.println("\nInvalid input - please enter a number between 1-4.\n");
                    // no break so it continues
            }
        }

    }

    public static double deposit(double balance) {
        System.out.print("\nAmount to deposit: €");
        double amount = sc.nextDouble();

        balance = balance + amount;

        System.out.printf("\n€%.2f will be deposited.\n", amount);
        System.out.printf("\nNew balance: €%.2f\n", balance);

        return balance;
    }


    public static double withdraw(double balance) {
        System.out.print("\nAmount to withdraw: €");
        double amount = sc.nextDouble();
        balance = balance - amount;

        System.out.printf("\n€%.2f will be withdrawn.\n", amount);
        System.out.printf("\nNew balance: €%.2f\n", balance);

        return balance;
    }


}
