
public class Song {
    private String title;
    private String artist;
    private String genre;
    private int releaseYear;

    public Song(String title, String artist, String genre, int releaseYear) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return title + " - " + artist + " (" + releaseYear
            + ") [" + genre + "]";
    }
}