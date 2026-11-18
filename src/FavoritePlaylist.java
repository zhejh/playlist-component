import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Stores and displays favorite songs using a Playlist.
 *
 * @author Zaid Hayat
 */
public final class FavoritePlaylist {

    /**
     * Favorite songs.
     */
    private Playlist songs;

    /**
     * Creates a playlist of favorite songs.
     */
    public FavoritePlaylist() {
        this.songs = new Playlist1();
        this.songs.addSong(new Song("Outside", "Staind"));
        this.songs.addSong(
                new Song("I Hate Everything About You", "Three Days Grace"));
        this.songs
                .addSong(new Song("Californication", "Red Hot Chili Peppers"));
        this.songs.addSong(new Song("Fine Again", "Seether"));
    }

    /**
     * Displays the favorite songs without changing their order.
     */
    public void displayFavorites() {
        SimpleWriter out = new SimpleWriter1L();
        int count = this.songs.size();

        for (int i = 0; i < count; i++) {
            Song song = this.songs.removeNextSong();
            out.println(song.title() + " - " + song.artist());
            this.songs.addSong(song);
        }

        out.close();
    }

    /**
     * Displays a favorite playlist.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        FavoritePlaylist favorites = new FavoritePlaylist();
        favorites.displayFavorites();
    }
}
