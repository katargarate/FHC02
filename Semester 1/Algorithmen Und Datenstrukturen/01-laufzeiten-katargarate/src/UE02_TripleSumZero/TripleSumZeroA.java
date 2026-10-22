package UE02_TripleSumZero;

public class TripleSumZeroA extends TripleSumZeroBase {

    @Override
    public int countTripleSum() {
        int n   = numbers.length;
        int cnt = 0;
        for (int i=0; i < n; i++) {
            for (int j=i+1; j < n; j++) {
                for (int k=j+1; k < n; k++) {
                    if (numbers[i]+ numbers[j]+ numbers[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        TripleSumZeroA tsn = new TripleSumZeroA();
        tsn.runTests(12800);
    }

}
