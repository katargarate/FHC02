import Models.Hund;

import java.util.Scanner;

public class HundMain {
    static void main() {

        Hund tessa = new Hund("Tessa", 7, "Mudi", "schwarz-grau");

        tessa.hundInfo();
        System.out.println();
        // Boolean übergeben and Methode und Nachricht ausgeben lassen
        tessa.stoeckchenBringen(hundKannAbfragen());
    }

    public static boolean hundKannAbfragen() {
        Scanner sc = new Scanner(System.in);
        boolean hundKann;

        while (true) {
            System.out.print("Kann Ihr Hund Stöckchen bringen? J/N: ");
            String input = sc.next().toUpperCase();

            if (input.equals("J")) {
                hundKann = true;
                break;
            }
            else if (input.equals("N")) {
                hundKann = false;
                break;
            }
            else System.out.println("Ungueltige Eingabe. Versuchen Sie es nochmals.");
        }

        return hundKann;

    }

}
