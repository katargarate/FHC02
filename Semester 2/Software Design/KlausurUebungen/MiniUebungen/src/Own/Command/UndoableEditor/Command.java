package Own.Command.UndoableEditor;

public interface Command {

    public void execute();
    public void undo();
}
