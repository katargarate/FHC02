package Parkhaus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parkhaus {
    public static int parkedCars = 0;
    public static final int MAX_CAPACITY = 5;
    public static int totalParkedCars = 0;
    public static int totalPickedUpCars = 0;
    private static final Object lock = new Object();

    static void main(String[] args) {
        EntryGate entryGate1 = new EntryGate(lock);
        EntryGate entryGate2 = new EntryGate(lock);
        ExitGate exitGate1 = new ExitGate(lock);
        ExitGate exitGate2 = new ExitGate(lock);

        Thread entryThread1 = new Thread(entryGate1, "Entry Gate 1");
        Thread entryThread2 = new Thread(entryGate2, "Entry Gate 2");
        Thread exitThread1 = new Thread(exitGate1, "Exit Gate 1");
        Thread exitThread2 = new Thread(exitGate2, "Exit Gate 2");

        entryThread1.start();
        entryThread2.start();
        exitThread1.start();
        exitThread2.start();

        if (getInputFromConsole() != null) {
            entryGate1.requestShutdown();
            entryGate2.requestShutdown();
            exitGate1.requestShutdown();
            exitGate2.requestShutdown();
        }

        try {
            entryThread1.join();
            entryThread2.join();
            exitThread1.join();
            exitThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("\nCurrent capacity: %d/%d", parkedCars, Parkhaus.MAX_CAPACITY);
        System.out.println("\nTotal parked cars: " + Parkhaus.totalParkedCars);
        System.out.println("Total picked up cars: " + Parkhaus.totalPickedUpCars);

    }

    public static String getInputFromConsole() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            return br.readLine();
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
