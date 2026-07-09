package P3_SortPhotoAlbums;

public class Sorter {

    public void sortPhotoAlbums(PhotoAlbum[] photoAlbums)
    {
        // TODO: FIX
        // Äußere Schleife (gleich lang wie alle ELemente)
        for (int n = 0; n < photoAlbums.length-1; n++) {
            boolean wasSwapped = false;
            boolean doSwap = false;

            // Innere Schleife (- äußere Iteration - 1)
            for (int i = 0; i < photoAlbums.length - n - 1; i++) {
                // wenn aktuelles größer ist als der nächste, tauschen
                if (photoAlbums[i].getYear() > photoAlbums[i + 1].getYear()) {

                    doSwap = true;
                }

                // wenn beide das gleiche Jahr haben:
                else if (photoAlbums[i].getYear() == photoAlbums[i + 1].getYear()) {
                    // wenn der aktuelle einen größeren Monat hat, tauschen:
                    if (photoAlbums[i].getMonth() > photoAlbums[i + 1].getMonth()) {
                        doSwap = true;
                    }
                }

                if (doSwap) {
                    PhotoAlbum temp = photoAlbums[i]; // akt. zwischenspeichern
                    photoAlbums[i] = photoAlbums[i + 1]; // anderer hier rein speichern
                    photoAlbums[i + 1] = temp; // den temp im Array in die nächste Stelle rein speichern
                    wasSwapped = true;
                }
            }

            // wenn in diese Iteration nichts getauscht wurde, heißt das, dass alles schon fertig sortiert ist
            // also können wir komplett abbrechen
           if (!wasSwapped) {
               break; // fertiggggg
           }
        }
    }

    public void sortPhotoAlbumsAlt(PhotoAlbum[] photoAlbums)
    {

        // Äußere Schleife (gleich lang wie alle ELemente)
        for (int n = 0; n < photoAlbums.length - 1; n++) {
            // Innere Schleife (- äußere Iteration - 1)
            for (int i = 0; i < photoAlbums.length - n - 1; i++) {
                boolean swap = false;
                PhotoAlbum currAlbum = photoAlbums[i];
                PhotoAlbum nextAlbum = photoAlbums[i+1];

                // wenn aktuelles größer ist als der nächste, tauschen
                if (currAlbum.getYear() > nextAlbum.getYear()) {
                    swap = true;
                }

                // wenn beide das gleiche Jahr haben, und der aktuelle einen größeren Monat hat:
                else if (currAlbum.getYear() == nextAlbum.getYear() &&
                        currAlbum.getMonth() > nextAlbum.getMonth()) {
                      swap = true;
                }

                // am Ende der Iteration, wenn swap auf True gesetzt wurde, Albums tauschen
                if (swap) {
                    // wenn man wie hier extra Variable hat (nextALbum, currAlbum), braucht man kein temp
                    photoAlbums[i] = nextAlbum;
                    photoAlbums[i + 1] = currAlbum;
                }
            }
        }
    }
}
