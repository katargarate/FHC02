package ExceptionChainingKlausur;

import ExceptionChainingKlausur.Exceptions.ApplikationException;
import ExceptionChainingKlausur.Exceptions.ServiceException;


public class Applikation {
    public void starte() {
        try {
            BenutzerService benutzerService = new BenutzerService();
            benutzerService.holeBenutzer(10);
        } catch (ServiceException e) {
            throw new ApplikationException("Applikation konnte nicht ausgeführt werden.", e);
        }
    }
}
