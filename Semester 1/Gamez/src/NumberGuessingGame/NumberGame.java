package NumberGuessingGame;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    private String ANSI_RESET = "\u001B[0m";
    private String ANSI_GREEN = "\u001B[32m";
    private String ANSI_BLUE = "\u001B[34m";
    private String ANSI_RED =  "\u001B[31m";

    private int maxNumber; // user chooses max number
    private int maxAttempts; //  User chooses max attempts


    private int guess = 0;
    private int attempts = 0;
    private int gamesWon = 0; // start at 0
    private int gamesPlayed = 0; // start at 0
    private boolean playAgain = true;



    public void mainMenu() {

        do {
            System.out.println(ANSI_GREEN+"\nNumber Guessing Game");
            System.out.println("------------------");
            // Difficulty selection (only changes number range)
            System.out.println(ANSI_BLUE+"""
                    Select difficulty:
                    1. Easy (1-15)
                    2. Medium (1-30)
                    3. Hard (1-50)
                    4. End Game
                    """+ANSI_RESET);
            System.out.print("Your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    maxNumber = 15; // set maxNumber accordingly
                    maxAttempts = 5; // set maxAttempty accordingly
                    break;
                case 2:
                    maxNumber = 30;
                    maxAttempts = 8;
                    break;
                case 3:
                    maxNumber = 50;
                    maxAttempts = 10;
                    break;
                case 4:
                    playAgain = false; // cancel while loop condition
                    continue; // skip playGame, trick into going to next iteration to break out
                default:
                    System.out.println("Invalid choice, try again.");
                    continue; // go to next iteration to allow user to try again
            }

            playGame();
            gamesPlayed++; // increment counter for total games played

            // returns false if they do not wish to play again, therefore ending the game
            // because the while condition is no longer true
            playAgain = getPlayAgainAnswer();


        } while(playAgain);

        // before ending program, display game stats
        System.out.printf("\nThanks for playing! Games won: %d/%d\nGoodbye!", gamesWon, gamesPlayed);


    }

    private boolean getPlayAgainAnswer() {
        while (true) {
            System.out.print("\nWould you like to play again? Y/N: ");
            String input = sc.next();

            if (input.equalsIgnoreCase("N")) {
                return false; // if n return false
            } else if  (input.equalsIgnoreCase("Y")) {
                return true; // if y return true
            }
            // for any other input cue a valid input (repeast loop until valid)
            System.out.println(ANSI_RED+"Invalid choice. Try Again."+ANSI_RESET);
        }

    }

    private void playGame() {
        int randomNumber = r.nextInt(maxNumber) + 1; // initialize random number
        attempts = 0; // reset attempts counter
        guess = 0;

        System.out.printf("\nYou have ONLY %d guesses!\nGuess a number between 1 and %d.\n", maxAttempts, maxNumber);

        while (guess != randomNumber && attempts < maxAttempts) {

            System.out.printf("\nAttempt %d: ",attempts + 1);
            guess = sc.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low!");
            } else if (guess > randomNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println(ANSI_GREEN+"Correct!"+ANSI_RESET);
                gamesWon++; // increment counter
            }
        }

        if (guess != randomNumber) {
            System.out.println(ANSI_RED+"\nYou lost!The number was: "+ randomNumber + ANSI_RESET);
        }
    }
}
