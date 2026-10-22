package UE_3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void main(String[] args) {
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();

        Thread t1 = new Thread(worker1, "Thread-1");
        Thread t2 = new Thread(worker2, "Thread-2");

        // Add both threads to the queue
        System.out.println("Zeit_Von_Timeserver.Main starting Uhrzeit Thread 1...");
        t1.start();
        System.out.println("Zeit_Von_Timeserver.Main starting Uhrzeit Thread 2...");
        t2.start();

        System.out.println("Press a button to exit..");

        // After starting both threads, main immediately moves on to here:
        // This blocks the main thread until Enter is pressed in the console.
        // Meanwhile, t1 and t2 are off running their own run() loops independently, printing once a second.
        if (readLineFromConsole() != null) {
            worker1.requestShutDown();
            worker2.requestShutDown();
        }

        // join() makes main wait until that thread has actually finished executing run() and died.
        // Without this, main might print "DONE" while the worker threads are still finishing their last loop iteration
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("DONE");
    }

    public static String readLineFromConsole() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
