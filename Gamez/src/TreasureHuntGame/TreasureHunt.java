package TreasureHuntGame;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class TreasureHunt {
    private Scanner sc = new Scanner(System.in);
    private Random r = new Random();

    private String ANSI_RESET = "\u001B[0m";
    private String ANSI_GREEN = "\u001B[32m";
    private String ANSI_BLUE = "\u001B[34m";
    private String ANSI_RED =  "\u001B[31m";

    private static final char EMPTY = '*';
    private static final char MISS = 'O';
    private static final char HIT = 'X';

    private int size = 5;
    private int maxAttempts = 10;
    private char[][] grid = new char[size][size];

    private int treasureRow;
    private int treasureCol;
    private int attempts = 0;
    private boolean found = false;


    private void initializeGame() {
        treasureRow = r.nextInt(size);
        treasureCol = r.nextInt(size);
        attempts = 0;
        found = false;
        fillGrid();
    }

    public void playGame() {

        initializeGame(); // fill grid, set treasure location, etc

        // print intro messages
        System.out.println(ANSI_BLUE+"Treasure Hunt!"+ANSI_RESET);
        System.out.println("Find the hidden treasure");

        printGrid();

        System.out.println("You have " + maxAttempts + " attempts.");

        // continue until treasure is found or maxAttempts exceeded
        while (attempts < maxAttempts && !found) {

            int row = getValidInt("row");
            int col = getValidInt("column");

            attempts++;

            // if the spot has already been taken, let the user guess again
            if (isSpotTaken(row, col)) continue;


            // if the row and the col both match the winning spot:
            if (row == treasureRow && col == treasureCol) {
                System.out.println(ANSI_GREEN + "You found the treasure!" + ANSI_RESET);
                found = true; // mark found as true to signal the win
                grid[row][col] = HIT; // mark the row as X to represent the found treasure
            } else { // otherwise mark the spot with O
                System.out.println(ANSI_RED+"No treasure here!"+ANSI_RESET);
                grid[row][col] = MISS; // mark guessed position
            }

            printGrid(); // print updated grid to show progress

        }

        // if bool found is true, print success message
        if (!found) {
            System.out.println(ANSI_RED+ "Game over! Treasure was at: ("
                    + treasureRow + ", " + treasureCol + ")" + ANSI_RESET);
        }
    }

    private boolean isSpotTaken(int row, int col) {
        // if that spot is already an X or O (already guessed):
        if (grid[row][col] == 'O' || grid[row][col] == 'X') {
            System.out.println(ANSI_RED + "You already guessed that spot!" + ANSI_RESET);
            return true;
        } return false; // otherwise return true
    }


    private void printGrid() {
        System.out.println();
        // print column numbers (top)
        System.out.print("   "); // space for row numbers
        for (int col = 0; col < grid[0].length; col++) {
            System.out.printf("%d  ", col+1);
        }
        System.out.println();

        // print rows
        for (int i = 0; i < grid.length; i++) {

            // print row number (left side)
            System.out.printf("%d  ", i+1);

            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == HIT) System.out.print(ANSI_RED+grid[i][j]+"  "  + ANSI_RESET);
                if (grid[i][j] == MISS) System.out.print(ANSI_BLUE+grid[i][j]+"  "  + ANSI_RESET);
                if (grid[i][j] == EMPTY) System.out.print(grid[i][j]+"  ");

            }

            System.out.println();
        }
        System.out.println();
    }

    // helper method to get valid int form user (1-5)
    private int getValidInt(String type) {
        int num;
        while (true) {
            System.out.printf("Enter a %s between 1-%d: ", type, size);
            num = sc.nextInt();

            if (num < 1 || num > size) { // if not a num between 0-2
                System.out.printf(ANSI_RED + "\nInvalid %s. Try again.\n" + ANSI_RESET, type);
                continue; // restart the loop
            }

            return num - 1; // return the row or column
        }

    }

    private void fillGrid() {
        // fill grid with '*'
        for (char[] row : grid) {
            Arrays.fill(row, EMPTY);
        }
    }
}
