package at.campus02.fernbedienung;

import java.util.Stack;


public class TVKanalRaufKommando implements Kommando {

    private TV tv;
    private Stack<Boolean> history = new Stack<>();

    public TVKanalRaufKommando(TV tv) {
        super();
        this.tv = tv;
    }

    @Override
    public void ausfuehren() {
        history.add(tv.istEin());
        if (!tv.istEin()) {
            tv.ein();
        } else {
            tv.rauf();
        }
    }

    @Override
    public void undo() {
        Boolean istEin = history.pop();
        if (!istEin) {
            tv.aus();
        } else {
            if (tv.getKanal() == 1) {
                tv.setKanal(40);
            } else {
                tv.runter();
            }
        }

    }

}
