package Schleifen;

import java.util.Scanner;


public class Uebung1While {
    static Scanner sc = new Scanner(System.in);
    static void main() {
//        version1();
        version2();

    }

    static void version1() {
        System.out.print("Enter a number: ");

        int num = sc.nextInt();
        int numCopy =  num;
        int sum = 0;

        while(num > 0) {
            sum += num;
            num--;
        }

        System.out.printf("The sum of the numbers 1 - %d is %d", numCopy, sum);
    }


    static void version2() {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int counter = 1;
        int sum = 0;

        while(counter <= num) {
            sum += counter;
            counter++;
        }

        System.out.printf("The sum of the numbers 1 - %d is %d", num, sum);
    }
}
