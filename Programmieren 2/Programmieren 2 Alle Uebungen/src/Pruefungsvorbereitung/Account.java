package Pruefungsvorbereitung;

public class Account {

    private String username;
    private String email;


    public Account(String username, String email) {
        this.username = username;
        this.email = email;
    }


    public String getInfo() {
        return String.format("Account: Username: %s, Email: %s", username, email);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
