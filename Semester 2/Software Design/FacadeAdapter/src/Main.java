public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! Heimkino Facade.");

        HeimKinoFassade heimkino = new HeimKinoFassade(
                new Fernseher(),
                new SoundSystem(),
                new BlueRayPlayer()
        );

        heimkino.filmStarten("2 Nemo 2 furious");

    }
}