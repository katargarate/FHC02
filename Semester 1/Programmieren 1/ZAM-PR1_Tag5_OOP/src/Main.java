import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mitKonstruktor();
    }

    public static void mitKonstruktor(){
        //Objekt der Klasse Person erstellen - Instanz erstellen
        Person p1 = new Person("Günter","Urig",56);

        p1.gibInfoUeberPerson();

        //Nun dem Objekt/Instanz einzelne Eigenschaften zuweisen
        p1.alter = 70;
        p1.fitness = 5; //0 (schlecht) - 10 (sehr gut)

        //Mit Scanner trdm. erstellen
        Scanner sc = new Scanner(System.in);
        System.out.println("Gib vorname, nachname und alter nacheinander ein und bestätige jedesmal mit Enter!");
        Person p2 = new Person(sc.next(), sc.next(), sc.nextInt());

        //Infos ausgeben
        p1.gibInfoUeberPerson();
        p2.gibInfoUeberPerson();

        Person p3 = new Person("Walter");
        p3.gibInfoUeberPerson();
    }

    public static void vorfuehrung() {
        //Objekt der Klasse Person erstellen - Instanz erstellen
        Person p1 = new Person("Günter","Urig",56);

        //Nun dem Objekt/Instanz einzelne Eigenschaften zuweisen
        p1.vorname = "Günter";
        p1.nachname = "Urig";
        p1.alter = 56;
        p1.fitness = 5; //0 (schlecht) - 10 (sehr gut)

        //Daten erstmalig ausgeben einmal mit println und einmal mit printf -> Vorgehen wie mit normalen Variablen!
        System.out.println("Die person heißt "+p1.vorname+" und ist "+p1.alter+" Jahre alt!");
        System.out.printf("Die person heißt %s %s und ist %d Jahre alt!\n\n",p1.vorname,p1.nachname,p1.alter);

        //Holen wir uns nun Informationen über die Person, durch eine Funktion
        p1.gibInfoUeberPerson();

        //Zweite Person erstellen und Eigenschaften zuweisen
        Person p2 = new Person();
        p2.vorname = "Mona";
        p2.nachname = "Hüpf";
        p2.alter = 13;
        p2.fitness = 10;

        p2.gibInfoUeberPerson();

        //Dritte Person erstellen, diesmal mit dynamischen Daten
        Person p3 = new Person();
        Scanner input = new Scanner(System.in);

        System.out.print("Bitte gib Vorname der Person ein: ");
        p3.vorname = input.next();
        System.out.print("Bitte gib Nachname der Person ein: ");
        p3.nachname = input.next();
        System.out.print("Bitte gib Alter der Person ein: ");
        p3.alter = input.nextInt();
        System.out.print("Bitte gib Fitnesslevel der Person ein: ");
        p3.fitness = input.nextInt();

        //Gib nochmal alle Infos gesammelt aus
        System.out.println();
        p1.gibInfoUeberPerson();
        p2.gibInfoUeberPerson();
        p3.gibInfoUeberPerson();
    }
}