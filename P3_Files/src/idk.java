public class idk {
    static void main(String[] args) {
        System.out.println("Antwort von funktion 4: " + funktion1(5));
    }

    private static int funktion1(int mult) {
        return funktion2(mult);
    }

    private static int funktion2(int mult) {
        return funktion3(mult);
    }

    private static int funktion3(int mult) {
        return funktion4(mult);
    }

    private static int funktion4(int mult) {
        return mult * mult;
    }
}
