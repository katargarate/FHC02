package at.campus02.fernbedienung;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Fernbedienung {
    Map<Integer, Kommando> kommandos = new HashMap<Integer, Kommando>();
    Stack<Kommando> history = new Stack<Kommando>();
    public Fernbedienung(){}


    public void setKommando(Integer slot, Kommando k)
    {
        kommandos.put(slot, k);
    }

    public void knopfGedrueckt(Integer knopf){
        if(kommandos.containsKey(knopf))
        {
            Kommando k = kommandos.get(knopf);
            k.ausfuehren();
            history.push(k);
        }
    }
    public void undoFernbedienung(){
        if(!history.isEmpty()){
            history.pop().undo();
        }
    }

}