package Abschlussbeispiel;

public abstract class Worker {
    protected String name;
    protected boolean shouldRun;

    public Worker(String name) {
        this.name = name;
        this.shouldRun = true;
    }

    public abstract void work();

    protected void printStarted() {
        System.out.println(name + " wurde gestartet");
    }

    protected void printStopped() {
        System.out.println(name + " wurde gestoppt");
    }

    public void stopWorker() {
        this.shouldRun = false;
    }


}
