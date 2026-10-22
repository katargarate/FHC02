package ExtraThreadsExamples;

public class ThreadStartTwice extends Thread {
    public void run() {
        System.out.println("running...");
    }

    public static void main(String args[]) {
        ThreadStartTwice t1 = new ThreadStartTwice();
        t1.start();
        t1.start();

    }
}