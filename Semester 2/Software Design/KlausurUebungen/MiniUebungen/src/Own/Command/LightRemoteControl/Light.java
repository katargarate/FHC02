package Own.Command.LightRemoteControl;

public class Light {
    public boolean isOn = false;

    public void on() {
        isOn = true;
        System.out.println("Light was turned on.");
    }

    public void off() {
        isOn = false;
        System.out.println("Light was turned off.");
    }
}
