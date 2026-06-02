package Models;

public class Rechner {

    static void main() {

        System.out.println("2 + 3 = " + addieren(2,3));
        System.out.println("2.2 + 3.5 = " +  addieren(2.2,3.5));

        System.out.println("2 + 3 + 4 = " + addieren(2,3,4));
        System.out.println("2.2 + 3.5 + 1.5 = " +  addieren(2.2,3.5,1.5));
    }

    public static int addieren(int x, int y) {
        return x + y;
    }

    public static  double addieren(double x, double y) {
        return x + y;
    }

    public static int addieren(int x, int y, int z) {
        return x + y + z;
    }

    public static double addieren(double x, double y, double z) {
        return x + y + z;
    }
}
