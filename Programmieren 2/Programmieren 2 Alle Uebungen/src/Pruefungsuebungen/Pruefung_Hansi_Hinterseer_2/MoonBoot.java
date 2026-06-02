package Pruefungsuebungen.Pruefung_Hansi_Hinterseer_2;

public class MoonBoot implements NFCTicket {

    protected String owner;
    protected boolean color;
    protected String secret;

    public MoonBoot(String owner, boolean color) {
        this.owner = owner;
        this.color = color;

        this.secret = TicketFraudSystem.createNewTicket("moonboot");
    }

    @Override
    public String getTicketOwner() {
        return this.owner;
    }

    @Override
    public double getProfit() {
        if (color) return 250; // mit farbigem Licht = 250,
        return 200; // sonst nur 200
    }

    @Override
    public int getCategory() {
        if (color) return 1; // kategorie 1 bei farbigem Licht
        return 2; // sonst kategorie 2
    }

    @Override
    public String getSecret() {
        return this.secret;
    }

    public String toString() {
        return String.format("Owner: %s | Secret: %s | Category: %d | Color: %s | Profit: €%.2f",
                owner, secret, getCategory(), color, getProfit());
    }

}
