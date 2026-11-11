public class PrefixDecorator extends TextDecorator{
    private String prefix;

    public PrefixDecorator(TextProcessor processor, String prefix) {
        super(processor);
        this.prefix = prefix;
    }

    @Override
    public String process(String text) {
        // Fügt einen frei wählbaren Präfix vor dem verarbeiteten Text ein.
        return String.format("%s %s",prefix, processor.process(text.toUpperCase()));
    }
}
