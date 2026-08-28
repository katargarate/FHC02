package Pensionsantritt;

public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws ZAMAgeTooHighException, ZAMAgeTooLowException {

        if (age >= 65) {
            throw new ZAMAgeTooHighException("Age is too high");
        } else if (age < 60) {
            throw new ZAMAgeTooLowException("Age is too low.");
        } else {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d", name, age);
    }
}
