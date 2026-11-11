package Own.Adapter.MediaPlayer;

public class MP4Player implements IPlayer{
    @Override
    public void play(String file) {
        System.out.println("Playing with an MP4 Player");
    }
}
