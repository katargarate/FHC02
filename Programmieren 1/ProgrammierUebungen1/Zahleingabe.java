package ProgrammierUebungen1;
import java.util.Scanner;

public class Zahleingabe {
    static void main() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("Enter a number between 1-10: ");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    System.out.println("You entered the number one.\n");
                    break;
                case 2:
                    System.out.println("You entered the number two.\n");
                    break;
                case 3:
                    System.out.println("You entered the number three.\n");
                    break;
                case 4:
                    System.out.println("You entered the number four.\n");
                    break;
                case 5:
                    System.out.println("You entered the number five.\n");
                    break;
                case 6:
                    System.out.println("You entered the number six.\n");
                    break;
                case 7:
                    System.out.println("You entered the number seven.\n");
                    break;
                case 8:
                    System.out.println("You entered the number eight.\n");
                    break;
                case 9:
                    System.out.println("You entered the number nine.\n");
                    break;
                case 10:
                    System.out.println("You entered the number ten.\n");
                    break;
                default:
                    System.out.println("Invalid input - enter a number between 1-10");
                    continue;
            }

            System.out.println("Goodbye!");
            break;
        }
    }
}
