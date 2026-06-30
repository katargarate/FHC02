package P4_BreadthFirstSearch;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        LinkedList<Node> visitedBfs = new LinkedList<>();

        tree.buildExampleTree();

        tree.performBfs(visitedBfs);
        System.out.println("[SOLL] [500, 250, 750, 125, 375, 625, 875]");
        System.out.println("[IST] " + visitedBfs.toString());
    }
}
