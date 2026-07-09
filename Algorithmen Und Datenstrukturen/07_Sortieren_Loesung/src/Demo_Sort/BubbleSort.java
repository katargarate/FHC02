package Demo_Sort;

public class BubbleSort {

    public void sort(int[] array)
    {
        boolean tausch = false;
        // Schleife für Durchläufe
        for (int n = 0; n < (array.length-1); n++)
        {
            tausch = false;
            // Vergleiche innerhalb eines Durchlaufs
            for (int i = 0; i < (array.length-1-n); i++) {
                // Vergleich, ob Tausch notwendig ist
                if (array[i] > array[i + 1]) {
                    // Tauschvorgang
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    tausch = true;
                }
            }
            // Kein Tauschvorgang im Durchlauf, deshalb abbrechen
            if (tausch == false)
                break;
        }
    }

}
