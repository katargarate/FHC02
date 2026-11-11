package Own.Iterator.MenuIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MenuIterator implements Iterator {
    MenuItem[] menuItems;
    private int pos;

    public MenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
        pos = 0;
    }

    @Override
    public boolean hasNext() {
        if (pos < menuItems.length) {
            return true;
        }
        return false;
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No menu items left.");
        }
        return menuItems[pos++];
    }
}
