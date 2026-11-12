import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

/**
 * Tests for the Playlist1 constructor, kernel, and standard methods.
 *
 * @author Zaid Hayat
 */
public class Playlist1Test {

    /**
     * Tests the no-argument constructor.
     */
    @Test
    public final void testConstructorEmpty() {
        Playlist playlist = new Playlist1();

        assertEquals(0, playlist.size());
    }

    /**
     * Tests adding to an empty playlist.
     */
    @Test
    public final void testAddSongToEmpty() {
        Playlist playlist = new Playlist1();

        playlist.addSong("A");

        assertEquals(1, playlist.size());
        assertEquals("A", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests adding to a nonempty playlist.
     */
    @Test
    public final void testAddSongToNonempty() {
        final int expectedSize = 3;
        Playlist playlist = new Playlist1();
        playlist.addSong("A");
        playlist.addSong("B");

        playlist.addSong("C");

        assertEquals(expectedSize, playlist.size());
        assertEquals("A", playlist.removeNextSong());
        assertEquals("B", playlist.removeNextSong());
        assertEquals("C", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests adding duplicate titles.
     */
    @Test
    public final void testAddDuplicateSong() {
        Playlist playlist = new Playlist1();
        playlist.addSong("A");

        playlist.addSong("A");

        assertEquals(2, playlist.size());
        assertEquals("A", playlist.removeNextSong());
        assertEquals("A", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests adding an empty title, which the contract permits.
     */
    @Test
    public final void testAddEmptyTitle() {
        Playlist playlist = new Playlist1();

        playlist.addSong("");

        assertEquals(1, playlist.size());
        assertEquals("", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests removing the only song.
     */
    @Test
    public final void testRemoveOnlySong() {
        Playlist playlist = new Playlist1();
        playlist.addSong("A");

        String result = playlist.removeNextSong();

        assertEquals("A", result);
        assertEquals(0, playlist.size());
    }

    /**
     * Tests removing the first of several songs.
     */
    @Test
    public final void testRemoveFirstSong() {
        Playlist playlist = new Playlist1();
        playlist.addSong("A");
        playlist.addSong("B");
        playlist.addSong("C");

        String result = playlist.removeNextSong();

        assertEquals("A", result);
        assertEquals(2, playlist.size());
        assertEquals("B", playlist.removeNextSong());
        assertEquals("C", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests the size of an empty playlist.
     */
    @Test
    public final void testSizeEmpty() {
        Playlist playlist = new Playlist1();

        int result = playlist.size();

        assertEquals(0, result);
        assertEquals(0, playlist.size());
    }

    /**
     * Tests size and preservation of the contents.
     */
    @Test
    public final void testSizeNonempty() {
        Playlist playlist = new Playlist1();
        playlist.addSong("A");
        playlist.addSong("B");

        int result = playlist.size();

        assertEquals(2, result);
        assertEquals(2, playlist.size());
        assertEquals("A", playlist.removeNextSong());
        assertEquals("B", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests clearing an empty playlist.
     */
    @Test
    public final void testClearEmpty() {
        Playlist playlist = new Playlist1();

        playlist.clear();

        assertEquals(0, playlist.size());
    }

    /**
     * Tests clearing a nonempty playlist.
     */
    @Test
    public final void testClearNonempty() {
        Playlist playlist = new Playlist1();
        playlist.addSong("A");
        playlist.addSong("B");

        playlist.clear();

        assertEquals(0, playlist.size());
    }

    /**
     * Tests reusing a cleared playlist.
     */
    @Test
    public final void testAddAfterClear() {
        Playlist playlist = new Playlist1();
        playlist.addSong("A");
        playlist.clear();

        playlist.addSong("B");

        assertEquals(1, playlist.size());
        assertEquals("B", playlist.removeNextSong());
        assertEquals(0, playlist.size());
    }

    /**
     * Tests newInstance from an empty playlist.
     */
    @Test
    public final void testNewInstanceEmpty() {
        Playlist original = new Playlist1();

        Playlist result = original.newInstance();

        assertNotSame(original, result);
        assertEquals(original.getClass(), result.getClass());
        assertEquals(0, original.size());
        assertEquals(0, result.size());
    }

    /**
     * Tests that a new instance is empty and independent.
     */
    @Test
    public final void testNewInstanceIndependent() {
        Playlist original = new Playlist1();
        original.addSong("A");
        original.addSong("B");

        Playlist result = original.newInstance();

        assertNotSame(original, result);
        assertEquals(original.getClass(), result.getClass());
        assertEquals(0, result.size());

        result.addSong("C");

        assertEquals(2, original.size());
        assertEquals("A", original.removeNextSong());
        assertEquals("B", original.removeNextSong());
        assertEquals(0, original.size());
        assertEquals(1, result.size());
        assertEquals("C", result.removeNextSong());
        assertEquals(0, result.size());
    }

    /**
     * Tests transferring to an empty destination.
     */
    @Test
    public final void testTransferToEmpty() {
        Playlist source = new Playlist1();
        source.addSong("A");
        source.addSong("B");
        Playlist destination = new Playlist1();

        destination.transferFrom(source);

        assertEquals(0, source.size());
        assertEquals(2, destination.size());
        assertEquals("A", destination.removeNextSong());
        assertEquals("B", destination.removeNextSong());
        assertEquals(0, destination.size());
    }

    /**
     * Tests replacing a nonempty destination.
     */
    @Test
    public final void testTransferReplacesDestination() {
        Playlist source = new Playlist1();
        source.addSong("A");
        source.addSong("B");
        Playlist destination = new Playlist1();
        destination.addSong("Old");

        destination.transferFrom(source);

        assertEquals(0, source.size());
        assertEquals(2, destination.size());
        assertEquals("A", destination.removeNextSong());
        assertEquals("B", destination.removeNextSong());
        assertEquals(0, destination.size());
    }

    /**
     * Tests transferring an empty source to a nonempty destination.
     */
    @Test
    public final void testTransferEmptySource() {
        Playlist source = new Playlist1();
        Playlist destination = new Playlist1();
        destination.addSong("Old");

        destination.transferFrom(source);

        assertEquals(0, source.size());
        assertEquals(0, destination.size());
    }

    /**
     * Tests transferring between empty playlists.
     */
    @Test
    public final void testTransferBothEmpty() {
        Playlist source = new Playlist1();
        Playlist destination = new Playlist1();

        destination.transferFrom(source);

        assertEquals(0, source.size());
        assertEquals(0, destination.size());
    }

    /**
     * Tests independent reuse of the source after transfer.
     */
    @Test
    public final void testTransferSourceIndependent() {
        Playlist source = new Playlist1();
        source.addSong("A");
        Playlist destination = new Playlist1();

        destination.transferFrom(source);

        assertEquals(0, source.size());
        source.addSong("B");

        assertEquals(1, source.size());
        assertEquals("B", source.removeNextSong());
        assertEquals(0, source.size());
        assertEquals(1, destination.size());
        assertEquals("A", destination.removeNextSong());
        assertEquals(0, destination.size());
    }
}
