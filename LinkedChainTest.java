import student.TestCase;

public class LinkedChainTest extends TestCase {
    public void testThreeGenericElementTypes() {
        LinkedChain<Song> songs = new LinkedChain<Song>();
        Song song = new Song("Nude", "Radiohead", "Alternative", 2007);
        songs.add(song);
        assertEquals(song, songs.get(0));

        LinkedChain<ListenerProfile> profiles = new LinkedChain<ListenerProfile>();
        ListenerProfile profile = new ListenerProfile();
        profiles.add(profile);
        assertEquals(profile, profiles.get(0));

        LinkedChain<String> artists = new LinkedChain<String>();
        artists.add("Radiohead");
        assertEquals("Radiohead", artists.get(0));
    }

    public void testAddRemoveAndMissingElement() {
        LinkedChain<String> chain = new LinkedChain<String>();
        assertTrue(chain.isEmpty());
        assertNull(chain.remove());
        assertFalse(chain.remove("missing"));
        assertTrue(chain.add("first"));
        assertTrue(chain.addToEnd("last"));
        assertEquals(2, chain.size());
        assertTrue(chain.contains("last"));
        assertEquals(1, chain.count("first"));
        assertEquals("first", chain.remove());
        assertFalse(chain.remove("missing"));
        assertTrue(chain.remove("last"));
        assertTrue(chain.isEmpty());
    }

    public void testArrayAndClear() {
        LinkedChain<String> chain = new LinkedChain<String>();
        chain.addToEnd("A");
        chain.addToEnd("B");
        String[] entries = chain.toArray(new String[chain.size()]);
        assertEquals("A", entries[0]);
        assertEquals("B", entries[1]);
        chain.clear();
        assertEquals(0, chain.size());
    }

    public void testInvalidArguments() {
        LinkedChain<String> chain = new LinkedChain<String>();
        try {
            chain.add(null);
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException expected) { }
        try {
            chain.get(0);
            fail("Expected IndexOutOfBoundsException");
        }
        catch (IndexOutOfBoundsException expected) { }
        try {
            chain.toArray(new String[0]);
            // Empty chain and empty array are valid.
        }
        catch (IllegalArgumentException unexpected) {
            fail("An empty array should fit an empty chain");
        }
        chain.add("A");
        try {
            chain.toArray(new String[0]);
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException expected) { }
    }
}
