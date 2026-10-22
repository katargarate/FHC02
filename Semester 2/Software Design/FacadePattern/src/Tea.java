public class Tea extends CaffeineBeverage {
    @Override
    protected void addCondiments() {
        System.out.println("Füge Zitronenblättern dazu.");
    }

    @Override
    protected void brew() {
        System.out.println("Wir fügen Teeblätter dem heißen Wasser dazu.");
    }
}
