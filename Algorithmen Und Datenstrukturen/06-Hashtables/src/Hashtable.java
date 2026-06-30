public class Hashtable {
    int size = 100;
    int[] socialSecurityArray = new int[size];

    // bei Hashtables sollen wir dann den Index ausrechnen

    public void add(int socialSecurityNo) {
        // Hashfunktion ausrechnen
        int index = socialSecurityNo % size;
        // 1234010190 = 90
        // 1234323445 = 45

        // dort dann speichern
        socialSecurityArray[index] = socialSecurityNo;
    }


    // dadurch, dass wir einfach die Stelle ausrechnen können, müssen wir nicht mehrere Positionen
    // durchgehen, um den richtigen Ergebnis zu finden
    public int search (int searchedSocialSecurityNo) {
        // Hashfunktion ausrechnen
        int index = searchedSocialSecurityNo % size;

        System.out.printf("\nIndex von %d wäre: %d\n", searchedSocialSecurityNo, index);

        // Wert gleich so zurückgeben
        return socialSecurityArray[index];
    }


}


