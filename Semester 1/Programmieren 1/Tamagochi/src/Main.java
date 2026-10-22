import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Spieler fragen welche Version er spielen moechte, beide sind im Aussehen gleich
        //Version 1 = ohne Array --> Bessere und elegantere Loesung!
        //Version 2 = mit Array --> Umstaendlicher!
        System.out.print("Welche Version des Spiels wollen sie Starten? 1 oder 2: ");
        Scanner in = new Scanner(System.in);
        int eingabe = in.nextInt();
        if(eingabe == 1) {
            Version1Starten();
        } else if(eingabe == 2) {
            Version2Starten();
        }
    }

    public static void Version1Starten(){
        //Erstellen eines Tamagotchi-Spiel-Objektes
        TamagotchiV1 spiel1 = new TamagotchiV1();
        //Starten des Tamagotchi-Version1 spiels
        spiel1.spielen();
    }

    public static void Version2Starten(){
        //Nun Version 2, die anders aufgebaut ist
        TamagotchiV2 spiel2 = new TamagotchiV2();
        spiel2.spielen();
    }
}