package ExceptionBeispiele;

public class div {

    public static int division(int num1, int num2) throws DBException {
        int result;

        try {
            result = num1 / num2;
            return result;
        }  catch (ArithmeticException e) {
            throw new DBException(e.getMessage());
        }

    }

}
