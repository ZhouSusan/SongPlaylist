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
}
