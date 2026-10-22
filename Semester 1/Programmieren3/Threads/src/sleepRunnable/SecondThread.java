package sleepRunnable;

import java.util.Date;

public class SecondThread implements Runnable {
    Boolean isRunning = true;

    public void requestShutdown() {
        isRunning = false;
    }

    @Override
    public void run() {
        do {
            System.out.println("This is the second thread.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (isRunning);
    }
}
