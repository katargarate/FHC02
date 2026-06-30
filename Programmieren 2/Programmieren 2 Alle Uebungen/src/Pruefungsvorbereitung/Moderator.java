package Pruefungsvorbereitung;

public class Moderator extends Account {

    private int reportsHandled;
    private boolean active;

    public Moderator(String username, String email) {
        super(username, email);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", ReportsHandled: %d, Active: %b", reportsHandled, active);
    }

    public int getReportsHandled() {
        return reportsHandled;
    }

    public void setReportsHandled(int reportsHandled) {
        this.reportsHandled = reportsHandled;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
