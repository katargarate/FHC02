package UE1_TodoLinkedList;

public class TestTodoLinkedList {
    public static void printLinkedList(TodoLinkedList todoLinkedList) {
        Node currentNode = todoLinkedList.getFirst();

        System.out.print("Start LinkedList: ");
        while (currentNode != null) {
            System.out.print(currentNode.getTodoText() + "; ");
            currentNode = currentNode.getNext();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        TodoLinkedList todoLinkedList = new TodoLinkedList();

        // *** Neue Elemente hinzufügen ***
        todoLinkedList.appendTodoText("Müll rausbringen");
        todoLinkedList.appendTodoText("Für ALD lernen");
        todoLinkedList.appendTodoText("Urlaub planen");
        todoLinkedList.appendTodoText("Steuerausgleich machen");
        printLinkedList(todoLinkedList);

        // *** Was ist auf der 5? ***
        int position = 4;
        System.out.println("Auf Position " + position + " ist: " + todoLinkedList.getTodoTextAtIndex(position));

        // *** Was ist auf der 2? ***
        position = 1;
        System.out.println("Auf Position " + position + " ist: " + todoLinkedList.getTodoTextAtIndex(position));

        // *** Das letzte Element löschen
        todoLinkedList.deleteLastTodoText();
        printLinkedList(todoLinkedList);

        // *** Noch mehr löschen
        todoLinkedList.deleteLastTodoText();
        todoLinkedList.deleteLastTodoText();
        todoLinkedList.deleteLastTodoText();
        todoLinkedList.deleteLastTodoText();
        todoLinkedList.deleteLastTodoText();
        printLinkedList(todoLinkedList);
    }

}
