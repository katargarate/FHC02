package UE4_BookingQueue;

public class BookingQueue
{
    // *** Membervariablen ***
    private Node front;
    private Node rear;


    // *** Getter- und Setter-Methoden ***
    public Node getFront()
    {
        return front;
    }


    // *** Operationen ***

    public void enqueue(Booking newBooking)
    {
        Node newNode = new Node(newBooking);

        // if queue is empty
        if (front == null)
        {
            front = newNode;
            rear = front;
            rear.setNext(null);
        }
        // if queue has elements
        else
        {
            rear.setNext(newNode); // link old last to new node
            rear = newNode;        // update last pointer
        }
    }

    public Booking dequeue() throws QueueEmptyException
    {
        if (front == null) throw new QueueEmptyException();

        // save the booking we are removing (to return it)
        Booking removedBooking = front.getBooking();

        // if there's only one element
        if (front == rear) {
            front = null;
            rear = null;
        }
        // if theres more than one element
        else {
            front = front.getNext();
        }

        return removedBooking;
    }

    public int getCount()
    {
        int counter = 0;
        Node curr = front;

        while (curr != null) {
            counter++;
            curr = curr.getNext();
        }

        return counter; // if the queue is empty it'll just return 0 (initial counter value)
    }
}
