package HundeFriseur.Dogs;

public class Corgi extends Dog {
    private boolean likesTreats;
    private boolean lovesTheGroomer;

    public Corgi(String name, int hairLength, boolean isChipped) {
        super(name, hairLength, isChipped);
    }



    public void kissGroomer() {
        System.out.println("SMOOOOOCH");
    }

    public boolean isLikesTreats() {
        return likesTreats;
    }

    public void setLikesTreats(boolean likesTreats) {
        this.likesTreats = likesTreats;
    }

    public boolean isLovesTheGroomer() {
        return lovesTheGroomer;
    }

    public void setLovesTheGroomer(boolean lovesTheGroomer) {
        this.lovesTheGroomer = lovesTheGroomer;
    }
}
