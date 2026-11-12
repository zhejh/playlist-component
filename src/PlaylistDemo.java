import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * demo of adding songs to a playlist.
 *
 * @author Zaid Hayat
 */
public final class PlaylistDemo {

    /**
     * Prevents instantiation.
     */
    private PlaylistDemo() {
    }

    /**
     * Runs the playlist demo.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        Playlist requests = new Playlist1();

        requests.addSong("Wet sand");
        requests.addSong("Fine Again");
        requests.addSong("Slow Cheetah");

        out.println("Requested songs: " + requests);

        requests.moveNextToEnd();
        out.println("After postponing the first request: " + requests);

        String nextSong = requests.removeNextSong();
        out.println("Selected to play: " + nextSong);

        requests.addSong("Black");
        out.println("After a new request: " + requests);
        out.println("Songs remaining: " + requests.size());

        out.close();
    }
}
