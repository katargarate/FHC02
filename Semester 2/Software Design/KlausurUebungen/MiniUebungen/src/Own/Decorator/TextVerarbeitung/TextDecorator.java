package Own.Decorator.TextVerarbeitung;

public abstract class TextDecorator implements TextProcessor {
    protected TextProcessor processor;

    public TextDecorator(TextProcessor processor) {
        this.processor = processor;
    }
}
