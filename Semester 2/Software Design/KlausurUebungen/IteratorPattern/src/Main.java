import java.util.Iterator;

public class Main {
    /*
    Erzeuge eine Einkaufstasche und füge mindestens drei Artikel hinzu.
    Gib alle Artikel mithilfe einer for-Schleife aus.
    Erzeuge anschließend einen Iterator und rufe next() so oft auf,
    dass beim letzten Aufruf keine Artikel mehr vorhanden sind und die Exception ausgelöst wird
     */
    public static void main(String[] args) {
        Einkaufstasche tasche = new Einkaufstasche();
        System.out.println("--- 3 Artikel hinzufügen ---");
        tasche.addArtikel(new Artikel("Bluse", 2));
        tasche.addArtikel(new Artikel("Hose", 3));
        tasche.addArtikel(new Artikel("Haube", 4));

        Iterator<Artikel> iterator = tasche.iterator();

        System.out.println("\n--- Iterate through all articles ---");
        int counter = 1;
        while (true) {
            System.out.println("Artikel " + counter++ + ": " + iterator.next());
        }

//        iterator.next();
//        iterator.next();
//        iterator.next();
//        iterator.next();
//        iterator.next();
    }
}