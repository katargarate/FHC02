package Pruefungsuebungen.Pruefung_Beispiel_Fuchs_3.Verhalten;

public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getInfo() {
        return String.format("First Name: %s, Last Name %s", firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
