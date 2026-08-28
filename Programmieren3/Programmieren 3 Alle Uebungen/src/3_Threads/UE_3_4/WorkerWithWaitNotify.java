package UE_3_4;

public class WorkerWithWaitNotify implements Runnable {

    private static final Object lock = new Object();
    private static int counter = 0;
    private static int turn = 0; // alternates between 0 and 1 to signify who's turn it is

    private int id;

    public WorkerWithWaitNotify(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                // while it's not the thread's turn and the counter is still unter 20, wait
                while (turn != id && counter < 20) {
                    try {
                        this.wait();
                    }  catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                // check if we're done
                if (counter >= 20) {
                    lock.notifyAll(); // wake the other thread so it can also exit
                    break;
                }

                // increment the counter and print it
                System.out.println(Thread.currentThread().getName() + ": Counter: " + ++counter);


                turn = 1 - id; // pass the turn to the other thread
                lock.notifyAll(); // wake it up
            }

            try {
                Thread.sleep(1000); // 1-second sleep
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
