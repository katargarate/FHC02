import java.io.File;

public class UE03_ListDirectoryContent {
    static void main(String[] args) {
        File dir = new File("/Users/katargarate/Documents/AQUA Unterlagen");
        //listDirectoryContent(dir);
        listDirectoryContentInclSubDirectories(dir, 0);
    }

    public static void listDirectoryContent(File dir) {
        // Write a program, which lists all files / directories of the given directory (without sub directories)
        // Make a different output for Files and Directories, for example:
        //Dir:C:\$Recycle.Bin
        //File:C:\3DEXP_Mkt_SW_6.29.743.exe

        // Array of files that is filled with the content (files and directories) of the given directory
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Dir:" + file.getAbsolutePath());
            } else System.out.println("File:" + file.getAbsolutePath());
        }
    }

    public static void listDirectoryContentInclSubDirectories(File dir, int indentLevel) {
        File[] files = dir.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files or directories in the given directory.");
            return;
        }

        // the indent level changes the length of the indent
        String indentString = "  ".repeat(indentLevel);

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.printf("%sDir:%s\n",indentString, file.getAbsolutePath());

                // recursive call with an additional indent level
                listDirectoryContentInclSubDirectories(file, indentLevel + 1);
            } else {
                System.out.printf("%sFile:%s\n", indentString, file.getAbsolutePath());
            }
        }
    }
}
