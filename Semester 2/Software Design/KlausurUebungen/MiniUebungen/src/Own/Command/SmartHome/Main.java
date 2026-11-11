package Own.Command.SmartHome;

public class Main {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Heater heater = new Heater();
        RemoteControl remote = new RemoteControl();

        remote.setCommand(0, new LampOnCommand(lamp));
        remote.setCommand(1, new LampOffCommand(lamp));
        remote.setCommand(2, new SetTemperatureCommand(heater, 20));

        remote.pressButton(0); // lamp on
        remote.pressButton(1); // lamp off
        remote.pressButton(2); // temp 18 -> 20
        remote.undo(); // temp back to 18
        remote.undo(); // lamp back on
        remote.undo(); // lamp back off
        remote.undo(); // stack empty
        remote.pressButton(5); // invalid slot
    }
}