package UE3P3;

public class Worker implements Runnable {
    public static int counter = 0;
    public static final Object LOCK = new Object();

    @Override
    public void run() {

        do {
            synchronized (LOCK) {
                System.out.printf("\n %s hat den counter auf %d erhöht", Thread.currentThread().getName(), ++counter);
            }


            // 1 sec sleep
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;

            }
        } while (counter < 20);
    }
}
