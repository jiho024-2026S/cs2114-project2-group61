import student.TestCase;

public class RecommendationEngineTest extends TestCase {
    private RecommendationEngine engine;
    private LinkedChain<Song> library;
    private ListenerProfile profile;
    private Song byArtist;
    private Song byGenre;

    public void setUp() {
        engine = new RecommendationEngine();
        library = new LinkedChain<Song>();
        profile = new ListenerProfile();
        byArtist = new Song("Nude", "Radiohead", "Alternative", 2007);
        byGenre = new Song("Teardrop", "Massive Attack", "Trip-Hop", 1998);
        library.addToEnd(byArtist);
        library.addToEnd(byGenre);
    }

    public void testArtistAndGenreMatches() {
        profile.addFavoriteArtist("Radiohead");
        profile.addFavoriteGenre("Trip-Hop");
        SuggestionQueue queue = engine.generateSuggestions(library, profile);
        assertEquals(byArtist, queue.nextSuggestion());
        assertEquals(byGenre, queue.nextSuggestion());
        assertTrue(queue.isEmpty());
    }

    public void testSongMatchingBothAddedOnce() {
        profile.addFavoriteArtist("Radiohead");
        profile.addFavoriteGenre("Alternative");
        SuggestionQueue queue = engine.generateSuggestions(library, profile);
        assertEquals(byArtist, queue.nextSuggestion());
        assertNull(queue.nextSuggestion());
    }

    public void testNoMatchesAndEmptyLibrary() {
        profile.addFavoriteArtist("Unknown");
        assertTrue(engine.generateSuggestions(library, profile).isEmpty());
        assertTrue(engine.generateSuggestions(new LinkedChain<Song>(), profile).isEmpty());
    }

    public void testNullArguments() {
        try {
            engine.generateSuggestions(null, profile);
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException expected) { }
        try {
            engine.generateSuggestions(library, null);
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException expected) { }
    }
    /** A library with songs but no preferences produces an empty queue. */
    public void testNoPreferences() {
        SuggestionQueue queue = engine.generateSuggestions(library, profile);
        assertTrue(queue.isEmpty());
        assertNull(queue.nextSuggestion());
    }


}
