package MultiDimensionalArrays;

public class MDArraySumCalc {

    static void main() {
        int[][] arr2D = {{2,4,6}, {1,3,5}};

        int[][][][] arr4D = {
                {{{ 1, 2 }, { 3, 4 }},
                {{ 5, 6 }, { 7, 8 }},
                {{ 9, 10 },{ 11, 12 }},
                {{ 13, 14 },{ 15, 16 }
                }}
        };

        // make empty 4D array
        int[][][][] arr4DEmpty = new int[2][2][2][2];

        System.out.println("2D Array:\n");
        loopAndCalc(arr2D);

        System.out.println("\n-------------------------\n");
        System.out.println("4D Array:\n");
        loopAndCalc4D(arr4D);

    }

    public static void loopAndCalc(int[][] arr ) {
        int sum = 0;
        int anzahl = 0;

        for (int[] row : arr) {
            for (int num : row) {
                anzahl++;
                sum += num;
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
        System.out.println("\nTotal sum: "+ sum);
        System.out.println("Total elements calculated with counter: "+ anzahl);
        System.out.println("Total elements calculated simply: "+ arr[0].length + arr[1].length);
    }

    public static void loopAndCalc4D(int[][][][] arr4 ) {
        int sum = 0;
        int anzahl = 0;

        for (int[][][] zahl1 : arr4) {
            for (int[][] zahl2 : zahl1) {
                for (int[] zahl3 : zahl2) {
                    for (int zahl4 : zahl3) {
                        anzahl++;
                        sum += zahl4;
                        System.out.printf("%d ", zahl4);
                    }
                    System.out.println();
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("\nTotal sum: "+ sum);
        System.out.println("Total elements calculated with counter: "+ anzahl);
    }
}
