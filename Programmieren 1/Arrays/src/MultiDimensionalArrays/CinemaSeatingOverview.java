package MultiDimensionalArrays;

// -- DOCUMENTATION -- //
/*
 * This program displays a cinema room's seating overview using a 2D Boolean Array.
 *
 * Features:
 * - Displays a 15x20 seating chart using a 2D boolean array.
 * - Marks selected seats as free (true), others as occupied (false).
 * - Shows the number of free seats per row where there are still available seats.
 * - Displays overall occupancy percentage.
 *
 *
 */

public class CinemaSeatingOverview {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        // 2D Boolean Array: true = free, false = taken
        boolean[][] seatingChart = new boolean[15][20]; // 15 rows and 20 seats per row

        // marking a few seats as free
        seatingChart[2][5] = true;
        seatingChart[2][6] = true;
        seatingChart[9][0] = true;
        seatingChart[9][1] = true;
        seatingChart[9][2] = true;
        seatingChart[4][2] = true;

        displaySeatingChart(seatingChart);
        displayFreeSeatsPerRow(seatingChart);
        displayOccupancyPercentage(seatingChart);
    }

    public static void displaySeatingChart(boolean[][] chart) {
        System.out.println(ANSI_RED+"Cinema Seating Plan:"+ANSI_RESET);
        for (int i = 0; i < chart.length; i++) { // loop through each row
            System.out.printf("%02d ", i + 1); // display row number (as 01 02 03 etc.)
            for (int j = 0; j < chart[i].length; j++) { // loop through each seat in that row
                if (chart[i][j]) { // if the seat is free
                    System.out.print("0 "); // mark with 0
                } else { // if its occupied
                    System.out.print(ANSI_RED+"X "+ANSI_RESET); // mark with X
                }
            }
            System.out.println();
        }
    }

    public static void displayFreeSeatsPerRow(boolean[][] chart) {
        System.out.println("\nFree Seats by Row:");
        for (int i = 0; i < chart.length; i++) { // loop through 2D array
            int freeSeats = 0;
            for (int j = 0; j < chart[i].length; j++) { // loop through seats in that row
                if (chart[i][j]) freeSeats++; // count free seats in that row
            }
            // if a row has free seats: display total amount int that row
            if (freeSeats > 0) {
                System.out.printf("%d free seats in row %d\n", freeSeats, i + 1);
            }
        }
    }

    public static void displayOccupancyPercentage(boolean[][] chart) {
        int totalSeats = chart.length * chart[0].length;
        int freeSeats = 0;

        for (boolean[] row : chart) { // loop through rows
            for (boolean seat : row) { // loop through seats in that row
                if (seat) freeSeats++; // if seat = true aka is free: add to counter
            }
        }

        double percentage = (double) (totalSeats - freeSeats) / totalSeats * 100; // calculate percentage
        System.out.printf("\nOccupancy:\n%.2f%% full%n", percentage);
    }
}
