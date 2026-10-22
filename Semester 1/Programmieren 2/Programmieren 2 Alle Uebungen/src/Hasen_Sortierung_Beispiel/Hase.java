package Hasen_Sortierung_Beispiel;

public class Hase implements Comparable<Hase> {
    private String name;
    private int alter;
    private int anzahlKarotten;
    private int vacationDays;

    public Hase(String name, int alter, int anzahlKarotten, int urlaubsTage) {
        this.name = name;
        this.alter = alter;
        this.anzahlKarotten = anzahlKarotten;
        this.vacationDays = urlaubsTage;
    }

    @Override
    public int compareTo(Hase andereHase) {
        if (this.alter > andereHase.alter) {
            return 1; // wenn diese Hase älter ist
        } else  if (this.alter < andereHase.alter) {
            return -1; // wenn diese Hase jünger ist
        } else { // wenn beide gleich alt sind nach Karottenanzahl sortieren:
            if (this.anzahlKarotten > andereHase.anzahlKarotten) { // wenn diese Hase mehr Karotten hat
                return 1;
            } else if (this.anzahlKarotten < andereHase.anzahlKarotten) { // wenn diese Hase weniger Karotten hat
                return -1;
            }

        } return 0; // default, wenn beide gleich alt sind und auch gleich viele Karotten haben
    }

    @Override
    public String toString() {
        return String.format("name: %s, alter: %s, anzahl karotten %d, urlaubstage: %d", name, alter, anzahlKarotten, vacationDays);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public int getAnzahlKarotten() {
        return anzahlKarotten;
    }

    public void setAnzahlKarotten(int anzahlKarotten) {
        this.anzahlKarotten = anzahlKarotten;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }
}
