package Own.Command.SmartHome;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoteControl {

    private final Command[] buttons = new Command[3];
    private final Deque<Command> history = new ArrayDeque<>();


    public void setCommand(int slot, Command c) {
        if (slot < 0 || slot >= buttons.length) {
            System.out.println("Ungültiger Slot.");
            return;
        }
        buttons[slot] = c;
    }

    public void pressButton(int slot) {
        if (slot < 0 || slot >= buttons.length || buttons[slot] == null) {
            System.out.println("Slot leer.");
            return;
        }
        Command c = buttons[slot];
        c.execute();
        // push + pop = stack, newest on top
        history.push(c);
    }

    public void undo() {
        if (history.isEmpty()) {
            System.out.println("Nichts rückgängig zu machen.");
        } else {
            history.pop().undo();
        }
    }
}
