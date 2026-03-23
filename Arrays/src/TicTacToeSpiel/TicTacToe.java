package TicTacToeSpiel;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    static Scanner sc = new Scanner(System.in);
    static char[][] field = new char[3][3];
    static int turnCounter = 1;
    static char symbol = 'x';
    static int winner = 0;

    // console colours
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE= "\u001B[34m";


    static void main() {

        fillInitialField();

        System.out.println(ANSI_BLUE + "\nWelcome to Tic Tac Toe!\n" + ANSI_RESET);
        printField();

        while (true) {
            if (turnCounter % 2 != 0) {
                symbol = 'o';
                System.out.println("Player 1 (o): ");
            }
            else {
                symbol = 'x';
                System.out.println("Player 2 (x): ");
            }

            getValidMove();
            printField(); // print updated field
            turnCounter++;

            // after each turn, check for a win, if true end loop / program

            if (checkForWin(symbol)) {
                if (winner == 1) {
                    System.out.println(ANSI_GREEN + "Player 1 wins.");
                } else if (winner == 2) {
                    System.out.println(ANSI_GREEN + "Player 2 wins.");
                } else if (winner == 0) {
                    System.out.println(ANSI_RED + "Game over. No win");
                }
                break; // WIP, will break only when there's a win
            }
        }

    }

    public static void printField() {
        // evtl. print 0,1,2 above columns and next to field for user-friendliness

        System.out.println();

        for (char[] row : field) {
            for (char spot : row) {
                System.out.print(spot + "  ");
            }
            System.out.println(); // blank line to start a new row
        }

        System.out.println();
    }

    public static void getValidMove() {

        while (true) {
            // get valid (0-2) row and column using helper method
            int row = getValidInt("row");
            int col = getValidInt("column");

            boolean validMove = checkIfSpotAvailable(row, col);

            if (!validMove) { // if invalid, restart while loop
                System.out.println(ANSI_RED + "That spot is already taken. Try again." + ANSI_RESET);
                continue;
            }

            field[row][col] = symbol; // globally saved, changed each round
            break;
        }
    }

    public static boolean checkIfSpotAvailable(int row, int col) {
        if (field[row][col] == '-') {
            return true;
        }
        return false; // otherwise return false
    }

    public static int getValidInt(String type) {
        int num;
        while (true) {
            System.out.printf("Enter a %s between 1-3: ", type);
            num = sc.nextInt();

            if (num != 1 && num != 2 && num != 3) { // if not a num between 0-2
                System.out.printf(ANSI_RED + "\nInvalid %s. Try again.\n" + ANSI_RESET, type);
                continue; // restart the loop
            }

            return num - 1; // return the row or column
        }

    }

    public static boolean checkForWin(char pl) {

        // pls = either x or o depending on if player 1 or player 2

        for (int i = 0; i < field.length; i++) { // loop through rows
            for (int j = 0; j < field[i].length; j++) { // loop through spots in row
                if ((field[i][0] == pl && field[i][1] == pl && field[i][2] == pl) || // check for pl horizontal win
                        (field[0][i] == pl && field[1][i] == pl && field[2][i] == pl) || // check for pl vertical win
                        (field[0][0] == pl && field[1][1] == pl && field[2][2] == pl) || // check for pl diagonal win
                        (field[0][2] == pl && field[1][1] == pl && field[2][0] == pl)) { // check for pl diagonal win

                    // assign winner according to pl
                    if (pl == 'o') {
                        winner = 1;
                    } else winner = 2;
                    return true;
                }
            }
        }

        // if board full, return true, else return false (=game not yet over)
        return isBoardFull();

    }

    public static boolean isBoardFull() {
        for (char[] row : field) {
            for (char spot : row) {
                if (spot == '-') return false; // return false at the first empty spot finding
            }
        }
        return true;
    }

    public static void fillInitialField() {
        // since every spot is being filled with the same char, instead of using a for loop we can use a for each loop
        // since we don't need to state positions
        for (char[] chars : field) {
            Arrays.fill(chars, '-'); // shortcut to fill every spot in each row with '-'
        }


    }


}
