package SharingResources;

public class ThreadObject implements Runnable {
    public Object sperrObjekt;
    String name;


    @Override
    public void run() {
        synchronized (name) {
            System.out.println("DAS IST DIE KRITISCHE SEKTION");
        }
    }
}
