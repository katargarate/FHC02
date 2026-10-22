package ProgrammierUebungen1;

import java.util.Scanner;

public class Eingabeaufforderung {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Name eingeben: ");
        String name = sc.next();

        System.out.print("Alter eingeben: ");
        int alter = sc.nextInt();

        System.out.printf("Hallo, %s! Du bist %d Jahre alt.", name, alter);

    }
}
