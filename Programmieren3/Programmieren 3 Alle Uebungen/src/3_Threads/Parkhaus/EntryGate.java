package Parkhaus;

public class EntryGate implements Runnable {

    private final Object lock;
    private static volatile boolean isRunning = true;

    public EntryGate(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {

                // if the parkhaus is already above capacity, wait
                if (Parkhaus.parkedCars >= 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                if (!isRunning) {
                    lock.notifyAll();
                    break;
                }

                Parkhaus.parkedCars++;
                Parkhaus.totalParkedCars++;
                System.out.printf("\n%s: Auto geparkt! Belegt: %d/%d", Thread.currentThread().getName(), Parkhaus.parkedCars, Parkhaus.MAX_CAPACITY);
            }

            // wait 500 ms between car entry attempts
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void requestShutdown() {
       isRunning = false;
    }
}
