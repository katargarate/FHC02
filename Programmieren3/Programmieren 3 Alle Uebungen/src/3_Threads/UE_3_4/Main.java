package UE_3_4;

public class Main {
    public static void main(String[] args) {
        WorkerWithWaitNotify worker1 = new WorkerWithWaitNotify(0);
        WorkerWithWaitNotify worker2 = new WorkerWithWaitNotify(1);

        Thread t1 = new Thread(worker1);
        Thread t2 = new Thread(worker2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
