package Own.Adapter.MediaPlayer;

public class MpegPlayer implements IPlayer{
    @Override
    public void play(String file) {
        System.out.println("Playing with an Mpeg Player");
    }
}
