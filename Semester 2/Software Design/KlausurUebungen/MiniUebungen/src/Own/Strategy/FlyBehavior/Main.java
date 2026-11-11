package Own.Strategy.FlyBehavior;

public class Main {
    static void main(String[] args) {
        Duck duck = new Duck();
        duck.performFly();

        duck.setFlyBehavior(new FlyNoWay());
        duck.performFly();
    }
}
