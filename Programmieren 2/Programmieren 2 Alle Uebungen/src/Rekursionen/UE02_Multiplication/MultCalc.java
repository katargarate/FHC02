package Rekursionen.UE02_Multiplication;

public class MultCalc {

    /*TODO:
    Implementieren Sie eine rekursive Lösung für die Multiplikation zweier positiver Zahlen ohne den
    Multiplikations-Operator * zu verwenden. Negative Zahlen müssen bei der Lösung nicht
    berücksichtigt werden.
    Tipp: 3 x 4 = 4 + 4 + 4 = 3 + 3 + 3 + 3
     */

    public int calcMultiplication(int multiplicand, int multiplier)
    {
        // Multiplicand = 3 = Wert
        // Multiplier = 4 = Zähler

        // when the multiplier is down to 1 (last recursion), return the multiplicand (just the single value)
        int result;

        if (multiplier == 1) return multiplicand;
        else { // return the current multiplicand with the recursion result
            result = multiplicand + calcMultiplication(multiplicand, (multiplier-1));
            return result;
        }
    }
}
