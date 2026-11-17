
/**
 * An immutable song described by title and artist. Title and artist must not be
 * null empty strings are ok. No special syntax or separator is required in
 * either field. Two songs are equal when their titles and artists match
 * exactly.
 *
 * @param title
 *            the song title
 * @param artist
 *            the artist name
 * @author Zaid Hayat
 */
public record Song(String title, String artist) {

    /**
     * Creates a song.
     *
     * @param title
     *            the song title
     * @param artist
     *            the artist name
     * @requires title /= null and artist /= null
     * @ensures this.title() = title and this.artist() = artist
     */
    public Song {
        assert title != null : "Violation of: title is not null";
        assert artist != null : "Violation of: artist is not null";
    }

}
