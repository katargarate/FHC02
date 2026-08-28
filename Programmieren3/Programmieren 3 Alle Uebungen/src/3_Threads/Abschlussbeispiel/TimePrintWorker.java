package Abschlussbeispiel;

import java.util.Date;

public class TimePrintWorker extends Worker implements Runnable {

    public TimePrintWorker(String name) {
        super(name);
    }

    @Override
    public void work() {
        printStarted();

        while (shouldRun) {
            Date date = new Date();
            System.out.println(date);

            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }

        printStopped();
    }

    @Override
    public void run() {
        work();
    }
}
