package Pensionsantritt;

public class ZAMAgeTooHighException extends ZAMException {
    public ZAMAgeTooHighException(String message) {
        super(message);
    }

    public ZAMAgeTooHighException() {
        super();

    }
}
