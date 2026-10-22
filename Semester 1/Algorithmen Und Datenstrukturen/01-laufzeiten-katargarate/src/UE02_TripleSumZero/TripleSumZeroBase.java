package UE02_TripleSumZero;

import java.util.HashMap;
import java.util.Random;

abstract public class TripleSumZeroBase {

    protected int[] numbers;
    private   long  startTime;

    abstract public int countTripleSum();

    /**
     * Generate a set of unique (pseudo-)random numbers
     * @param n ... numbers to generate
     */
    public void genNums(int n) {
        Random rg = new Random(1234);
        numbers = new int[n];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(n*2+10);
        for (int i=0; i < n; i++) {
            int x;
            do {
                x = rg.nextInt(n*200) - n*100;
            } while (hm.get(x) != null);
            hm.put(x, 1);
            numbers[i] = x;
        }
    }

    public void startStopWatch() {
        startTime = System.currentTimeMillis();
    }

    public double elapsedTime() {
        return (System.currentTimeMillis() - startTime) / 1000.0;
    }

    /**
     * Run a series of tests
     * Amount of numbers gets doubled in every iteration
     * @param maxN ... maximum of numbers
     */
    public void runTests(int maxN) {
        double oldtime = 0;
        for (int n = 100; n <= maxN; n *= 2) {
            genNums(n);
            startStopWatch();
            int cnt = countTripleSum();
            double time = elapsedTime();
            System.out.print("n:" + n + ", count:" + cnt + ", time:" + time + "sec");
            if (oldtime != 0) {
                System.out.printf(", ratioToPrev:%.2f", time/oldtime);
            }
            oldtime = time;
            System.out.println();
        }
    }
}
