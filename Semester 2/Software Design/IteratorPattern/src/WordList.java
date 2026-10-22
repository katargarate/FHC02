import java.util.Iterator;

public class WordList implements Iterable<String> {
    private String[] text;

    public WordList(String text) {
        this.text = text.split(" ");
        System.out.println("Word list created with string: " + text);
    }

    @Override
    public Iterator<String> iterator() {
        return new WordListIterator(text);
    }
}
