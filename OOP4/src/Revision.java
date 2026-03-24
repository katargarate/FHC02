import java.util.Scanner;

public class Revision {
    static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {
        System.out.print("Nummer: ");
        String num = sc.nextLine();

        sc.nextLine();

        System.out.print("Frage: ");
        String frage = sc.nextLine();

        frage1(num,frage);
    }

    public static void frage1(String num, String frage) {
        System.out.printf("Frage %s lautet: %s", num,frage);
    }
}
