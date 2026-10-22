import java.io.*;
import java.util.ArrayList;

public class UE11_ProductManager {

    ArrayList<Product> products = new ArrayList<Product>();

    public void add(Product p){
        products.add(p);
        System.out.println("Product added successfully:  " + p);
    }

    public void saveToFile(String filepath) {
        File file = new File(filepath);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Product p : products) {
                bufferedWriter.write(p.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Product Information successfully saved.");
    }

    public void readFromFile(String filepath) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filepath);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Product Information successfully read.");
    }

}

class Product {
    private String productName;
    private double price;
    private String productCatgeory;

    public Product(String productName, double price, String productCatgeory) {
        this.productName = productName;
        this.price = price;
        this.productCatgeory = productCatgeory;
    }

    @Override
    public String toString() {
        return String.format("%s - €%.2f - Category: %s", productName, price, productCatgeory);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductCatgeory() {
        return productCatgeory;
    }

    public void setProductCatgeory(String productCatgeory) {
        this.productCatgeory = productCatgeory;
    }
}

class Main {
    public static void main(String[] args) {
        UE11_ProductManager productManager = new UE11_ProductManager();

        Product p1 = new Product("Laptop", 209.99, "Electronics");
        Product p2 = new Product("Tablet", 199.99, "Electronics");
        Product p3 = new Product("Ice Cream", 19.99, "Groceries");
        Product p4 = new Product("BMW", 12999.99, "Automotive");
        Product p5 = new Product("T-Shirt", 19.99, "Clothing");

        productManager.add(p1);
        productManager.add(p2);
        productManager.add(p3);
        productManager.add(p4);
        productManager.add(p5);

        productManager.saveToFile("src/1_Files/UE11_ProductsList.txt");
        productManager.readFromFile("src/1_Files/UE11_ProductsList.txt");
    }
}