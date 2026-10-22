package UE_3_1;

import java.util.Date;

public class Uhrzeit extends Thread{

    private boolean isRunning = true;

    @Override
    public void run() {
        do {
            Date date = new Date();
            System.out.println(Thread.currentThread().getName()+": " + date);

            try {
                Thread.sleep(1000); // 1 second sleep
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (isRunning);

    }

    public void requestShutDown() {
        isRunning = false;
    }
}
