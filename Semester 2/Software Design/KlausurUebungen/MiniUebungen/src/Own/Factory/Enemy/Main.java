package Own.Factory.Enemy;

public class Main {
    static void main(String[] args) {
        EnemyFactory factory = new EnemyFactory();
        Enemy goblin = factory.createEnemy("goblin");
        Enemy orc = factory.createEnemy("orc");
        Enemy dragon = factory.createEnemy("dragon");

        goblin.attack();
        orc.attack();
        dragon.attack();
    }
}
