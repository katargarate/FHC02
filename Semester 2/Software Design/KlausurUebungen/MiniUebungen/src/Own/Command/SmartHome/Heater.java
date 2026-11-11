package Own.Command.SmartHome;

public class Heater {
    protected int temperature = 18;

    public void setTemperature(int t) {
        int oldtemp = temperature;
        temperature = t;
        System.out.printf("Temperature has been changed from %d to %d degrees.\n", oldtemp, temperature);
    }

    public int getTemperature() {
        return temperature;
    }

}
