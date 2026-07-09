import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;

public class UE6 {
    public static void main(String[] args) throws IOException {
        File folder =  new File("/Users/katargarate/FHC02/P3_Files/src/UE6Files");
        //create10Files(folder);

        //renameFiles(folder);

        deleteAllFiles(folder);
    }

    private static void deleteAllFiles(File folder) {
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            }
        }
    }

    public static void create10Files(File folder) throws IOException {


        if (!folder.exists()) {
            System.out.println("This folder doesn't exist");
            return;
        }

        if (!folder.isDirectory()) {
            System.out.println("This is a file, not a directory");
            return;
        }


        for (int i = 0; i < 10; i++) {
            int random = ThreadLocalRandom.current().nextInt(5000, 6000);
            File f = new File(folder.getAbsolutePath() + File.separator + "a" + random + ".txt");

            if (!f.createNewFile()) {
              System.out.println("File " + random + " failed to be created.");
            } else  {
              System.out.println("File a" + random + " successfully created.");
            }
        }
    }

    public static void renameFiles(File folder) throws IOException {
       /*
       2. Write a method, which renames all files (only files and not directories!) within a given folder (= Method Parameter)
2.1 for example: test.txt to kjb.txt
2.1.1 for the new file name - concatenate a string with .getParent(), separator + pre_id + getName()
        */

        // Fall: Ordner existiert nicht
        if (!folder.exists()) {
            System.err.println("This folder does not exist");
            return;
        }

        // Liste alle Inhalte vom Ordner (Auch Unterordner)
        File[] listOfFiles = folder.listFiles();

        // Fall: Ordner ist leer
        if (listOfFiles.length == 0) {
            System.err.println("This folder is empty.");
            return;
        }

        // filter so only .txt files appear
        FilenameFilter txtFilter = (dir, name) -> name.toLowerCase().endsWith(".txt");
        File[] list = folder.listFiles(txtFilter);
        int counter = 0;

        for (File oldFile : list) {
            System.out.print("File to rename: " + oldFile.getName());


            File newFile = new File(oldFile.getParent() + File.separator + "1_"+ oldFile.getName());

            System.out.println(" -> " + newFile.getName());
            oldFile.renameTo(newFile);
        }










    }
}
