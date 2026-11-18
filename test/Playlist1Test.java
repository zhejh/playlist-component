
/**
 * Runs the Playlist tests using Playlist1.
 *
 * @author Zaid Hayat
 */
public class Playlist1Test extends PlaylistTest {

    @Override
    protected final Playlist constructorTest() {
        return new Playlist1();
    }

    @Override
    protected final Playlist constructorRef() {
        return new Playlist1();
    }
}
