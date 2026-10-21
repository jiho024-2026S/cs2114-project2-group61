/** Finds songs with an artist or genre the listener likes. */
public class RecommendationEngine {
    public SuggestionQueue generateSuggestions(LinkedChain<Song> library,
        ListenerProfile profile) {
        if (library == null || profile == null) {
            throw new IllegalArgumentException("Library and profile are required.");
        }
        SuggestionQueue queue = new SuggestionQueue();
        Song[] songs = library.toArray(new Song[library.size()]);
        for (Song song : songs) {
            if (profile.likesArtist(song.getArtist())
                || profile.likesGenre(song.getGenre())) {
                queue.addSuggestion(song);
            }
        }
        return queue;
    }
}
