import java.util.ArrayList;

public class PlayList {

    private ArrayList<Song> songList;
    private int trackNumber;
    private int playListSize;

    public PlayList () {
        this.songList = new ArrayList<Song>();
        this.trackNumber = 0;
    }

    public int getPlayListSize() {
        return this.songList.size();
    }

    public void addSong(Song song) {
        for (Song s : songList) {
            if (s.getTitle().equals(song.getTitle()) && s.getArtist().equals(song.getArtist())) {
                System.out.printf("This song, %s is already in your playlist\n", s.getTitle());
                return;
            }
        }
        this.songList.add(song);
        this.trackNumber++;
    }

    public Song findSong(String title) {
        for (Song s : songList) {
            if (s.getTitle().equals(title)) {
                System.out.println("Track Number: " + (this.trackNumber-1) + " ," + s.toString());
                return s;
            }
        }

        return null;
    }

}
