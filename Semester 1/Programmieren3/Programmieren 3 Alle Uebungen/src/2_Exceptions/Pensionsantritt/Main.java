package Pensionsantritt;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person p = new Person(64, "Petra");

        boolean ageSuccessfullyChanged = false;

        do {
            System.out.print("Neues Alter (60-64) für Petra eingeben: ");

            try {
                int age = sc.nextInt();
                p.setAge(age);
                ageSuccessfullyChanged = true;
            } catch (InputMismatchException e) {
                System.err.println("Fehler: Eingabe kann nicht als Zahl interpretiert werden!");
                sc.nextLine(); // Buffer leeren
            } catch (ZAMException e) {
                System.err.println("Fehler: " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.err.println("ERROR: Strg+D gedrückt, beende das Programm.");
                return;
            } catch (NullPointerException e) {
                System.err.println("Fehler: Peter gibt es nicht. Beende mich.");
                return;
            } catch (Exception e) {
                System.out.println("ERROR: unbekannter Error" + e.getMessage() + e.getClass());
                System.err.println("ERROR: beende Programm.");
                return;
            }
        } while (!ageSuccessfullyChanged);


        System.out.println("Petra's new age is: " + p.getAge());

    }


}
