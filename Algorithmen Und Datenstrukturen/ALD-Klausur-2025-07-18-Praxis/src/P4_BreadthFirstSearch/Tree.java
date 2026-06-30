package P4_BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private Node top;

    public void buildExampleTree()
    {
        Node n1 = new Node(500);
        Node n2 = new Node(250);
        Node n3 = new Node(750);

        top = n1;
        n1.setLeft(n2);
        n1.setRight(n3);

        Node n4 = new Node(125);
        Node n5 = new Node(375);

        n2.setLeft(n4);
        n2.setRight(n5);

        Node n6 = new Node(625);
        Node n7 = new Node(875);

        n3.setLeft(n6);
        n3.setRight(n7);
    }

    public void performBfs(LinkedList<Node> visited)
    {
        // TODO
        //Queue<Node> queue = new LinkedList<>();
        // queue.add() = entspricht enqueue
        // queue.poll() = entspricht dequeue
    }

}
