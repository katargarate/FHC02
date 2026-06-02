package Sorting_Collections;

public class Animal implements Comparable<Animal> {
    private String vorname;
    private String nachname;
    private int alter;

    public Animal(String vorname, String nachname, int alter) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
    }

    public int compareTo(Animal otherAnimal) {
        if (this.alter > otherAnimal.alter) {
            return 1;
        } else  if (this.alter < otherAnimal.alter) {
            return -1;
        } else { // same age
            if (this.vorname.compareTo(otherAnimal.vorname) > 0) {
                return 1;
            }
        }
        return 0; // gleich alt
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }


}
