import components.standard.Standard;

/**
 * Playlist kernel component with primary methods.
 *
 * @mathmodel type PlaylistKernel is modeled by string of string
 * @initially <pre>
 * this = <>
 * </pre>
 * @author Zaid Hayat
 */
public interface PlaylistKernel extends Standard<Playlist> {

    /**
     * Adds song to the end of this playlist.
     *
     * @param song
     *            the song title to add
     * @updates this
     * @ensures this = #this * <song>
     */
    void addSong(String song);

    /**
     * Removes and returns the first song in this playlist.
     *
     * @return the first song
     * @updates this
     * @requires this /= <>
     * @ensures #this = <removeNextSong> * this
     */
    String removeNextSong();

    /**
     * Reports the number of songs in this playlist.
     *
     * @return the number of songs
     * @ensures size = |this|
     */
    int size();
}
