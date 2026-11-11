package at.campus02.zam.sd.bsp3;

import java.util.ArrayDeque;
import java.util.Queue;

public class Warteschlange {
    private Queue<Auftrag> auftraege = new ArrayDeque<>();

    public void hinzufuegen(Auftrag a) {
        auftraege.add(a);
    }

    public void abarbeiten() {
        System.out.printf("Warteschlange: %d Aufträge\n\n", auftraege.size());

        // solange die Warteschlange nicht leer ist, werden die Aufträge abgearbeitet
        if (!auftraege.isEmpty()) { // wenn empty, dann wird gleich zur Ausgabe übersprungen
            while(!auftraege.isEmpty()) {
                Auftrag a = auftraege.poll();
                a.ausfuehren();
            }
        }

        System.out.println("Nichts zu tun.");
    }
}
