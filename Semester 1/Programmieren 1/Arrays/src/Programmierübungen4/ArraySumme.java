package Programmierübungen4;

public class ArraySumme {

    static void main() {
        double[][] arr = {{8.8, 12}, {134,67.92,45,32.4,76}, {1}, {0, 0.56}};
        System.out.println("Die Summe beträgt: " + calculatesum(arr));
    }

    private static double calculatesum(double[][] arr) {
        double sum = 0;

        for (double[] row : arr) {
            for (double num : row) {
                sum += num;
            }
        }

        return sum;
    }
}
