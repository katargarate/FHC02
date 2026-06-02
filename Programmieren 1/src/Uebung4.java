import java.util.Scanner;

public class Uebung4 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        // speed input
        System.out.print("Geschwindigkeit in km/h: ");
        int geschwindigkeit = sc.nextInt();

        int strafe = 0;

        // if speed above 50, calculate fine; output result to user
        if (geschwindigkeit > 50) {
            strafe = speedStrafeBerechnen(geschwindigkeit);
            System.out.println("Geschwindigkeitsüberschreitungsstrafe: €" + strafe);
        } else {
            System.out.println("Keine Strafe!");
        }

        // alcohol level input
        System.out.print("\nAlkoholpegel eingeben: ");
        double promille = sc.nextDouble();

        // calculate alc fine and output result to user
        int alcStrafe = alcStrafeBerechnen(promille);
        System.out.printf("Alc Strafe: €%d", alcStrafe);

        int gesamteStrafe = alcStrafe + strafe; // calc. total of speed and alc fines
        System.out.printf("\n\nSumme beide Strafen: €%d", gesamteStrafe);


        // month input for possible fine discount
        System.out.print("\n\nAktueller Monat eingeben: ");
        String monat = sc.next();

        // calculate applicable discount
        System.out.println("Bekommen Sie heuer ein Rabatt?");
        double ermaessigterPreis = rabattRechnen(monat, gesamteStrafe);

        // output final price (made up of speed fine, alc fine, and discount)
        System.out.printf("\nGesamte Strafe: €%.2f",ermaessigterPreis);

    }

    public static int speedStrafeBerechnen(int geschwindigkeit) {
        int ueberschreitung = geschwindigkeit - 50;
        int strafe = 0;

        if (ueberschreitung <= 10) {
            System.out.println("Schriftliche Verwarnung");
        } else if (ueberschreitung <= 20) {
            strafe = 30;
        } else if (ueberschreitung <= 30) {
            strafe = 50;
        } else if (ueberschreitung <= 50) {
            strafe = 100;
        } else if (ueberschreitung <= 100) {
            strafe = 500;
        } else strafe = 1500;

        return strafe;
    }

    public static int alcStrafeBerechnen(double promille) {
        int strafe = 0;

        if (promille <= 0.5) {
            System.out.println("Alles in Ordnung.");
        } else if (promille <= 1.0) {
            strafe = 50;
        } else if (promille <= 2.0) {
            strafe = 100;
        } else strafe = 2500;

        return strafe;
    }


    public static double rabattRechnen(String monat, double strafe) {
        switch (monat.toLowerCase()) {
            case "jaenner", "februar":
                System.out.println("Nein. Heuer keine Rabatte möglich");
                break;
            case "maerz", "april":
                System.out.println("Ja. 10% Rabatt auf die gesamte Strafe");
                strafe = strafe * 0.9;
                break;
            case "mai", "juni":
                System.out.println("Ja. 15% Rabatt auf die gesamte Strafe");
                strafe = strafe * 0.85;
                break;
            case "juli", "august":
                System.out.println("Ja. 20% Rabatt auf die gesamte Strafe");
                strafe = strafe * 0.8;
                break;
            case "september", "oktober":
                System.out.println("Ja. 25% Rabatt auf die gesamte Strafe");
                strafe = strafe * 0.75;
                break;
            case "november", "dezember":
                System.out.println("Ja. 30% Rabatt auf die gesamte Strafe");
                strafe = strafe * 0.7;
                break;
            default:
                System.out.println("Nein. Kein gültiges Monat - kein Rabatt möglich.");
                break;
        }
        return strafe;
    }

}
