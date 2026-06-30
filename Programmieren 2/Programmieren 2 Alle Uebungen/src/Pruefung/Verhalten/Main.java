package Pruefung.Verhalten;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main(String[] args) {
        Lektor le1 = new Lektor("Max", "Mustermann");
        le1.getInfo();

        Person p = le1;

        // Subtyp - Polymorphismus sagt, dass die Implementierung der Unterklasse genommen wird also wird getInfo von Lektor
        // aufgerufen, obwohl p vom Typ Person ist, weil p tatsächlich eine Instanz von Lektor ist
        p.getInfo();



        // Up-casting (kein problem, weil Lektor eine Subklasse von Person ist)
        Lektor le2 = new Mentor("Sandra", "Schuhster");

        // Down-Casting (kann problematisch sein, weil nicht alle Lektoren Mentoren sind, deshalb muss explizit gecastet werden)
        Mentor m1 = (Mentor) le2;


        // Studenteninstanzen machen
        Student s1 = new Student("Lisa", "Müller", 12345);
        Student s2 = new Student("Tim", "Schneider", 67890);
        Student s3 = new Student("Anna", "Fischer", 54321);
        Student s4 = new Student("Muster", "Schneider", 12345);

        // zu m1 Studenten hinzufügen
        m1.addStudent(s1);
        m1.addStudent(s2);
        m1.addStudent(s3);
        m1.addStudent(s4);

        // -- MENTOR INFO AUSGEBEN INKL. STUDENTEN --
        System.out.println("\n------ MENTOR INFO: ------");
        m1.getInfo();


        // --- WRAPPERS ---
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        List<Integer> alleIDs = new ArrayList<>();
        for (Student student : students) {
            alleIDs.add(student.getId()); // werden mit autoboxing als Integer (Wrapper-Klasse) gespeichert
        }

        System.out.println("\n------ WRAPPER BEISPIEL: ------");
        System.out.println("Alle IDs der Studenten: " + alleIDs);

        // jetzt kann auch ein Element auf null gesetzt werden, weil es nicht primitiv ist
        alleIDs.set(0, null);

        System.out.println("\nAlle IDs der Studenten nach Änderung: " + alleIDs);

        // --- GENERICS ---

        // hier habe ich eine Gruppe Klasse erstellt, die für jedes Objekt eine Gruppe erstellen kann,
        // weil sie generisch ist (mit <T> definiert)
        Gruppe<Student> studentenGruppe = new Gruppe<>();
        studentenGruppe.mitgliedHinzufuegen(s1);
        studentenGruppe.mitgliedHinzufuegen(s2);

        studentenGruppe.mitgliederAusgeben();









    }
}
