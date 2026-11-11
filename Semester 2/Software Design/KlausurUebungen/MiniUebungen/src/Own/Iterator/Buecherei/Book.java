package Own.Iterator.Buecherei;

public class Book {

    protected String title;
    protected int year;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", title, year);
    }
}
