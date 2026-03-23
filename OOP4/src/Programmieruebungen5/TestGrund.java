package Programmieruebungen5;

public class TestGrund {
    static void main() {
        int[][] grundstuecke = {
                {1, 30, 40},
                {2, 20, 50},
                {3, 10, 30}
        };

        Grundsteuer gs = new Grundsteuer();
        double summe = gs.grundSteuerberechnen(grundstuecke);
        System.out.printf("Summe der Grundsteuer: €%.2f",summe);
    }


}
