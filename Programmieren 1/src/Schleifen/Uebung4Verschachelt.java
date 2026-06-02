package Schleifen;

import static Schleifen.Uebung1While.sc;

public class Uebung4Verschachelt {
    static void main() {
        //starOutput();
        //userSpecifiedOutput();
        //userSpecifiedDiamond();
        //ticTacToeFeld();
        //uebung433();
        uebung433Alt();
    }

    public static void starOutput() {
        int x = 5;

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void userSpecifiedOutput() {

        System.out.print("Enter a value you would like to see repeated: ");
        String value = sc.next();

        System.out.print("Enter how often it should be repeated: ");
        int iter = sc.nextInt();

        System.out.println();

        for (int i = 1; i <= iter; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void userSpecifiedDiamond() {

        System.out.print("Enter a value you would like to see repeated: ");
        String value = sc.next();

        System.out.print("Enter how often it should be repeated: ");
        int iter = sc.nextInt();

        System.out.println();

        for (int i = 1; i <= iter; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(value);
            }
            System.out.println();
        }

        for (int i = iter-1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(value);
            }
            System.out.println();
        }


    }

    public static void ticTacToeFeld(){
        int anz = 3;
        for (int i=1; i<=anz; i++) {
            for (int j=1; j<=anz; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }

    public static void uebung431() {
        int breite = 7;
        int hoehe = 6;
        for (int i=1; i<=hoehe; i++) {
            for (int j=1; j<=breite; j++) {
                System.out.print("0  ");
            }
            System.out.println();
        }
    }

    public static void uebung432() {
        int x = 8;

        for (int i=1; i<=x; i++) {
            for (int j=1; j<=x; j++) {
                System.out.print("S  ");
            }
            System.out.println();
        }
    }

    public static void uebung433() {
        int x = 8;

        for (int i=1; i<=x; i++) {

            for (int j=1; j<=x; j++) {

                if (i % 2 == 0) { // check if row is even
                    if (j % 2 == 0) { // check if column even
                        System.out.print("0  "); // if yes print 1
                    } else System.out.print("1  "); // if not print 0
                }

                else { // uneven rows
                    if (j % 2 == 0) {
                        System.out.print("1  ");
                    } else System.out.print("0  ");
                }
            }

            System.out.println();
            }
        }

    public static void uebung433Alt() {
        int x = 8;
        boolean bool = true;

        for (int i=1; i<=x; i++) { // rows
            for (int j=1; j<=x; j++) { // columns
               if (bool) System.out.print("0  ");
               else System.out.print("1  ");
               bool = !bool; // flip bool between each column
            }
            System.out.println();
            bool = !bool; // flip bool after each row so that the next row starts with a dif number
        }
    }

    }



