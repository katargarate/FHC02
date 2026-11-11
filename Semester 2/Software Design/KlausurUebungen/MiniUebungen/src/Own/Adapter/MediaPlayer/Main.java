package Own.Adapter.MediaPlayer;

public class Main {
    static void main(String[] args) {
        MultiMediaPlayer player = new MultiMediaPlayer();

        player.registerFormat("mpeg", new MpegPlayer());
        player.registerFormat("mp4", new MP4Player());
        player.registerFormat("mp3", new MP3PlayerAdapter(new AudioPlayer()));
        player.registerFormat("mp2", new MP2PlayerAdapter(new AudioPlayer()));

        player.play("mpeg", "123");
        player.play("mp4", "345");
        player.play("mp3", "567");
        player.play("mp3", "789");
        player.play("dfdsfs", "sdfsdf");

    }
}
