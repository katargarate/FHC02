import java.io.File;

public class UE04_DisplayDirectoryContent {
    static void main(String[] args) {
        File dir = new File("/Users/katargarate/Documents/AQUA Unterlagen");
        printDirectoryContent(dir);
    }

    public static void printDirectoryContent(File directoryPath) {
        long fileSizeSum = 0;

        // Check if file is a directory
        if (directoryPath.isDirectory()) {
            System.out.println("This file is a directory.");
        } else {
            System.out.println("This file is not a directory.");
            return;
        }

        // Print all files with file name, file path, and file size
        File[] files = directoryPath.listFiles();

        if (files == null) {
            System.out.println("No files or directories in the given directory.");
            return;
        }

        for (File f : files) {
            System.out.printf("\nFile Name: %s | File Path: %s | File Size: %d Bytes",
                    f.getName(), f.getAbsolutePath(), f.length());

            fileSizeSum += f.length();
        }

        // Print the total size of all the files together
        System.out.println("\n\nTotal size of all the files in this directory: " + fileSizeSum + " Bytes");
    }
}
