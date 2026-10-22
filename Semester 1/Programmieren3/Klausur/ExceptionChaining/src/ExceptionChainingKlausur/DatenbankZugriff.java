package ExceptionChainingKlausur;

import ExceptionChainingKlausur.Exceptions.DatenbankException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatenbankZugriff {


    public void ladeBenutzer(int id){
        // direkt eine Exception werfen, als ob der Zugriff fehlschlage würde
        String fehlerMeldung = String.format("Benutzer mit id %d konnte nicht gefunden werde, " +
                "da die Datenbankzugriff fehlgeschlagen hat.", id);

        throw new DatenbankException(fehlerMeldung);
    }

}
