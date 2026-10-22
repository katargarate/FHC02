package UE7_MovieLinkedList;

public class MovieLinkedList {
    // *** Membervariablen ***
    // TODO

    // *** Methoden ***
    public Node getFirst() {
        // TODO
        return null;
    }

    public Node getLast() {
        // TODO
        return null;
    }

    public Node getMovieAtIndex(int index) {
        // TODO
        return null;
    }

    public void insertMovieTitleAtIndex(String movieTitle, int index) {
        // TODO
    }

    public void deleteMovieAtIndex(int index) {
        // TODO
    }

    public void printList() {
        Node currentNode = this.getFirst();

        System.out.print("*** Start: ");
        if (currentNode == null) {
            System.out.print("<empty>");
        } else {
            while (currentNode != null) {
                System.out.print(currentNode.getMovieTitle() + ", ");
                currentNode = currentNode.getNext();
            }
        }
        System.out.println();
    }

}
