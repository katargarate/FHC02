package Own.Decorator.TextVerarbeitung;

public class TrimDecorator extends TextDecorator {

    public TrimDecorator(TextProcessor processor) {
        super(processor);
    }

    @Override
    public String process(String text) {
        return super.processor.process(text).trim();
    }
}
