package UE2_WagonLinkedList;

public class Node {
    // *** Membervariablen ***
    // TODO
    private String wagonId;
    private Node next;
    private Node current;
    private Node prev;

    public Node(String wagonId) {
        this.wagonId = wagonId;
    }

    // *** Getter- & Setter-Methoden ***
    public String getWagonId() {
        return wagonId;
    }

    public void setWagonId(String wagonId) {
        this.wagonId = wagonId;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
