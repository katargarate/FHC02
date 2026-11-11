package Own.Singleton.SettingsManager;

public class Main {
    static void main(String[] args) throws InterruptedException {
        // never did threads for this so just testing normally
        System.out.println("First attempt to create an instance of a settings manager:");
        SettingsManager settingsManager = SettingsManager.getInstance();

        Runnable task = () -> System.out.println(
                Thread.currentThread().getName() + " -> " + System.identityHashCode(SettingsManager.getInstance()));

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
