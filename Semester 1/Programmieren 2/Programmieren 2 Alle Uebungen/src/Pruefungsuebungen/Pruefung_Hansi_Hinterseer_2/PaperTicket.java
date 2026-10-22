package Pruefungsuebungen.Pruefung_Hansi_Hinterseer_2;

public class PaperTicket implements NFCTicket {
    protected String owner;
    protected double price;
    protected double discount;
    protected boolean winner;
    protected String secret;
    protected int dealerCosts = 20;

    public PaperTicket(String owner, double price, double discount, boolean winner) {
        this.owner = owner;
        this.price = price;
        this.discount = discount;
        this.winner = winner;

        this.secret = TicketFraudSystem.createNewTicket("paper");
    }

    @Override
    public String getTicketOwner() {
        return this.owner;
    }

    @Override
    public double getProfit() {
        // preis ohne Händlerskosten berechnen
        double priceWithoutDealerCosts = price - dealerCosts;
        // neuer preis berechnen und zurückgeben
        return ((100 - discount) * 0.01) * priceWithoutDealerCosts;
    }

    @Override
    public int getCategory() {
        int category; // Zwischenspeicher

        // kategorie nach preis initialisieren
        if (getProfit() >= 80) category = 2;
        else category = 3;

        // wenn die Tickets gewonnen wurden, wird die Kategorie um 1 gesenkt (bessere Karten?)
        if (winner) category += 1;

        return category;
    }

    @Override
    public String getSecret() {
        return this.secret;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return String.format("Owner: %s | Secret: %s | Category: %d | Winner: %s | Price: €%.2f | Profit: €%.2f",
                owner, secret, getCategory(), winner, getPrice(), getProfit());
    }
}
