public class Zahlverarbeiter {

    static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println("Methode liefereSumme: " + liefereSumme(nums));
        System.out.println("Methode liefereMax: " + liefereMax(nums));
        System.out.println("Methode liefereMin: " + liefereMin(nums));
        System.out.println("Methode liefereMittelWert: " + liefereMittelwert(nums));
    }

    public static int liefereSumme(int[] arr) {
        int summe = 0; // bei 0 initialisieren;
        for (int num : arr) {
            summe += num; // bei jeder Iteration wird der aktuelle num zur Summe addiert
        }
        return summe; // fertig gerechnete Summe zurückschicken
    }

    public static int liefereMax(int[] arr) {
        // mit den ersten zahl des Arrays initialisieren, damit wir gleich eine Vergleichzahl haben
        int max = arr[0];

        for (int num : arr) {
            if (num > max) { // wenn die nummer größer als das aktuelle Maximum ist:
                max = num; // ersetze max
            }
        } return max;
    }

    public static int liefereMin(int[] arr) {
        // mit den ersten zahl des Arrays initialisieren, damit wir gleich eine Vergleichszahl haben
        int min = arr[0];

        for (int num : arr) {
            if (num < min) { // wenn die nummer kleiner als das aktuelle Minimum ist:
                min = num; // ersetze min
            }
        } return min;
    }

    public static double liefereMittelwert(int[] arr) {
        // muss zu double umgewandelt werden, sonst wird es als int berechnet und es wird runtergerundet
        return (double) liefereSumme(arr) / arr.length;
    }
}
