package Own.Command.SmartHome;

public class LampOffCommand implements Command{
    Lamp lamp;

    public LampOffCommand(Lamp l) {
        lamp = l;
    }

    @Override
    public void execute() {
        lamp.off();
    }

    @Override
    public void undo() {
        lamp.on();
    }
}
