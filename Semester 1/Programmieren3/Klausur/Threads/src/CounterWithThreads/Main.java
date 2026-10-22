package CounterWithThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Worker w = new Worker();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);

        System.out.println("Press a button to exit..");

        t1.start();
        t2.start();


        //Nachdem beide Threads starten, geht main hier weiter
        // Gleichzeitig laufen t1 und t2 weiter
        if (readLineFromConsole() != null) {
            w.requestShutDown();
        }
    }

    // Hilfsmethode, um den Benutzer zu erlauben, dass der Counter unterbrochen werden kann
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
