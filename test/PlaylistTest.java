import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests for Playlist constructors and operations.
 *
 * @author Zaid Hayat
 */
public abstract class PlaylistTest {

    /**
     * First sample song.
     */
    private static final Song SONG_A = new Song("Outside", "Staind");

    /**
     * Second sample song.
     */
    private static final Song SONG_B = new Song("Fine Again", "Seether");

    /**
     * Third sample song.
     */
    private static final Song SONG_C = new Song("Black", "Pearl Jam");

    /**
     * Creates an object of the implementation under test.
     *
     * @return an empty playlist
     * @ensures constructorTest = <>
     */
    protected abstract Playlist constructorTest();

    /**
     * Creates an object used to represent the expected value.
     *
     * @return an empty playlist
     * @ensures constructorRef = <>
     */
    protected abstract Playlist constructorRef();

    /**
     * Creates a test playlist from the given songs.
     *
     * @param songs
     *            the songs in playlist order
     * @return the constructed playlist
     * @requires <pre>
     * songs /= null and
     * every entry is a non-null Song with non-null title and artist
     * </pre>
     * @ensures <pre>
     * createFromArgsTest = [the title-artist pairs from songs,
     *                       in array order]
     * </pre>
     */
    private Playlist createFromArgsTest(Song... songs) {
        Playlist result = this.constructorTest();
        for (Song song : songs) {
            result.addSong(song);
        }
        return result;
    }

    /**
     * Creates a reference playlist from the given songs.
     *
     * @param songs
     *            the songs in playlist order
     * @return the constructed playlist
     * @requires <pre>
     * songs /= null and
     * every entry is a non-null Song with non-null title and artist
     * </pre>
     * @ensures <pre>
     * createFromArgsRef = [the title-artist pairs from songs,
     *                      in array order]
     * </pre>
     */
    private Playlist createFromArgsRef(Song... songs) {
        Playlist result = this.constructorRef();
        for (Song song : songs) {
            result.addSong(song);
        }
        return result;
    }

    /**
     * Tests the constructor's empty initial value.
     */
    @Test
    public final void testConstructor() {
        Playlist pRef = this.constructorRef();

        Playlist pTest = this.constructorTest();

        assertEquals(pRef, pTest);
        assertEquals(0, pTest.size());
    }

    /**
     * Tests adding to zero songs.
     */
    @Test
    public final void testAddSongZero() {
        Playlist pTest = this.createFromArgsTest();
        Playlist pRef = this.createFromArgsRef(SONG_A);

        pTest.addSong(SONG_A);

        assertEquals(pRef, pTest);
    }

    /**
     * Tests adding to one song.
     */
    @Test
    public final void testAddSongOne() {
        Playlist pTest = this.createFromArgsTest(SONG_A);
        Playlist pRef = this.createFromArgsRef(SONG_A, SONG_B);

        pTest.addSong(SONG_B);

        assertEquals(pRef, pTest);
    }

    /**
     * Tests adding to many songs.
     */
    @Test
    public final void testAddSongMany() {
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B);
        Playlist pRef = this.createFromArgsRef(SONG_A, SONG_B, SONG_C);

        pTest.addSong(SONG_C);

