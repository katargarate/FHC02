package LinkedLists;

public class LinkedList {
    private Node first; // da wo die Liste beginnt speichern, damit ich weiß, wo ich anfangen muss
    private Node last; // optional

    public void addToDoAtLastPos(String toDoText) {
        Node newNode = new Node(toDoText);

        // Prüfen, ob die Liste leer ist
        if (first == null)  {
            first = newNode; // erste Stelle = neues Node
            last = null;
        } else {
            last.setNext(newNode); // last auf new node setzen
            last = newNode; // Last Referenz für später auf newNode setzen
        }


    }

    public void deleteToDoFromFirstPos() {
        if (first == null) return; // wenn die Liste leer ist einfach rausspringen

        first =  first.getNext(); // first auf den 2. Node zeigen

        // Fall: nur ein Knoten in der Liste
        if (first == last) {
            last = null;
        }
    }


    public Node searchToDoText(String toDoText) {
        Node current = first; // Hilfsvariable erstmals auf first setzen

        while (current != null) {
            if (current.getToDo().equals(toDoText)) {
                return current;

            } current = current.getNext(); // Hilfsvariable auf den nächsten Node setzen
        }
        return null; // wenn kein passendes Node genfunden wurde
    }


    public Node getFirst() {

        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }
}
