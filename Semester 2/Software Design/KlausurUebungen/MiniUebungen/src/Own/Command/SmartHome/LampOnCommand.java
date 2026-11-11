package Own.Command.SmartHome;

public class LampOnCommand implements Command{
    Lamp lamp;

    public LampOnCommand(Lamp l) {
        lamp = l;
    }

    @Override
    public void execute() {
        lamp.on();
    }

    @Override
    public void undo() {
        lamp.off();
    }
}
