package Own.Singleton.Logger;

public class Main {
    static void main(String[] args) throws InterruptedException {
        Runnable task = () -> System.out.println(
                Thread.currentThread().getName() + " -> " + System.identityHashCode(Logger.getInstance()));

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Logger instance = Logger.getInstance();
        instance.log("Hello World!");
        instance.log("Goodbye World!");

        System.out.println("Msg count: " +instance.getCount());
        instance.printAll();

        // Ohne synchronized können zwei Threads gleichzeitig loggerInstance == null sehen und beide ein Logger-Objekt erzeugen.
        // Dann gibt es zwei Instanzen statt einer.
    }
}
