import java.util.ArrayList;

public class PlayList {

    private ArrayList<Song> songList;
    private int trackNumber;

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

    public void displaySongAtIndex (int index) {
        if (songList.size() == 0 || index < 0 || index > songList.size()-1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.out.println(songList.get(index).toString());
    }

    public void removeSong(int index) {
        if (songList.size() == 0 || index < 0 || index > songList.size()-1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.songList.remove(index);
    }

    public void showPlayList() {
        for (Song s : songList) {
            System.out.println(s + "\n");
        }
    }
}
