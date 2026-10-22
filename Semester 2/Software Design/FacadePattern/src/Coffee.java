public class Coffee extends CaffeineBeverage {
    @Override
    protected void addCondiments() {
        System.out.println("Füge Hafermilch dazu.");
    }

    @Override
    protected void brew() {
        System.out.println("Wir fügen Kaffee dem heißen Wasser dazu.");
    }
}
