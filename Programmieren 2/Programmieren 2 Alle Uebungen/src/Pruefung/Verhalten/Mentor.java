package Pruefung.Verhalten;

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

    @Override
    public String toString() {
        return super.toString() + String.format(", Anzahl Studenten: %d", students.size());
    }

    @Override
    public void getInfo() {
        System.out.println(this); // gibt die Info von toString aus

        // zusätzliche auch die Studenten
        System.out.printf("Studenten von Mentor %s %s :\n", getFirstName(), getLastName());
        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }
}
