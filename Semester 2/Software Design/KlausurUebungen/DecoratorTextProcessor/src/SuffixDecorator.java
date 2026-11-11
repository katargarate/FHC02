public class SuffixDecorator extends TextDecorator{
    private String suffix;

    public SuffixDecorator(TextProcessor processor, String suffix) {
        super(processor);
        this.suffix = suffix;
    }

    @Override
    public String process(String text) {
        // Fügt einen frei wählbaren Präfix vor dem verarbeiteten Text ein.
        return String.format("%s %s", processor.process(text), suffix);
    }
}
