package TicketVerkauf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void main(String[] args) {
        Seller seller1 = new Seller(0);
        Seller seller2 = new Seller(1);

        Thread t1 = new Thread(seller1);
        Thread t2 = new Thread(seller2);

        t1.start();
        t2.start();

        // when we get a string back, continue
        if (readLineFromConsole() != null) {
            seller1.requestShutDown();
            seller2.requestShutDown();
        }

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
