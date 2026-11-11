package Own.Command.UndoableEditor;

import java.util.ArrayDeque;
import java.util.Deque;

public class Toolbar {
    private Deque<Command> undoStack = new ArrayDeque<>();
    private Deque<Command> redoStack = new ArrayDeque<>();

    public void press(Command command) {
        // Step 1: execute the command
        command.execute();

        // Step 2: push this command to the undo stack so it can be undone later
        undoStack.push(command);

        // Step 3: Redo History is cleared because of the new action
        redoStack.clear();
    }

    public void undo() {
        // Step 1: check if the undo stack is empty, if so return
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }
        // Step 2: Otherwise get the command and delete it from the undo stack by popping
        Command command = undoStack.pop();

        // Step 3: use the command's undo method
        command.undo();

        // Step 4: add the command into the redo stack so it can be redone
        redoStack.push(command);
    }

    public void redo() {
        // Step 1: check if the redo stack is empty, if so return
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }

        // Step 2: Otherwise get the command and delete it from the redo stack by popping
        Command command = redoStack.pop();

        // Step 3: use the command's execute method to re-execute it
        command.execute();

        // Step 4: put the command into the undo stack so it can be re-undone
        undoStack.push(command);
    }
}
