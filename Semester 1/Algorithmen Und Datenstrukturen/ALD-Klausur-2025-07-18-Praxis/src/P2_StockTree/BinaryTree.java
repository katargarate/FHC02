package P2_StockTree;

public class BinaryTree {
    private Node top;

    public Node getTop() {
        return top;
    }

    public void addStock(Stock stock)
    {
        // TODO
        // Implementieren Sie die Methode addStock(), die einen Bestand anhand der
        //ID im Binärbaum an der richtigen Stelle einfügt. Sie können die Lösung entweder
        //mithilfe einer Schleife oder mit einer Rekursion implementieren.

        // temp Variable um den aktuellen Node zu speichern
        Node curr = top;
        int currID = curr.getStock().getStockId();

        Node newNode = new Node(stock);
        int newNodeId = newNode.getStock().getStockId();

        boolean found = false;

        do {
            if (newNodeId < currID) {
                // wenn das linke kind leer ist, dort setzen
                if (curr.getLeft() == null) {
                    curr.setLeft(newNode);
                    found = true;
                } else {
                    // sonst setzen wir curr auf den Linken, um weiterzusuchen
                    curr = curr.getLeft();
                }
            }

            else if (newNodeId > currID) {
                if (curr.getRight() == null) {
                    curr.setRight(newNode);
                } else {
                    curr = curr.getRight();
                }
            }
        } while (true);
    }
}
