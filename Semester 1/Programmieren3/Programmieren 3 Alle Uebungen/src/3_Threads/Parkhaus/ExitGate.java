package Parkhaus;

public class ExitGate implements Runnable {
    private final Object lock;

    private static volatile boolean isRunning = true;

    public ExitGate(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {

                // if the parkhaus is already empty
                if (Parkhaus.parkedCars == 0) {
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

                Parkhaus.parkedCars--;
                Parkhaus.totalPickedUpCars++;
                System.out.printf("\n%s: Auto abgeholt! Belegt: %d/%d", Thread.currentThread().getName(), Parkhaus.parkedCars, Parkhaus.MAX_CAPACITY);
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
