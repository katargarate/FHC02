package Own.Decorator.TextVerarbeitung;

import org.w3c.dom.Text;

public class Main {
    // Textverarbeitung ohne Decorators
    // Anwendung eines einzelnen Decorators
    // Kombination von mindestens drei Decorators
    // dieselben Decorators in einer anderen Verschachtelungsreihenfolge
    // Anwendung des SuffixDecorator
    // Geben Sie jeweils den ursprünglichen und den verarbeiteten Text auf der Konsole aus. Verwenden Sie dafür den Text:
    //
    // Text
    //   Hallo Java!


    static void main(String[] args) {
        String text = "   Hallo Java!   ";

        TextProcessor unchanged = new UnchangedProcessor();
        TextProcessor trimmed = new TrimDecorator(new UnchangedProcessor());
        TextProcessor trimmedAndUpper = new UppercaseDecorator(new TrimDecorator(new UnchangedProcessor()));
        TextProcessor megaCombo = new PrefixDecorator(new UppercaseDecorator(new SuffixDecorator(new TrimDecorator(new UnchangedProcessor()), " - SUFFIX")), "PREFIX - ");

       printResult("Unchanged", unchanged, text);
       printResult("Trimmed", trimmed, text);
       printResult("Trimmed and upper case", trimmedAndUpper, text);
       printResult("Trimmed + upper case + prefix + suffix", megaCombo, text);
    }

    private static void printResult(String title, TextProcessor processor, String text) {
        System.out.println(title + ":");
        System.out.println("  Original:  \"" + text + "\"");
        System.out.println("  Processed: \"" + processor.process(text) + "\"");
        System.out.println();
    }


}
