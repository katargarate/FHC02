package Own.Command.UndoableEditor;

public class Document {
    public String docContent = "";

    public void append(String content) {
        docContent += content;
    }

    public String deleteLast(int count) {
        // löscht den letzten `count` Zeichen und liefert den tatsächlich gelöschten Text zurück.
        String textToDelete;

        if (count > 0) {
            if (count <= docContent.length()) {
                // mit Substring den zu löschenden Text in textToDelete speichern
                textToDelete = docContent.substring(docContent.length() - count);

                // den restlichen Text, was überbleibt in docContent speichern
                docContent = docContent.substring(0, docContent.length() - count);
                return textToDelete;
            }
            // sind weniger als `count` Zeichen vorhanden, wird den ganzen vorhandenen Text gelöscht
            String docContentCopy = docContent;
            docContent = "";
            return docContentCopy;
        }
        return "";
    }

    public String getText() {
        return docContent;
    }
}
