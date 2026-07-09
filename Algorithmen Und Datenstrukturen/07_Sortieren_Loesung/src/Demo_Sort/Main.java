package Demo_Sort;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        //BubbleSort bubbleSort = new BubbleSort();
        InsertionSort insertionSort = new InsertionSort();

        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(100);

        printArray(array);

        insertionSort.sort(array);

        printArray(array);


    }

    private static void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + ",");
        System.out.println();
    }
}
