public class MDArrayTasks {

    // proper entry point if you want to run this class
    public static void main(String[] args) {
        sumOfArrayRow();
        maxInGrid();
        countElementsIn3DArray();
        sum3DArray();
        countEvenNumbers4DArray();
    }

    // ---------------- 2D ARRAYS ----------------

    public static void sumOfArrayRow() {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // outer loop = rows
        for (int i = 0; i < grid.length; i++) {
            int sum = 0;

            // inner loop = columns inside each row
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }

            System.out.println("Row " + (i + 1) + " sum = " + sum);
        }
    }

    public static void maxInGrid() {
        int[][] grid = {
                {3, 5, 1},
                {9, 2, 8},
                {4, 7, 6}
        };

        // start with first element as initial max
        int max = grid[0][0];

        // check every element in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j]; // update max if bigger value found
                }
            }
        }

        System.out.println("Max value: " + max);
    }

    // ---------------- 3D ARRAYS ----------------

    public static void countElementsIn3DArray() {
        int[][][] cube = {
                {
                        {1, 2},
                        {3, 4}
                },
                {
                        {5, 6},
                        {7, 8}
                }
        };

        int count = 0;

        // each extra dimension = one more loop
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    count++; // count every element
                }
            }
        }

        System.out.println("Total elements: " + count);
    }

    public static void sum3DArray() {
        int[][][] cube = {
                {
                        {1, 2},
                        {3, 4}
                },
                {
                        {5, 6},
                        {7, 8}
                }
        };

        int sum = 0;

        // enhanced for-loop version (cleaner for reading)
        for (int[][] layer : cube) {        // 2D slice
            for (int[] row : layer) {      // 1D row
                for (int value : row) {   // actual numbers
                    sum += value;
                }
            }
        }

        System.out.println("Total sum: " + sum);
    }

    // ---------------- 4D ARRAYS ----------------

    public static void countEvenNumbers4DArray() {
        // 4D = array of 3D arrays
        int[][][][] hypercube = {
                {
                        {
                                {1, 2},
                                {3, 4}
                        }
                },
                {
                        {
                                {5, 6},
                                {7, 8}
                        }
                }
        };

        int evenCount = 0;

        // 4 nested loops = 4 dimensions
        for (int i = 0; i < hypercube.length; i++) {
            for (int j = 0; j < hypercube[i].length; j++) {
                for (int k = 0; k < hypercube[i][j].length; k++) {
                    for (int l = 0; l < hypercube[i][j][k].length; l++) {

                        // check if number is even
                        if (hypercube[i][j][k][l] % 2 == 0) {
                            evenCount++;
                        }

                    }
                }
            }
        }

        System.out.println("Even numbers: " + evenCount);
    }
}