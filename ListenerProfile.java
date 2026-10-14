/** A listener's favorite artists and genres. */
public class ListenerProfile {
    private LinkedChain<String> artists = new LinkedChain<String>();
    private LinkedChain<String> genres = new LinkedChain<String>();

    public void addFavoriteArtist(String artist) {
        if (artist == null || artist.trim().isEmpty()) {
            throw new IllegalArgumentException("Artist cannot be blank.");
        }
        artists.add(artist.trim());
    }

    public void addFavoriteGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be blank.");
        }
        genres.add(genre.trim());
    }

    public boolean likesArtist(String artist) {
        return artists.contains(artist);
    }

    public boolean likesGenre(String genre) {
        return genres.contains(genre);
    }
}
