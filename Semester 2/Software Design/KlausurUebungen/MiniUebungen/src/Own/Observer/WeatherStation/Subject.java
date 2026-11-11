package Own.Observer.WeatherStation;

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers(float temperature);
}
