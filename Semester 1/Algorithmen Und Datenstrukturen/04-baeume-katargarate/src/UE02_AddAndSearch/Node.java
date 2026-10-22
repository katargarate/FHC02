package UE02_AddAndSearch;

public class Node
{
    // *** Membervariablen ***
    private int number;
    private Node left;
    private Node right;
    private Node parent;

    public Node(int number) {
        this.number = number;
    }
    // TODO

    // *** Konstruktor ***
    // TODO

    // *** Getter- & Setter-Methoden ***

    public int getNumber() {
        return number;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node getParent() {
        return parent;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
