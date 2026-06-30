package P2_StockTree;

public class Node {
    private Stock stock;
    private Node left;
    private Node right;

    public Node(Stock stock) {
        this.stock = stock;
    }

    public Stock getStock() {
        return stock;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
