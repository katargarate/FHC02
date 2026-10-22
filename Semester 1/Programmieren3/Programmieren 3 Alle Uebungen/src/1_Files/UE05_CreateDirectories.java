import java.io.File;

public class UE05_CreateDirectories {
    static void main(String[] args) {
        File dirToCreate = new File("src/1_Files/createdDirectory/Layer2/Layer3");
        createMultipleDirectories(dirToCreate);
    }

    public static void createMultipleDirectories(File dir) {
        // check if file is a file or directory
        if (dir.isDirectory()) {
            // perform mkdirs() to try to create a directory, incl any necessary parent directories
            // returns true if successful, otherwise false
            System.out.println("Directory " + dir.getAbsolutePath() + " created?: " + dir.mkdirs());
        } else {
            System.out.println("Directory " + dir.getAbsolutePath() + " created?: " + dir.mkdirs());
        }
    }
}
