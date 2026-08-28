import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CreateAndRenameFiles {
    static void main(String[] args) {
        File dir = new File("src/1_Files/Practice_Directory");

        // if the directory does not yet exist, create it and print a success message
        if (!dir.exists()) {
            System.out.println("Directory successfully created: " + dir.mkdir());
        }

        // create10Files(dir);
        // renameFiles(dir);
        // deleteAllFilesInDirectory(dir);
    }

    public static void create10Files(File dir) {
        Random r = new Random();

        // If the given File does not exist, return
        if (!dir.exists()) {
            System.out.println("Directory " + dir.getAbsolutePath() + " does not exist.");
            return;
        }

        // If the given File is not a directory, return
        if (!dir.isDirectory()) {
            System.out.println("The given file is not a directory");
            return;
        }

        // Create 10 new files with concatenated file names
        for (int i = 0; i < 10; i++) {
            String filePath = dir.getAbsolutePath() + "/File_" + r.nextInt(1,500) + ".txt";
            File newFile = new File(filePath);

            try {
                newFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating file " + filePath);
                e.printStackTrace();
            }
        }


    }

    public static void renameFiles(File dir) {
        if (!dir.exists()) {
            System.out.println("Directory " + dir.getAbsolutePath() + " does not exist.");
            return;
        }

        // If the given File is not a directory, return
        if (!dir.isDirectory()) {
            System.out.println("The given file is not a directory");
            return;
        }

        File[] files = dir.listFiles();
        int counter = 0;

        for (File f : files) {
            // increment counter for file name
            counter++;

            // try to rename and print a success/failure message
            if (f.renameTo(new File (f.getParent() + "/" + counter + "_test.txt"))) {
                System.out.println("Successfully renamed file: " + f.getAbsolutePath());
            } else System.out.println("Failed to rename file: " + f.getAbsolutePath());
        }
    }

    public static void deleteAllFilesInDirectory(File dir) {
        if (!dir.exists()) {
            System.out.println("Directory " + dir.getAbsolutePath() + " does not exist.");
            return;
        }

        if (!dir.isDirectory()) {
            System.out.println("The given file is not a directory");
            return;
        }

        // loop through all the files in the directory and delete them
        for (File file : dir.listFiles()) {
            // attempt to delete the file and print a message with the success/failure result
            System.out.printf("\nFile %s successfully deleted: %b", file.getName(), file.delete());
        }

    }
}
