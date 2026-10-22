package UE05_BreadthFirstSearch.Queue;

import UE05_BreadthFirstSearch.Tree.TreeNode;

public class Queue {
    private QueueNode front;
    private QueueNode rear;

    public void enqueue(TreeNode treeNode) {
        // QueueNode erstellen
        QueueNode newNode = new QueueNode();
        newNode.setTreeNode(treeNode);

        // Queue ist noch leer
        if (front == null) {
            front = newNode;
            rear = newNode;
        }
        // Queue ist bereits befüllt
        else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public TreeNode dequeue() {
        // Queue ist nicht leer
        if (front != null) {
            TreeNode treeNode = front.getTreeNode();
            front = front.getNext();
            // Queue wurde im Zuge der Aktion leer, darum rear anpassen
            if (front == null)
                rear = null;
            return treeNode;
        }
        else
            return null;
    }

    public boolean isEmpty()
    {
        return (front == null);
    }


}

