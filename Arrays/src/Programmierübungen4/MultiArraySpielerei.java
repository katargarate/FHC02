package Programmierübungen4;


import java.util.Random;

public class MultiArraySpielerei {
    static int[][] arr = new int[8][8];
    static int min;
    static int max;
    static int sum;
    static int counter;

    static void main() {
        fillArray();
        printArray();
        findSumAndMinAndMax();

        // Java decides the division type before storing the result so we have to first cast the numerator to double
        // AKA without casting it, it calculates sum/counter as an int and turns it to double after so i nly get round values
        double avg = (double) sum / counter;

        // print with text block using text block to avoid having to write new lines etc
        System.out.printf("""
                        
                        Summe aller Elemente: %d
                        Durchschnitt aller Elemente: %.2f
                        Maximum im Array: %d
                        Minimum im Array: %d
                        """,
                sum, avg, max, min
        );


    }

    public static void findSumAndMinAndMax() {
        // initialize min and max with the smallest/biggest possible values
        min = 1;
        max = 100;

        counter = 0;
        sum = 0;

        for (int[] row : arr){
            for (int num : row) {
                sum +=num; // calculate running sum
                counter++; // increment counter

                // check for min and max
                if (num < min) {
                    num = min;
                } if (num > max) {
                    max = num;
                }
            }
        }
    }


    public static void printArray() {
        for (int[] row : arr) {
            for (int num : row) {
                System.out.printf("%02d  ", num); // print nums with 0 if single digit (02,03)
            }
            System.out.println();
        }
    }

    public static void fillArray(){
        Random r = new Random(); // initialize Random instance

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = r.nextInt(100)+1; // insert a random num up to 100;
            }
        }


    }

}
