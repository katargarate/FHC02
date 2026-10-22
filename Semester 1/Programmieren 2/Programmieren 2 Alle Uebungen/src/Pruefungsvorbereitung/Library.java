package Pruefungsvorbereitung;

import java.util.ArrayList;

public class Library<T> {
    private ArrayList<T> list;

    public Library() {
        list = new ArrayList<T>();
    }

    public void addToLibrary(T item) {
        list.add(item);
    }

    public ArrayList<T> getLibrary() {
        return list;
    }

    public void printLibrary() {
        for (T item : list) {
            System.out.println(item.toString());
        }
    }
}
