package Own.Observer.Auktionshaus;

public class Main {
    // Erklären Sie in ein bis zwei Sätzen, was die lose Kopplung im Own.Observer Pattern bedeutet und warum sie hier nützlich ist.

    // Lose Kopplung bedeutet, dass der AuctionServer nur das Interface AuctionClient kennt, nicht die konkreten Klassen
    // hinzugefügt oder entfernt werden, ohne den Server zu ändern,
    // und jeder Client entscheidet selbst, wie er auf ein Gebot reagiert.

    static void main(String[] args) {
        AuctionServer server = new AuctionServer();
        PhoneClient phone = new PhoneClient(true);
        ScreenClient screen = new ScreenClient();

        phone.joinAuction(server);
        screen.joinAuction(server);

        System.out.println("--- Phone notifications turned on, amount over 100, both should receive notifications --- ");
        server.placeBid("Antique Dresser", 249.50);

        System.out.println("\n--- Phone notifications turned off, only screen should receive notification --- ");
        phone.setNotifications(false);
        server.placeBid("Clown Shoes", 149.50);

        System.out.println("\n--- Bid Amount under 100 and phone notifications turned off, no one should receive notification --- ");
        server.placeBid("Plastic Spoon", 0.50);

        System.out.println("\n--- Screen leaves auction, no one should receive notification --- ");
        screen.leaveAuction();
        server.placeBid("Flexity tram", 100000000);

    }
}
