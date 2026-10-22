package UE7_MovieLinkedList;

public class TestMovieLinkedList {

    public static void main(String[] args) {
        MovieLinkedList movieLinkedList = new MovieLinkedList();

        // Einfügen
        movieLinkedList.insertMovieTitleAtIndex("Ghostbusters", 0);
        movieLinkedList.insertMovieTitleAtIndex("Indiana Jones", 1);
        movieLinkedList.insertMovieTitleAtIndex("Matrix", 2);
        movieLinkedList.insertMovieTitleAtIndex("Inception", 0);
        movieLinkedList.insertMovieTitleAtIndex("Titanic", 1);
        movieLinkedList.printList();

        // Suche
        Node searchNode1 = movieLinkedList.getMovieAtIndex(1);
        System.out.println("Suche 1: " + (searchNode1 == null ? "null" : searchNode1.getMovieTitle()));
        Node searchNode2 = movieLinkedList.getMovieAtIndex(75);
        System.out.println("Suche 2: " + (searchNode2 == null ? "null" : searchNode2.getMovieTitle()));

        // Löschen
        movieLinkedList.deleteMovieAtIndex(0);
        movieLinkedList.deleteMovieAtIndex(42);
        movieLinkedList.deleteMovieAtIndex(3);
        movieLinkedList.printList();

        // First und Last prüfen
        System.out.println("First: " + (movieLinkedList.getFirst() != null ? movieLinkedList.getFirst().getMovieTitle() : "null"));
        System.out.println("Last: " + (movieLinkedList.getLast() != null ? movieLinkedList.getLast().getMovieTitle() : "null"));
    }
}
