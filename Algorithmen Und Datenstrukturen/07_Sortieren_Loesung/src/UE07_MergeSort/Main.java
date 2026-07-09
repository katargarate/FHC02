package UE07_MergeSort;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        MergeSort sorter = new MergeSort();

        numbers.add(8);
        numbers.add(3);
        numbers.add(5);
        numbers.add(2);
        numbers.add(7);
        numbers.add(1);
        numbers.add(9);
        numbers.add(6);
        numbers.add(4);
        numbers.add(10);

        System.out.println("List before sorting: " + numbers);

        LinkedList<Integer> sortedlist = sorter.mergesort(numbers);

        System.out.println("List after sorting: " + sortedlist);



    }
}
