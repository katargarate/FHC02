package Binary;

import java.io.*;

public class UE16 {

    static void main(String[] args) throws IOException, ClassNotFoundException {
        //writeAndReadString();
        writeAndReadeObject();
    }

    public static void writeAndReadString() throws IOException {
        File file = new File("object.dat");

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream objOutputStream = new ObjectOutputStream(fos);

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream objInputStream = new ObjectInputStream(fis);

        String msg = "Hello world";
        String msg2 = "Hello world!!!!!";

        // write msg into the file
        objOutputStream.writeObject(msg);
        objOutputStream.writeObject(msg2);
        objOutputStream.flush();
        objOutputStream.close();

        int currLine = 0;

        // loop through the file and read the result back out into the console as a string line by line
        try {
            while (true) {
                String readLine = (String) objInputStream.readObject();
                System.out.printf("Line %d: %s\n", currLine++, readLine);
            }
        } catch (EOFException | ClassNotFoundException e) {
            // End of file reached
            System.out.printf("\nEnd of file reached.\nTotal lines read: %d", currLine);
        }


        objInputStream.close();
    }

    public static void writeAndReadeObject() throws IOException, ClassNotFoundException {
        File file = new File("object.dat");

        Coffee espresso = new Coffee("espresso", 's', 2.3);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream objOutputStream = new ObjectOutputStream(fos);

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream objInputStream = new ObjectInputStream(fis);

        // write the espresso object into the file
        objOutputStream.writeObject(espresso);

        // read it back out, cast as a Coffee object
        Coffee coffeeOutput = (Coffee) objInputStream.readObject();

        System.out.printf("Coffee Output: %s\n", coffeeOutput);

        objOutputStream.flush();
        objOutputStream.close();

    }
}
