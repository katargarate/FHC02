package Own.Iterator.MenuIterator;

import java.util.Iterator;

public class Main {
    static void main(String[] args) {
        printMenu(new LunchMenu().iterator());
        printMenu(new BreakfastMenu().iterator());
    }

    static void printMenu(Iterator<MenuItem> it) {
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
