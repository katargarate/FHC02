/*
Erstellen Sie die abstrakte Klasse TextDecorator, die TextProcessor implementiert:

Sie soll ein Objekt vom Typ TextProcessor speichern.
Der Konstruktor soll dieses Objekt entgegennehmen.
Verwenden Sie für das gespeicherte Objekt das Schlüsselwort protected,
damit die konkreten Decorators darauf zugreifen können.
 */
public abstract class TextDecorator implements TextProcessor {
    protected TextProcessor processor;

    public TextDecorator(TextProcessor processor) {
        this.processor = processor;
    }
}
