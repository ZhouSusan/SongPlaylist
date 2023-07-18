import java.util.Scanner;

public class Menu {
    public static void printMenu(Scanner scan, PlayList playList) {
        int userChoice;
        try {
            do {
                System.out.printf("Welcome to your music list, what would you like to do?\n");
                System.out.println("    1- Play Song");
                System.out.println("    2- Next Song");
                System.out.println("    3- Previous Song");
                System.out.println("    4- Add song");
                System.out.println("    5- Update Song");
                System.out.println("    6- Remove Song");
                System.out.println("    7- Find Song");
                System.out.println("    8- View PlayList");
                System.out.println("    9- Randomize PlayList");
                System.out.println("    0- Quit");
                System.out.println();
                System.out.print("Enter choice: ");
                userChoice = scan.nextInt();

                if (userChoice < 0 || userChoice > 10) {
                    System.out.println("Invalid choice. Please choose a number between 0 - 10");
                }
            } while (userChoice < 0 || userChoice > 10);

            switch (userChoice) {
                case 1:
                    playList.displaySongAtIndex(0);
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

                    System.out.print("Enter Album: ");
                    newSong.setAlbum(scan.nextLine());

                    playList.addSong(newSong);
                    System.out.println(newSong.toString());
                    break;
                case 5:
                    System.out.println("Updating which song selection?");
                    int songSelection = scan.nextInt();

                    System.out.print("Enter Title: ");
                    scan.nextLine();
                    String updatedTitle = scan.nextLine();

                    System.out.print("Enter Artist: ");
                    String updatedArtist = scan.nextLine();

                    System.out.print("Enter Duration in this format (0:00): ");
                    String updatedDuration = scan.nextLine();

                    System.out.print("Enter Album: ");
                    String updatedAlbum = scan.nextLine();

                    playList.updateSong(songSelection, updatedTitle, updatedArtist, updatedDuration, updatedAlbum);
                    playList.displaySongAtIndex(songSelection);
                    break;
                case 6:
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
                    break;
                case 10:
                    scan.nextLine();
                    break;
            }

            if (userChoice != 0) {
                Menu.printMenu(scan, playList);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
