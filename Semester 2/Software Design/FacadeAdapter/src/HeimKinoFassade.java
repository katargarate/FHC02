import javax.swing.plaf.basic.BasicLabelUI;

public class HeimKinoFassade {
    private Fernseher fernseher;
    private SoundSystem soundSystem;
    private BlueRayPlayer blueRayPlayer;

    public HeimKinoFassade(Fernseher fernseher, SoundSystem soundSystem, BlueRayPlayer blueRayPlayer) {
        this.fernseher = fernseher;
        this.soundSystem = soundSystem;
        this.blueRayPlayer = blueRayPlayer;
    }

    public void filmStarten(String filmName) {
        fernseher.turnOn();
        soundSystem.turnOn();
        blueRayPlayer.turnOn();

        soundSystem.setVolume(30);
        blueRayPlayer.startMovie();

        System.out.println("\nThe following film has officially started: " + filmName);
    }
}
