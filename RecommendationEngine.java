
public class RecommendationEngine {
    public SuggestionQueue generateSuggestions(LinkedChain<Song> library, ListenerProfile listener)
    {
        if (library == null || listener == null) {
            throw new IllegalArgumentException(
                "Library and listener cannot be null");
        }

        SuggestionQueue suggestions = new SuggestionQueue();

        // Convert the linked chain into an array for iteration.
        Song[] allSongs = library.toArray(
            new Song[library.size()]);

        for (int i = 0; i < allSongs.length; i++) {
            Song song = allSongs[i];

            boolean artistMatch =
                listener.likesArtist(song.getArtist());

            boolean genreMatch =
                listener.likesGenre(song.getGenre());

            if (artistMatch || genreMatch) {
                suggestions.enqueue(song);
            }
        }

        return suggestions;
    }
}
