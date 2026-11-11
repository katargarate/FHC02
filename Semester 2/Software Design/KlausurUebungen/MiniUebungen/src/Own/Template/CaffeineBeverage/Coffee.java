package Own.Template.CaffeineBeverage;

public class Coffee extends CaffeineBeverage{
    @Override
    public void addCondiments() {
        System.out.println("Adding oat milk and syrup...");
    }

    @Override
    public void brew() {
        System.out.println("Brewing for 10 minutes...");
    }
}
