package Abschlussbeispiel;

import java.io.*;
import java.util.ArrayList;

public class FileReadWorker extends Worker implements Runnable {
    private String path;
    public ArrayList<String> lines;

    public FileReadWorker(String name, String path) {
        super(name);
        this.path = path;
        lines = new ArrayList<>();
    }

    @Override
    public void work() {
        printStarted();

        try {
            File file = new File(path);

            if (!file.exists()) {
                System.out.println(path + " nicht gefunden");
                return;
            }

            if (!file.isFile()) {
                System.out.println(file.getName() + " ist keine Datei");
                return;
            }

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null && shouldRun) {
                lines.add(line);
                line = br.readLine();
            }

            shouldRun = false;

            System.out.println("Final ArrayList: ");

            for (String s : lines) {
                System.out.println(s);
            }

            printStopped();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        work();
    }
}
