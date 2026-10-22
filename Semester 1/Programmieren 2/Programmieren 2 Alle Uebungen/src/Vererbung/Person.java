package Vererbung;

public abstract class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void doSomething(){
        System.out.println("Doing something.....");
    }

    @Override
    public String toString() {
        return  "First Name: " + firstName + '\'' +
                ", Last Name: " + lastName + '\'' +
                '}';
    }
}
