package Uebungsbeispiel;

public class MessageCounter {

    private int count = 0;

    // synchronized = nur ein Thread kann diese Methode gleichzeitig ausführen
    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}