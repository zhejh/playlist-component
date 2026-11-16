/**
 * Secondary operations for Playlist.
 *
 * @author Zaid Hayat
 */
public abstract class PlaylistSecondary implements Playlist {

    /**
     * Used 31 because it is a very common prime multiplier, to combine song
     * hashes. Multiplying x by 31 is equivalent to (x << 5) - x. Multiplying
     * before adding each hash makes song order matter.
     */
    private static final int HASH_MULTIPLIER = 31;

    @Override
    public final boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public final void skipSongs(int count) {
        assert count >= 0 : "Violation of: count >= 0";
        assert count <= this.size() : "Violation of: count <= |this|";

        for (int i = 0; i < count; i++) {
            this.removeNextSong();
        }
    }

    @Override
    public final void moveNextToEnd() {
        assert this.size() > 0 : "Violation of: this /= <>";

        Song song = this.removeNextSong();
        this.addSong(song);
    }

    @Override
    public final boolean equals(Object obj) {
        // An object is equal to itself.
        if (obj == this) {
            return true;
        }

        // A playlist cannot equal null.
        if (obj == null) {
            return false;
        }

        // The other object must be a playlist.
        if (!(obj instanceof Playlist)) {
            return false;
        }

        // Treat obj as a playlist so we can use its methods.
        Playlist otherPlaylist = (Playlist) obj;

        // Equal playlists must have the same number of songs.
        if (this.size() != otherPlaylist.size()) {
            return false;
        }

        // Assume the songs match until we find a difference.
        boolean equal = true;
        int length = this.size();

        // Finish the loop to restore both playlists' original order.
        for (int i = 0; i < length; i++) {
            Song song = this.removeNextSong();
            Song otherSong = otherPlaylist.removeNextSong();

            if (!song.equals(otherSong)) {
                equal = false;
            }

            this.addSong(song);
            otherPlaylist.addSong(otherSong);
        }

        return equal;
    }

    @Override
    public final int hashCode() {
        int result = 1;
        int length = this.size();

        for (int i = 0; i < length; i++) {
            Song song = this.removeNextSong();
            result = HASH_MULTIPLIER * result + song.hashCode();
            this.addSong(song);
        }

        return result;
    }

    @Override
    public final String toString() {
        String result = "<";
        int length = this.size();

        for (int i = 0; i < length; i++) {
            Song song = this.removeNextSong();

            if (i > 0) {
                result = result + ", ";
            }
            result = result + song;

            this.addSong(song);
        }

        result = result + ">";
        return result;
    }

}
