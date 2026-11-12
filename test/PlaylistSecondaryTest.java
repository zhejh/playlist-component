import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests for the secondary and common Playlist methods.
 *
 * @author Zaid Hayat
 */
public class PlaylistSecondaryTest {

    /**
     * Tests isEmpty on an empty playlist.
     */
    @Test
    public final void testIsEmptyTrue() {
        Playlist playlist = new Playlist1();

        boolean result = playlist.isEmpty();

        assertTrue(result);
        assertEquals(0, playlist.size());
    }

    /**
     * Tests isEmpty on a nonempty playlist and preserves its contents.
     */
    @Test
    public final void testIsEmptyFalse() {
        Playlist playlist = new Playlist1();
        playlist.addSong("A");
        playlist.addSong("B");

        boolean result = playlist.isEmpty();

        assertFalse(result);
        assertEquals(2, playlist.size());
        assertEquals("A", playlist.removeNextSong());
        assertEquals("B", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests skipping zero songs on an empty playlist.
     */
    @Test
    public final void testSkipZeroEmpty() {
        Playlist playlist = new Playlist1();

        playlist.skipSongs(0);

        assertEquals(0, playlist.size());
    }

    /**
     * Tests skipping zero songs on a nonempty playlist.
     */
    @Test
    public final void testSkipZeroNonempty() {
        Playlist playlist = new Playlist1();
        playlist.addSong("A");
        playlist.addSong("B");

        playlist.skipSongs(0);

        assertEquals(2, playlist.size());
        assertEquals("A", playlist.removeNextSong());
        assertEquals("B", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests skipping some songs.
     */
    @Test
    public final void testSkipSome() {
        Playlist playlist = new Playlist1();
        playlist.addSong("A");
        playlist.addSong("B");
        playlist.addSong("C");
        playlist.addSong("D");

        playlist.skipSongs(2);

        assertEquals(2, playlist.size());
        assertEquals("C", playlist.removeNextSong());
        assertEquals("D", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests skipping all songs.
     */
    @Test
    public final void testSkipAll() {
        final int songsToSkip = 3;
        Playlist playlist = new Playlist1();
        playlist.addSong("A");
        playlist.addSong("B");
        playlist.addSong("C");

        playlist.skipSongs(songsToSkip);

        assertEquals(0, playlist.size());
    }

    /**
     * Tests moving the only song to the end.
     */
    @Test
    public final void testMoveSingleSong() {
        Playlist playlist = new Playlist1();
        playlist.addSong("A");

        playlist.moveNextToEnd();

        assertEquals(1, playlist.size());
        assertEquals("A", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests moving the first of several songs to the end.
     */
    @Test
    public final void testMoveSeveralSongs() {
        final int expectedSize = 3;
        Playlist playlist = new Playlist1();
        playlist.addSong("A");
        playlist.addSong("B");
        playlist.addSong("C");

        playlist.moveNextToEnd();

        assertEquals(expectedSize, playlist.size());
        assertEquals("B", playlist.removeNextSong());
        assertEquals("C", playlist.removeNextSong());
        assertEquals("A", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests equality with the same object.
     */
    @Test
    public final void testEqualsSelf() {
        Playlist playlist = new Playlist1();
        playlist.addSong("A");
        playlist.addSong("B");

        boolean result = playlist.equals(playlist);

        assertTrue(result);
        assertEquals(2, playlist.size());
        assertEquals("A", playlist.removeNextSong());
        assertEquals("B", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests equality with null.
     */
    @Test
    public final void testEqualsNull() {
        Playlist playlist = new Playlist1();
        playlist.addSong("A");

        boolean result = playlist.equals(null);

        assertFalse(result);
        assertEquals(1, playlist.size());
        assertEquals("A", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests equality with an object of another type.
     */
    @Test
    public final void testEqualsDifferentType() {
        Playlist playlist = new Playlist1();
        playlist.addSong("A");
        Object other = "A";

        boolean result = playlist.equals(other);

        assertFalse(result);
        assertEquals(1, playlist.size());
        assertEquals("A", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests equality between empty playlists.
     */
    @Test
    public final void testEqualsEmpty() {
        Playlist first = new Playlist1();
        Playlist second = new Playlist1();

        boolean result = first.equals(second);

        assertTrue(result);
        assertEquals(0, first.size());
        assertEquals(0, second.size());
    }

    /**
     * Tests equality and symmetry for matching playlists.
     */
    @Test
    public final void testEqualsMatching() {
        Playlist first = new Playlist1();
        first.addSong("A");
        first.addSong("B");
        Playlist second = new Playlist1();
        second.addSong("A");
        second.addSong("B");

        boolean forward = first.equals(second);
        boolean backward = second.equals(first);

        assertTrue(forward);
        assertTrue(backward);
        assertEquals(2, first.size());
        assertEquals(2, second.size());
        assertEquals("A", first.removeNextSong());
        assertEquals("B", first.removeNextSong());
        assertEquals("A", second.removeNextSong());
        assertEquals("B", second.removeNextSong());
        assertEquals(0, first.size());
        assertEquals(0, second.size());
    }

    /**
     * Tests equality for playlists of different sizes.
     */
    @Test
    public final void testEqualsDifferentSizes() {
        Playlist first = new Playlist1();
        first.addSong("A");
        Playlist second = new Playlist1();
        second.addSong("A");
        second.addSong("B");

        boolean result = first.equals(second);

        assertFalse(result);
        assertEquals(1, first.size());
        assertEquals(2, second.size());
        assertEquals("A", first.removeNextSong());
        assertEquals("A", second.removeNextSong());
        assertEquals("B", second.removeNextSong());
        assertEquals(0, first.size());
        assertEquals(0, second.size());
    }

    /**
     * Tests that different song order means unequal playlists.
     */
    @Test
    public final void testEqualsDifferentOrder() {
        Playlist first = new Playlist1();
        first.addSong("A");
        first.addSong("B");
        Playlist second = new Playlist1();
        second.addSong("B");
        second.addSong("A");

        boolean result = first.equals(second);

        assertFalse(result);
        assertEquals(2, first.size());
        assertEquals(2, second.size());
        assertEquals("A", first.removeNextSong());
        assertEquals("B", first.removeNextSong());
        assertEquals("B", second.removeNextSong());
        assertEquals("A", second.removeNextSong());
        assertEquals(0, first.size());
        assertEquals(0, second.size());
    }

    /**
     * Tests a mismatch followed by a matching song.
     */
    @Test
    public final void testEqualsDifferentTitles() {
        Playlist first = new Playlist1();
        first.addSong("A");
        first.addSong("B");
        Playlist second = new Playlist1();
        second.addSong("X");
        second.addSong("B");

        boolean result = first.equals(second);

        assertFalse(result);
        assertEquals(2, first.size());
        assertEquals(2, second.size());
        assertEquals("A", first.removeNextSong());
        assertEquals("B", first.removeNextSong());
        assertEquals("X", second.removeNextSong());
        assertEquals("B", second.removeNextSong());
        assertEquals(0, first.size());
        assertEquals(0, second.size());
    }

    /**
     * Tests hash codes for empty playlists.
     */
    @Test
    public final void testHashCodeEmpty() {
        Playlist first = new Playlist1();
        Playlist second = new Playlist1();

        int firstHash = first.hashCode();
        int secondHash = second.hashCode();

        assertEquals(firstHash, secondHash);
        assertEquals(0, first.size());
        assertEquals(0, second.size());
    }

    /**
     * Tests equal hash codes, repeatability, and preserved contents.
     */
    @Test
    public final void testHashCodeMatching() {
        Playlist first = new Playlist1();
        first.addSong("A");
        first.addSong("B");
        Playlist second = new Playlist1();
        second.addSong("A");
        second.addSong("B");

        int firstHash = first.hashCode();
        int secondHash = second.hashCode();
        int repeatedHash = first.hashCode();

        assertEquals(firstHash, secondHash);
        assertEquals(firstHash, repeatedHash);
        assertEquals(2, first.size());
        assertEquals(2, second.size());
        assertEquals("A", first.removeNextSong());
        assertEquals("B", first.removeNextSong());
        assertEquals("A", second.removeNextSong());
        assertEquals("B", second.removeNextSong());
        assertEquals(0, first.size());
        assertEquals(0, second.size());
    }

    /**
     * Tests the text representation of an empty playlist.
     */
    @Test
    public final void testToStringEmpty() {
        Playlist playlist = new Playlist1();

        String result = playlist.toString();

        assertEquals("<>", result);
        assertEquals(0, playlist.size());
    }

    /**
     * Tests the text representation of one song.
     */
    @Test
    public final void testToStringSingleSong() {
        Playlist playlist = new Playlist1();
        playlist.addSong("A");

        String result = playlist.toString();

        assertEquals("<A>", result);
        assertEquals(1, playlist.size());
        assertEquals("A", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests the text representation of several songs.
     */
    @Test
    public final void testToStringSeveralSongs() {
        final int expectedSize = 3;
        Playlist playlist = new Playlist1();
        playlist.addSong("A");
        playlist.addSong("B");
        playlist.addSong("C");

        String result = playlist.toString();

        assertEquals("<A, B, C>", result);
        assertEquals(expectedSize, playlist.size());
        assertEquals("A", playlist.removeNextSong());
        assertEquals("B", playlist.removeNextSong());
        assertEquals("C", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }
}
