package Own.Command.LightRemoteControl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RemoteControl {
    Deque<Command> history = new ArrayDeque<>();
    Map<Integer, Command> buttonSlots = new HashMap<>();

    public void addCommand(Command c) {
        buttonSlots.put(buttonSlots.size(), c);
        System.out.println("Added command: " + c.getClass());
    }

    public void pressButton(int slot) {
        Command btn = buttonSlots.get(slot);

        if (btn != null) {
            btn.execute();
            history.add(btn);
        } else {
            System.out.println("No command assigned to this button slot.");
        }
    }

    public void undo() {
        if (history.isEmpty()) {
            System.out.println("Nothing to undo.");
        } else {
            Command last = history.removeLast();
            System.out.println("Undoing:" + last.getClass());
            last.undo();
        }
    }
}
