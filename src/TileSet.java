/*
Here we take the tile class and produce the entire mahjong set.
We then shuffle the set and allow them to be drawn.
 */

import java.util.ArrayList;
import java.util.Collections;

public class TileSet {
    private final ArrayList<Tile> tiles;

    public TileSet() {
        tiles = new ArrayList<>();
        initializeTiles();
        shuffleTiles();
    }

    private void shuffleTiles() {

        Collections.shuffle(tiles);
    }

    private void initializeTiles() {
        // Four tiles for each tile. One for each of the eight flower
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 4; y++) {
                tiles.add(new Tile(Tile.Suit.BAMBOO, x, false, false));
                tiles.add(new Tile(Tile.Suit.MILLION, x, false, false));
                tiles.add(new Tile(Tile.Suit.DOT, x, false, false));
            }
        }
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                tiles.add(new Tile(Tile.Suit.WIND, x, true, false));
            }
        }
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                tiles.add(new Tile(Tile.Suit.DRAGON, x, true, false));
            }
        }
        for (int x = 0; x < 8; x++) {
            tiles.add(new Tile(Tile.Suit.FLOWER, x, true, true));
        }
    }


    public Tile drawTile() {
        // Draw a tile from the set and remove it
        if (!tiles.isEmpty()) {
            return tiles.removeLast();  // Remove and return the last tile (similar to pop in stacks)
        }
        return null;  // Return null if there are no tiles left
    }


    public int remainingTiles() {
        // Return the number of remaining tiles
        return tiles.size();
    }
}
