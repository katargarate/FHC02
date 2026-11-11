package at.campus02.fernbedienung;
import java.util.Stack;

public class TVKanalRunterKommando implements Kommando {

    private TV tv;
    private Stack<Boolean> history = new Stack<>();


    public TVKanalRunterKommando(TV tv) {
        this.tv = tv;
    }

    @Override
    public void ausfuehren() {
        history.add(tv.istEin());
        if (!tv.istEin()) {
            tv.ein();
        } else {
            tv.runter();
        }
    }

    @Override
    public void undo() {
        Boolean istEin = history.pop();
        if(!istEin){
            tv.aus();
        }else{
            if (tv.getKanal() == 40) {
                tv.setKanal(1);
            } else {
                tv.rauf();
            }
        }
    }


}
