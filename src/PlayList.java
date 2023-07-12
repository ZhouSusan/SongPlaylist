import java.util.ArrayList;

public class PlayList {

    private ArrayList<Song> songList;
    private int playListSize;

    public PlayList () {
        this.songList = new ArrayList<Song>();
    }

    public int getPlayListSize() {
        return this.songList.size();
    }

    public void addSong(Song song) {
        for (Song s : songList) {
            if (s.getTitle().equals(song.getTitle())) {
                System.out.printf("This song, %s is already in your playlist", s.getTitle());
                return;
            }
        }
        this.songList.add(song);
    }

    public Song findSong(String title) {
        for (Song s : songList) {
            if (s.getTitle().equals(title)) {
                System.out.println(s.toString());
                return s;
            }
        }

        return null;
    }
}
