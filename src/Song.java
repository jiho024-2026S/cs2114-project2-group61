/** Information about one song. */
public class Song {
    private String title;
    private String artist;
    private String genre;
    private int releaseYear;

    public Song(String title, String artist, String genre, int releaseYear) {
        if (title == null || title.trim().isEmpty()
            || artist == null || artist.trim().isEmpty()
            || genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Song information cannot be blank.");
        }
        if (releaseYear < 0) {
            throw new IllegalArgumentException("Release year cannot be negative.");
        }
        this.title = title.trim();
        this.artist = artist.trim();
        this.genre = genre.trim();
        this.releaseYear = releaseYear;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getGenre() { return genre; }
    public int getReleaseYear() { return releaseYear; }

    public String toString() {
        return title + " - " + artist + " (" + releaseYear + ") [" + genre + "]";
    }
}
