import Figures.*;

import java.io.PrintStream;
import java.util.Scanner;

public class App {
    private final Scanner input;
    private final PrintStream output;
    private boolean exit = false;
    private int figureNr;
    private Figure figure;
    private int sizeInput;

    // Konstruktor
    // input wird verwendet um Daten vom Benutzer einzulesen (verwendet scanner)
    // output wird verwendet um Text auf der Konsole auszugeben (verwendet sysout)
    public App(Scanner input, PrintStream output){
        this.input = input;
        this.output = output;
    }

    //die Gameloop
    public void Run() {
        initialize();
        printState();

        while(!exit) {
            readUserInput();
            updateState();
            printState();
        }
    }

    private void initialize() {
        //TODO: Initialisierungen hier durchführen
    }

    private void readUserInput() {
        //TODO: Alle Eingaben der Benutzer einlesen
        inputFigure();
        inputSize();
    }

    private void updateState() {
        //TODO: Benutzereingaben verarbeiten

        switch (figureNr){
            case 1:
                figure = new FigureH(sizeInput);
                break;
            case 2:
                figure = new FigureL(sizeInput);
                break;
            case 3:
                figure = new FigureO(sizeInput);
                break;
            case 4:
                figure = new FigureO2(sizeInput);
                break;
            case 5:
                figure = new FigureI(sizeInput);
                break;
            case 6:
                figure = new FigureMinus(sizeInput);
                break;
            default: break;
        }
    }

    private void printState() {
        //TODO: Ausgabe des aktuellen Zustands

        if (figure != null){
            output.println(figure);
        }
    }

    private void inputSize() {
        do {
            System.out.print("Welche Größe wollen Sie? 1/2/3: ");
            sizeInput = input.nextInt();
            if (sizeInput < 1 || sizeInput > 3){
                System.out.println("Ungültige Eingabe! Sie müssen eine Zahl zwischen 1-3 eingeben.");
            } else break;
        } while (true);
    }

    private void inputFigure() {
        // Hier sehen Sie ein Pattern für Benutzereingaben
        // Solange kein gültiger Wert eingegeben wurde, wird die Eingabe wiederholt
        do {
            output.print("Welche Grafik möchten Sie anzeigen (1-6): ");
            figureNr = input.nextInt();
            if (figureNr < 1 || figureNr > 6) {
                output.println("Dies ist keine gültige Grafik!");
            }
            else {
                break;
            }
        } while (true);
    }
}