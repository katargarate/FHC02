import Models.Teilnehmer;

public class TeilnehmerMain {
    static void main() {
        Teilnehmer t1 = new Teilnehmer("kat", 26);

        t1.hatFrageGestellt();

        System.out.println("Gestellte Fragen: "+ t1.rueckgabeFragenCounter());

        // 5 Fragen "stellen"
        for (int i = 0; i <5; i++) {
            t1.hatFrageGestellt();
        }

        // noch mals die Anzahl der gestellten Fragen ausgeben
        System.out.println("Gestellte Fragen: "+ t1.rueckgabeFragenCounter());


        System.out.println("\nTeilnehmer Info bevor Adresse zugewiesen wurde:");
        t1.teilnehmerInfo();

        // Adresse zuweisen
        t1.setAdresse("Teilnehmerweg 10, 8010 Graz");
        t1.setAlter(30); // Alter updaten


        System.out.println("\nTeilnehmer Info inkl. Adresse:");
        t1.teilnehmerInfo();

    }

}
