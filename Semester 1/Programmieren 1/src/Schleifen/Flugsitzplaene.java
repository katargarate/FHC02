package Schleifen;

import static Schleifen.Uebung1While.sc;

public class Flugsitzplaene {
    static void main() {
        while(true) {
            System.out.println("\nMenu: \n1.A380\n2.B380\n3.Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            System.out.println();

            if (choice == 1 || choice == 2) {
                for (int i = 1; i <= 50; i++) {
                    if (i == 13 || i == 17) continue;
                    if (choice == 1 && i >= 20) break;
                    System.out.println("Reihe " + i);
                }
            }
            else if (choice == 3) break;

            else System.out.println("Ungueltige Eingabe.");

        }
    }
}
