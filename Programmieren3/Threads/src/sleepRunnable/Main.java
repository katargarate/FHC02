package sleepRunnable;

public class Main implements Runnable  {
    static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + ": Ich bin der erste Thread.");

        Runnable r = new Main();
        Thread t = new Thread(r);

        t.start();

        System.out.println(Thread.currentThread().getName() + " beendet sich.");

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Ich bin der zweite Thread.");

        try {
            Thread.sleep(3000); // sleep for 3 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // after the sleep (attempt) the thread ends
        System.out.println(Thread.currentThread().getName() + " beendet sich.");
    }
}
