import java.util.Arrays;

public class EvenNumberArray1 {

    static void main() {
        version2();
    }

    public static void version1() {
        String[] even =  new String[100];
        int curr = 0;

        for (int i = 2; i <= even.length; i++){
            if (i % 2 == 0) {
                even[curr] = Integer.toString(i); // add String version to array at index curr
                curr++;
            }
        }

        //print the array as a string
        System.out.println(Arrays.toString(even));

    }

    public static void version2() {
        String[] even =  new String[100];
        int curr = 0;

        // incrementing by 2 each time so we don't have to check if even
        for (int i = 2; i <=200; i+=2){
            even[curr] = Integer.toString(i);
            curr++;
        }

        //print the array as a string
        System.out.println(Arrays.toString(even));

    }


}
