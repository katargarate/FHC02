package Model;

import Model.FlugVerhalten.FlugVerhalten;

public class Rotkopfente  extends Ente{

    public Rotkopfente(String name, FlugVerhalten fv) {
        super(name, fv);
    }

    @Override
    public void anzeigen() {
        System.out.printf("\n\uD83E\uDD86Hallo ich bin %s, eine Model.Rotkopfente\n", name);
    }
}
