package Own.Template.CaffeineBeverage;

public class Main {
    static void main(String[] args) {
        Tea tea = new Tea();
        Coffee coffee = new Coffee();

        System.out.println("--- Preparing tea... ---");
        tea.prepareRecipe();
        System.out.println("--- Preparing coffee... ---");
        coffee.prepareRecipe();
    }
}