        assertEquals(pRef, pTest);
    }

    /**
     * Tests adding a duplicate song.
     */
    @Test
    public final void testAddSongDuplicate() {
        Playlist pTest = this.createFromArgsTest(SONG_A);
        Playlist pRef = this.createFromArgsRef(SONG_A, SONG_A);
        Song duplicate = new Song("Outside", "Staind");

        pTest.addSong(duplicate);

        assertEquals(pRef, pTest);
    }

    /**
     * Tests removing the only song.
     */
    @Test
    public final void testRemoveNextSongOne() {
        Playlist pTest = this.createFromArgsTest(SONG_A);
        Playlist pRef = this.createFromArgsRef();

        Song result = pTest.removeNextSong();

        assertEquals(SONG_A, result);
        assertEquals(pRef, pTest);
    }

    /**
     * Tests removing from two songs.
     */
    @Test
    public final void testRemoveNextSongTwo() {
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B);
        Playlist pRef = this.createFromArgsRef(SONG_B);

        Song result = pTest.removeNextSong();

        assertEquals(SONG_A, result);
        assertEquals(pRef, pTest);
    }

    /**
     * Tests removing from many songs.
     */
    @Test
    public final void testRemoveNextSongMany() {
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B, SONG_C);
        Playlist pRef = this.createFromArgsRef(SONG_B, SONG_C);

        Song result = pTest.removeNextSong();

        assertEquals(SONG_A, result);
        assertEquals(pRef, pTest);
    }

    /**
     * Tests size with zero songs.
     */
    @Test
    public final void testSizeZero() {
        Playlist pTest = this.createFromArgsTest();
        Playlist pRef = this.createFromArgsRef();

        int result = pTest.size();

        assertEquals(0, result);
        assertEquals(pRef, pTest);
    }

    /**
     * Tests size with one song.
     */
    @Test
    public final void testSizeOne() {
        Playlist pTest = this.createFromArgsTest(SONG_A);
        Playlist pRef = this.createFromArgsRef(SONG_A);

        int result = pTest.size();

        assertEquals(1, result);
        assertEquals(pRef, pTest);
    }

    /**
     * Tests size with many songs.
     */
    @Test
    public final void testSizeMany() {
        final int expectedSize = 3;
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B, SONG_C);
        Playlist pRef = this.createFromArgsRef(SONG_A, SONG_B, SONG_C);

        int result = pTest.size();

        assertEquals(expectedSize, result);
        assertEquals(pRef, pTest);
    }

    /**
     * Tests clearing zero songs.
     */
    @Test
    public final void testClearZero() {
        Playlist pTest = this.createFromArgsTest();
        Playlist pRef = this.createFromArgsRef();

        pTest.clear();

        assertEquals(pRef, pTest);
    }

    /**
     * Tests clearing one song.
     */
    @Test
    public final void testClearOne() {
        Playlist pTest = this.createFromArgsTest(SONG_A);
        Playlist pRef = this.createFromArgsRef();

        pTest.clear();

        assertEquals(pRef, pTest);
    }

    /**
     * Tests clearing many songs.
     */
    @Test
    public final void testClearMany() {
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B, SONG_C);
        Playlist pRef = this.createFromArgsRef();

        pTest.clear();

        assertEquals(pRef, pTest);
    }

    /**
     * Tests newInstance from zero songs.
     */
    @Test
    public final void testNewInstanceZero() {
        Playlist pTest = this.createFromArgsTest();
        Playlist pRef = this.createFromArgsRef();
        Playlist expected = this.constructorRef();

        Playlist result = pTest.newInstance();

        assertNotSame(pTest, result);
        assertEquals(pTest.getClass(), result.getClass());
        assertEquals(expected, result);
        assertEquals(pRef, pTest);
    }

    /**
     * Tests newInstance from one song.
     */
    @Test
    public final void testNewInstanceOne() {
        Playlist pTest = this.createFromArgsTest(SONG_A);
        Playlist pRef = this.createFromArgsRef(SONG_A);
        Playlist expected = this.constructorRef();

        Playlist result = pTest.newInstance();

        assertNotSame(pTest, result);
        assertEquals(pTest.getClass(), result.getClass());
        assertEquals(expected, result);
        assertEquals(pRef, pTest);
    }

    /**
     * Tests newInstance from many songs.
     */
    @Test
    public final void testNewInstanceMany() {
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B, SONG_C);
        Playlist pRef = this.createFromArgsRef(SONG_A, SONG_B, SONG_C);
        Playlist expected = this.constructorRef();

        Playlist result = pTest.newInstance();

        assertNotSame(pTest, result);
        assertEquals(pTest.getClass(), result.getClass());
        assertEquals(expected, result);
        assertEquals(pRef, pTest);
    }

    /**
     * Tests transferring between empty playlists.
     */
    @Test
    public final void testTransferZeroToZero() {
        Playlist source = this.createFromArgsTest();
        Playlist destination = this.createFromArgsTest();
        Playlist sourceRef = this.createFromArgsRef();
        Playlist destinationRef = this.createFromArgsRef();

        destination.transferFrom(source);

        assertEquals(sourceRef, source);
        assertEquals(destinationRef, destination);
    }

    /**
     * Tests an empty source replacing many destination songs.
     */
    @Test
    public final void testTransferZeroToMany() {
        Playlist source = this.createFromArgsTest();
        Playlist destination = this.createFromArgsTest(SONG_B, SONG_C);
        Playlist sourceRef = this.createFromArgsRef();
        Playlist destinationRef = this.createFromArgsRef();

        destination.transferFrom(source);

        assertEquals(sourceRef, source);
        assertEquals(destinationRef, destination);
    }

    /**
     * Tests one source song replacing one destination song.
     */
    @Test
    public final void testTransferOneToOne() {
        Playlist source = this.createFromArgsTest(SONG_A);
        Playlist destination = this.createFromArgsTest(SONG_C);
        Playlist sourceRef = this.createFromArgsRef();
        Playlist destinationRef = this.createFromArgsRef(SONG_A);

        destination.transferFrom(source);

        assertEquals(sourceRef, source);
        assertEquals(destinationRef, destination);
    }

    /**
     * Tests many source songs replacing many destination songs.
     */
    @Test
    public final void testTransferManyToMany() {
        Playlist source = this.createFromArgsTest(SONG_A, SONG_B);
        Playlist destination = this.createFromArgsTest(SONG_C, SONG_C);
        Playlist sourceRef = this.createFromArgsRef();
        Playlist destinationRef = this.createFromArgsRef(SONG_A, SONG_B);

        destination.transferFrom(source);

        assertEquals(sourceRef, source);
        assertEquals(destinationRef, destination);
    }

    /**
     * Tests isEmpty with zero songs.
     */
    @Test
    public final void testIsEmptyZero() {
        Playlist pTest = this.createFromArgsTest();
        Playlist pRef = this.createFromArgsRef();

        boolean result = pTest.isEmpty();

        assertTrue(result);
        assertEquals(pRef, pTest);
    }

    /**
     * Tests isEmpty with one song.
     */
    @Test
    public final void testIsEmptyOne() {
        Playlist pTest = this.createFromArgsTest(SONG_A);
        Playlist pRef = this.createFromArgsRef(SONG_A);

        boolean result = pTest.isEmpty();

        assertFalse(result);
        assertEquals(pRef, pTest);
    }

    /**
     * Tests isEmpty with many songs.
     */
    @Test
    public final void testIsEmptyMany() {
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B);
        Playlist pRef = this.createFromArgsRef(SONG_A, SONG_B);

        boolean result = pTest.isEmpty();

        assertFalse(result);
        assertEquals(pRef, pTest);
    }

    /**
     * Tests skipping zero songs.
     */
    @Test
    public final void testSkipSongsZero() {
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B);
        Playlist pRef = this.createFromArgsRef(SONG_A, SONG_B);

        pTest.skipSongs(0);

        assertEquals(pRef, pTest);
    }

    /**
     * Tests skipping the only song.
     */
    @Test
    public final void testSkipSongsOne() {
        Playlist pTest = this.createFromArgsTest(SONG_A);
        Playlist pRef = this.createFromArgsRef();

        pTest.skipSongs(1);

        assertEquals(pRef, pTest);
    }

    /**
     * Tests skipping several songs while leaving one.
     */
    @Test
    public final void testSkipSongsMany() {
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B, SONG_C);
        Playlist pRef = this.createFromArgsRef(SONG_C);

        pTest.skipSongs(2);

        assertEquals(pRef, pTest);
    }

    /**
     * Tests skipping all songs.
     */
    @Test
    public final void testSkipSongsAll() {
        final int count = 3;
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B, SONG_C);
        Playlist pRef = this.createFromArgsRef();

        pTest.skipSongs(count);

        assertEquals(pRef, pTest);
    }

    /**
     * Tests moving the only song.
     */
    @Test
    public final void testMoveNextToEndOne() {
        Playlist pTest = this.createFromArgsTest(SONG_A);
        Playlist pRef = this.createFromArgsRef(SONG_A);

        pTest.moveNextToEnd();

        assertEquals(pRef, pTest);
    }

    /**
     * Tests moving the first of two songs.
     */
    @Test
    public final void testMoveNextToEndTwo() {
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B);
        Playlist pRef = this.createFromArgsRef(SONG_B, SONG_A);

        pTest.moveNextToEnd();

        assertEquals(pRef, pTest);
    }

    /**
     * Tests moving the first of many songs.
     */
    @Test
    public final void testMoveNextToEndMany() {
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B, SONG_C);
        Playlist pRef = this.createFromArgsRef(SONG_B, SONG_C, SONG_A);

        pTest.moveNextToEnd();

        assertEquals(pRef, pTest);
    }

    /**
     * Tests equality with the same object.
     */
    @Test
    public final void testEqualsSelf() {
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B);

        boolean result = pTest.equals(pTest);

        assertTrue(result);
        assertEquals(2, pTest.size());
        assertEquals(SONG_A, pTest.removeNextSong());
        assertEquals(SONG_B, pTest.removeNextSong());
        assertEquals(0, pTest.size());
    }

    /**
     * Tests equality with null.
     */
    @Test
    public final void testEqualsNull() {
        Playlist pTest = this.createFromArgsTest(SONG_A);

        boolean result = pTest.equals(null);

        assertFalse(result);
        assertEquals(1, pTest.size());
        assertEquals(SONG_A, pTest.removeNextSong());
        assertEquals(0, pTest.size());
    }

    /**
     * Tests equal contents stored in separate Song objects.
     */
    @Test
    public final void testEqualsMany() {
        final int expectedSize = 3;
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B, SONG_C);
        Playlist pRef = this.createFromArgsRef(new Song("Outside", "Staind"),
                new Song("Fine Again", "Seether"),
                new Song("Black", "Pearl Jam"));

        boolean result = pTest.equals(pRef);

        assertTrue(result);
        assertEquals(expectedSize, pTest.size());
        assertEquals(SONG_A, pTest.removeNextSong());
        assertEquals(SONG_B, pTest.removeNextSong());
        assertEquals(SONG_C, pTest.removeNextSong());
        assertEquals(0, pTest.size());

        assertEquals(expectedSize, pRef.size());
        assertEquals(SONG_A, pRef.removeNextSong());
        assertEquals(SONG_B, pRef.removeNextSong());
        assertEquals(SONG_C, pRef.removeNextSong());
        assertEquals(0, pRef.size());
    }

    /**
     * Tests unequal order and restoration after a mismatch.
     */
    @Test
    public final void testEqualsDifferentOrder() {
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B);
        Playlist pRef = this.createFromArgsRef(SONG_B, SONG_A);

        boolean result = pTest.equals(pRef);

        assertFalse(result);
        assertEquals(2, pTest.size());
        assertEquals(SONG_A, pTest.removeNextSong());
        assertEquals(SONG_B, pTest.removeNextSong());
        assertEquals(0, pTest.size());

        assertEquals(2, pRef.size());
        assertEquals(SONG_B, pRef.removeNextSong());
        assertEquals(SONG_A, pRef.removeNextSong());
        assertEquals(0, pRef.size());
    }

    /**
     * Tests equal hash codes for empty playlists.
     */
    @Test
    public final void testHashCodeZero() {
        Playlist pTest = this.createFromArgsTest();
        Playlist pRef = this.createFromArgsRef();
        int expected = pRef.hashCode();

        int result = pTest.hashCode();

        assertEquals(expected, result);
        assertEquals(0, pTest.size());
        assertEquals(0, pRef.size());
    }

    /**
     * Tests equal hash codes for equal one-song playlists.
     */
    @Test
    public final void testHashCodeOne() {
        Playlist pTest = this.createFromArgsTest(SONG_A);
        Playlist pRef = this.createFromArgsRef(new Song("Outside", "Staind"));
        int expected = pRef.hashCode();

        int result = pTest.hashCode();

        assertEquals(expected, result);
        assertEquals(1, pTest.size());
        assertEquals(SONG_A, pTest.removeNextSong());
        assertEquals(0, pTest.size());

        assertEquals(1, pRef.size());
        assertEquals(SONG_A, pRef.removeNextSong());
        assertEquals(0, pRef.size());
    }

    /**
     * Tests equal hash codes for equal playlists with many songs.
     */
    @Test
    public final void testHashCodeMany() {
        final int expectedSize = 3;
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B, SONG_C);
        Playlist pRef = this.createFromArgsRef(new Song("Outside", "Staind"),
                new Song("Fine Again", "Seether"),
                new Song("Black", "Pearl Jam"));
        int expected = pRef.hashCode();

        int result = pTest.hashCode();

        assertEquals(expected, result);
        assertEquals(expectedSize, pTest.size());
        assertEquals(SONG_A, pTest.removeNextSong());
        assertEquals(SONG_B, pTest.removeNextSong());
        assertEquals(SONG_C, pTest.removeNextSong());
        assertEquals(0, pTest.size());

        assertEquals(expectedSize, pRef.size());
        assertEquals(SONG_A, pRef.removeNextSong());
        assertEquals(SONG_B, pRef.removeNextSong());
        assertEquals(SONG_C, pRef.removeNextSong());
        assertEquals(0, pRef.size());
    }

    /**
     * Tests repeated hash calls without changing the playlist.
     */
    @Test
    public final void testHashCodeRepeated() {
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B);

        int first = pTest.hashCode();
        int second = pTest.hashCode();

        assertEquals(first, second);
        assertEquals(2, pTest.size());
        assertEquals(SONG_A, pTest.removeNextSong());
        assertEquals(SONG_B, pTest.removeNextSong());
        assertEquals(0, pTest.size());
    }

    /**
     * Tests the text of zero songs.
     */
    @Test
    public final void testToStringZero() {
        Playlist pTest = this.createFromArgsTest();
        String expected = "<>";

        String result = pTest.toString();

        assertEquals(expected, result);
        assertEquals(0, pTest.size());
    }

    /**
     * Tests the text of one song.
     */
    @Test
    public final void testToStringOne() {
        Playlist pTest = this.createFromArgsTest(SONG_A);
        String expected = "<Song[title=Outside, artist=Staind]>";

        String result = pTest.toString();

        assertEquals(expected, result);
        assertEquals(1, pTest.size());
        assertEquals(SONG_A, pTest.removeNextSong());
        assertEquals(0, pTest.size());
    }

    /**
     * Tests the text of many songs.
     */
    @Test
    public final void testToStringMany() {
        final int expectedSize = 3;
        Playlist pTest = this.createFromArgsTest(SONG_A, SONG_B, SONG_C);
        String expected = "<Song[title=Outside, artist=Staind], "
                + "Song[title=Fine Again, artist=Seether], "
                + "Song[title=Black, artist=Pearl Jam]>";

        String result = pTest.toString();

        assertEquals(expected, result);
        assertEquals(expectedSize, pTest.size());
        assertEquals(SONG_A, pTest.removeNextSong());
        assertEquals(SONG_B, pTest.removeNextSong());
        assertEquals(SONG_C, pTest.removeNextSong());
        assertEquals(0, pTest.size());
    }
}
