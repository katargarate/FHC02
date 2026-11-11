package Own.Decorator.TextVerarbeitung;

public class UppercaseDecorator extends TextDecorator {

    public UppercaseDecorator(TextProcessor processor) {
        super(processor);
    }

    @Override
    public String process(String text) {
        return super.processor.process(text).toUpperCase();
    }
}
