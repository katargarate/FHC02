package Own.Command.UndoableEditor;

public class Main {
    // compares expected text with the document and prints OK or FAIL
    static void check(String expected, Document doc) {
        String actual = doc.getText();
        System.out.println((expected.equals(actual) ? "OK   " : "FAIL ")
                + "expected '" + expected + "', got '" + actual + "'");
    }

    public static void main(String[] args) {
        Document doc = new Document();
        Toolbar tb = new Toolbar();

        TypeCommand tc1 = new TypeCommand(doc, "Hello");
        TypeCommand tc2 = new TypeCommand(doc, " World");
        DeleteCommand dc1 = new DeleteCommand(doc, 3);

        tb.press(tc1);
        check("Hello", doc);
        tb.press(tc2);
        check("Hello World", doc);
        tb.undo();
        check("Hello", doc);
        tb.redo();
        check("Hello World", doc);
        tb.press(dc1);
        check("Hello Wo", doc);
        tb.undo();
        check("Hello World", doc);
        tb.redo();
        check("Hello Wo", doc);
        tb.press(tc1);
        check("Hello WoHello", doc);
        tb.undo();
        check("Hello Wo", doc);
        tb.undo();
        check("Hello World", doc);

        // new action must clear the redo stack
        tb.press(new TypeCommand(doc, "!"));
        check("Hello World!", doc);
        tb.redo(); // should print "Nothing to redo."
        check("Hello World!", doc);

        // deleting more than available, then undo
        Document small = new Document();
        Toolbar tb2 = new Toolbar();
        tb2.press(new TypeCommand(small, "Hi"));
        tb2.press(new DeleteCommand(small, 50));
        check("", small);
        tb2.undo();
        check("Hi", small);

        // empty stacks must not crash
        Toolbar tb3 = new Toolbar();
        tb3.undo(); // should print "Nothing to undo."
        tb3.redo(); // should print "Nothing to redo."
    }
}