package Model.FlugVerhalten;

public class SegelnflugVerhalten implements FlugVerhalten{
    @Override
    public void fliegen() {
        System.out.println("VERHALTEN: " + "segeln");
    }
}
