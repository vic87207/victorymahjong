/*
Player has a hand of 16 tiles.
Player can draw and discard tile.
 */


import java.util.ArrayList;
import java.util.Comparator;

public class Player {
    private final ArrayList<Tile> hand;
    private final ArrayList<Tile> discard;
    private final ArrayList<Tile> played;
    private int selectedTile = 0;

    public Player() {
        hand = new ArrayList<>();
        discard = new ArrayList<>();
        played = new ArrayList<>();
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

    public void playFlowers() {
        // Loop through the hand in reverse to avoid concurrent modification issues
        for (int i = hand.size() - 1; i >= 0; i--) {
            Tile tile = hand.get(i);
            if (tile.isFlower()) {
                // Remove the tile from the hand and add it to the played list
                hand.remove(i);
                played.add(tile);
            }
        }
    }

    public void drawTile(TileSet tileSet) {
        hand.add(tileSet.drawTile());
    }

    public void discardTile(int selectedTile){
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
