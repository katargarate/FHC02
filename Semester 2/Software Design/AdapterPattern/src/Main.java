public class Main {
    static void main(String[] args) {

        System.out.println("--- Duck ---");
        Duck duck = new Duck();

        duck.fly();
        duck.quack();

        System.out.println("\n--- Turkey mit TurkeyAdapter ---");
        Turkey turkey = new Turkey();
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);

        turkeyAdapter.quack();
        turkeyAdapter.fly();

    }
}