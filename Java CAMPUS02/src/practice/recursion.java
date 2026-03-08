package practice;

public class recursion {
    public static int sum(int k) {
        if (k > 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }


     static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
    }
}
