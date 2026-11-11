package Own.Command.UndoableEditor;

public class DeleteCommand implements Command {
    Document doc;
    int charsToDelete;
    String deleted = null;

    public DeleteCommand(Document doc, int charsToDelete) {
        this.doc = doc;
        this.charsToDelete = charsToDelete;
    }

    @Override
    public void execute() {
        deleted = doc.deleteLast(charsToDelete);
    }

    @Override
    public void undo() {
        if (deleted != null) {
            doc.append(deleted);
            deleted = null;
        }
        else {
            System.out.println("Nothing to un-delete. (Msg coming from DeleteCommand.undo())");
        }
    }
}
