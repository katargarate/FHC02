package Own.Observer.Auktionshaus;

import java.util.ArrayList;

public class AuctionServer {
    ArrayList<AuctionClient> clients = new ArrayList<>();
    private double lastAmount;

    public void registerClient(AuctionClient c) {
        clients.add(c);
    }

    public void removeClient(AuctionClient c) {
        if (clients.contains(c)) {
            clients.remove(c);
        } else System.out.println("Client cannot be removed because they are not in the list of subscribers");
    }

    public void placeBid(String item, double amount) {
        System.out.printf("Bid has been place. Item: %s, Amount: €%.2f.\n", item, amount);
        lastAmount = amount;
        notifyClients(item, amount);
    }

    private void notifyClients(String item, double amount) {
        for (AuctionClient client : clients) {
            client.update(item, amount);
        }
    }

    public double getLastAmount() {
        return lastAmount;
    }
}
