package Pruefungsvorbereitung;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
    private String title;
    private String genre;
    private ArrayList<Player> players;

    public Game(String title, String genre) {
        this.title = title;
        this.genre = genre;

        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void getInfo(){
        System.out.println(this); // toString
        System.out.println("Players:");

        // loop through all players and print their to strings (and running counter)
        int counter = 0;
        for (Player player : players) {
            System.out.printf("%d: %s\n",++counter, player.getInfo());
        }
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Genre: %s", title, genre);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
