package Own.Observer.WeatherStation;

import java.util.ArrayList;

public class WeatherStation implements Subject{
    public ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Added the observer: " + observer.getClass());
    }


    @Override
    public void removeObserver(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println("Removed the observer: " + observer.getClass());
        } else {
            System.out.println("Own.Observer not found.");
        }
    }

    @Override
    public void notifyObservers(float temperature) {
        for (Observer observer : observers) {
                observer.update(temperature);
        }
    }
}
