package at.campus02.fernbedienung;

import java.util.Scanner;

class Main {
    // Das ist unser Klient im Pattern
    public static void main(String[] args) {
        // Fernbedienung ist unser Aufrufer (invoker)
        Fernbedienung fb = new Fernbedienung();
        Licht licht = new Licht();
        TV tv = new TV();
        // geben Empfänger beim Konstruktor mit
        LichtAnKommando lKAn = new LichtAnKommando(licht);
        LichtAusKommando lKAus = new LichtAusKommando(licht);
        TVKanalRaufKommando tvAuf = new TVKanalRaufKommando(tv);
        TVKanalRunterKommando tvAb = new TVKanalRunterKommando(tv);

        // weisen ein Kommando dem Aufrufer zu
        fb.setKommando(1, lKAn);
        fb.setKommando(2, lKAus);
        fb.setKommando(3, tvAuf);
        fb.setKommando(4, tvAb);

        Scanner scanner = new Scanner(System.in);
        while (true){
            String s = scanner.next();
            if(s.equals("q"))
                break;

            try {
                if(s.equals("undo")){
                    fb.undoFernbedienung();
                }else {
                    Integer key = Integer.parseInt(s);
                    fb.knopfGedrueckt(key);
                }

            } catch (NumberFormatException e) {
                System.out.println("Keine gültige Taste!");
            }
        }




    }
}