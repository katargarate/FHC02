package Threads;

import java.util.ArrayList;

// Die Threads wechseln sich ab, weil sie beim ersten Aufruf eine ID bekommen (mithilfe einer ArrayList)
// wenn der Thread gerade nicht dran ist (turn!=id), sagt das keyword wait(), dass er auf den LOCK warten müssen,
// nachdem der Thread, der dran war, fertig ist, gibt er den Lock weiter mit notfiy()
// Ich verwende synchronized mit einem statische Lock Objekt (statisch, damit es nur einen gibt, da es zur Klasse gehört)

public class Worker implements Runnable {
    private static final Object LOCK = new Object();
    private static int turn = 0; // wechselt sich zwischen 0 und 1, damit wir wissen, wer dran ist
    private static int counter = 0;


    private static ArrayList<Thread> threads = new ArrayList<>();

    @Override
    public void run() {
        // Jeder Thread bekommt beim ersten Aufruf eine ID
        int threadID;

        synchronized (LOCK) {
            threads.add(Thread.currentThread());
            threadID = threads.size() - 1; // (erster = 0, zweiter = 1)
        }

        while (true) {
            synchronized (LOCK) {
                // Wenn der Counter 20 erreicht hat, beide Threads beenden
                if (counter >= 20) {
                    LOCK.notifyAll();
                    return;

                }
                // Warten, solange dieser Thread nicht dran ist
                while (turn != threadID) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }

                    // Nach dem Aufwachen prüfen, ob wir fertig sind
                    if (counter > 20) {
                        LOCK.notifyAll();
                        return;
                    }
                }

                // Jetzt ist dieser Thread dran
                System.out.printf("%s %d%n", Thread.currentThread().getName(), counter++);

                // Anderen Thread drannehmen lassen
                turn = 1 - threadID;

                // Anderen wartenden Thread aufwecken
                LOCK.notifyAll();
            }
        }

    }
}
