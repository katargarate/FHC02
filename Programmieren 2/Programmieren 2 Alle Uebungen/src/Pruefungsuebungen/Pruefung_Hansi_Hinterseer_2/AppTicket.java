package Pruefungsuebungen.Pruefung_Hansi_Hinterseer_2;

public class AppTicket implements NFCTicket {

    protected String owner;
    protected double price;
    protected String system;
    protected String secret;

    public AppTicket(String owner, double price, String system) {
        this.owner = owner;
        this.price = price;
        this.system = system;

        this.secret = TicketFraudSystem.createNewTicket("app");
    }


    @Override
    public String getTicketOwner() {
        return this.owner;
    }

    @Override
    public double getProfit() {
        // preis nach System berechnen und zurückgeben
        if (this.system.equalsIgnoreCase("ios")) {
            return this.price * 0.7;
        } else if (this.system.equalsIgnoreCase("android")) {
            return this.price * 0.75;
        } else return this.price * 0.8; // bei allen anderen Systemen
    }

    @Override
    public int getCategory() {
        if (getProfit() >= 100) return 1; // ab €100
        else if (getProfit() >= 50) return 2; // ab €50 (muss unter 100 sein, wenn das erste if nicht zutrifft)
        else return 3; // alles unter €50
    }

    @Override
    public String getSecret() {
        return this.secret;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return String.format("Owner: %s | Secret: %s | Category: %d | Price: €%.2f | Profit: €%.2f",
                owner, secret, getCategory(), getPrice(), getProfit());
    }
}
