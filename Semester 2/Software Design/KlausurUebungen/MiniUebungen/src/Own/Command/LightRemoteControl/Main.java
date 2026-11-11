package Own.Command.LightRemoteControl;

public class Main {
    static void main(String[] args) {
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();
        remote.addCommand(lightOnCommand);
        remote.addCommand(lightOffCommand);

        remote.pressButton(1);
        remote.pressButton(0);
        remote.undo();
    }
}
