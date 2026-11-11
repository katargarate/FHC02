package at.campus02.zam.sd.bsp3;

public class Drucker {

    public void drucke(String dokument, int kopien) {
        System.out.printf("Drucke %d x %s\n", kopien, dokument);
    }

    public void scanne(String dokument) {
        System.out.printf("Scanne %s\n", dokument);
    }
}
