package ConnectFour;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ConnectFour {
    int[][] board = new int[6][7];
    boolean player1 = true;
    char num = 1;
    Scanner sc = new Scanner(System.in);
    boolean ongoingGame = true;

    // console colours
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_BLUE= "\u001B[34m";
    private final String ANSI_YELLOW =  "\u001B[33m";

    public ConnectFour() {
        initializeBoard();
        displayBoard();
        playGame();
    }

    private void playGame() {
        while (ongoingGame) {
            if (player1) num = 1;
            else num = 2;

            getValidMove();

            if (isBoardFull()) {
                System.out.println("No more moves possible. Game over.");
                ongoingGame = !ongoingGame;
            }
            player1 = !player1;
        }
    }

    private void getValidMove() {

        if (player1) System.out.print(ANSI_BLUE+"\nPlayer 1 - Enter column number: "+ANSI_RESET);
        else System.out.print(ANSI_YELLOW+"\nPlayer 2 - Enter column number: "+ANSI_RESET);

        int column = sc.nextInt()-1;


        int row = getValidRowForColumn(column);

        if (row != -1) {
            board[row][column] = num;
        } else System.out.println("No free spots in this column, try again.");

        displayBoard();

        if (checkWin()){
            if (player1) System.out.println(ANSI_BLUE+"\nPLAYER 1 WINS"+ANSI_RESET);
            else System.out.println(ANSI_YELLOW+"\nPLAYER 2 WINS"+ANSI_RESET);

            ongoingGame = false;
        }
    }

    private int getValidRowForColumn(int col) {
        int lowestAvailable = -1;

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 0) {
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
//            if (place != num){
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
//            if (board[i][column] != num) {
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
                if (board[i][j] == num && board[i][j + 1] == num && board[i][j + 2] == num && board[i][j + 3] == num) {
                    return true;
                }
            }
        }
        //vertikal
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == num && board[i + 1][j] == num && board[i + 2][j] == num && board[i + 3][j] == num) {
                    return true;
                }
            }
        }
        //diagonal schräg nach oben
        for (int i = 3; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j] == num && board[i - 1][j + 1] == num && board[i - 2][j + 2] == num && board[i - 3][j + 3] == num) {
                    return true;
                }
            }
        }
        //diagonal schräg nach unten
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 3; j < board[i].length; j++) {
                if (board[i][j] == num && board[i + 1][j + 1] == num && board[i + 2][j + 2] == num && board[i + 3][j + 3] == num) {
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

            if (board[currRow][currCol] != num) {
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
        for (int[] row: board) {
            for (int place : row) {
                if (place == 1) System.out.print(ANSI_BLUE  + "O  " + ANSI_RESET);
                else if (place == 2) System.out.print(ANSI_YELLOW  + "O  " + ANSI_RESET);
                else System.out.print("*  ");
            }
            System.out.println();

        }

        for (int i = 0; i <= board.length; i++) {
            System.out.print(ANSI_GREEN+(i+1)+"  "+ANSI_RESET);
        }
        System.out.println();

    }


    private void initializeBoard() {
        // initialize board with stars
        for (int[] row : board) {
            Arrays.fill(row,0);
        }

    }

    private boolean isBoardFull() {

        for (int[] row : board) {
            for (int place : row) {
                if (place == 0) return false;
            }
        }

        return true;
    }




}
