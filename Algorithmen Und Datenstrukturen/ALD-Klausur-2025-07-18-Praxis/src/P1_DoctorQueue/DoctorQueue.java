package P1_DoctorQueue;

public class DoctorQueue {
    private Node front;
    private Node rear;

    public Node getFront() {
        return front;
    }

    public Node getRear() {
        return rear;
    }

    public void enqueue(String name)
    {
        // Queue - FIFO - First In First Out

        // wenn es leer ist, gleich am Anfang den Node erstellen
        if (front == null) {
            front = new Node(name);
            rear = front; // rear muss auch auf
            return;
        }

        // temp. Variable um den aktuellen Node zu speichern
        Node curr = front;

        while (curr.getNext() != null) {
            curr = curr.getNext(); // zur Nächste schauen
        }

        // wenn curr.getNext() dann null ist, den neuen Node dort setzen:
        curr.setNext(new Node(name));

        // und rear auf dne neuen Node setzen
        rear = curr.getNext();
    }
}
