package Own.Adapter.TurkeyDuck;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {
        ArrayList<Duck> ducks = new ArrayList<>();
        ducks.add(new RedDuck());
        ducks.add(new TurkeyAdapter(new Turkey()));

        for (Duck duck : ducks) {
            System.out.println();
            duck.quack();
            duck.fly();
        }
    }
}
