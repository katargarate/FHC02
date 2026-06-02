package Pruefungsuebungen.Pruefung_Beispiel_Fuchs_3.Verhalten;

public class Student extends Person {
    private int id;

    public Student(String firstName, String lastName, int id) {
        super(firstName, lastName);
        this.id = id;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", ID: %d", id);
    }

    public int getId() {
        return id;
    }
}
