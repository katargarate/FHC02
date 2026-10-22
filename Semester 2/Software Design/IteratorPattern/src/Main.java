import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    static void main(String[] args) {
        List<String> meineListe = new ArrayList<>();
        meineListe.add("a");
        meineListe.add("b");
        meineListe.add("c");

        // ausgeben in foreach
        for (String s : meineListe) {
            System.out.println(s);
        }

        // meine Liste manuell auslesen
        System.out.println("-------------");
        WordList wordList = new WordList("eins zwei drei vier 4");

        Iterator<String> i1 = wordList.iterator();

        // While-Schleife
        System.out.println("--- Mit While-Schleife ---");
        while (i1.hasNext()) {
            System.out.println(i1.next());
        }

        // For Each Schleife
        System.out.println("--- Mit For-Each-Schleife ---");
        for (String s : wordList) {
            System.out.println(s);
        }
    }
}
