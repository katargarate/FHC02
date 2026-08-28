package ExceptionChainingKlausur.Exceptions;

public class ApplikationException extends RuntimeException {
    public ApplikationException(String message) {
        super(message);
    }

    public ApplikationException(String message, Throwable cause) {
        super(message, cause);
    }
}
