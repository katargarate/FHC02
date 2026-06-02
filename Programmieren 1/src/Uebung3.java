import java.util.Scanner;

public class Uebung3 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nummer eingeben: ");
        int num = sc.nextInt();

        if (num > 5) {
            System.out.println("Nummer ist größer als 5");
        } else if (num <5) {
            System.out.println("Nummer ist kleiner als 5");
        } else {
            System.out.println("Zahl ist gleich 5.");
        }



    }
}
