/*
Player has a hand of 16 tiles.
Player can draw and discard tile.
Flower tiles are played and redrawn.
Four tile sets are marked.

TODO:
pong functions, chi functions (maybe have a separate game engine class to handle these)
 */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player {
    private final ArrayList<Tile> hand;
    private final ArrayList<Tile> discard;
    private final ArrayList<Tile> played;
    private int selectedTile = 0;
    private final String playerName;

    public Player(String playerName) {
        hand = new ArrayList<>();
        discard = new ArrayList<>();
        played = new ArrayList<>();
        this.playerName = playerName;
    }

    public void initializeHand(TileSet tileset) {
        for (int i = 0; i < 16; i++) {
            Tile drawnTile = tileset.drawTile();
            if (drawnTile != null) {
                hand.add(drawnTile);
            }
        }
    }

    public void sortHand() {
        hand.sort(Comparator.comparing(Tile::getSuit).thenComparingInt(Tile::getValue));
    }

    public ArrayList<Tile> getHand() {
        return hand;
    }

    public ArrayList<Tile> getDiscard() {
        return discard;
    }

    public ArrayList<Tile> getPlayed() {
        return played;
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean hasFlower() {
        // Loop through the hand and check if any tile is a flower
        for (Tile tile : hand) {
            if (tile.isFlower()) {
                return true;  // Return true as soon as a flower is found
            }
        }
        return false;  // No flowers found
    }


    public void playFlowers(TileSet tileSet) {
        // Loop through the hand in reverse to safely remove flowers
        for (int i = hand.size() - 1; i >= 0; i--) {
            Tile tile = hand.get(i);
            if (tile.isFlower()) {
                // Move the flower tile to played, remove from hand
                played.add(tile);
                hand.remove(i);

                // Draw a replacement tile, ensuring it is not a flower
                drawTile(tileSet);
            }
        }
    }

    public List<Integer> hasFours(){
        // loop through the sorted hand, find a set of four of the same, return the where the set ends
        List<Integer> sets = new ArrayList<>();
        for(int i = 3; i < hand.size(); i++){
            if (hand.get(i).equals(hand.get(i - 1)) &&
                    hand.get(i).equals(hand.get(i - 2)) &&
                    hand.get(i).equals(hand.get(i - 3))) {
                sets.add(i);
            }
        }
        return sets;
    }


    public void drawTile(TileSet tileSet) {
        // Draw a tile from the tile set, and if it's a flower, play it and draw another
        Tile drawnTile = tileSet.drawTile();
        while (drawnTile != null && drawnTile.isFlower()) {
            // If the drawn tile is a flower, play it and draw another tile
            played.add(drawnTile);
            drawnTile = tileSet.drawTile();  // Keep drawing until it's not a flower
        }
        if (drawnTile != null) {
            hand.add(drawnTile);  // Add the non-flower tile to the hand
        }
    }

    public void discardTile(int selectedTile){
        // This will add a tile to discard pile and remove it from hand
        discard.add(hand.get(selectedTile));
        hand.remove(selectedTile);
    }

    public void setSelectedTile(int selectedTile) {
        this.selectedTile = selectedTile;
    }

    public int getSelectedTile() {
        return selectedTile;
    }
}
