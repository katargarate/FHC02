package at.campus02.Verhalten;

import java.util.ArrayList;

public class Gruppe<T> {
    private ArrayList<T> mitglieder;

    public Gruppe() {
        mitglieder = new ArrayList<>();
    }

    public void mitgliedHinzufuegen(T mitglied) {
        this.mitglieder.add(mitglied);
    }

    public ArrayList<T> getMitglieder() {
        return mitglieder;
    }

    public void mitgliederAusgeben(){
        for (T mitglied : mitglieder) {
            System.out.println(mitglied);
        }

    }
}
