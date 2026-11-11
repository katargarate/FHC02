package Own.Adapter.MediaPlayer;

public class MP2PlayerAdapter implements IPlayer{
    private final AudioPlayer audioPlayer;

    public MP2PlayerAdapter(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    @Override
    public void play(String file) {
        audioPlayer.playMp2(file);
    }
}
