import student.TestCase;

public class SuggestionQueueTest extends TestCase {
    private SuggestionQueue queue;
    private Song first;
    private Song second;

    public void setUp() {
        queue = new SuggestionQueue();
        first = new Song("Nude", "Radiohead", "Alternative", 2007);
        second = new Song("Teardrop", "Massive Attack", "Trip-Hop", 1998);
    }

    public void testEmptyQueue() {
        assertTrue(queue.isEmpty());
        assertNull(queue.nextSuggestion());
        assertTrue(queue.isEmpty());
    }

    public void testAddAndNextSuggestion() {
        queue.addSuggestion(first);
        queue.addSuggestion(second);
        assertFalse(queue.isEmpty());
        assertEquals(first, queue.nextSuggestion());
        assertEquals(second, queue.nextSuggestion());
        assertNull(queue.nextSuggestion());
        assertTrue(queue.isEmpty());
    }

    public void testNullSuggestion() {
        try {
            queue.addSuggestion(null);
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException expected) { }
        assertTrue(queue.isEmpty());
    }
    /** Adding a valid song to an initially empty queue works. */
    public void testSingleSuggestion() {
        assertTrue(queue.isEmpty());
        queue.addSuggestion(first);
        assertFalse(queue.isEmpty());
        assertEquals(first, queue.nextSuggestion());
        assertTrue(queue.isEmpty());
    }


}
