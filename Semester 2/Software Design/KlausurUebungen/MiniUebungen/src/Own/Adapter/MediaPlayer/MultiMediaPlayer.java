package Own.Adapter.MediaPlayer;

import java.util.HashMap;
import java.util.Map;

public class MultiMediaPlayer {
    public Map<String, IPlayer> formats = new HashMap<>();

    public void registerFormat(String format, IPlayer player) {
        formats.put(format, player);
        System.out.println("Format added.");
    }

    public void play(String format, String file) {
        if (formats.containsKey(format)) {
            formats.get(format).play(file);
        } else System.out.println("Format not found");
    }
}
