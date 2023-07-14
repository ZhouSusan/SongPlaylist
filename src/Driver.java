import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PlayList SusanPlayList = new PlayList();
        Menu.printMenu(scan, SusanPlayList);

        scan.close();
    }
}
