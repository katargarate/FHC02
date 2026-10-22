package UE02_TripleSumZero;

import java.util.Arrays;

public class TripleSumZeroB extends TripleSumZeroBase {

    @Override
    public int countTripleSum() {
        Arrays.sort(numbers);
        int cnt = 0;
        int n = numbers.length;
        for (int i=0; i < n-3; i++) {
            int k = i + 1;
            int l = n - 1;
            while (k < l) {
                if (numbers[i] + numbers[k] + numbers[l] == 0) {
                    cnt++;
                    k++;
                }
                else if (numbers[i] + numbers[k] + numbers[l] > 0) {
                    l--;
                }
                else {
                    k++;
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        TripleSumZeroB tsi = new TripleSumZeroB();
        tsi.runTests(12800);
    }
}
