import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Demo of managing song requests with a playlist.
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

        requests.addSong(new Song("Wet Sand", "Red Hot Chili Peppers"));
        requests.addSong(new Song("Fine Again", "Seether"));
        requests.addSong(new Song("Slow Cheetah", "Red Hot Chili Peppers"));

        out.println("Requested songs: " + requests);

        requests.moveNextToEnd();
        out.println("After postponing the first request: " + requests);

        Song nextSong = requests.removeNextSong();
        out.println("Selected to play: " + nextSong.title() + " - "
                + nextSong.artist());

        requests.addSong(new Song("Black", "Pearl Jam"));
        out.println("After a new request: " + requests);
        out.println("Songs remaining: " + requests.size());

        out.close();
    }
}
