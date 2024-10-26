import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;


public class TestLoop implements Runnable {

    public void checkAndSort(Player player) {
        printTiles(player);
        player.sortHand();
        printTiles(player);
    }

    private void printTiles(Player player) {
        System.out.println(player.getPlayerName() + "'s hand:");
        System.out.println(TerminalDisplay.getHandAsString(player.getHand()));
        System.out.println("Played tiles: " + player.getPlayed());
        System.out.println("Discarded tiles: " + player.getDiscard());
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void drawSequence(Player player, TileSet tileSet) {
        Scanner scanner = new Scanner(System.in);
        player.drawTile(tileSet);
        System.out.println(TerminalDisplay.getHandAsString(player.getHand()));

        System.out.println("What tile would you like to discard?");
        int choice = scanner.nextInt() - 1;

        player.setSelectedTile(choice);
        player.discardTile(player.getSelectedTile());
        checkAndSort(player);

        scanner.close();
    }

    public void run() {
        TileSet tileSet = new TileSet();

        ArrayList<Player> allPlayers = new ArrayList<>();

        allPlayers.add(new Player("Victor"));
        allPlayers.add(new Player("Lauren"));
        allPlayers.add(new Player("Oliver"));
        allPlayers.add(new Player("Mary"));


        for (Player player : allPlayers) {
            player.initializeHand(tileSet);
            checkAndSort(player);
            if (player.hasFlower()){
                player.playFlowers(tileSet);
                checkAndSort(player);
            }
        }

    }
}
