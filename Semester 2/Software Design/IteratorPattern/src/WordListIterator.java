import java.util.Iterator;

public class WordListIterator implements Iterator<String> {
    private String[] words;
    private int pos; // bei welchem Element bin ich geraade

    public WordListIterator(String[] text) {
        words = text;
        pos = 0; // bei nullte Position beginnen
    }

    @Override
    public boolean hasNext() {
        System.out.println("--- WordListIterator.hasNext() called ---");
        if (pos < words.length) return true;
        return false;

        // simplified:
        // return pos < words.length;
    }

    @Override
    public String next() {
        System.out.println("--- WordListIterator.next() called ---");
        if (hasNext()) {
            return words[pos++];
        }
        return null;
    }
}
