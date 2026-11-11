package Own.KlausurVorjahr.Beispiel2Spiel;

public interface GameClient {
    public void update(EventData evt);

    public void startGame(GameServer server);
    public void endGame();
}
