
public class Main {
    public static void main(String[] args) {
        // 1. Create the song library.
        LinkedChain<Song> library = new LinkedChain<Song>();

        library.addToEnd(new Song(
            "Nude", "Radiohead", "Alternative", 2007));
        library.addToEnd(new Song(
            "Karma Police", "Radiohead", "Alternative", 1997));
        library.addToEnd(new Song(
            "Obstacle 1", "Interpol", "Post-Punk", 2002));
        library.addToEnd(new Song(
            "Disorder", "Joy Division", "Post-Punk", 1979));
        library.addToEnd(new Song(
            "Teardrop", "Massive Attack", "Trip-Hop", 1998));
        library.addToEnd(new Song(
            "Roads", "Portishead", "Trip-Hop", 1994));
        library.addToEnd(new Song(
            "Just Like Heaven", "The Cure", "Alternative", 1987));
        library.addToEnd(new Song(
            "No Surprises", "Radiohead", "Alternative", 1997));
        library.addToEnd(new Song(
            "Enjoy the Silence", "Depeche Mode", "Synth-Pop", 1990));
        library.addToEnd(new Song(
            "Love Will Tear Us Apart", "Joy Division",
            "Post-Punk", 1980));

        // 2. Create a listener profile.
        ListenerProfile listener = new ListenerProfile();

        listener.addFavoriteArtist("Radiohead");
        listener.addFavoriteArtist("Joy Division");
        listener.addFavoriteGenre("Trip-Hop");

        // 3. Generate suggestions.
        RecommendationEngine engine =
            new RecommendationEngine();

        SuggestionQueue suggestions =
            engine.generateSuggestions(library, listener);

        // 4. Display and consume the queue.
        System.out.println("Song Suggestions:");

        while (!suggestions.isEmpty()) {
            Song song = suggestions.dequeue();
            System.out.println(song);
        }
    }
}
