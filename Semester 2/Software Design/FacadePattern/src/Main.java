public class Main {
    static void main(String[] args) {
        System.out.println("\n----- TEA");
        Tea tea = new Tea();
        tea.prepareRecipe();

        System.out.println("\n----- COFFEE");
        Coffee coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
