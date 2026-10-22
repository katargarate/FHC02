package UE_3_3;

public class WorkerSynchronizedOnly implements Runnable {

    private static final Object lock = new Object();
    private static int counter = 0;


    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (counter >= 20) { // exits the while loop, still inside the lock is fine here
                    break;
                }
                System.out.println(Thread.currentThread().getName() + ": Counter: " + ++counter);
            }

            try {
                Thread.sleep(1000); // 1-second sleep
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
