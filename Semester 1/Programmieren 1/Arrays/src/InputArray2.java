import java.util.Arrays;
import java.util.Scanner;

public class InputArray2 {
    static Scanner sc = new Scanner(System.in);

    static void main() {
        System.out.print("Wie viele Personen befinden sich in ihrem Kurs?: ");
        int anzahl = sc.nextInt();
        String[] namen = new String[anzahl];

        // clear buffer, has to be used because we read nextLine() later,
        // if we just used next() we could skip this
        sc.nextLine();

        // make user enter as many names as what they inputted
        for (int i = 0; i < anzahl; i++) {
            System.out.printf("Person %d: ", i+1);
            namen[i] = sc.nextLine();
        }

        // Print list as converted array
        System.out.println("\nAlle Namen: " + Arrays.toString(namen));

        // print with for lop, then with foreach loop

        forLoopPrint(namen);
        foreachLoopPrint(namen);

    }

    public static void forLoopPrint(String[] namen) {
        // print array with a for loop
        System.out.println("\nAlle Namen mit eine For Schleife ausgegeben: ");

        for (int i = 0; i < namen.length; i++) {
            System.out.printf("%d: %s\n", i+1,namen[i]);
        }

    }

    public static void foreachLoopPrint(String[] namen) {
        // print with a for each loop
        System.out.println("\nAlle Namen mit eine Foreach Schleife ausgegeben: ");
        int counter = 1;

        for (String name : namen) {
            System.out.println(counter+": "+name);
            counter++;
        }
    }

}
