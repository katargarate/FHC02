package Pruefungsvorbereitung;

import java.util.ArrayList;

public class GameLibrary<T> {
    private ArrayList<T> list;

    public GameLibrary() {
        list = new ArrayList<T>();
    }

    public void addGameToLibrary(T game) {
        list.add(game);
    }

    public ArrayList<T> getGameList() {
        return list;
    }

    public void printGameList() {
        System.out.println("Game Library:");

        for (T game : list) {
            System.out.println(game.toString());
        }
    }
}
