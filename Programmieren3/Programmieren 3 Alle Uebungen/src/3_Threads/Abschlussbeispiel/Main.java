package Abschlussbeispiel;

import java.io.FileReader;

public class Main {
    static void main(String[] args) {
        TimePrintWorker timePrintWorker = new TimePrintWorker("Time Print Worker 1");
        Thread timePrintWorkerThread = new Thread(timePrintWorker);

        timePrintWorkerThread.start();

        FileReadWorker fileReadWorker = new FileReadWorker("File Read Worker 1", "src/1_Files/new-file-to-inspect.txt");
        Thread fileReadWorkerThread = new Thread(fileReadWorker);

        fileReadWorkerThread.start();



    }
}
