import components.standard.Standard;

/**
 * Playlist kernel component with primary methods.
 *
 * <p>
 * Each song is represented by a pair containing its title and artist. Both
 * fields are not null strings; empty strings are permitted. No special syntax
 * is required in either field. Songs are ordered with the next song first.
 * Duplicates are permitted. Titles and artists are compared exactly, including
 * capitalization.
 * </p>
 *
 * @mathmodel <pre>
 * type PlaylistKernel is modeled by string of
 *     (title: string of character, artist: string of character)
 * </pre>
 * @initially <pre>
 * this = <>
 * </pre>
 *
 * @author Zaid Hayat
 */
public interface PlaylistKernel extends Standard<Playlist> {

    /**
     * Adds song to the end of this playlist.
     *
     * @param song
     *            the song title to add
     * @updates this
     * @requires <pre>
     * song /= null and
     * song.title() /= null and
     * song.artist() /= null
     * </pre>
     * @ensures this = #this * <(song.title(), song.artist())>
     */
    void addSong(Song song);

    /**
     * Removes and returns the first song in this playlist.
     *
     * @return the first song
     * @updates this
     * @requires this /= <>
     * @ensures <pre>
     * removeNextSong /= null and
     * #this = <(removeNextSong.title(), removeNextSong.artist())> * this
     * </pre>
     */
    Song removeNextSong();

    /**
     * Reports the number of songs in this playlist.
     *
     * @return the number of songs
     * @ensures size = |this|
     */
    int size();
}
