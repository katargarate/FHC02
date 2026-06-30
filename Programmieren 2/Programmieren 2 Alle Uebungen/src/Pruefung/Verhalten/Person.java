package at.campus02.Verhalten;

// könnte eigentlich abstract sein, aber ist nicht in der Angabe oder UML so gestanden, also hab ich es nicht-abstrakt gelassen
public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void getInfo() {
        System.out.println(this); // gibt die Info von toString aus
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s, Last Name %s", firstName, lastName);
    }
}
