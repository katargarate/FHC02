package Pruefungsuebungen.Pruefung_Beispiel_Fuchs_3.Verhalten;

import java.util.ArrayList;
import java.util.List;

public class Mentor extends Lektor {

    private List<Student> students;

    public Mentor(String firstName, String lastName) {
        super(firstName, lastName);
        students = new ArrayList<>(); // initialisieren
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<String> getStudentsInfo() {
        List<String> names = new ArrayList<>();

        // alle Namen hinzufuegen
        for (Student student : students) {
            names.add(student.getFirstName() + " " + student.getLastName());
        }

        return names;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", Students: %s", getStudentsInfo());
    }
}
