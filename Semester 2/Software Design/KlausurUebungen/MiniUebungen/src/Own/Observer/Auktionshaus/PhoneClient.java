package Own.Observer.Auktionshaus;

public class PhoneClient implements AuctionClient{
    public boolean notificationsOn;
    private double lastSeenAmount;
    private AuctionServer auctionServer;

    public PhoneClient(boolean notificationsOn) {
        this.notificationsOn = notificationsOn;
    }

    @Override
    public void update(String item, double amount) {
        if (notificationsOn) {
            System.out.printf("*** Phone Update: Item: %s, Amount: €%.2f.\n", item, amount);
            lastSeenAmount = amount;
        }
    }

    @Override
    public void joinAuction(AuctionServer server) {
        server.registerClient(this);
        auctionServer = server;
    }

    @Override
    public void leaveAuction() {
        if (auctionServer != null) {
            auctionServer.removeClient(this);
            auctionServer = null;
        }
    }

    public void setNotifications(boolean b) {
        notificationsOn = b;
    }
}
