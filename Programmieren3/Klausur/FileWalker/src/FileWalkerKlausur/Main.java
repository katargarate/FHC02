package FileWalkerKlausur;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        File dir = new File("src/FileWalkerKlausur");

        // Reukursive Methode auführen
        ArrayList<File> javaFiles = walk(dir);



        if (javaFiles != null && javaFiles.size() > 0) {
            System.out.println("Directory: " + dir.getAbsolutePath());
            printFolderContent(javaFiles);
        } else System.out.println("No files found.");

    }

    public static ArrayList<File> walk(File dir) {
        ArrayList<File> javaFiles = new ArrayList<>();
        // Wenn der übergeben File keine Directory ist:
        if (!dir.isDirectory()) {
            System.err.println("Not a directory");
            return null;
        }

        // Alle Files/Directories in einen Array speichern
        File[] files = dir.listFiles();

        // wenn es keine files/directories gibt: null zurückgeben
        if (files == null || files.length == 0) {
            System.out.println("No files or directories in the given directory.");
            return null;
        }

        // alle files in der Directory zu der files ArrayList hinzufügen
        for (File file : files) {
            if (file.isDirectory()) {
                // Rekursion benutzen um dieses Verzeichnis auch durchsuchen zu können, und zurückgegebene Files
                // zur ArrayList hinzufügen
                ArrayList<File> recursiveFiles = walk(file);
                javaFiles.addAll(recursiveFiles);
            }
            // wenn es eine Java Datei ist, zur ArrayList hinzufügen
            if (file.isFile() && file.getName().endsWith(".java")) {
                javaFiles.add(file);
            }
        }

        // wenn die Liste leer ist geben wir zwar die Liste noch zurück, aber geben auch eine Nachricht aus.
        if (javaFiles.isEmpty()) {
            System.out.println("No files or directories in the given directory.");
        }

        // ArrayList zurückliefern
        return javaFiles;
    }

    public static void printFolderContent(ArrayList<File> files) {

        for (File file : files) {
            System.out.println("Java File: " + file.getAbsolutePath());
        }
    }
}
