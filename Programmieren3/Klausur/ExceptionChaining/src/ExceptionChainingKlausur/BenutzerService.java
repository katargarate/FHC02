package ExceptionChainingKlausur;

import ExceptionChainingKlausur.Exceptions.DatenbankException;
import ExceptionChainingKlausur.Exceptions.ServiceException;

public class BenutzerService {

    public void holeBenutzer(int id) {
        DatenbankZugriff datenbankZugriff = new DatenbankZugriff();

        try {
            datenbankZugriff.ladeBenutzer(id);
        } catch (DatenbankException e) {
            throw new ServiceException("Benutzer konnte nicht geladen werden.", e);
        }

    }
}
