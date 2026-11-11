package Own.Strategy.FlyBehavior;

public class Duck {
    private FlyBehavior fb = new FlyWithWings();

    public void performFly() {
        fb.fly();
    }

    public void setFlyBehavior(FlyBehavior fb) {
        this.fb = fb;
    }
}
