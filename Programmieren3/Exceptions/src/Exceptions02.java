class Exceptions02 {
    public static void main(String[] args) {

        if (5 < 8) {
            throw new DBnotFoundException("Das ist meine Privatexception");
        }

        System.out.println("Hallo");
    }
}