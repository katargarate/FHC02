package UE06_Wishlist;

public class Wishlist {
    public static void main(String[] args) {
        Present[] presents = {
                new Present("Schokolade", 4),
                new Present("Buch", 5),
                new Present("Schuhe", 6),
                new Present("Handy", 1),
                new Present("Dinner für 2", 2),
                new Present("Urlaub", 3),
                new Present("Fahrrad", 7),
                new Present("Tasche", 8)
        };

        PresentSorter sorter = new PresentSorter();
        sorter.sortPresentsByDesire(presents);

        // Soll Geschenke sortiert nach "desire" von 1..8 ausgeben.
        for (Present p: presents) {
            System.out.println(p.description + " (" + p.desire + ")");
        }
    }
}
