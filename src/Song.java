import java.util.*;

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

    public Song() {
        _id = UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public String getId() {
        return this._id;
    }

    public void setTitle(String title) {
        this._title = title;
    }

    public String getTitle() {
        return this._title;
    }

    public void setArtist(String artist) {
        this._artist = artist;
    }
    public String getArtist() {
        return this._artist;
    }

    public void setDuration(String duration) {
        if (!durationValidator(duration)) {
            throw new IllegalArgumentException("Invalid time duration of song");
        }
        this._duration = duration;
    }

    public String getDuration() {
        return this._duration;
    }

    public void setAlbum(String album) {
        this._album = album;
    }

    public String getAlbum() {
        return this._album;

    }

    public boolean durationValidator(String inputStr) {
        if (inputStr == null || inputStr.isEmpty()) {
            return false;
        }
        String regex = "^(?:[0-9]+(?:[:][0-9]+)?|[:][0-9]+)$";
        return inputStr.matches(regex) ? true : false;
    }

    public String toString() {
        return "Song Details { ID: " + getId() +
                "\nTitle: " + getTitle()+ ",\nArtist: " + getArtist() +
                ",\nAlbum: " + getAlbum() + ",\nDuration of Song: " +getDuration() + "}";
    }
}
