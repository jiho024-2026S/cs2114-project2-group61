import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import student.TestCase;

public class MenuTest extends TestCase {
    private LinkedChain<Song> songs;
    private ListenerProfile profile;
    private Song sample;
    private PrintStream originalOut;
    private ByteArrayOutputStream output;

    public void setUp() {
        songs = new LinkedChain<Song>();
        profile = new ListenerProfile();
        sample = new Song("Nude", "Radiohead", "Alternative", 2007);
        originalOut = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    public void tearDown() {
        System.setOut(originalOut);
    }

    private Menu menu(String input) {
        return new Menu(songs, profile, new Scanner(input));
    }

    public void testAddSongAndRetryBlankAndBadYear() {
        menu("   \nNude\nRadiohead\nAlternative\nabc\n-1\n2007\n"
            ).addSong();
        assertEquals(1, songs.size());
        assertEquals("Nude", songs.get(0).getTitle());
        assertTrue(output.toString().contains("Input cannot be blank"));
        assertTrue(output.toString().contains("Invalid year"));
    }

    public void testSearchFoundAndNotFound() {
        songs.add(sample);
        menu("Nude\nRadiohead\n").searchSong();
        assertTrue(output.toString().contains("Found:"));
        output.reset();
        menu("Missing\nNobody\n").searchSong();
        assertTrue(output.toString().contains("Song could not be found."));
    }

    public void testSearchEmpty() {
        menu("").searchSong();
        assertTrue(output.toString().contains("There are no songs stored."));
    }

    public void testRemoveFoundAndMissing() {
        songs.add(sample);
        menu("Missing\nNobody\n").removeSong();
        assertEquals(1, songs.size());
        assertTrue(output.toString().contains("could not be found"));
        output.reset();
        menu("Nude\nRadiohead\n").removeSong();
        assertTrue(songs.isEmpty());
        assertTrue(output.toString().contains("Removed:"));
    }

    public void testRemoveEmpty() {
        menu("").removeSong();
        assertTrue(output.toString().contains("no songs stored to remove"));
    }

    public void testListSongs() {
        menu("").listSongs();
        assertTrue(output.toString().contains("There are no songs stored."));
        output.reset();
        songs.add(sample);
        menu("").listSongs();
        assertTrue(output.toString().contains(sample.toString()));
    }

    public void testSuggestionsAndNext() {
        songs.add(sample);
        profile.addFavoriteArtist("Radiohead");
        Menu m = menu("");
        m.generateSuggestions();
        assertTrue(output.toString().contains("Suggestions ready"));
        output.reset();
        m.nextSuggestion();
        assertTrue(output.toString().contains("Next: " + sample));
        output.reset();
        m.nextSuggestion();
        assertTrue(output.toString().contains("There are no more song suggestions."));
    }

    public void testNoMatchingSuggestions() {
        songs.add(sample);
        menu("").generateSuggestions();
        assertTrue(output.toString().contains("No matching suggestions were found."));
    }

    public void testRunInvalidOptionAndPreferences() {
        Menu m = menu("abc\n5\n \nRadiohead\n6\nAlternative\n9\n");
        m.run();
        assertTrue(output.toString().contains("Invalid option"));
        assertTrue(output.toString().contains("Input cannot be blank"));
        assertTrue(profile.likesArtist("Radiohead"));
        assertTrue(profile.likesGenre("Alternative"));
        assertTrue(output.toString().contains("Goodbye."));
    }
    /** Add a song with valid input and verify the saved fields. */
    public void testAddSongNormal() {
        menu("OK Computer\nRadiohead\nAlternative\n1997\n").addSong();
        assertEquals(1, songs.size());
        assertEquals("OK Computer", songs.get(0).getTitle());
        assertEquals(1997, songs.get(0).getReleaseYear());
        assertTrue(output.toString().contains("Added:"));
    }

    /** Blank artist and genre values must be re-prompted. */
    public void testAddSongRetriesBlankArtistAndGenre() {
        menu("Nude\n  \nRadiohead\n\nAlternative\n2007\n").addSong();
        assertEquals(1, songs.size());
        assertEquals("Radiohead", songs.get(0).getArtist());
        assertEquals("Alternative", songs.get(0).getGenre());
        assertTrue(output.toString().contains("Input cannot be blank"));
    }

    /** The normal menu path should execute a choice and exit. */
    public void testRunNormalListAndExit() {
        songs.add(sample);
        menu("4\n9\n").run();
        assertTrue(output.toString().contains(sample.toString()));
        assertTrue(output.toString().contains("Goodbye."));
    }

    /** Generating recommendations from an empty library is safe. */
    public void testGenerateSuggestionsEmptyLibrary() {
        profile.addFavoriteArtist("Radiohead");
        menu("").generateSuggestions();
        assertTrue(output.toString().contains("No matching suggestions were found."));
    }

    /** Adding a song invalidates previously generated suggestions. */
    public void testAddSongResetsPreviousSuggestions() {
        songs.add(sample);
        profile.addFavoriteArtist("Radiohead");
        Menu m = menu("New Song\nNew Artist\nRock\n2020\n");
        m.generateSuggestions();
        m.addSong();
        output.reset();
        m.nextSuggestion();
        assertTrue(output.toString().contains("There are no more song suggestions."));
    }

    /** Removing a song invalidates previously generated suggestions. */
    public void testRemoveSongResetsPreviousSuggestions() {
        songs.add(sample);
        profile.addFavoriteArtist("Radiohead");
        Menu m = menu("Nude\nRadiohead\n");
        m.generateSuggestions();
        m.removeSong();
        output.reset();
        m.nextSuggestion();
        assertTrue(output.toString().contains("There are no more song suggestions."));
    }


}
