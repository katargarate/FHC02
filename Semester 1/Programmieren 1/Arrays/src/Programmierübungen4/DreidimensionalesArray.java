package Programmierübungen4;

/*
Erstelle ein dreidimensionales Array mit den Dimensionen 4x3x2 und fülle jedes Element mit einer zufälligen
double Zahl zwischen 0.0 und 1.0 auf. Führe
anschließend die nachfolgenden Unterpunkte aus und gib am Ende alles gemeinsam
aus (wie bei Übung 2)
    1. Die Summe aller Elemente in diesem Array
    2. Den Durchschnitt aller Elemente in diesem Array
    3. Das größte bzw. maximale Element in diesem Array (Tipp: Initialisieren Sie dieHilfsvariable hierfür mit dem kleinstmöglichen Integer-Wert)
    4. Das kleinste bzw. minimale Element in diesem Array (Tipp: Initialisieren Sie die Hilfsvariable mit dem größtmöglichen Integer-Wert)
 */

import java.util.Arrays;
import java.util.Random;

public class DreidimensionalesArray {
    static double[][][] dreiDimArray = new double[4][3][2];
    static double min;
    static double max;
    static double sum;
    static int counter;

    static void main() {
        fillArray();
        printArray();
        findMinMaxSum();

        double avg = (double) sum/counter;

        System.out.printf("""
                
                Stats:
                Sum: %.2f
                Average: %.2f
                Min: %.2f
                Max: %.2f
                """, sum, avg, min, max);
    }

    private static void findMinMaxSum() {
        sum = 0;
        // initialize with first value
        min = dreiDimArray[0][0][0];
        max = dreiDimArray[0][0][0];

        for (int i = 0; i < dreiDimArray.length; i++) {
            for (int j = 0; j < dreiDimArray[i].length; j++) {
                for (int k = 0; k < dreiDimArray[i][j].length; k++) {

                    double l = dreiDimArray[i][j][k]; // simplify with a new variable

                    counter++; // increment counter (for average later)
                    sum += l;  // add to sum
                    if (l < min) min = l; // replace min, if smaller
                    else if (l > max) max = l; // replace max if bigger
                }
            }
        }
    }

    public static void fillArray() {
        Random r = new Random();
        for (int i = 0; i < dreiDimArray.length; i++) {
            for (int j = 0; j < dreiDimArray[i].length; j++) {
                for (int k = 0; k < dreiDimArray[i][j].length; k++) {
                    dreiDimArray[i][j][k] = r.nextDouble(1.0)+1;
                }
            }
        }
    }


    public static void printArray() {
        for (double[][] arr : dreiDimArray) {
            for (double[] row : arr) {
                for (double num : row) {
                    System.out.printf("%.2f  ", num);
                }
                System.out.println();
            }
        }
    }

}
