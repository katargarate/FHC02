package P3_SortPhotoAlbums;

public class Main {
    public static void main(String[] args) {
        PhotoAlbum[] photoAlbums = new PhotoAlbum[16];
        Sorter sorter = new Sorter();

        createExamplePhotoAlbums(photoAlbums);

        sorter.sortPhotoAlbums(photoAlbums);

        for(int i = 0; i < photoAlbums.length; i++)
        {
            if (photoAlbums[i] != null)
                System.out.println(photoAlbums[i].toString());
        }
    }

    public static void createExamplePhotoAlbums(PhotoAlbum[] photoAlbums)
    {
        photoAlbums[0] = new PhotoAlbum(1997, 3, "Lignano");
        photoAlbums[1] = new PhotoAlbum(2001,9, "Kap Kamenjak");
        photoAlbums[2] = new PhotoAlbum(2002,7, "Rom");
        photoAlbums[3] = new PhotoAlbum(2005,8, "Paris");
        photoAlbums[4] = new PhotoAlbum(2012,10, "Oslo");
        photoAlbums[5] = new PhotoAlbum(2016,12, "San Vito Lo Capo");
        photoAlbums[6] = new PhotoAlbum(2001,8, "Ossiach");
        photoAlbums[7] = new PhotoAlbum(2005,2, "Schladming");
        photoAlbums[8] = new PhotoAlbum(2012,12, "Barcelona");
        photoAlbums[9] = new PhotoAlbum(2020,2, "USA");
        photoAlbums[10] = new PhotoAlbum(2021,1, "Rio de Janeiro");
        photoAlbums[11] = new PhotoAlbum(2020,1, "Thailand");
        photoAlbums[12] = new PhotoAlbum(2009,1, "Japan");
        photoAlbums[14] = new PhotoAlbum(2005,1, "Simbabwe");
        photoAlbums[13] = new PhotoAlbum(2020,6, "Hvar");
        photoAlbums[15] = new PhotoAlbum(2020,4, "Soca-Tal");
    }
}
