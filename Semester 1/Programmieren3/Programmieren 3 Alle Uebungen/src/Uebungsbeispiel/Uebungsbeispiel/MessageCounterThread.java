package Uebungsbeispiel;

/*
 * Hintergrundthread - gibt alle 5 Sekunden die Anzahl empfangener Nachrichten aus.
 *
 * Unterschied zum MyFilesizeThread aus dem Chat-Beispiel:
 * - Dort wurde File.length() abgefragt (kein geteilter Zustand zwischen Threads nötig).
 * - Hier wird ein MessageCounter Objekt geteilt, das synchronized ist
 *   -> zeigt, wie man mit "echtem" geteiltem Zustand zwischen Threads umgeht.
 *
 * Stop-Mechanismus ist gleich wie im Chat-Beispiel: Thread.interrupted() prüfen,
 * InterruptedException beim sleep() abfangen, dann break.
 */
public class MessageCounterThread implements Runnable {

    private final MessageCounter counter;

    public MessageCounterThread(MessageCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("ANZAHL NACHRICHTEN BISHER: " + counter.getCount() +
                    " (Thread: " + Thread.currentThread().getName() + ")");
            try {
                Thread.sleep(5000); // 5 Sekunden Pause zwischen den Ausgaben
            } catch (InterruptedException e) {
                // wird ausgelöst, wenn counterThread.interrupt() in main() aufgerufen wird
                System.out.println("Counter-Thread wurde unterbrochen, beende mich sauber.");
                break; // Schleife verlassen, run() endet, Thread stirbt kontrolliert
            }
        }
    }
}