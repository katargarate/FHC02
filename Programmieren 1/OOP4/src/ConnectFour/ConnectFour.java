package ConnectFour;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ConnectFour {
    char[][] board = new char[6][7];
    boolean player1 = true;
    char symbol = 'x';
    Scanner sc = new Scanner(System.in);
    boolean ongoingGame = true;

    // console colours
    private  final String ANSI_RESET = "\u001B[0m";
    private  final String ANSI_GREEN = "\u001B[32m";
    private  final String ANSI_BLUE= "\u001B[34m";

    public ConnectFour() {
        initializeBoard();
        displayBoard();
        playGame();
    }

    private void playGame() {
        while (ongoingGame) {
            if (player1) symbol = 'x';
            else symbol = 'o';

            getValidMove();

            if (isBoardFull()) {
                System.out.println("No more moves possible. Game over.");
                ongoingGame = !ongoingGame;
            }
            player1 = !player1;
        }
    }

    private void getValidMove() {

        if (player1) System.out.print("Player 1 - Enter column number: ");
        else System.out.print("Player 2 - Enter column number: ");

        int column = sc.nextInt()-1;


        int row = getValidRowForColumn(column);

        if (row != -1) {
            board[row][column] = symbol;
        } else System.out.println("No free spots in this column, try again.");

        displayBoard();

        if (checkWin()){
            if (player1) System.out.println("\nPLAYER 1 WINS");
            else System.out.println("\nPLAYER 2 WINS");

            ongoingGame = false;
        }
    }

    private int getValidRowForColumn(int col) {
        int lowestAvailable = -1;

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == '*') {
                lowestAvailable = i;
            }
        }
        return lowestAvailable;
    }

//    private boolean checkForWin(int row, int column) {
//
//        //System.out.println("\nDEBUGGING: CHECKING FOR WIN");
//
//        // horizontal win
//        int counter = 0;
//        for (char place : board[row]) {
//            if (counter >= 4) return true;
//            if (place != symbol){
//                counter = 0;
//
//            } else {
//                counter ++;
//            }
//        }
//
//        // vertical win
//        counter = 0;  // reset counter
//
//        for (int i = 0; i < board.length; i++) {
//
//            if (board[i][column] != symbol) {
//                counter = 0;
//            } else {
//                counter++;
//            }
//            if (counter == 4) return true;
//        }
//
//
//        if (checkForDiagonalWin(row, column, true)) return true;
//
//
//        if (checkForDiagonalWin(row, column, false)) return true;
//
//    return false;
//
//    }

    //methode um den gewinn zu überprüfen mit boolean rückgabetyp
    public boolean checkWin() {

        //horizontal
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == symbol && board[i][j + 1] == symbol && board[i][j + 2] == symbol && board[i][j + 3] == symbol) {
                    return true;
                }
            }
        }
        //vertikal
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == symbol && board[i + 1][j] == symbol && board[i + 2][j] == symbol && board[i + 3][j] == symbol) {
                    return true;
                }
            }
        }
        //diagonal schräg nach oben
        for (int i = 3; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == symbol && board[i - 1][j + 1] == symbol && board[i - 2][j + 2] == symbol && board[i - 3][j + 3] == symbol) {
                    return true;
                }
            }
        }
        //diagonal schräg nach unten
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 3; j < board[i].length; j++) {
                if (board[i][j] == symbol && board[i + 1][j + 1] == symbol && board[i + 2][j + 2] == symbol && board[i + 3][j + 3] == symbol) {
                    return true;
                }
            }
        }
        //kein gewinner
        return false;
    }

    private boolean checkForDiagonalWin(int row, int column, boolean toLeft) {
        int counter = 0;

        int currRow = row;
        int currCol = column;

        // Move to the start of the diagonal (edge of the board)
        if (!toLeft) {
            // go down-left
            while (currRow < 5 && currCol > 0) {
                currRow++;
                currCol--;
            }
        } else {
            // go down-right
            while (currRow < 5 && currCol < 6) {
                currRow++;
                currCol++;
            }
        }

        // Scan the diagonal
        while (currRow >= 0 && currRow <= 5 && currCol >= 0 && currCol <= 6) {

            if (board[currRow][currCol] != symbol) {
                counter = 0;
            } else {
                counter++;
            }

            if (counter == 4) return true;

            // Move along the diagonal
            if (!toLeft) {
                // up-right
                currRow--;
                currCol++;
            } else {
                // up-left
                currRow--;
                currCol--;
            }
        }

        return false;
    }


    private void displayBoard() {
        // use for each loop to display board
        System.out.println();
        for (char[] row: board) {
            for (char place : row) {
                if (place == 'x') System.out.print(ANSI_BLUE + place + "  " + ANSI_RESET);
                else if (place == 'o') System.out.print(ANSI_GREEN + place + "  " + ANSI_RESET);
                else System.out.print(place + "  ");
            }
            System.out.println();

        }
        System.out.println();

    }


    private void initializeBoard() {
        // initialize board with stars
        for (char[] row : board) {
            Arrays.fill(row,'*');
        }

    }

    private boolean isBoardFull() {

        for (char[] row : board) {
            for (char place : row) {
                if (place == '*') return false;
            }
        }

        return true;
    }




}
