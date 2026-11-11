package Own.KlausurVorjahr.Beispiel2Spiel;

public class AppClient implements GameClient {
    private int version;
    private double batteryPercent; // ein wert zwischen 0 und 100
    private GameServer server;

    private String lastEventURL;

    public AppClient(int version, double batteryPercent) {
        this.version = version;
        this.batteryPercent = batteryPercent;
        lastEventURL = null;
    }

    public String getLastEventURL() {
        return lastEventURL;
    }
    public int getVersion() {
        return version;
    }
    public double getBatteryPercent() {
        return batteryPercent;
    }


    @Override
    public void update(EventData evt) {
        if (batteryPercent >= 20 && version >= 1000) {
            lastEventURL = evt.getEventDataURL();
            System.out.println("App Client has been updated about: " + evt.getEventDescription() + " (Battery: " + batteryPercent + "%, Version: " + version +")");
        }
        else System.out.println("App Client has NOT been updated (Battery: " + batteryPercent + "%, Version: " + version +")");
    }

    @Override
    public void startGame(GameServer server) {
        this.server = server;
        server.registerObserver(this);
    }

    @Override
    public void endGame() {
        server.removeObserver(this);
        server = null;
    }
}
