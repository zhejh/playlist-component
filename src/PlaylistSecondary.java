/**
 * Secondary operations for Playlist.
 *
 * @author Zaid Hayat
 */
public abstract class PlaylistSecondary implements Playlist {

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

        String song = this.removeNextSong();
        this.addSong(song);
    }

    @Override
    public final boolean equals(Object obj) {
        boolean equal = obj == this;

        if (!equal && obj instanceof Playlist other) {
            int length = this.size();
            equal = length == other.size();

            if (equal) {
                for (int i = 0; i < length; i++) {
                    String song = this.removeNextSong();
                    String otherSong = other.removeNextSong();

                    if (!song.equals(otherSong)) {
                        equal = false;
                    }

                    this.addSong(song);
                    other.addSong(otherSong);
                }
            }
        }

        return equal;
    }

    @Override
    public final int hashCode() {
        final int multiplier = 31;
        int result = 1;
        int length = this.size();

        for (int i = 0; i < length; i++) {
            String song = this.removeNextSong();
            result = multiplier * result + song.hashCode();
            this.addSong(song);
        }

        return result;
    }

    @Override
    public final String toString() {
        StringBuilder result = new StringBuilder("<");
        int length = this.size();

        for (int i = 0; i < length; i++) {
            String song = this.removeNextSong();

            if (i > 0) {
                result.append(", ");
            }
            result.append(song);

            this.addSong(song);
        }

        result.append(">");
        return result.toString();
    }
}
