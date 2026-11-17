import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Playlist represented by a queue of Song records. Each song contains a title
 * and an artist as separate strings. The front of the queue is the next song.
 * Duplicate songs are allowed. Titles and artists are not null; empty strings
 * are allowed.
 *
 * @author Zaid Hayat
 * @convention <pre>
 * $this.songs /= null and
 * every entry in $this.songs is a non-null Song
 * whose title and artist are non-null
 * </pre>
 * @correspondence <pre>
 * this = [the sequence of (title, artist) pairs represented by
 *         the entries in $this.songs, in front-to-back order]
 * </pre>
 */
public final class Playlist1 extends PlaylistSecondary {

    /**
     * Queue holding the songs in playlist order.
     */
    private Queue<Song> songs;

    /**
     * Creates an empty representation.
     *
     * @ensures $this.songs = <>
     */
    private void createNewRep() {
        this.songs = new Queue1L<Song>();
    }

    /**
     * Creates an empty playlist.
     *
     * @ensures this = <>
     */
    public Playlist1() {
        this.createNewRep();
    }

    @Override
    public Playlist newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public void transferFrom(Playlist source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof Playlist1 : "Violation of: source has type Playlist1";

        Playlist1 localSource = (Playlist1) source;
        this.songs = localSource.songs;
        localSource.createNewRep();
    }

    @Override
    public void addSong(Song song) {
        assert song != null : "Violation of: song is not null";
        assert song.title() != null : "Violation of: title is not null";
        assert song.artist() != null : "Violation of: artist is not null";

        this.songs.enqueue(song);
    }

    @Override
    public Song removeNextSong() {
        assert this.songs.length() > 0 : "Violation of: this /= <>";

        return this.songs.dequeue();
    }

    @Override
    public int size() {
        return this.songs.length();
    }
}
