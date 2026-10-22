import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UE08_ReadConsoleInputWithInputStream {
    static void main(String[] args) {
        readConsoleInputWithInputStream();
    }

    public static void readConsoleInputWithInputStream() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("Start typing.");

        try {
            String line = br.readLine();
            while (line != null  && ! line.equalsIgnoreCase("STOP")) {
                System.out.println(line.trim());

                // update the current line to the next
                line = br.readLine();
            }

            // close the buffered reader
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Copycat session over.");



    }
}
