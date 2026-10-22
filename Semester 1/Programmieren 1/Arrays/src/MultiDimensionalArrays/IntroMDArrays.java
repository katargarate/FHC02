package MultiDimensionalArrays;

public class IntroMDArrays {

    static void main() {
        oneDArray();
        twoDArray();

    }

    private static void twoDArray() {
        int[][] arr = {{2,4,6,8}, {1,3,5,7,9,11}};

        System.out.println("Print 2D Array with For Each Loop:");

        for (int[] row : arr) { // loop through each array in the md array
            for (int col : row) { // loop through each element of the current 1d array
                System.out.print(col +" "); // print each element
            }
            System.out.println();
        }


        System.out.println("\nPrint 2D Array with For Loop:");

        for (int i = 0; i < arr.length; i++) { // with arr.length, we get the amount of 1d arrays in the md array (2)
            for (int j = 0; j < arr[i].length; j++) { // with arr[i].length, we get the amount of elements in array i
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static void oneDArray() {
        int[] arr = {1,2,3};

        System.out.println("Print 1D Array with For Each Loop:");

        for (int num : arr) {
            System.out.println(num);
        }

        System.out.println("\nPrint 1D Array with For Loop:");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
