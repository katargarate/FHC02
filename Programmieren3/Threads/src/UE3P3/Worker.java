package UE3P3;

public class Hund implements Runnable {
    public static int counter = 0;
    public static final Object LOCK = new Object();

    @Override
    public void run() {
        synchronized (LOCK) {
            

        }
    }
}
