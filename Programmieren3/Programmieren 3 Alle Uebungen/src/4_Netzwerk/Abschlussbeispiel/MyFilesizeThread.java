package Abschlussbeispiel;

import java.io.File;

public class MyFilesizeThread implements Runnable {
    File logfileFromMain; // Referenz auf dasselbe Logfile-Objekt wie im Main-Thread

    public MyFilesizeThread(File logfileToSize) {
        this.logfileFromMain = logfileToSize;
    }

    @Override
    public void run() {
        // läuft so lange, bis der Thread von außen unterbrochen wird (interrupt())
        while (!Thread.interrupted()) {
            System.out.println("FILSIZE: " +
                    logfileFromMain.length() + " (Name:  " +
                    Thread.currentThread().getName() + ")");
            try {
                Thread.sleep(5000); // 5 Sekunden warten bis zur nächsten Ausgabe
            } catch (InterruptedException e) {
                // hier landen wir, wenn logfilesizeThread.interrupt() aus main() aufgerufen wird
                // -> das ist die "freundliche" Beendigung, die die Aufgabe verlangt
                System.out.println("Schlaf wurde unterbrochen, beende mich.");
                break; // Schleife verlassen -> run() ist fertig -> Thread stirbt sauber
            }
        }
    }
}