
public class ListenerProfile {
    private LinkedChain<String> favoriteArtists;
    private LinkedChain<String> favoriteGenres;

    public ListenerProfile() {
        favoriteArtists = new LinkedChain<String>();
        favoriteGenres = new LinkedChain<String>();
    }

    public void addFavoriteArtist(String artist)
    {
        if (artist != null && !favoriteArtists.contains(artist)) {
            favoriteArtists.addToEnd(artist);
        }
    }

    public void addFavoriteGenre(String genre) {
        if (genre != null && !favoriteGenres.contains(genre)) {
            favoriteGenres.addToEnd(genre);
        }
    }

    public boolean likesArtist(String artist) {
        return favoriteArtists.contains(artist);
    }

    public boolean likesGenre(String genre) {
        return favoriteGenres.contains(genre);
    }
}