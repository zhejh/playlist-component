/**
 * Playlist component with secondary operations.
 *
 * @author Zaid Hayat
 */
public interface Playlist extends PlaylistKernel {

    /**
     * Reports whether this playlist is empty.
     *
     * @return true if this playlist is empty
     * @ensures isEmpty = (this = <>)
     */
    boolean isEmpty();

    /**
     * Removes the first count songs from this playlist.
     *
     * @param count
     *            the number of songs to skip
     * @updates this
     * @requires 0 <= count and count <= |this|
     * @ensures this = #this[count, |#this|)
     */
    void skipSongs(int count);

    /**
     * Moves the first song to the end of this playlist.
     *
     * @updates this
     * @requires this /= <>
     * @ensures this = #this[1, |#this|) * #this[0, 1)
     */
    void moveNextToEnd();
}
