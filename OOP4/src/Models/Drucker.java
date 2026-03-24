package Models;

import java.util.Scanner;

public class Drucker {
    static void main() {

        drucken("Hello"); // string
        drucken(2); // int
        drucken(2.5); // double
        drucken(2.5 > 3); // boolean

    }

    // Drucken einer Zeichenkette
    private static String drucken(String str) {
        System.out.println(str);
        return str;
    }


    // Drucken eines Ints
    private static int drucken(int x) {
        System.out.println(x);
        return x;
    }


    // Drucken eines Doubles
    private static double drucken(double x) {
        System.out.println(x);
        return x;
    }

    // Drucken eines Booleans
    private static boolean drucken(boolean b) {
        System.out.println(b);
        return b;
    }
}
