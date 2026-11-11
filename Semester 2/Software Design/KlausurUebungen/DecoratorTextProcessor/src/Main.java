public class Main {
    public static void main(String[] args) {
        String text = "   Hallo Java!   ";

        TextProcessor unchanged = new UnchangedProcessor();

        TextProcessor trimmed = new TrimDecorator(new UnchangedProcessor());

        TextProcessor combination =
                new PrefixDecorator(
                        new UppercaseDecorator(
                                new TrimDecorator(
                                        new UnchangedProcessor()
                                )
                        ),
                        "ERGEBNIS: "
                );

        TextProcessor differentOrder =
                new UppercaseDecorator(
                        new PrefixDecorator(
                                new TrimDecorator(
                                        new UnchangedProcessor()
                                ),
                                "Ergebnis: "
                        )
                );

        TextProcessor withSuffix =
                new SuffixDecorator(
                        new TrimDecorator(new UnchangedProcessor()),
                        " — verarbeitet"
                );

        printResult("Unverändert", unchanged, text);
        printResult("Leerzeichen entfernt", trimmed, text);
        printResult("Kombination", combination, text);
        printResult("Andere Reihenfolge", differentOrder, text);
        printResult("Mit Suffix", withSuffix, text);
    }

    private static void printResult(
            String title,
            TextProcessor processor,
            String text
    ) {
        System.out.println(title + ":");
        System.out.println("  Ursprünglich:  \"" + text + "\"");
        System.out.println("  Verarbeitet:   \"" + processor.process(text) + "\"");
        System.out.println();
    }
}