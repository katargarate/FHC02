import java.io.*;
import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>(); // initialize list
    }

    public void add(Product p) {
        products.add(p);
    }

    // save the products list into the file
    public void saveToFile(String path) throws IOException {
        File file = new File(path);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

        // if the file is empty, add the header names to the top of the file (CSV standard)
        if (file.length() == 0) {
            bw.write("Product Name, Price, Category\n");
        }

        for (Product p : products) {
            bw.write(p.toString());
            bw.newLine();
            bw.flush();
        }

        bw.flush(); // not necessary because closing the file flushes it anyway
        bw.close();
    }


    public void readFromFile(String path) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = br.readLine();

        // display all the content from the file
        while (line != null) {
            System.out.println(line+"\n");
            line = br.readLine();
        }

        br.close();
    }

    public void readWordByWordFromFile(String path) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();

        // go through each line
        while (line!=null) {
            //separate by comma and give each part out individually

            // loop through each word in line, splitting by the comma
            for (String word : line.split(",")) {
                System.out.println(word.trim()); // trim to remove leading/trailing whitespace
            }

            line = br.readLine();
        }
    }

}
