/** Holds matching songs in the order they were found. */
public class SuggestionQueue {
    private LinkedChain<Song> suggestions = new LinkedChain<Song>();

    public void addSuggestion(Song song) {
        suggestions.addToEnd(song);
    }

    public Song nextSuggestion() {
        return suggestions.remove(); // Returns null when empty.
    }

    public boolean isEmpty() {
        return suggestions.isEmpty();
    }
}
