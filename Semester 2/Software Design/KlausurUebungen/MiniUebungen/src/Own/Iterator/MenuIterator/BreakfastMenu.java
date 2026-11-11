package Own.Iterator.MenuIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class BreakfastMenu implements Iterable<MenuItem> {
    ArrayList<MenuItem> menuItems = new ArrayList<>();

    public BreakfastMenu() {
        menuItems.add(new MenuItem("Scrambled Tofu", 7));
        menuItems.add(new MenuItem("Oatmeal", 5));
        menuItems.add(new MenuItem("Pancakes", 4));
        menuItems.add(new MenuItem("Cinnamon Bun", 3));
        menuItems.add(new MenuItem("Smoothie", 4));
    }

    @Override
    public Iterator iterator() {
        // arraylist already provides an iterator
        return menuItems.iterator();
    }
}
