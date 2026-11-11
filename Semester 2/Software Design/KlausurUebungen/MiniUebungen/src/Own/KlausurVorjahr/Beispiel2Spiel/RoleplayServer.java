package Own.KlausurVorjahr.Beispiel2Spiel;

import java.util.ArrayList;

public class RoleplayServer implements GameServer {

    ArrayList<GameClient> clients;
    EventData lastEvent;

    public RoleplayServer(){
        lastEvent = null;
        clients = new ArrayList<GameClient>();
    }
    public ArrayList<GameClient> getClients() {
        return clients;
    }
    public EventData getLastEvent() {
        return lastEvent;
    }

    public void newEvent(String description, String url){
        EventData event = new EventData(description, url);
        lastEvent = event;

        // notify clients via its own method
        notifyObservers();
    }

    @Override
    public void registerObserver(GameClient gc) {
        clients.add(gc);
    }

    @Override
    public void removeObserver(GameClient gc) {
        if (clients.contains(gc)) {
            clients.remove(gc);
        }
        else System.out.println("Client not found in list of subscribed clients");
    }

    @Override
    public void notifyObservers() {
        for (GameClient client : clients) {
            client.update(lastEvent);
        }
    }
}
