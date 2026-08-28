package UE_3_1;

import java.util.Date;

public class HintergrundThread implements Runnable{

    private boolean isRunning = true;

    @Override
    public void run() {
        while (isRunning) {
            System.out.println(new Date());
        }

        System.out.println("Ending HintergrundThread...");
    }

    public void requestShutDown() {
        isRunning = false;
    }
}
