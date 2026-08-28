package ExceptionChainingKlausur.Exceptions;

public class DatenbankException extends RuntimeException {
    public DatenbankException(String message) {
        super(message);
    }

    public DatenbankException(String message, Throwable cause) {
        super(message, cause);
    }
}
