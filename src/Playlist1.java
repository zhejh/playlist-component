import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Playlist represented by a queue of song titles.
 *
 * @author Zaid Hayat
 * @convention $this.songs /= null
 * @correspondence this = $this.songs
 */
public final class Playlist1 extends PlaylistSecondary {

    /**
     * Queue holding the songs in playlist order.
     */
    private Queue<String> songs;

    /**
     * Creates an empty representation.
     */
    private void createNewRep() {
        this.songs = new Queue1L<String>();
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
        return new Playlist1();
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
    public void addSong(String song) {
        assert song != null : "Violation of: song is not null";

        this.songs.enqueue(song);
    }

    @Override
    public String removeNextSong() {
        assert this.songs.length() > 0 : "Violation of: this /= <>";

        return this.songs.dequeue();
    }

    @Override
    public int size() {
        return this.songs.length();
    }
}
