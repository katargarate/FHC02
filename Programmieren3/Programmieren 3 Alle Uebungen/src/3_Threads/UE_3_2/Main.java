package UE_3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {
        Uhrzeit uhrzeit = new Uhrzeit();
        Thread uhrzeitThread = new Thread(uhrzeit);
        System.out.println("Main starting Uhrzeit Thread...");

        uhrzeitThread.start(); // adding thread to queue

        System.out.println("Press a button to exit..");

        readLineFromConsole(); // warte auf enter

        uhrzeit.requestShutDown();
    }

    public static String readLineFromConsole() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
