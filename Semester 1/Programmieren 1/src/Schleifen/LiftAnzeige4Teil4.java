package Schleifen;

import static Schleifen.Uebung1While.sc;

public class LiftAnzeige4Teil4 {

    static void main() {
        runMenu();
    }

    public static void runMenu() {
        while(true) {
            boolean house = true;
            System.out.println("\nMenu:\n1. House\n2. Skyscraper\n3. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) house = true;
            else if (choice == 2) house = false;
            else if (choice == 3) break;
            else System.out.println("Invalid input - try again");

            displayFloors(house);
        }
    }

    public static void displayFloors(boolean house) {
        for (int i = 0; i <= 68; i++) {

            // go to next iteration if on one of these floors
            if (i == 10 || i == 19 || i == 28 || i == 36 || i == 55) continue;

            // if house = true, and we're above 4, break the loop
            if (house && i > 4) break;

            System.out.println("Floor: " + i);
        }
    }



}
