package Own.Iterator.MenuIterator;

import java.util.Iterator;

public class LunchMenu implements Iterable<MenuItem> {
    MenuItem[] menuItems = new MenuItem[5];

    public LunchMenu() {
        menuItems[0] = new MenuItem("Burger", 7);
        menuItems[1] = new MenuItem("Fries", 4);
        menuItems[2] = new MenuItem("Wrap", 6);
        menuItems[3] = new MenuItem("Hot Dog", 5);
        menuItems[4] = new MenuItem("Pizza", 10);
    }

    @Override
    public Iterator iterator() {
        // array has no iterator so we hand out our own
        return new MenuIterator(menuItems);
    }
}
