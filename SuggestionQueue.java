
public class SuggestionQueue {
    private LinkedChain<Song> songs;

    public SuggestionQueue() {
        songs = new LinkedChain<Song>();
    }

    // Adds a song to the back of the queue.
    public void enqueue(Song song) {
        if (song == null) {
            throw new IllegalArgumentException(
                "Song cannot be null");
        }

        songs.addToEnd(song);
    }

    // Removes and returns the first suggested song.
    public Song dequeue() {
        return songs.remove();
    }

    // Returns the first song without removing it.
    public Song peek() {
        if (songs.isEmpty()) {
            return null;
        }

        return songs.get(0);
    }

    public int size() {
        return songs.size();
    }

    public boolean isEmpty() {
        return songs.isEmpty();
    }

    public void clear() {
        songs.clear();
    }

    @Override
    public String toString() {
        return songs.toString();
    }
}
