package Own.Adapter.TurkeyDuck;

public class RedDuck implements Duck{
    @Override
    public void quack() {
        System.out.println("Quack Quack");
    }

    @Override
    public void fly() {
        System.out.println("Duck flies 10m.");
    }
}
