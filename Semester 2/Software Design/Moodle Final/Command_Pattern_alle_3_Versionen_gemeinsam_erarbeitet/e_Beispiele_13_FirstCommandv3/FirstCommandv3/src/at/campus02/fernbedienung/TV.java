package at.campus02.fernbedienung;

public class TV {

    private boolean istEin = false;
    private int kanal = 1;

    public void ein() {
        istEin = true;
        System.out.println("Fernseher ist ein: " + kanal);
    }

    public void aus() {
        istEin = false;
        System.out.println("Fernseher ist aus");
    }

    public void rauf() {
        if (!istEin) {
            return;
        }

        if (kanal == 40) {
            kanal = 1;
        } else {
            kanal++;
        }
        System.out.println("Neuer Kanal: " + kanal);
    }

    public void runter() {
        if (!istEin) {
            return;
        }
        if (kanal == 1) {
            kanal = 40;
        } else {
            kanal--;
        }
        System.out.println("Neuer Kanal: " + kanal);
    }

    public int getKanal() {
        return kanal;
    }

    public void setKanal(int kanal) {
        this.kanal = kanal;
        System.out.println("Neuer Kanal: " + kanal);
    }

    public boolean istEin() {
        return istEin;
    }

}
