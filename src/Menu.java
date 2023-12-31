import java.util.Scanner;

public class Menu {
    public static void printMenu(Scanner scan, PlayList playList) {
        int userChoice;
        try {
            do {
                System.out.printf("Welcome to your music playlist. What would you like to do?\n");
                System.out.println("    1- Play Song");
                System.out.println("    2- Play Next Song");
                System.out.println("    3- Play Previous Song");
                System.out.println("    4- Add new song");
                System.out.println("    5- Update Song");
                System.out.println("    6- Remove Song");
                System.out.println("    7- Find a Song");
                System.out.println("    8- View PlayList");
                System.out.println("    9- Randomize PlayList");
                System.out.println("    10- Sort PlayList by Title");
                System.out.println("    11- Reset Playlist");
                System.out.println("    0- Quit");
                System.out.println();
                System.out.print("Enter choice: ");
                userChoice = scan.nextInt();

                if (userChoice < 0 || userChoice > 11) {
                    System.out.println("Invalid choice. Please choose a number between 0 - 12");
                }
            } while (userChoice < 0 || userChoice > 11);

            switch (userChoice) {
                case 1:
                    playList.play();
                    break;
                case 2:
                    playList.playNextSong();
                    break;
                case 3:
                    playList.playPreviousSong();
                    break;
                case 4:
                    Song newSong = new Song();
                    System.out.print("Enter Title: ");
                    scan.nextLine();
                    newSong.setTitle(scan.nextLine());

                    System.out.print("Enter Artist: ");
                    newSong.setArtist(scan.nextLine());

                    System.out.print("Enter Duration in this format (0:00): ");
                    newSong.setDuration(scan.nextLine());

                    System.out.print("Enter Album's Name: ");
                    newSong.setAlbum(scan.nextLine());

                    playList.addSong(newSong);
                    System.out.println();
                    System.out.println(newSong.toString());
                    System.out.println();
                    break;
                case 5:
                    if (playList.isSongListEmpty()) {
                        break;
                    } else {
                        System.out.println("Which song selection would you like to update?");
                        int songSelection = scan.nextInt();

                        System.out.print("Enter Title: ");
                        scan.nextLine();
                        String updatedTitle = scan.nextLine();

                        System.out.print("Enter Artist: ");
                        String updatedArtist = scan.nextLine();

                        System.out.print("Enter Duration in this format (0:00): ");
                        String updatedDuration = scan.nextLine();

                        System.out.print("Enter Album's Name: ");
                        String updatedAlbum = scan.nextLine();

                        playList.updateSong(songSelection, updatedTitle, updatedArtist, updatedDuration, updatedAlbum);
                        System.out.println();
                        playList.displaySongAtIndex(songSelection);
                        System.out.println();
                    }
                    break;
                case 6:
                    if (playList.isSongListEmpty()) {
                        break;
                    }
                    playList.showPlayList();
                    System.out.println("Which song would you like to remove? Track Number: ");
                    int removeSong = scan.nextInt();
                    playList.removeSong(removeSong);
                    break;
                case 7:
                    System.out.println("Please enter the song's title you would like to find? ");
                    scan.nextLine();
                    String findThisSong = scan.nextLine();
                    playList.findSong(findThisSong);
                    break;
                case 8:
                    playList.showPlayList();
                    break;
                case 9:
                    playList.shufflePlayList();
                    playList.showPlayList();
                    System.out.println();
                    break;
                case 10:
                    playList.sortByTitleASC();
                    playList.showPlayList();
                    System.out.println();
                    break;
                case 11:
                    playList.resetPlaylist();
                    break;
            }

            if (userChoice != 0) {
                Menu.printMenu(scan, playList);
            }
        } catch (Exception e) {
            System.out.println("Invalid choice selection! ");
        }
    }
}
