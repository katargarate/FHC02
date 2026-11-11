package Own.KlausurVorjahr.Beispiel2Spiel;

public class ConsoleClient implements GameClient{
    private String system;
    private String lastEventURL;
    private GameServer server;

    public ConsoleClient(String system) {
        this.system = system;
        lastEventURL = null;
    }


    public String getSystem() {
        return system;
    }
    public String getLastEventURL() {
        return lastEventURL;
    }


    @Override
    public void update(EventData evt) {
        if (!system.equalsIgnoreCase("Nintendo")) {
            lastEventURL = evt.getEventDataURL();
            System.out.println("Console Client has been updated about: " + evt.getEventDescription() + " (System: " + system + ")");
        }
        else System.out.println("Console Client has NOT been updated (System: " + system +")");
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
