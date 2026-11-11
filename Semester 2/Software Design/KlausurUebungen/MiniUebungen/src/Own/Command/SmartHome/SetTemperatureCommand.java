package Own.Command.SmartHome;

public class SetTemperatureCommand implements Command{
    Heater heater;
    int prevTemp;
    int temperature;

    public SetTemperatureCommand(Heater h, int t) {
        heater = h;
        temperature = t;
    }

    @Override
    public void execute() {
        prevTemp = heater.getTemperature();
        heater.setTemperature(temperature);
    }

    @Override
    public void undo() {
        temperature = prevTemp;
        execute();
    }
}
