public class UnchangedProcessor implements  TextProcessor{
    //Erstellen Sie die Klasse UnchangedProcessor, die TextProcessor implementiert.
    // Sie soll den übergebenen Text unverändert zurückgeben.
    @Override
    public String process(String text) {
        return text;
    }
}
