package Own.Decorator.TextVerarbeitung;

public class UnchangedProcessor implements TextProcessor {

    @Override
    public String process(String text) {
        return text;
    }
}
