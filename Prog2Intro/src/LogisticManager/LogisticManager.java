package LogisticManager;

import java.util.ArrayList;
import java.util.List;

public class LogisticManager {

    private List<Moveable> moveables = new ArrayList<>();

    public void addMoveable(Moveable moveable) {
        moveables.add(moveable);
    }

    public void removeMoveable(Moveable moveable) {
        moveables.remove(moveable);
    }

    public void moveAll(String destination) {
        if (moveables.isEmpty()) {
            System.out.println("No moveable objects!");
        }
        for (Moveable moveable : moveables) {
            moveable.move(destination);
        }
    }

    public List<Moveable> getMoveables() {
        return moveables;
    }
}
