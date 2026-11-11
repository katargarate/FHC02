package Own.Decorator.TextVerarbeitung;

public class PrefixDecorator extends TextDecorator {
    protected String prefix;

    public PrefixDecorator(TextProcessor processor, String prefix) {
        super(processor);
        this.prefix = prefix;
    }

    @Override
    public String process(String text) {
        return prefix + super.processor.process(text);
    }
}
