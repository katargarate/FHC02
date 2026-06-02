package Rekursionen;

public class RekursionenBeispiel {

    static void main(String[] args) {
        rekursion(10);
    }

    // prints a countdown using recursioons
    private static void rekursion(int counter) {
        System.out.printf("Der Countdown beträgt t - %d Sekunden\n", counter);
        counter--;
        if (counter >= 0) {
            rekursion(counter); // repeat the recursion until counter < 0
            System.out.println("Nach Aufruf"); // 10 will print after all the recursions because it's unwinding out of all the recursions
        }
    }
}
