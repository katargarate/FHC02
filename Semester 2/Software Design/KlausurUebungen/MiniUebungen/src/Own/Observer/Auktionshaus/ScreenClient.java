package Own.Observer.Auktionshaus;

public class ScreenClient implements AuctionClient{
    private double lastSeenAmount;
    private AuctionServer auctionServer;

    @Override
    public void update(String item, double amount) {
        if (amount >= 100.0) {
            System.out.printf("*** Screen Update: Item: %s, Amount: €%.2f.\n", item, amount);
            lastSeenAmount = amount;
        }
    }

    @Override
    public void joinAuction(AuctionServer server) {
        auctionServer = server;
        auctionServer.registerClient(this);
    }

    @Override
    public void leaveAuction() {
        if (auctionServer != null) {
            auctionServer.removeClient(this);
            auctionServer = null;
        }
    }
}
