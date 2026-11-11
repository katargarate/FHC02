package at.campus02.fernbedienung;

// Alle Kommandos implementieren gleiches Interface
public interface Kommando {
    public void ausfuehren();
    public void undo();
}
