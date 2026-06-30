package hoeflichesStoppen;

import java.util.Date;

public class Uhrzeit extends Thread {
    Boolean isRunning = true;

    public void requestShutdown() {
        isRunning = false;
    }

    @Override
    public void run() {
        do {
            Date d = new Date();
            System.out.print(Thread.currentThread().getName() + ": ");
            System.out.println(d.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (isRunning);
    }
}
