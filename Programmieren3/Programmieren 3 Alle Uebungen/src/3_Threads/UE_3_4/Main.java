package UE_3_3;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();

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
