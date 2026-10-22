import KuchenRezepte.BlueberryPie;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        sparAktionProTag();

    }

    public static void sparAktionProTag(){
        //Scanner erstellen und Eingabe
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte den Tag eingeben: ");
        String tag = scanner.next().toLowerCase();
        double einkauf = 100;

        switch(tag){
            case "montag","dienstag":
                einkauf = einkauf * 0.9;
                break;
            case "mittwoch":
            case "donnerstag":
                einkauf = einkauf * 0.85;
                break;
            case "freitag":
            case "samstag":
                einkauf = einkauf * 0.8;
                break;
            default:
                System.out.println("Systemfehler - kommen Sie an einem anderen Tag.");
        }

        System.out.println("Der Preis beträgt: "+einkauf+"€");


    }



    public static void humanicAktion(){
        //Scanner erstellen und Eingabe
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte das Alter angeben: ");
        int alter = scanner.nextInt();
        System.out.print("Bitte den Einkauf angeben: ");
        double einkauf = scanner.nextDouble();

        switch(alter){
            case 25:
                System.out.println("Sie bekommen 25% Rabatt");
                einkauf = einkauf * 0.75;
                break;
            case 26:
                System.out.println("Sie bekommen 26% Rabatt");
                einkauf = einkauf * 0.74;
                break;
            case 30:
                System.out.println("Sie bekommen 30% Rabatt");
                einkauf = einkauf * 0.70;
                break;
            default:
                System.out.println("Sie liegen leider außerhalb der Aktion!");
        }

        //Ausgabe des finalen Betrags
        System.out.println("Sie zahlen nun: "+einkauf+"€");
    }


    public static void uebung4Teil3(int geldStrafe){
        //Alkopegel als Double-Typ einlesen
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Bitte gib gemessenen Alkopegel an: ");
        double promille = eingabe.nextDouble();

        if(promille <= 0.5){
            System.out.println("Alles i.O. kein Alkoholgehalt gemessen");
        } else if (promille <= 1.0) {
            geldStrafe = geldStrafe + 50;
            System.out.println("Promille gemessen: "+promille+" daher Geldstrafe +50€");
        } else if (promille <= 2.0){
            geldStrafe = geldStrafe + 100;
            System.out.println("Promille gemessen: "+promille+" daher Geldstrafe +100€");
        } else {
            geldStrafe = geldStrafe + 2500;
            System.out.println("Promille gemessen: "+promille+" daher Geldstrafe +2500€");
        }

        System.out.println("Die gesamte Geldstrafe beträgt: "+geldStrafe+"€");
    }

    public static int uebung4Teil2(int ueberschreitung){
        System.out.println("Wir sind in Methode uebung4teil2 und der übergebene Wert lautet:"+ueberschreitung);

        //Nun zur Aufgabe
        int geldStrafe = 0;

        if(ueberschreitung <= 10){
            System.out.println("Schriftliche Verwarnung - alles OK");
        } else if(ueberschreitung <= 20){
            geldStrafe = 30;
            System.out.println("Strafe beträgt 30€");
        } else if(ueberschreitung <= 30){
            geldStrafe = 50;
            System.out.println("Strafe beträgt 50€");
        } else if(ueberschreitung <= 50){
            geldStrafe = 100;
            System.out.println("Strafe beträgt 100€");
        } else if (ueberschreitung <= 100) {
            geldStrafe = 500;
            System.out.println("Strafe beträgt 500€");
        } else {
            geldStrafe = 1500;
            System.out.println("Strafe beträgt 1500€");
        }

        //Geldstrafe als Integer zurückgeben
        return geldStrafe;
    }





    public static int uebung4Teil1(){
        //Scanner erstellen und Eingabe vom Polizisten holen
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte die gemessene Geschwindigkeit eingeben: ");
        int gemesseneGeschw = scanner.nextInt();

        //Differenz berechnen, wenn wir von 50KM/h erlaubter Geschwindigkeit ausgehen
        int ueberschreitung = 0;

        //Das IF notwendig um sicher zu gehen, dass wir keine Differenz nach unten haben
        if(gemesseneGeschw <= 50){
            System.out.println("Alles i.O. die Geschwindigkeit ist OK");
        } else {
            ueberschreitung = gemesseneGeschw - 50;
            System.out.println("Die Geschwindigkeitsüberschreitung beträgt exakt: "+ueberschreitung);
        }

        //Hier geben wir den Wert zurück an den Ort, wo die Methode aufgerufen wurde
        return ueberschreitung;
    }


    public static void uebung3IfAnweisungen(){
        int nummer = 0;
        Scanner eingabe = new Scanner(System.in);
        System.out.print("Bitte Zahl eingeben für Übung 3: ");
        nummer = eingabe.nextInt();

        //Version 1
        if(nummer >= 5){
            if(nummer == 5){
                System.out.println("Nummer = 5");
            } else {
                System.out.println("Nummer ist größer 5");
            }
        } else {
            System.out.println("Nummer ist kleiner 5");
        }

        //Version 2
        if(nummer > 5){
            System.out.println("Nummer ist größer 5");
        } else{
            if(nummer < 5){
                System.out.println("Nummer kleiner 5");
            } else {
                System.out.println("Nummer = 5");
            }
        }

        //Version 3
        if(nummer > 5){
            System.out.println("Nummer ist größer 5");
        } else if (nummer < 5) {
            System.out.println("Nummer ist kleiner 5");
        } else {
            System.out.println("Nummer = 5");
        }
    }


    //Methode um alle Kuchenrezepte mit einem Aufruf anzuzeigen
    public static void kuchenRezepteAufruf(){
        BlueberryPie.rufeAlleRezepteAuf();
    }

    public static void methode1(){
        System.out.println("Zuerst werde ich aufgerufen - ich bin in der Methode1");
    }

    public static void methode3(){
        System.out.println("Nun werde ich aufgerufen - ich bin in der Methode3");
    }

    public static void allerErsteUebung1(){
        System.out.println("Name: XY");
    }

    public static void allerErsteUebung2(){
        System.out.println("Wetter: bewölkt");
        System.out.println("Katzenname: Schnurrli");
    }


    public static void anfangsUebungen(){
        int a = 115;
        boolean b = a <= 110;
        System.out.println(b);
        //Output funktioniert auch ohne Variable
        System.out.println(a<=115);

        //Mittels Scanner eine Eingabe von der Konsole in eine Variable speichern
        Scanner eingabe = new Scanner(System.in); //Erstellen eines Scanner-Objkets

        System.out.printf("Bitte gib hier deinen Namen ein: ");
        String meinname = eingabe.next(); //Einlesen von der Konsole und Speichern in Variable meinname
        System.out.println("Hier ist deine Eingabe: "+meinname); //Ausgabe in die Konsole

        //Adresse in das System einlesen über SCANNER
        String strasse;
        int hausnummer;

        System.out.print("Bitte Strasse eingeben: ");
        strasse = eingabe.next();

        System.out.print("Bitte Hausnummer eingeben: ");
        hausnummer = eingabe.nextInt();

        System.out.println("Meine Adresse ist die "+strasse+" "+hausnummer);
    }

    public static void uebung2(){
        //Schritt 1 aus der Übung
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte den Vornamen eingeben: ");
        String vorname = scanner.next();

        System.out.print("Bitte den Nachnamen eingeben: ");
        String nachname = scanner.next();

        //Schritt 2 aus der Übung
        String name = vorname +" "+nachname;

        //Schritt 3 aus der Übung
        System.out.println("Die Variable Name hat insgesamt: "+name.length()+" Zeichen");
        System.out.println("Die Variable Name hat ohne das eine Leerzeichen: "+(name.length()-1)+" Zeichen");

        //True oder Falls - hat die Variable name mehr als 10 Zeichen?
        boolean b = (name.length()-1) > 10;
        System.out.println("Ist der Name größer als 10-Zeichen? "+b);

        //Schritt 4 aus der Übung
        System.out.println("Willkommen "+name.toUpperCase());
    }
}