package LinkedLists;

public class Main {

    void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        if (linkedList.getFirst()  == null) {
            System.out.println("Liste ist leer, first = null");
        }
        else {
            System.out.println("Liste ist nicht leer - first = " + linkedList.getFirst().getToDo());

        }

        linkedList.addToDoAtLastPos("Wäsche Waschen");
        System.out.println("1. Node enthalten, first = " + linkedList.getFirst().getToDo());
        System.out.println("1. Node enthalten, last = " + linkedList.getLast().getToDo());

        linkedList.addToDoAtLastPos("Steuerausgleich machen");
        System.out.println("2. Node enthalten, first = " + linkedList.getFirst().getToDo());
        System.out.println("2. Node enthalten, last = " + linkedList.getLast().getToDo());

        linkedList.deleteToDoFromFirstPos();
        System.out.println("1. Node gelöscht, first = " + linkedList.getFirst().getToDo());
        System.out.println("2. Node gelöscht, last = " + linkedList.getLast().getToDo());
    }
}
