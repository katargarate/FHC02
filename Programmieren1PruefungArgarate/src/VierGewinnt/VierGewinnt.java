package VierGewinnt;

import java.util.Arrays;
import java.util.Scanner;

public class VierGewinnt {
    char[][] spielfeld = new char[6][7];
    boolean spieler1 = true; // toggle um zu wissen, wer gerade dran ist
    char symbol;
    Scanner sc = new Scanner(System.in);
    boolean spielLaeuft = true;

    // console colours
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_BLUE= "\u001B[34m";
    private final String ANSI_YELLOW =  "\u001B[33m";

    public VierGewinnt() {
        initialisiereSpielfeld();
        zeigeSpielfeld();
    }

    public void spielen() {
        // solange das Spiel läuft (boolean auf true) wird die Schleife wiederholt
        while (spielLaeuft) {
            // Spieler Symbol setzen, abhängig von wer dran ist
            if (spieler1) symbol = 'x';
            else symbol = 'o';

            gueltigerZugSpielen();

            // prüfen, ob Spielfeld voll ist (AKA Spiel vorbei)
            if (istSpielfeldVoll()) {
                System.out.println("No more moves possible. Game over.");
                spielLaeuft = !spielLaeuft; // Abbruchbedingung negieren
            }
            spieler1 = !spieler1; // Speiler wechseln
        }
    }

    private void gueltigerZugSpielen() {

        while (true){
            if (spieler1) System.out.print(ANSI_BLUE+"\nPlayer 1 - Enter column number: "+ANSI_RESET);
            else System.out.print(ANSI_YELLOW+"\nPlayer 2 - Enter column number: "+ANSI_RESET);

            int column = sc.nextInt()-1; // -1 um Index zu bekommen

            int row = reiheFuerSpalteFinden(column); // Passende Reihe finden mittel Helfermethode

            // wenn -1 zurückgegeben wird, heißt es, es gibt keine freie Plaetze in der Reihe
            if (row != -1) {
                spielfeld[row][column] = symbol;
            } else {
                System.out.println("No free spots in this column, try again.");
                continue; // nächste Iteration
            }

            zeigeSpielfeld(); // aktualisiert anzeigen

            if (checkForWin(row, column)){
                if (spieler1) System.out.println(ANSI_BLUE+"\nPLAYER 1 WINS"+ANSI_RESET);
                else System.out.println(ANSI_YELLOW+"\nPLAYER 2 WINS"+ANSI_RESET);

                spielLaeuft = false;
            }

            break; // raus wenn fertig
        }

    }

    private int reiheFuerSpalteFinden(int col) {
        int lowestAvailable = -1;

        // schleife durch Spalte machen um zu finden, was der niedrigsten möglichen Reihe wäre
        for (int i = 0; i < spielfeld.length; i++) {
            if (spielfeld[i][col] == '*') {
                lowestAvailable = i; // ersetzen
            }
        }
        return lowestAvailable;
    }

    private boolean checkForWin(int row, int column) {

        // horizontal win
        int counter = 0;
        for (char place : spielfeld[row]) {
            if (counter >= 4) return true;
            if (place != symbol){
                counter = 0;

            } else {
                counter ++;
            }
        }

        // vertical win
        counter = 0;  // reset counter

        for (int i = 0; i < spielfeld.length; i++) {

            if (spielfeld[i][column] != symbol) {
                counter = 0;
            } else {
                counter++;
            }
            if (counter == 4) return true;
        }

        // nach links diagonal checken, wenn true zurückkommt, schon true returnen
        if (checkForDiagonalWin(row, column, true)) return true;
        // nach rechts diagonal checken, wenn true zurückkommt, schon true returnen
        if (checkForDiagonalWin(row, column, false)) return true;

    return false; // sonst return false

    }

    private boolean checkForDiagonalWin(int row, int column, boolean toLeft) {
        int counter = 0;

        int currRow = row;
        int currCol = column;

        // Zum Start von der Diagonale gehen (edge of the board) zum starten
        if (!toLeft) {
            // rechts runter
            while (currRow < 5 && currCol > 0) {
                currRow++;
                currCol--;
            }
        } else {
            //links runter
            while (currRow < 5 && currCol < 6) {
                currRow++;
                currCol++;
            }
        }

        // Diagonale scannen
        while (currRow >= 0 && currRow <= 5 && currCol >= 0 && currCol <= 6) {

            // wenn der symbol gefunden wird counter erhöhen, sonst wieder auf 0 setzen
            if (spielfeld[currRow][currCol] != symbol) {
                counter = 0;
            } else {
                counter++;
            }

            if (counter == 4) return true; // wenn der counter 4 erreicht (4 hintereinander genfunden) - gewinn gefunden

            // Die Schritte rauf/ruunter
            if (!toLeft) {
                // rechts rauf
                currRow--;
                currCol++;
            } else {
                // links rauf
                currRow++;
                currCol--;
            }
        }

        return false;
    }


    private void zeigeSpielfeld() {
        // mit for-each Schleife alles ausgeben, obwohl die Züge als x und o gespeichert werden, gebe ich die trotzdem
        // beide als O aus (blau bei P1, gelb bei P2) damit es realistischer ausschaut.
        System.out.println();
        for (char[] row: spielfeld) {
            for (int place : row) {
                if (place == 'x') System.out.print(ANSI_BLUE  + "O  " + ANSI_RESET);
                else if (place == 'o') System.out.print(ANSI_YELLOW  + "O  " + ANSI_RESET);
                else System.out.print("*  "); // wenn es noch leer ist, einfach den * ausgeben
            }
            System.out.println();

        }

        // Nachdem alle Felder ausgegeben werden, wir zusätzlich eine grüne Reihe von Spaltenzahlen
        // ausgegeben, um den Benutzer zu helfen die richtige Spalte leicht auszusuchen.
        for (int i = 0; i <= spielfeld.length; i++) {
            System.out.print(ANSI_GREEN+(i+1)+"  "+ANSI_RESET);
        }
        System.out.println();

    }


    private void initialisiereSpielfeld() {
        // zum Init. wird das Spielfeld mit * gefüllt, um alle als leere Plätze zu speichern
        for (char[] row : spielfeld) {
            Arrays.fill(row,'*');
        }

    }

    private boolean istSpielfeldVoll() {
        // for-each Schleife durch das Spielfeld um zu überprüfen, ob es schon voll ist.
        // sobald ein * gefunden wird, wird false zurückgegeben, da wir dann nichts Weiteres überprüfen müssen
        for (char[] row : spielfeld) {
            for (int place : row) {
                if (place == '*') return false;
            }
        }
        return true; // wenn keine * gefunden werden, wird false zurückgegeben
    }




}
