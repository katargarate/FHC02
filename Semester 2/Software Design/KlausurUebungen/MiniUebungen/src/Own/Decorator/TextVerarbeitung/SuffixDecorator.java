package Own.Decorator.TextVerarbeitung;

public class SuffixDecorator extends TextDecorator {
    protected String suffix;

    public SuffixDecorator(TextProcessor processor, String suffix) {
        super(processor);
        this.suffix = suffix;
    }

    @Override
    public String process(String text) {
        return super.processor.process(text) + suffix;
    }
}
