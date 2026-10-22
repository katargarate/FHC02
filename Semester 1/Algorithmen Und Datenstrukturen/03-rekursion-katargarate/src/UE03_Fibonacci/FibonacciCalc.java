package UE03_Fibonacci;

public class FibonacciCalc {

    public int calcFibonacci(int n)
    {
        // Variante Iteration
        return calcFibonacciViaIteration(n);
        // Variante Rekursion
        //return calcFibonacciViaRecursion(n);
    }

    private int calcFibonacciViaIteration(int n)
    {
        if (n <= 1) {
            return n;
        }

        int fib = 1;
        int prevFib = 1;

        for(int i=2; i<n; i++) {
            int temp = fib;
            fib = fib + prevFib;
            prevFib = temp;
        }
        return fib;
    }

    private int calcFibonacciViaRecursion(int n)
    {
        // TODO: Implementieren
        return 0;
    }


}
