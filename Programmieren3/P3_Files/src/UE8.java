import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UE8 {
    static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("Enter text line by line and enter 'STOP' when you are done:");

        // read user input until the user enters 'STOP' (not case-sensitive)
        String line = br.readLine();

        while (!line.equalsIgnoreCase("STOP")) {
            System.out.println("You wrote: " + line);
            line = br.readLine();
        }

        System.out.println("You entered stop. Goodbye");

        br.close();
    }
}
