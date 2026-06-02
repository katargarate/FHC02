
import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/katargarate/Desktop/test/a.txt"); // inkl. Dateiname
        file.createNewFile(); // gibt true zurück, wenn es die Datei noch nicht gibt und erfolgreich erstellt wird
//        System.out.println(file.getAbsoluteFile());

        // in eine Schleife mehrere Dateien erstellen
//        for (int i = 0; i <= 10; i++) {
//            File fSpam = new File("/Users/katargarate/Desktop/test/spamDateiNo" + i + "fSpam.txt");
//            fSpam.createNewFile();
//        }


        // printFileInfo("/Users/katargarate/Desktop/test/a.txt");
        File folder = new File("/Users/katargarate/Documents/ESP32/a/");
        // printDirectoryContent(folder);
        // printDirectoryContentRecursively(folder);

        // printFolderFilesInfo("/Users/katargarate/Documents/ESP32");

        // createDirectories(folder);
    }

    public static void printFileInfo(String path) throws IOException {
        File file = new File(path);

        // check if the file exists
        System.out.println("Does this file exist?:\t" + file.exists());

        // name of file
        System.out.println("Name of file:\t" + file.getName());

        // parent directory of this file
        int parentNameStartIndex = file.getParent().lastIndexOf('/');
        String parentName = file.getParent().substring(parentNameStartIndex + 1);
        System.out.println("Parent directory of this file:\t" + parentName);

        // absolute path to this file
        System.out.println("Absolute path of this file:\t" + file.getAbsoluteFile());

        // if this a directory?
        System.out.println("Is this a directory?:\t" + file.isDirectory());

        // is this a file?
        System.out.println("Is this a file?:\t" + file.isFile());

        // is this file hidden?
        System.out.println("Is this file hidden?:\t" + file.isHidden());

        // is this file readable
        System.out.println("Is this file readable?:\t" + file.canRead());

        // if this file writable
        System.out.println("Is this file writable?:\t" + file.canWrite());

        // file size ( 1 byte per character)
        System.out.println("File size:\t" + file.length() + " bytes");
    }


    public static void printDirectoryContent (File folder) throws IOException {
        if (!folder.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] listOfFiles = folder.listFiles();

        // counters
        int fileCount = 0;
        int dirCount = 0;

        if(listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                // print files
                if (listOfFile.isFile()) {
                    System.out.println("File:" + listOfFile.getAbsoluteFile());
                    fileCount++;
                } else { // print dirs
                    System.out.println("Directory: " + listOfFile.getAbsoluteFile());
                    dirCount++;
                }
            }
        } else System.out.println("No file or directory found.");


        System.out.println("\nNumber of files: " + fileCount);
        System.out.println("Number of directories: " + dirCount);

    }


    public static void printDirectoryContentRecursively(File f) throws IOException {

        if (!f.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        // files
        if (f.isFile()) {
            System.out.println("|--------File:" + f.getAbsoluteFile());
        } else { // directories
            System.out.println("Directory:" + f.getAbsoluteFile());
            File[] listOfFiles = f.listFiles();

            if (listOfFiles == null) {
                System.out.println("|--------This folder is empty.");
                return;
            }

            for (File listOfFile : listOfFiles) {
                if (listOfFile.isDirectory()) {
                    printDirectoryContentRecursively(listOfFile);
                } else System.out.println("|--------File:" + f.getAbsoluteFile());
            }
        }











    }

    public static void printFolderFilesInfo(String path) throws IOException {

        File folder = new File(path);

        long totalSize = 0;

        if (!folder.exists()) {
            System.out.println("Folder does not exist.");
        }

        if (!folder.isDirectory()) {
            System.out.println("Path does not lead to a directory.");
        }

        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                System.out.println("File Name:" + file.getName());
                System.out.println("File Path:" + file.getAbsoluteFile());
                System.out.println("File Size:" + file.length());

                totalSize += file.length();
            }
        }
        System.out.println("Total Size: " + totalSize + " bytes");
    }


    public static void createDirectories(File f){

//        if (!f.isDirectory()) {
//            System.err.println("This is not a directory.");
//        }

        boolean isCreated = f.mkdir();

        System.out.println("Directory " + f.getAbsolutePath() + " created?: " + isCreated);

    }

}