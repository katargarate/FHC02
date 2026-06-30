import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("main: starting");
        Uhrzeit uhrzeit = new Uhrzeit();
        Thread uhrzeitThread = new Thread(uhrzeit);
        System.out.println("main: starting Uhrzeit-Thread");
        uhrzeitThread.start();
        System.out.println("main: Taste drücken zum Abbrechen...");
        readLineFromConsole(); //warte auf "Enter"
        uhrzeit.isRunning = false;

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
