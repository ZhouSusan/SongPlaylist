import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @org.junit.jupiter.api.Test
    void SongTest() {
        Song firstSong = new Song("Counting Stars", "One Republic", "4:17", "Native" );
        Song secondSong = new Song("Lonely", "Akon", "4:24m", "Trouble");

        int expectedUUIDLength = 32;

        assertNotNull(firstSong);
        assertEquals(expectedUUIDLength, secondSong.getId().length());
        assertFalse(firstSong.getId().contains("-"));
        assertTrue(firstSong.getTitle().equals("Counting Stars"));
        assertFalse(firstSong.getTitle().equals("Apologize"));
        assertTrue(firstSong.getArtist().equals("One Republic"));
        assertTrue(firstSong.getDuration().matches("^(?:[0-9]+(?:[:][0-9]+)?|[:][0-9]+)$"));
        assertTrue(firstSong.getAlbum().equals("Native"));

        assertEquals(expectedUUIDLength, secondSong.getId().length());
        assertFalse(secondSong.getId().contains("-"));
        assertTrue(secondSong.getTitle().equals("Lonely"));
        assertTrue(secondSong.getArtist().equals("Akon"));
        assertFalse(secondSong.getDuration().matches("^(?:[0-9]+(?:[:][0-9]+)?|[:][0-9]+)$"));
        assertTrue(secondSong.getAlbum().equals("Trouble"));

        assertTrue(Song.SongTitleComparator.compare(secondSong, firstSong) > 0);
    }
}