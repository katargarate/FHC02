public class UppercaseDecorator extends TextDecorator{
    public UppercaseDecorator(TextProcessor processor) {
        super(processor);
    }

    @Override
    public String process(String text) {
        // Wandelt den verarbeiteten Text in Großbuchstaben um.
        return processor.process(text).toUpperCase();
    }
}
