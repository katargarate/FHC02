package UE06_Wishlist_Loesung;

public class PresentSorter {
    public void sortPresentsByDesire(Present[] presents) {
        // Beispiel mit BubbleSort

        // Äußere Schleife
        for (int j = 0; j < presents.length - 1; j++) {
            // Innere Schleife
            for (int i = 0; i < (presents.length - j - 1); i++) {
                // Tauschen
                if (presents[i].desire > presents[i + 1].desire) {
                    Present temp = presents[i];
                    presents[i] = presents[i + 1];
                    presents[i + 1] = temp;
                }
            }
        }
    }
}
