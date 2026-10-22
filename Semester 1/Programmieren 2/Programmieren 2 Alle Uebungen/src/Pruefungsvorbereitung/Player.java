package Pruefungsvorbereitung;

public class Player extends Account {

    private int level;
    private int hoursPlayed;

    public Player(String username, String email) {
        super(username, email);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", Level: %d, Hours Played: %d", level, hoursPlayed);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(int hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
