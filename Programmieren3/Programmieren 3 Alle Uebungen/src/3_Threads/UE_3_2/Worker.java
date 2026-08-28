package UE_3_2;

import java.util.Date;

public class Uhrzeit extends Thread{

    private final int sleepInterval = 1000; // 1 second
    private final static Object lockObject = new Object();

    private boolean isRunning = true;

    @Override
    public void run() {

        while (isRunning) {
            synchronized (lockObject) {
                Date date = new Date();

                System.out.printf("%s [%s, CPUS: %d, FreeMem: %d]\n",
                        Thread.currentThread().getName(), date, Runtime.getRuntime().availableProcessors(),
                        Runtime.getRuntime().totalMemory());

                try {
                    Thread.sleep(1000); // 1 second sleep
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public void requestShutDown() {
        isRunning = false;
    }
}
