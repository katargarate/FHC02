package Pruefungsuebungen.Pruefung_Beispiel_Fuchs_3.Verhalten;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main(String[] args) {
        Lektor le1 = new Lektor("Max", "Mustermann");
        System.out.println(le1.getInfo());

        Person p = le1;

        // wäre die toString Methode in Lektor überschrieben, würde die von Lektor genommen werden, obwohl p vom Typ Person ist
        // (Subtyp - Polymorphismus sagt, dass die Implementierung der Unterklasse genommen wird)
        // dadurch, dass Lektor keine zusätzlichen Attribute hat, habe ich in Lektor toString nicht überschrieben
        // deshalb wird die geerbte toString()-Methode von Person verwendet.

        System.out.println(p.getInfo());


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

        System.out.println(m1.getInfo());

        /*
        Wrapper Klassen (erstellen Sie zB einen primitiven Typ und weisen sie einer Wrapper
Klasse diesen Typ zu.
•Generics (erstellen Sie einen Generic und verwenden Sie ihn)
         */

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

        System.out.println("\n------ WRAPPER BEISPIEL:");
        System.out.println("Alle IDs der Studenten: " + alleIDs);

        // jetzt kann auch ein Element auf null gesetzt werden, weil es nicht primitiv ist
        alleIDs.set(0, null);

        System.out.println("\nAlle IDs der Studenten nach Änderung: " + alleIDs);

        // --- GENERICS ---

        Gruppe<Student> studentenGruppe = new Gruppe<>();
        studentenGruppe.mitgliedHinzufuegen(s1);
        studentenGruppe.mitgliedHinzufuegen(s2);

        studentenGruppe.mitgliederAusgeben();









    }
}
