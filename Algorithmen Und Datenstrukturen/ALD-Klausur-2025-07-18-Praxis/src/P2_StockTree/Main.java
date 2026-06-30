package P2_StockTree;


public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addStock(new Stock(5000, "Festplatte"));
        System.out.println("Top - [SOLL] 5000, [IST] " + printIdFromNode(binaryTree.getTop()));

        binaryTree.addStock(new Stock(3000, "Monitor"));
        System.out.println("Top - [SOLL] 5000, [IST] " + printIdFromNode(binaryTree.getTop()));
        System.out.println("Top-Left - [SOLL] 3000, [IST] " + (binaryTree.getTop() == null ? "null" : printIdFromNode(binaryTree.getTop().getLeft())));

        binaryTree.addStock(new Stock(7500, "Webcam"));
        System.out.println("Top-Right - [SOLL] 7500, [IST] " + (binaryTree.getTop() == null ? "null" : printIdFromNode(binaryTree.getTop().getRight())));

        binaryTree.addStock(new Stock(4000, "Maus"));
        System.out.println("Top-Left-Right - [SOLL] 4000, [IST] " + (binaryTree.getTop() == null ? "null" : (binaryTree.getTop().getLeft() == null ? "null" : printIdFromNode(binaryTree.getTop().getLeft().getRight()))));

        binaryTree.addStock(new Stock(6000, "Tastatur"));
        System.out.println("Top - [SOLL] 5000, [IST] " + printIdFromNode(binaryTree.getTop()));
        System.out.println("Top-Right-Left - [SOLL] 6000, [IST] " + (binaryTree.getTop() == null ? "null" : (binaryTree.getTop().getRight() == null ? "null" : printIdFromNode(binaryTree.getTop().getRight().getLeft()))));
    }

    private static String printIdFromNode(Node node)
    {
        if (node == null)
            return "null";
        else
            return node.getStock().getStockId() + "";
    }
}
