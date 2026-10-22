package UE3P4;

public class Main {
    static void main(String[] args) throws InterruptedException {
        Worker w1 = new Worker();
        Worker w2 = new Worker();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\n\nCounter zum Schluss: " + Worker.counter);

    }
}
