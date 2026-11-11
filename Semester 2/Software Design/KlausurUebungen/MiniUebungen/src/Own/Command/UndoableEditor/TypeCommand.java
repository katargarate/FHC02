package Own.Command.UndoableEditor;

public class TypeCommand implements Command {
    Document doc;
    String text;

    public TypeCommand(Document doc, String text) {
        this.doc = doc;
        this.text = text;
    }

    @Override
    public void execute() {
        doc.append(text);
    }

    @Override
    public void undo() {
        doc.deleteLast(text.length());
    }
}
