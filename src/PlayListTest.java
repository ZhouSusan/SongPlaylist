import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayListTest {

    @Test
    void PlayListTest() {
        PlayList myPlaylist = new PlayList();

        assertNotNull(myPlaylist);
        assertTrue(myPlaylist.isSongListEmpty());
        assertTrue(myPlaylist.counter == 0);

        assertTrue(myPlaylist.getPlayListSize() == 0);

        Song firstSong = new Song ("One Last Time", "Ariana Grande", "3:17", "My Everything");
        myPlaylist.addSong(firstSong);

        assertTrue(myPlaylist.getPlayListSize() == 1);

        // Duplicate song does not add to the current playlist.
        Song duplicateSong = new Song ("One Last Time", "Ariana Grande", "3:17", "My Everything");
        myPlaylist.addSong(duplicateSong);
        assertTrue(myPlaylist.getPlayListSize() == 1);


        Song secondSong = new Song("When I'm Gone", "Eminem", "4:41", "Curtain Call");
        Song thirdSong = new Song("Live Your Life", "T.I., Rihanna", "5:38", "Paper Trail");
        myPlaylist.addSong(secondSong);
        myPlaylist.addSong(thirdSong);
        assertTrue(myPlaylist.getPlayListSize() == 3);

        // Updating a song
        Song fourthSong = new Song("updateTitle", "updateArtist", "0:00", "updateAlbum");
        myPlaylist.addSong(fourthSong);
        assertTrue(myPlaylist.getPlayListSize() == 4);

        myPlaylist.updateSong(3,"Raise Your Glass", "P!nk", "3:22", "Greatest Hits...So Far!!!");
        assertTrue(fourthSong.getId().length() == 32);
        assertEquals("Raise Your Glass", fourthSong.getTitle());
        assertEquals("P!nk", fourthSong.getArtist());
        assertEquals("3:22", fourthSong.getDuration());
        assertEquals("Greatest Hits...So Far!!!", fourthSong.getAlbum());
        assertTrue(myPlaylist.getPlayListSize() == 4);

        Song fifthSong = new Song("Who Says", "Selena Gomez", "3:30", "Stars Dance");
        myPlaylist.addSong(fifthSong);

        // Removing a song
        Song removeThisSong = new Song("removeTitle", "removeArtist", "0:00", "removeAlbum");
        myPlaylist.addSong(removeThisSong);
        assertTrue(myPlaylist.getPlayListSize() == 6);
        myPlaylist.removeSong(5);
        assertTrue(myPlaylist.getPlayListSize() == 5);
        assertNull(myPlaylist.findSong(removeThisSong.getTitle()));

        // Shuffling playlist
        myPlaylist.shufflePlayList();
        Assert.assertThat( new Song[] { firstSong,  secondSong, thirdSong, fourthSong, fifthSong}, IsNot.not(IsEqual.equalTo(myPlaylist.getSongList().toArray())));

        // Sorting a song
        myPlaylist.sortByTitleASC();
        Assert.assertArrayEquals( new Song[] { thirdSong, firstSong, fourthSong, secondSong, fifthSong}, myPlaylist.getSongList().toArray());

        Song findThiSong = myPlaylist.findSong("Who Says");
        Assert.assertEquals(findThiSong.getTitle(), "Who Says");

        // Play Song
        myPlaylist.play();
        assertTrue(myPlaylist.counter == 0);
        assertTrue(myPlaylist.getSongList().get(myPlaylist.counter).getTitle().equals("Live Your Life"));

        // Play next song
        myPlaylist.playNextSong();
        assertTrue(myPlaylist.counter == 1);
        assertTrue(myPlaylist.getSongList().get(myPlaylist.counter).getTitle().equals("One Last Time"));

        myPlaylist.playNextSong();
        assertTrue(myPlaylist.counter == 2);
        assertTrue(myPlaylist.getSongList().get(myPlaylist.counter).getTitle().equals("Raise Your Glass"));

        myPlaylist.playNextSong();
        assertTrue(myPlaylist.counter == 3);
        assertTrue(myPlaylist.getSongList().get(myPlaylist.counter).getTitle().equals("When I'm Gone"));

        myPlaylist.playNextSong();
        assertTrue(myPlaylist.counter == 4);
        assertTrue(myPlaylist.getSongList().get(myPlaylist.counter).getTitle().equals("Who Says"));

        myPlaylist.playNextSong();
        assertTrue(myPlaylist.counter == 0);
        assertTrue(myPlaylist.getSongList().get(myPlaylist.counter).getTitle().equals("Live Your Life"));

        // Play previous song
        myPlaylist.playPreviousSong();
        assertTrue(myPlaylist.counter == 4);
        assertTrue(myPlaylist.getSongList().get(myPlaylist.counter).getTitle().equals("Who Says"));

        myPlaylist.playPreviousSong();
        assertTrue(myPlaylist.counter == 3);
        assertTrue(myPlaylist.getSongList().get(myPlaylist.counter).getTitle().equals("When I'm Gone"));

        myPlaylist.playPreviousSong();
        assertTrue(myPlaylist.counter == 2);
        assertTrue(myPlaylist.getSongList().get(myPlaylist.counter).getTitle().equals("Raise Your Glass"));

        myPlaylist.playPreviousSong();
        assertTrue(myPlaylist.counter == 1);
        assertTrue(myPlaylist.getSongList().get(myPlaylist.counter).getTitle().equals("One Last Time"));

        myPlaylist.playPreviousSong();
        assertTrue(myPlaylist.counter == 0);
        assertTrue(myPlaylist.getSongList().get(myPlaylist.counter).getTitle().equals("Live Your Life"));

        myPlaylist.playPreviousSong();
        assertTrue(myPlaylist.counter == 4);
        assertTrue(myPlaylist.getSongList().get(myPlaylist.counter).getTitle().equals("Who Says"));

        // Resetting playlist
        myPlaylist.resetPlaylist();
        assertTrue(myPlaylist.isSongListEmpty());
        assertTrue(myPlaylist.getPlayListSize() == 0);
    }
}
