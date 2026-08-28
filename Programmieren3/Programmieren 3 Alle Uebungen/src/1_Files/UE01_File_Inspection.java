import java.io.File;

public class UE01_File_Inspection {
    static void main(String[] args) {
        File newfile = new File("src/new-file-to-inspect.txt");
        inspectFile(newfile);
    }

    public static void inspectFile(File file) {

        // überprüfe, ob das File existiert
        System.out.println("Diese Datei existiert: " + file.exists());

        // Dateiname ausgeben
        System.out.println("Dateiname: " + file.getName());

        // Parent-Directory des Files
        System.out.println("Parent Directory: " + file.getParent());

        // Ist dieses File ein Verzeichnis?
        System.out.println("Dieses File ist ein Verzeichnis: " + file.isDirectory());

        // Ist dieses File eine Datei?
        System.out.println("Dieses File ist eine Datei: " + file.isFile());

        // Ist dieses File readable?
        System.out.println("Dieses File ist readable: " + file.canRead());

        // Ist dieses File writeable?
        System.out.println("Dieses File ist writeable: " + file.canWrite());

        // File Größe
        System.out.println("File Größe: " + file.length() + " Bytes");
    }
}
