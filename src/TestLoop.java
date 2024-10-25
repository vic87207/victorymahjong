import java.util.Scanner;

import static java.lang.Thread.sleep;


public class TestLoop implements Runnable {

    public void run() {
        TileSet tileSet = new TileSet();
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);

        player.initializeHand(tileSet);
        System.out.println(TerminalDisplay.getHandAsString(player.getHand()));
        try {
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        player.sortHand();
        System.out.println(TerminalDisplay.getHandAsString(player.getHand()));

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        player.playFlowers();
        System.out.println(TerminalDisplay.getHandAsString(player.getHand()));
        System.out.println(player.getPlayed());

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        player.drawTile(tileSet);
        System.out.println(TerminalDisplay.getHandAsString(player.getHand()));


        System.out.println("What tile would you like to discard?");
        int choice = scanner.nextInt() - 1;

        player.setSelectedTile(choice);
        player.discardTile(player.getSelectedTile());
        System.out.println(TerminalDisplay.getHandAsString(player.getHand()));
        System.out.println(player.getDiscard());

        scanner.close();
    }
}
