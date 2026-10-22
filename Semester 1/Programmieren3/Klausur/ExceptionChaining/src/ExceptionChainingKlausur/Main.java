package ExceptionChainingKlausur;

import ExceptionChainingKlausur.Exceptions.ApplikationException;

public class Main {
    public static void main(String[] args) {
        Applikation applikation = new Applikation();

        try {
            applikation.starte();
        } catch (ApplikationException e) {
            e.printStackTrace();
        }
    }
}
