package UE05_BreadthFirstSearch.Tree;

import UE05_BreadthFirstSearch.Queue.Queue;

public class Tree {
    private TreeNode root;

    public void add(int number)
    {
        // Knoten erstellen
        TreeNode newNode = new TreeNode();
        newNode.setNumber(number);

        // Tree ist noch leer
        if (root == null)
            root = newNode;
            // Tree ist nicht leer
        else
        {
            TreeNode currentNode = root;
            boolean nodeAdded = false;

            while ((currentNode != null) && (nodeAdded == false))
            {
                if (newNode.getNumber() < currentNode.getNumber())
                {
                    // Linkes Kind noch frei
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        nodeAdded = true;
                    }
                    // Linkes Kind bereits gesetzt
                    else
                        currentNode = currentNode.getLeft();
                }
                else
                {
                    // Rechtes Kind noch frei
                    if (currentNode.getRight() == null)
                    {
                        currentNode.setRight(newNode);
                        nodeAdded = true;
                    }
                    // Rechtes Kind bereits gesetzt
                    else
                        currentNode = currentNode.getRight();
                }
            }
        }
    }

    public void performBreadthFirstSearch()
    {
        Queue queue = new Queue();
        System.out.print("Start BFS: ");

        queue.enqueue(root);
        while (queue.isEmpty() == false)
        {
            TreeNode currentNode = queue.dequeue();
            System.out.print(currentNode.getNumber() + ", ");

            if (currentNode.getLeft() != null)
                queue.enqueue(currentNode.getLeft());
            if (currentNode.getRight() != null)
                queue.enqueue(currentNode.getRight());
        }
    }


}
