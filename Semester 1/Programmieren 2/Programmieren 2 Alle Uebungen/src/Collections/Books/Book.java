package Collections.Books;

public class Book {
    private String title;
    private boolean finished;
    //private Stars stars;
    private int stars;

    public Book(String title, boolean finished) {
        this.title = title;
        this.finished = finished;
    }

    // overloaded method to optionally allow the user to enter stars directly
    public Book(String title, boolean finished, int stars) {
        this.title = title;
        this.finished = finished;

        if (stars < 1) stars = 1; // if user gave an int below 1, set to 1
        if (stars > 5) stars = 5; // if user gave an int over 5, set to 5
        this.stars = stars;
    }

    @Override
    public String toString() {
        return String.format("""
                Book: %s
                Finished: %b
                Stars: %s
                """, title, finished, "*".repeat(stars)); // print stars as a string of the equivalent amount of asterisks
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
        finished = true; // set finished to true if stars are set
    }
}
