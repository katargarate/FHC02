import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        EinfacheFernbedienung fb = new EinfacheFernbedienung();
//        Licht licht1 = new Licht();
//        LichtAnKommando lk = new LichtAnKommando(licht1);
//
//        // Kommando zuweisen
//        fb.setKommando(lk);
//
//        // Knopf drücken
//        fb.knopfGedrueckt();

        //System.out.println("---TV SIMPLE");
        //TVSimple();

        System.out.println("TV mit Kommando");
        TVMitKommando();
    }

    public static void TVSimple() {
        TV tv  = new TV();
        tv.toggleTV();

        tv.kanalErhoehen();
        tv.kanalErniedrigen();
        tv.kanalErniedrigen();
    }

    public static void TVMitKommando() {
        TV tv = new TV();
        KanalRaufKommando rauf = new KanalRaufKommando(tv);
        KanalRunterKommando runter = new KanalRunterKommando(tv);

        Fernbedienung fb = new Fernbedienung();
        fb.setKommando(1, rauf);
        fb.setKommando(2, runter);

        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("\nFunktion wählen (1: Kanal rauf | 2: Kanal Runter | 0: Exit): ");
            int auswahl;

            try {
                auswahl = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Bitte nur Zahlen eingeben.");
                sc.nextLine();
                continue;
            }

            if (auswahl == 0) {
                System.out.println("Wird abgebrochen...");
                break;
            }

            if (auswahl != 1 && auswahl != 2 ) {
                System.out.println("Bitte entweder 1 oder zwei eingeben.");
                continue;
            }

            fb.knopfGedrueckt(auswahl);

        } while (true);

    }
}