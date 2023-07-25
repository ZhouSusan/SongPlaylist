import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PlayList {

    public ArrayList<Song> getSongList() {
        return songList;
    }

    private ArrayList<Song> songList;
    private int trackNumber;

    int counter = 0;

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
                System.out.println(s.toString());
                return s;
            }
        }
        System.out.println("Song is not found in your playlist.");

        return null;
    }

    public void displaySongAtIndex (int index) {
        if (isSongListEmpty()) {
            return;
        }
        if (index < 0 || index > songList.size()-1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.out.println("Track Number: " + (index) + "\n" + songList.get(index).toString());
    }

    public void removeSong(int index) {

        if (index < 0 || index > songList.size()-1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.songList.remove(index);
    }

    public void showPlayList() {
        if (isSongListEmpty()) {
            return;
        }

        for (int i = 0; i < songList.size(); i++) {
            System.out.println("Track Number: " + i + " - "+ songList.get(i) + "\n");
        }
    }

    public void updateSong(int index, String title, String artist, String duration, String album) {

        if (index < 0 || index > songList.size()-1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        songList.get(index).setTitle(title);
        songList.get(index).setArtist(artist);
        songList.get(index).setDuration(duration);
        songList.get(index).setAlbum(album);
    }

    public void shufflePlayList() {
        if (isSongListEmpty()) {
            return;
        }

        int size = songList.size();
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            int changedValue = i + r.nextInt(size-i);
            swap(songList, i, changedValue);
        }
    }

    private void swap(List<Song> playlist, int index, int changedValue) {
        Song temp = playlist.get(index);
        playlist.set(index, playlist.get(changedValue));
        playlist.set(changedValue, temp);
    }

    public void play() {
        if (isSongListEmpty()) {
            return;
        }
        displaySongAtIndex(this.counter);
    }

    public void playNextSong() {

        this.counter += 1;
        if (isSongListEmpty()) {
            return;
        }

        if (this.counter >= songList.size()) {
            this.counter = 0;
        }
        Song nextObject = songList.get(this.counter);
        System.out.println(nextObject.toString());
    }

    public void playPreviousSong() {

        this.counter = this.counter - 1;
        if (isSongListEmpty()) {
            return;
        }

        if ( this.counter < 0) {
            this.counter = songList.size()-1;
        }

        try {
            Song previousObject = songList.get(this.counter);
            System.out.println(previousObject.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sortByTitleASC() {
        Collections.sort(songList, Song.SongTitleComparator);
    }

    public void resetPlaylist() {
        this.songList.clear();
        System.out.println("Your playlist has been reset.");
    }

    public boolean isSongListEmpty() {
        if (getPlayListSize() == 0) {
            System.out.println("Your playList is currently empty.");
            return true;
        }
        return false;
    }
}
