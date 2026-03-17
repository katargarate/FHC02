public class dsfs {
    static void main() {
        String name = "kat";

        sayHi(name);

        int num = 3;
        add2(num);
        // System.out.println(sum);
    }

    private static void add2(int num) {
        System.out.println(num + 2);
    }

    private static void sayHi(String name) {
        System.out.println("hi, " + name);
    }


}
