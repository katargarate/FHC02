package Programmieruebungen3Arrays;

//AUFGABE:
//Schreiben Sie ein Programm, das die Elemente eines Arrays mit 10 ganzen Zahlen
//von der Konsole durch den Benutzer einliest und dann das größte Element findet
//und ausgibt.

import java.util.Arrays;

import static Programmieruebungen3Arrays.StringArrayFilterByStart7.sc;

public class UserReadIntegersArray8 {

    public static void main() {
        int[] nums = new int[10];
        int max = 0;
        int num = 0;
        System.out.println("Enter 10 integers to find the average:");


        for (int i=0; i < 10; i++) {
            System.out.printf("%d: ", i+1);
            num = sc.nextInt();
            nums[i] = num;

            if (num>max) max = num; // if the current num is bigger than max, replace max
        }


        System.out.println("\nThe highest number you entered was " + max);
    }
}
