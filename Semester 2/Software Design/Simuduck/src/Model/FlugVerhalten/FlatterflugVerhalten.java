package Model.FlugVerhalten;

public class FlatterflugVerhalten implements FlugVerhalten{
    @Override
    public void fliegen() {
        System.out.println("VERHALTEN: " + "flattern");
    }
}
