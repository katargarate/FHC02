package ProgrammierUebungen1;

import java.util.Scanner;

public class Eingabeaufforderung {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Name eingeben: ");
        String name = sc.next();

        System.out.print("Alter eingeben: ");
        int alter = sc.nextInt();

        String adresse = "Trattenweg 10";

         System.out.printf("Hallo, %s! Du bist %d Jahre alt.", name, alter);


        System.out.printf("Ich heiße %s und bin %d alt und wohne am %s.", name, alter, adresse);

    }
}
