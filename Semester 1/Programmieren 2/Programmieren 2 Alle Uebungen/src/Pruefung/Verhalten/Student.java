package Pruefung.Verhalten;

public class Student extends Person {
    private int id;

    public Student(String firstName, String lastName, int id) {
        super(firstName, lastName);
        this.id = id;
    }

    @Override
    public void getInfo() {
        System.out.println(this); // gibt die Info von toString aus
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", ID: %d", id);
    }
}
