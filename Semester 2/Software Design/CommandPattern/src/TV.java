public class TV {
    private int kanal = 1;
    private boolean tvAn = false;

    public void kanalErhoehen() {
        if (!tvAn) toggleTV();

        else {
            kanal++;
            if (kanal > 40) kanal = 1;
            System.out.println("Kanal auf " + kanal + " erhöht.");
        }
    }

    public void kanalErniedrigen() {
        if (!tvAn) toggleTV();

        else {
            kanal--;
            if (kanal < 1) kanal = 40;
            System.out.println("Kanal auf " + kanal + " erniedrigt.");
        }
    }

    public void toggleTV() {
        tvAn = !tvAn;
        isTvAn();
    }

    public boolean isTvAn() {
        if (tvAn == true) System.out.println("TV ist an.");
        else System.out.println("TV ist nicht an.");

        return tvAn;
    }

    public int getKanal() {
        return kanal;
    }

    public void setKanal(int kanal) {
        this.kanal = kanal;
    }
}
