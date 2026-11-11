package Own.Facade.HomeTheater;

public class HomeTheaterFacade {
    private SoundSystem soundSystem;
    private Lights lights;
    private Projector projector;

    public HomeTheaterFacade() {
        soundSystem = new SoundSystem();
        lights = new Lights();
        projector = new Projector();
    }

    public void watchMovie() {
        soundSystem.soundSystemOn();
        lights.lightsOn();
        projector.projectorOn();
    }

    public void endMovie() {
        soundSystem.soundSystemOff();
        lights.lightsOff();
        projector.projectorOff();
    }
}
