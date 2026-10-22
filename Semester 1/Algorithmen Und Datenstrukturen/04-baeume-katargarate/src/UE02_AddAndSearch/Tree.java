package UE02_AddAndSearch;

public class Tree {
    private Node root;

    public void add(int number) {
        // Knoten erstellen
        Node newNode = new Node(number);

        // Fall: Baum leer
        if (root == null)
        {
            root = newNode;
        }
        // Fall: Baum ist nicht leer
        else
        {
            // Variante 1: Schleife
            //addLoop(root, newNode);

            // Variante 2: Rekursion
            addRecursive(root, newNode);
        }
    }

    // Add - Variante Rekursion
    private void addRecursive(Node currentNode, Node newNode) {
        // Fall: Linke Seite
        if (newNode.getNumber() < currentNode.getNumber())
        {
            // Ist linke Seite schon besetzt?
            if (currentNode.getLeft() == null)
            {
                currentNode.setLeft(newNode);
            }
            // Weiterhüpfen
            else
                addRecursive(currentNode.getLeft(), newNode);
        }
        // Fall: Rechte Seite
        else
        {
            // Ist rechte Seite schon besetzt?
            if (currentNode.getRight() == null)
            {
                currentNode.setRight(newNode);
            }
            // Weiterhüpfen
            else
                addRecursive(currentNode.getRight(), newNode);

        }
    }

    // Add - Variante Loop
    private void addLoop(Node startNode, Node newNode) {
        Node current = root;

        // Fall: Baum ist leer
        if (root == null)
            root = newNode;
            // Fall: Baum ist nicht leer
        else {
            boolean added = false;
            do {
                // Linke Seite
                if (newNode.getNumber() < current.getNumber()) {
                    if (current.getLeft() == null) {
                        current.setLeft(newNode);
                        added = true;
                    } else
                        current = current.getLeft();
                }
                // Rechte Seite
                else if (newNode.getNumber() > current.getNumber()) {
                    if (current.getRight() == null) {
                        current.setRight(newNode);
                        added = true;
                    } else
                        current = current.getRight();
                }
            } while (added == false);
        }
    }

    public Node searchNumber(int number) {
        System.out.print("SearchNumber - ");

        // TODO: Entweder Variante 1 oder 2 einkommentieren
        // Variante 1: Aufruf Rekursiv
        return searchNumberRecursive(root, number);
        // Variante 2: Aufruf Schleife
        //return searchNumberLoop(number);
    }

    // Suche - Variante Rekursion
    private Node searchNumberRecursive(Node currentNode, int number) {
        if (currentNode == null)
            return null;
        else if (currentNode.getNumber() == number) {
            return currentNode;
        }
        // Fall: Linke Seite
        else if (number < currentNode.getNumber())
        {
            return searchNumberRecursive(currentNode.getLeft(), number);
        }
        else
        {
            return searchNumberRecursive(currentNode.getRight(), number);
        }
    }

    // Suche - Variante Schleife
    private Node searchNumberLoop(int number) {
        Node current = root;

        while (current != null)
        {
            // Fall: Aktueller Knoten ist gesuchter Knoten
            if (current.getNumber() == number) {
                return current;
            }
            // Fall: Linke Seite weitersuchen
            else if (number < current.getNumber()) {
                current = current.getLeft();
            }
            // Fall: Rechte Seite weitersuchen
            else
            {
                current = current.getRight();
            }
        }
        return null;
    }

    /**
     * Funktion zur Ausgabe des gesamten Baums.
     */
    public void printTree() {
        printTree(root, "");
    }

    /**
     * Funktion zur Ausgabe des Baums unterhalb eines Knotens
     *
     * @param currentNode Knoten, dessen Teilbaum ausgegeben werden soll
     * @param prefix      Zur Einr�ckung
     */
    public void printTree(Node currentNode, String prefix) {
        if (currentNode == null) {
            return;
        }
        System.out.println(prefix + currentNode.getNumber());
        printTree(currentNode.getLeft(), prefix + "L ");
        printTree(currentNode.getRight(), prefix + "R ");
    }


}
