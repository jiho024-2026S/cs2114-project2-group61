import student.TestCase;

public class ListenerProfileTest extends TestCase {
    private ListenerProfile profile;

    public void setUp() {
        profile = new ListenerProfile();
    }

    public void testArtists() {
        assertFalse(profile.likesArtist("Radiohead"));
        profile.addFavoriteArtist(" Radiohead ");
        assertTrue(profile.likesArtist("Radiohead"));
        assertFalse(profile.likesArtist("radiohead")); // Case-sensitive by design.
        assertFalse(profile.likesArtist("Coldplay"));
        assertFalse(profile.likesArtist(null));
    }

    public void testGenres() {
        assertFalse(profile.likesGenre("Rock"));
        profile.addFavoriteGenre(" Rock ");
        assertTrue(profile.likesGenre("Rock"));
        assertFalse(profile.likesGenre("Jazz"));
        assertFalse(profile.likesGenre(null));
    }

    public void testInvalidArtist() {
        try {
            profile.addFavoriteArtist("  ");
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException expected) { }
        try {
            profile.addFavoriteArtist(null);
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException expected) { }
    }

    public void testInvalidGenre() {
        try {
            profile.addFavoriteGenre("  ");
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException expected) { }
        try {
            profile.addFavoriteGenre(null);
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException expected) { }
    }
    /** Adding more than one favorite keeps the earlier preference searchable. */
    public void testMultipleFavorites() {
        profile.addFavoriteArtist("Radiohead");
        profile.addFavoriteArtist("Massive Attack");
        profile.addFavoriteGenre("Alternative");
        profile.addFavoriteGenre("Trip-Hop");
        assertTrue(profile.likesArtist("Radiohead"));
        assertTrue(profile.likesArtist("Massive Attack"));
        assertTrue(profile.likesGenre("Alternative"));
        assertTrue(profile.likesGenre("Trip-Hop"));
    }


}
