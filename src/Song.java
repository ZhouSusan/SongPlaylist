import java.util.UUID;

public class Song {
    private String _id;
    private String _title;
    private String _artist;
    private String _duration;
    private String _album;


    public Song(String title, String artist, String duration, String album) {
        this._title = title;
        this._artist = artist;
        this._duration = duration;
        this._album = album;

        _id = UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

}
