package Own.Template.CaffeineBeverage;

public class Tea extends CaffeineBeverage{
    @Override
    public void addCondiments() {
        System.out.println("Adding lemon juice...");
    }

    @Override
    public void brew() {
        System.out.println("Brewing for 3 minutes...");
    }
}
