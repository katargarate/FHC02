package UE3P2;

import java.util.Date;

public class Uhrzeit extends Thread {
    Boolean isRunning = true;
    public static final Object LOCK = new Object();

    public void requestShutdown() {
        isRunning = false;
    }

    @Override
    public void run() {

        do {
            synchronized (LOCK) {
                Date d = new Date();
                System.out.print(Thread.currentThread().getName() + ": [");
                System.out.print(d.toString());
                System.out.print(", CPUS: ");
                System.out.print(Runtime.getRuntime().availableProcessors());
                System.out.print(", Free Mem: ");
                System.out.print(Runtime.getRuntime().freeMemory());
                System.out.print("]");
                System.out.println();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        } while (isRunning);

    }
}
