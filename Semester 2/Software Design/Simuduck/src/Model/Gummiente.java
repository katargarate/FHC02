package Model;

import Model.FlugVerhalten.FlugVerhalten;

public class Gummiente extends Ente{

    public Gummiente(String name, FlugVerhalten fv) {
        super(name, fv);
    }

    @Override
    public void anzeigen() {
        System.out.printf("\uD83E\uDD86Hallo ich bin %s, eine Model.Stockente\n", name);
    }
}
