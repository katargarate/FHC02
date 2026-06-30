package at.campus02.Verhalten;

public class Lektor extends Person {

    public Lektor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String toString() {
        return super.toString() + ", Role: Lektor";
    }

    @Override
    public void getInfo() {
        System.out.println(this + "Role: Lektor"); // es gibt keine zusätzliche Info also habe ich die Role hinzugefuegt
    }

}
