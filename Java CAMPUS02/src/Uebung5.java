import java.util.Scanner;

public class Uebung5 {
    static Scanner sc = new Scanner(System.in);


    static void main() {
        switchMethode();
        ifMethode();

    }

    public static void switchMethode() {

        System.out.print("Monat eingeben: ");
        String monat = sc.next().toLowerCase();

        // enhanced switch to assign days depending on the given month
        int tage = switch (monat) {
            case "september","april","juni", "november" -> 30;
            case "jaenner", "maerz", "mai", "juli", "august", "oktober", "dezember" -> 31;
            case "februar" -> 28;
            default -> {
                System.out.println("Ungueltiges Monat");
                yield 0;
            }
        };
        if (tage != 0) System.out.printf("Laut switch Methode hat %s %d Tage.\n\n", monat, tage);
    }

    public static void ifMethode(){
        int tage;

        System.out.print("\nMonat eingeben: ");
        String monat = sc.next().toLowerCase();

        if (monat.equals("jaenner") || monat.equals("maerz") || monat.equals("mai") || monat.equals("juli")
                || monat.equals("august") || monat.equals("oktober") || monat.equals("dezember")) {
            tage = 31;
        } else if (monat.equals("september") || monat.equals("april") || monat.equals("juni") || monat.equals("november")) {
            tage = 30;
        } else if (monat.equals("februar")) {
            tage = 28;
        } else {
            System.out.println("Ungueltiges Monat");
            return;
        }

        System.out.printf("Laut if Methode, hat %s %d Tage.\n\n", monat, tage);
    }
}
