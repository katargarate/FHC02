package UE07_MergeSort_Loesung;

import java.util.LinkedList;

public class MergeSort {

    public LinkedList<Integer> mergesort(LinkedList<Integer> numbers)
    {
        if (numbers.size() <= 1)
            return numbers;

        // Linke Teilliste schaffen
        LinkedList<Integer> leftlist = new LinkedList<Integer>();
        for (int i = 0; i < (numbers.size() / 2); i++) {
            leftlist.add(numbers.get(i));
        }
        // Linke Teilliste rekursiv sortieren
        leftlist = mergesort(leftlist);

        // Rechte Teilliste schaffen
        LinkedList<Integer> rightlist = new LinkedList<Integer>();
        for (int i = leftlist.size(); i < numbers.size(); i++) {
            rightlist.add(numbers.get(i));
        }
        // Rechte Teilliste rekursiv sortieren
        rightlist = mergesort(rightlist);

        // Linke und rechte Teilliste zusammenführen
        return merge(leftlist, rightlist);
    }

    private LinkedList<Integer> merge(LinkedList<Integer> leftlist, LinkedList<Integer> rightlist)
    {
        LinkedList<Integer> mergedlist = new LinkedList<Integer>();

        while ((leftlist.isEmpty() == false) && (rightlist.isEmpty() == false))
        {
            if (leftlist.get(0) < rightlist.get(0)) {
                mergedlist.add(leftlist.get(0));
                leftlist.removeFirst();
            }
            else
            {
                mergedlist.add(rightlist.get(0));
                rightlist.removeFirst();
            }
        }

        if (leftlist.isEmpty() == false)
            mergedlist.addAll(leftlist);

        if (rightlist.isEmpty() == false)
            mergedlist.addAll(rightlist);

        return mergedlist;
    }

}
