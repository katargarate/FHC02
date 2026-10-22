package Model;

import Model.FlugVerhalten.FlugVerhalten;

public abstract class Ente {

    public String name;
    public FlugVerhalten flugVerhalten;

    public Ente(String name, FlugVerhalten fv) {
        this.name = name;
        this.flugVerhalten = fv;
    }

    public void quaken() {
        System.out.println("\uD83D\uDD0A " + name + " quakt");
    }

    public void schwimmen() {
        System.out.println("\uD83C\uDFCA\uD83C\uDFFC " + name + " schwimmt");
    }

    public void fliegen() {
        if (this.flugVerhalten != null) {
            flugVerhalten.fliegen();
        }
    }


    public abstract void anzeigen();
}
