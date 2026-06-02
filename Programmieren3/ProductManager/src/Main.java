import java.io.IOException;

public class Main {

    static void main(String[] args) throws IOException {
        Product p1 = new Product("Apple", 0.99, "Fruit");
        Product p2 = new Product("Banana", 0.89, "Fruit");
        Product p3 = new Product("Kiwi", 0.69, "Fruit");
        Product p4 = new Product("Mango", 1.99, "Fruit");

        ProductManager pm = new ProductManager();
        pm.add(p1);
        pm.add(p2);
        pm.add(p3);
        pm.add(p4);

        pm.saveToFile("products.txt");
        pm.readFromFile("products.txt");

        // pm.readWordByWordFromFile("products.txt");
    }
}