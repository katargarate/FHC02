package UE06_RotateTree;


public class Tree
{
    private Node root;

    public void addNode(TvShow newTvShow)
    {
        Node newNode = new Node(newTvShow);

        if (root == null)
            root = newNode;
        else
            addNodeRecursive(root, newNode);
    }

    // Variante: Rekursion
    private void addNodeRecursive(Node currentNode, Node newNode)
    {
        // Neuer Wert ist kleiner als der Wert beim aktuellen Knoten
        if (newNode.getTvShow().getRank() < currentNode.getTvShow().getRank())
        {
            // Links vom aktuellen Knoten ist es frei -> neuen Knoten anhängen
            if (currentNode.getLeft() == null)
                currentNode.setLeft(newNode);
                // Links vom aktuellen Knoten ist ein anderer Knoten -> weiter in die Tiefe gehen
            else
                addNodeRecursive(currentNode.getLeft(), newNode);
        }
        // Neuer Wert ist größer als der Wert beim aktuellen Knoten
        else
        {
            // Rechts vom aktuellen Knoten ist es frei -> neuen Knoten anhängen
            if (currentNode.getRight() == null)
                currentNode.setRight(newNode);
                // Rechts vom aktuellen Knoten ist ein anderer Knoten -> weiter in die Tiefe gehen
            else
                addNodeRecursive(currentNode.getRight(), newNode);
        }
    }

    // Variante: Schleife
    private void addNodeLoop(Node newNode)
    {
        Node currentNode = root;
        boolean added = false;

        while (added == false)
        {
            if (newNode.getTvShow().getRank() < currentNode.getTvShow().getRank())
            {
                // Links ist nichts. Darum dort einfügen
                if (currentNode.getLeft() == null)
                {
                    currentNode.setLeft(newNode);
                    added = true;
                }
                // Links ist etwas. Darum dort weiterschauen.
                else
                    currentNode = currentNode.getLeft();
            }
            else if (newNode.getTvShow().getRank() > currentNode.getTvShow().getRank())
            {
                // Rechts ist nichts. Darum dort einfügen.
                if (currentNode.getRight() == null)
                {
                    currentNode.setRight(newNode);
                    added = true;
                }
                // Rechts ist etwas. Darum dort weiterschauen.
                else
                    currentNode = currentNode.getRight();
            }
        }
    }

    public int getMaxDepth()
    {
        return getMaxDepth(root);
    }

    private int getMaxDepth(Node currentTree)
    {
        if (currentTree == null)
            return 0;
        else
        {
            int leftDepth = getMaxDepth(currentTree.getLeft());
            int rightDepth = getMaxDepth(currentTree.getRight());

            if (leftDepth > rightDepth)
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }

    /**
     * Knoten nach rechts rotieren:
     *
     *       N				 L
     *      / \             / \
     *     L   r     =>    ll  N
     *    / \			      / \
     *   ll lr               lr  r
     */
    public void rotateRight()
    {
        if (root == null)
            return;

        Node previousRoot = root;
        Node lNode = root.getLeft();

        if (lNode != null)
        {
            Node lrNode = lNode.getRight();
            previousRoot.setLeft(lrNode);

            lNode.setRight(previousRoot);
            root = lNode;
        }
    }


    /**
     * Knoten nach links rotieren:
     *
     *       N				 R
     *      / \             / \
     *     l   R     =>    N  rr
     *        / \	      / \
     *       rl rr       l  rl
     */
    public void rotateLeft()
    {
        if (root == null)
            return;

        Node previousRoot = root;
        Node rNode = root.getRight();

        if (rNode != null)
        {
            Node rlNode = rNode.getLeft();
            previousRoot.setRight(rlNode);

            rNode.setLeft(previousRoot);
            root = rNode;
        }
    }

    public int getNodeCount()
    {
        return getNodeCount(root);
    }

    private int getNodeCount(Node currentNode)
    {
        if (currentNode == null)
            return 0;
        else
        {
            Node leftNode = currentNode.getLeft();
            if (leftNode != null)
                return (1 + getNodeCount(leftNode));

            Node rightNode = currentNode.getRight();
            if (rightNode != null)
                return (1 + getNodeCount(rightNode));

            return 1;
        }
    }
}
