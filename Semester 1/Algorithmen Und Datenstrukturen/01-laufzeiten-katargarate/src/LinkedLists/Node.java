package LinkedLists;

public class Node {
    private String toDo; // Wert
    private Node next; // Referenz

    public Node(String toDo) {
        this.toDo = toDo;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
