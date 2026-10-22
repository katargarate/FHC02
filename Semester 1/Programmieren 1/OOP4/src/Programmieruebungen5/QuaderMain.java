package Programmieruebungen5;

public class QuaderMain {

    static void main() {
        Quader q1 = new Quader(2.0, 3.0,4.0);
        q1.displayInfo();

        q1.skaliere(2);

        System.out.println("\nSkaliertes Quader:");
        q1.displayInfo();
    }
}
