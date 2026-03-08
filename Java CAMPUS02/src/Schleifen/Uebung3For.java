package Schleifen;

public class Uebung3For {

    static void main() {
        teil1();
        teil2();
    }

    public static void teil1() {
        for (int i=1;i<=10; i++){
            System.out.println(i);
        }
    }

    public static void teil2() {
        for (int i=0;i<=30; i++){
            if (i%2==0) {
                System.out.println(i);
            }
        }
    }
}
