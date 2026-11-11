package Own.KlausurVorjahr.Beispiel2Spiel;

public interface GameServer {
    public void registerObserver(GameClient gc);

    public void removeObserver(GameClient gc);

    public void notifyObservers();
}
