package Factorial;

public class Main {

    static void main(String[] args) {
        System.out.println("Via recursion: " + factorialViaRecursion(3));
        System.out.println("Via iteration: " + factorialViaIteration(3));
    }

    public static int factorialViaRecursion(int n) {
        if (n <= 1) return 1;
        else return n * factorialViaRecursion(n - 1);
    }

    public static int factorialViaIteration(int n) {
        int factorial = n;
        for (int i = (n-1); i > 0; i--) {
            factorial *= i;
        }
        return factorial;
    }
}
