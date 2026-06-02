package Programmieruebungen3Arrays;


//AUFGABE:
//Schreibe ein Programm, das ein Array von 10 Strings erzeugt (Kein Einlesen von der Konsole)
// und diejenigen Strings im Array ausgibt, die mit einem bestimmten Buchstaben beginnen.

import java.util.Arrays;
import java.util.Scanner;

public class StringArrayFilterByStart7 {
    static String[] randStrs = new String[10];
    static Scanner sc = new Scanner(System.in);

    public static void main() {

        // fill with 10 strings using my helper method
        String[] namen = {"Anna", "Ana", "Hanna", "Hannah", "Banana", "Osama", "Panama", "Ohana", "Alabama", "Lasama"};


        System.out.print("Mit welche Erstbuchstabe soll gefiltert werden?: ");
        String input = sc.next().toUpperCase();

        char search = input.charAt(0); // save char as first index of input string (in case user enters multiple chars)


        System.out.print("Mit welche Erstbuchstabe soll gefiltert werden?: ");
        String sp = sc.nextLine();


        System.out.printf("\nAlle Strings die mit %s anfangen:\n", search);
        for (String name : namen) {
            if (name.startsWith(String.valueOf(search))) {
                System.out.println(name);
            }
        }

        System.out.println("\nAlle Strings zum Prüfen:\n" + Arrays.toString(namen));
    }





}
