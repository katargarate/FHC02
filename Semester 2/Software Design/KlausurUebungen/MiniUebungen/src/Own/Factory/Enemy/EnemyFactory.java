package Own.Factory.Enemy;

public class EnemyFactory {

    public Enemy createEnemy(String type) {
        return switch (type.toLowerCase()) {
            case "goblin" -> new Goblin();
            case "orc" -> new Orc();
            case "dragon" -> new Dragon();
            default -> throw new IllegalArgumentException("Unexpected value: " + type.toLowerCase());
        };
    }
}
