public class TrimDecorator extends TextDecorator{
    public TrimDecorator(TextProcessor processor) {
        super(processor);
    }

    @Override
    public String process(String text) {
       // Entfernt Leerzeichen am Anfang und Ende des verarbeiteten Textes.
        return processor.process(text.trim());
    }
}
