package Own.Adapter.MediaPlayer;

public class MP3PlayerAdapter implements IPlayer{
    private final AudioPlayer audioPlayer;

    public MP3PlayerAdapter(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void play(String file) {
        audioPlayer.playMp3(file);
    }
}
