package UE2_WagonLinkedList;

public class WagonLinkedList {
    // *** Membervariablen ***
    // TODO
    private Node first;
    private Node last;

    // *** Methoden ***

    public Node getFirst() {
       return first;
    }

    public Node getLast() {
        return last;
    }


    void insertWagonAtFirstPos(String wagonId) {
        // Create a new node with the given wagon ID
        Node newNode = new Node(wagonId);

        // if the list is empty
        if (first == null) {
            // the new node becomes both the first and last node
            first = newNode;
            last = newNode;
        } else { // if the list already has elements:

            newNode.setNext(first); // link the new node to the current first node

            first.setPrev(newNode); // since it's a doubly linked list, set the previous pointer of the old first node to the new node

            first = newNode; // update the first pointer to the new node
        }
    }

    void removeWagonFromLastPos() {
        // if the list is empty, there is nothing to remove
        if (last == null) {
            return;
        }

        // if there's only one node in the list:
        if (first == last) {
            // removing that node makes the list empty
            first = null;
            last = null;
        } else { // if there's more than one node in the list:

            last = last.getPrev(); // move the last pointer one step back

            last.setNext(null); // disconnect the new last node from the removed node
        }


    }

    void printList() {
        System.out.print("* List: ");

        if (this.getFirst() == null) {
            System.out.print("<empty>");
        } else {
            Node currentNode = this.getFirst();
            while (currentNode != null) {
                System.out.print(currentNode.getWagonId() + ", ");
                currentNode = currentNode.getNext();
            }
        }

        System.out.println();
    }
}
