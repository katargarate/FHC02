import java.io.*;

public class UE16_SerializeFromFile {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String meinString = "Hello World!";

        File file = new File("object.dat");
        FileOutputStream fos = new FileOutputStream(file);
        //ab hier gibt es das leere file, egal ob es vorher existiert hat
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);

        objectOutputStream.writeObject(meinString);
        objectOutputStream.flush();
        objectOutputStream.close();

        // jetzt den String-Objekt wieder einlesen
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        String gelesen = (String) ois.readObject();
        System.out.println("Gelesener String: " + gelesen);
        ois.close();

        //Eigene Klasse erstellen mit min. 3 versch. Membertypen.
        //diese Klasse in die object.dat schreiben und im Editor anschauen

        File file2 = new File("object2.dat");
        FileOutputStream fos2 = new FileOutputStream(file2);
        //ab hier gibt es das leere file, egal ob es vorher existiert hat
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fos2);
        objectOutputStream2.writeObject(new Animal());
        objectOutputStream2.flush();
        objectOutputStream2.close();
        System.out.println("geschrieben.");
        // jetzt das Animal-Objekt wieder einlesen
        FileInputStream fis2 = new FileInputStream(file2);
        ObjectInputStream ois2 = new ObjectInputStream(fis2);
        Animal gelesen2 = (Animal) ois2.readObject();
        System.out.println("Gelesenes Animal: " + gelesen2);
        ois.close();

    }

    public static class Animal implements Serializable {
        int version = 5;
        public int alter = 83;
        public String name = "Willibald das Axolotl";
        public Double gewichtInStone = 0.05d;
        //   public String parents = "parents";


        @Override
        public String toString() {
            return "Animal{" + "version=" + version + ", alter=" + alter + ", name='" + name + '\'' + ", gewichtInStone=" + gewichtInStone + '}';
        }
    }
}