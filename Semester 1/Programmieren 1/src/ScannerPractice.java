import java.util.Scanner;

public class ScannerPractice {
    static void main() {
        // ausgabeUebung();
        // boolUebung();
       scannerUebung();
    }


    public static void ausgabeUebung() {
        System.out.println("Name: Katharina Argarate");
        System.out.println("Wetter: Bewölkt");
        System.out.println("Name einer Katze: Mr. Meow");


        String tag = "Montag";
        System.out.printf("Heute ist ein schöner %s!", tag);
    }

    public static void boolUebung() {
        int a = 115;
        boolean b = a >= 110;

        System.out.printf("Ist %d grösser/gleich als 110? ", a);
        System.out.println(b);

        String txt = "Hello World";
        System.out.println(txt.substring(6,10));
    }

    public static void scannerUebung() {
        Scanner sc = new Scanner(System.in);

        // Input first name
        System.out.print("Vorname: ");
        String vorname = sc.next();

        // Input last name
        System.out.print("Nachname: ");
        String nachname = sc.next();

        String name = vorname + " " + nachname; // concat name

        int nameLaenge = name.length() -1;
        boolean istLangerName = nameLaenge > 10; // true if name over 10 chars, otherwise false

        // Output
        System.out.println("Wilkommen " + name.toUpperCase());
        System.out.printf("Ihr Name ist länger 10: %s - und die exaktae Laenge ist %d", istLangerName, nameLaenge);
    }
}
