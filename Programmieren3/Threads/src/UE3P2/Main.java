package UE3P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main: starting");
        Uhrzeit uhrzeit1 = new Uhrzeit();
        Uhrzeit uhrzeit2 = new Uhrzeit();

        Thread uhrzeitThread1 = new Thread(uhrzeit1);
        Thread uhrzeitThread2 = new Thread(uhrzeit1);


        System.out.println("main: starting Uhrzeit-Thread 1");
        uhrzeitThread1.start();


        System.out.println("main: starting Uhrzeit-Thread 2");
        uhrzeitThread2.start();

//        System.out.println("main: Taste drücken zum Abbrechen...");
//        readLineFromConsole(); //warte auf "Enter"

        uhrzeit1.isRunning = false;
        uhrzeit2.isRunning = false;

        System.out.println("main: stopping");
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
