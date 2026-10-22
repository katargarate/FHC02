package UE_3_2;

import java.util.Date;

public class Worker implements Runnable{

    private boolean isRunning = true;
    private final int sleepInterval = 1000; // 1 second

    // since this lock is static, its belongs to the class and not the instance, so only one instance can have it at a time
    private final static Object lockObject = new Object();


    @Override
    public void run() {

        while (isRunning) {
            // lockObject is like a single key (static). Only one thread can be holding that key at any given moment.
            // When a thread hits synchronized (lockObject) { ... }, it tries to grab the key:
            // If no one else has it → it takes the key, runs the block, then puts the key back when done.
            // If another thread already has it → it waits (blocks) until the key is released.
            synchronized (lockObject) {
                Date date = new Date();

                System.out.printf("%s [%s, CPUS: %d, FreeMem: %d]\n",
                        Thread.currentThread().getName(), date, Runtime.getRuntime().availableProcessors(),
                        Runtime.getRuntime().totalMemory());

            }

            // The sleep is outside the synchronised block, so a thread releases the lock before it goes to sleep.
            // That's what lets the other thread grab the lock and print while the first one is sleeping
            try {
                Thread.sleep(sleepInterval); // 1 second sleep
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void requestShutDown() {
        isRunning = false;
    }
}
