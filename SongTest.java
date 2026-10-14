import student.TestCase;

public class SongTest extends TestCase {
    public void testConstructorAndGetters() {
        Song song = new Song(" Nude ", " Radiohead ", " Alternative ", 2007);
        assertEquals("Nude", song.getTitle());
        assertEquals("Radiohead", song.getArtist());
        assertEquals("Alternative", song.getGenre());
        assertEquals(2007, song.getReleaseYear());
        assertEquals("Nude - Radiohead (2007) [Alternative]", song.toString());
    }

    public void testBlankOrNullInformation() {
        assertBadSong(null, "Artist", "Rock", 2000);
        assertBadSong("   ", "Artist", "Rock", 2000);
        assertBadSong("Title", null, "Rock", 2000);
        assertBadSong("Title", "   ", "Rock", 2000);
        assertBadSong("Title", "Artist", null, 2000);
        assertBadSong("Title", "Artist", "   ", 2000);
    }

    public void testNegativeYear() {
        assertBadSong("Title", "Artist", "Rock", -1);
    }

    private void assertBadSong(String title, String artist, String genre, int year) {
        try {
            new Song(title, artist, genre, year);
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException expected) {
            // Invalid song information is rejected.
        }
    }
    /** Year zero is accepted as a boundary value. */
    public void testZeroReleaseYear() {
        Song song = new Song("Title", "Artist", "Genre", 0);
        assertEquals(0, song.getReleaseYear());
        assertTrue(song.toString().contains("(0)"));
    }


}
