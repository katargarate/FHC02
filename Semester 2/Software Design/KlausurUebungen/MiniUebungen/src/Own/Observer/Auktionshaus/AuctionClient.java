package Own.Observer.Auktionshaus;

public interface AuctionClient {
    void update(String item, double amount);
    void joinAuction(AuctionServer server);
    void leaveAuction();
}
