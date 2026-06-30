package P3_SortPhotoAlbums;

public class PhotoAlbum {
    private int year;
    private int month;
    private String place;

    public PhotoAlbum(int year, int month, String place) {
        this.year = year;
        this.month = month;
        this.place = place;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public String getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return this.year + "-" + this.month + "-" + this.place;
    }
}
