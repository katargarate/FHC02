package Models;

public class Person {
    //Eigenschaften der Person, welche sie näher beschreiben
    String vorname;
    String nachname;
    int alter;
    double groesse;
    String adresse;
    String email;
    String telefonnummer;
    String hobbies;
    String beruf;
    String familienstand;
    String augenfarbe;
    boolean hausTierVorhanden;
    char geschlecht;
    public String haarfarbe;
    int fitness = 0;

    public Person(){

    }

    public Person(String vorname){
        this.vorname = vorname;
    }

    public Person(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public Person(String vorname, String nachname, int alter) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
    }

    //Fähigkeiten der Person, welche sie ausführen kann
    //z.B.: Gehen, Schreiben, Lesen, Essen, Trinken, Schlafen, Fahrradfahren, Schwimmen, Musizieren, Programmieren, ...
    public void essenFassen(){
        System.out.printf("Die Person %s hat jetzt gegessen, das war lecker!",vorname);
    }

    public void laufen(){
        System.out.println("bin laufen gewesen, Fitnesslevel gestiegen!");
        fitness++;
    }

    public void gibInfoUeberPerson(){
        //Einfacher bei vielen Variablen mit printf - als print
        System.out.printf("Die Person heißt %s %s und ist %d Jahre alt, ihre Hobbies sind %s und der Fitnesslevel ist %d\n",vorname,nachname,alter,hobbies,fitness);

        //umständliche Version
        //System.out.print("Die Person heißt "+vorname+" "+nachname+" und ist "+alter+" Jahre alt, ihre Hobbies sind "+hobbies);
    }
}

