package UE2_WagonLinkedList;

public class TestWagonLinkedList {
    public static void main(String[] args) {
        WagonLinkedList wagonLinkedList = new WagonLinkedList();

        wagonLinkedList.printList(); // empty list

//        // Hinzufügen
//        wagonLinkedList.insertWagonAtFirstPos("Speisewagen 4712");
//        wagonLinkedList.insertWagonAtFirstPos("Schlafabteil 7");
//        wagonLinkedList.insertWagonAtFirstPos("Güterwagon 39");
//        wagonLinkedList.printList();
//        System.out.println("First: " + (wagonLinkedList.getFirst() != null ? wagonLinkedList.getFirst().getWagonId() : "null"));
//        System.out.println("Last: " + (wagonLinkedList.getLast() != null ? wagonLinkedList.getLast().getWagonId() : "null"));

        // Löschen
        wagonLinkedList.removeWagonFromLastPos();
        System.out.println("First: " + (wagonLinkedList.getFirst() != null ? wagonLinkedList.getFirst().getWagonId() : "null"));
        System.out.println("Last: " + (wagonLinkedList.getLast() != null ? wagonLinkedList.getLast().getWagonId() : "null"));

        // Noch mehr löschen
        wagonLinkedList.removeWagonFromLastPos();
        wagonLinkedList.removeWagonFromLastPos();
        wagonLinkedList.printList();
        System.out.println("First: " + (wagonLinkedList.getFirst() != null ? wagonLinkedList.getFirst().getWagonId() : "null"));
        System.out.println("Last: " + (wagonLinkedList.getLast() != null ? wagonLinkedList.getLast().getWagonId() : "null"));
    }
}
