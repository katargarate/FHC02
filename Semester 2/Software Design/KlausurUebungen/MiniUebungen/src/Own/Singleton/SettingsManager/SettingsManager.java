package Own.Singleton.SettingsManager;

public class SettingsManager {
    private static SettingsManager instance;

    private int volume = 0;

    private SettingsManager(int volume) {
        this.volume = volume;
    }

    public static synchronized SettingsManager getInstance() {
        if (instance == null) {
            instance = new SettingsManager(0);
            System.out.println("Created instance of settings manager");
        }
        else System.out.println("Was unable to create instance because one already exists");
        return instance;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
