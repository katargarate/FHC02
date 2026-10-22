public class TurkeyAdapter extends Duck {
    Turkey turkey =  new Turkey();
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    public void quack() {
        turkey.gobble();
    }

    public void fly() {
        // 2 Mal, weil der Turkey nur 5m fliegt, aber Duck 10m
        turkey.flySmall();
        turkey.flySmall();
    }

}
