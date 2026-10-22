public abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected abstract void addCondiments();

    protected void pourInCup() {
        System.out.println("Getränk wird in Tasse gefüllt.");
    }


    protected abstract void brew();

    protected void boilWater() {
        System.out.println("Wasser wird gekocht.");
    }
}
