package Schleifen;

import java.util.Scanner;

public class Uebung2DoWhile {
    static Scanner sc = new Scanner(System.in);

    static void main() {
        part2Refined();
    }
    public static void part1() {

        String input;
        String pword ="geheim";

        do {
            System.out.print("Enter your password: ");
            input = sc.next();
        } while (!input.equals(pword));


        System.out.println("\nCorrect password!");
    }

    public static void part2() {
        int counter = 0;
        boolean exit = false;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Espresso");
            System.out.println("2 - Verlängerter");
            System.out.println("3 - Cappuccino");
            System.out.println("0 - Beenden");

            System.out.print("\nWahl: ");
            int wahl = sc.nextInt();


            switch (wahl) {
                case 1:
                    System.out.println("\nDer Espresso wird zubereitet.");
                    counter++;
                    break;
                case 2:
                    System.out.println("\nDer Verlängerter wird zubereitet.");
                    counter++;
                    break;
                case 3:
                    System.out.println("\nDer Cappuccino wird zubereitet.");
                    counter++;
                    break;
                case 0:
                    System.out.print("\nSicher? (j|n): ");
                    String x = sc.next().toLowerCase();

                    if (x.equals("j")) {
                        exit = true; // to end do-while
                        break;
                    } else if (!x.equals("n")) { // invalid
                        System.out.println("Ungültiger Auswahl, trink einfach mal noch einen Kaffee.");
                    } else { // back to menu
                        System.out.println("Okay, ein Kaffee geht ja noch.");
                        continue;
                    }

                default:
                    System.out.println("\nUngültiger Auswahl");

            }
        } while(!exit);

        // Output total coffees:
        System.out.println("\nInsgesamt konsumierte Kaffee: " + counter);

        }

    public static void part2Refined() {
        int counter = 0;
        boolean exit = false;

        do {
            switch (runMenu()) {
                case 1:
                    counter = runAction("Espresso", counter);
                    break;
                case 2:
                    counter = runAction("Verlaengerter", counter);
                    break;
                case 3:
                    counter = runAction("Cappuccino", counter);
                    break;
                case 0:
                    System.out.print("\nSicher? Y/N: ");
                    String input = sc.next().toUpperCase();

                    if (input.equals("Y")) {
                        exit = true; // to end do-while
                    } else if (!input.equals("N")) { // invalid
                        System.out.println("Ungültiger Auswahl, trink einfach mal noch einen Kaffee.");
                    } else { // back to menu
                        System.out.println("Okay, ein Kaffee geht ja noch.");
                        continue;
                    } break;

                default:
                    System.out.println("\nUngültiger Auswahl");

            }
        } while(!exit);

        // Output total coffees:
        System.out.println("\nInsgesamt konsumierte Kaffee: " + counter);
    }

    public static int runAction(String coffee, int counter) {
        System.out.println("\nDer " + coffee + " wird zubereitet.");
        return counter +1;
    }

    public static int runMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Espresso");
        System.out.println("2 - Verlängerter");
        System.out.println("3 - Cappuccino");
        System.out.println("0 - Beenden");

        System.out.print("\nWahl: ");

        return sc.nextInt();
    }
    }

