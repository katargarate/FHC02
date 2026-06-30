package UE3P4;

public class Worker implements Runnable {
    public static int counter = 0;
    public static final Object LOCK = new Object();

    @Override
    public void run() {

        while (counter < 20) {

            synchronized (LOCK) {
                System.out.printf("\n %s hat den counter auf %d erhöht", Thread.currentThread().getName(), ++counter);

                LOCK.notify(); // ei der erste Iteration passiert hier noch nichts, weil keiner waitet

                try {
                    Thread.sleep(500);
                    LOCK.wait();
                }  catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }




        }


    }

    public synchronized void incrementCounter() {
        System.out.printf("\n %s hat den counter auf %d erhöht", Thread.currentThread().getName(), ++counter);

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
