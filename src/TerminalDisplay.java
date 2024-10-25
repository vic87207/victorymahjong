/*
This is the class that prints stuff in the terminal to make sure things are working
 */

import java.util.ArrayList;

public class TerminalDisplay {

    public static String getHandAsString(ArrayList<Tile> hand) {
        StringBuilder handString = new StringBuilder();

        // First row - top borders of tiles
        handString.append("!");
        for (int i = 0; i < hand.size(); i++) {
            if (i == hand.size() - 1) {
                handString.append("┬――┐");  // Last tile has a different end
            } else {
                handString.append("┬――");
            }
        }
        handString.append("\n");

        // Second row - values of tiles
        handString.append("|");
        for (Tile tile : hand) {
            handString.append("｜").append(tile.getValueAsString()).append(" ");  // Tile value
        }
        handString.append("｜\n");

        // Third row - suits of tiles
        handString.append("|");
        for (Tile tile : hand) {
            handString.append("｜").append(tile.getSuitAsString()).append(" ");  // Tile suit
        }
        handString.append("｜\n");

        // Fourth row - bottom borders of tiles
        handString.append("ﾞ");
        for (int i = 0; i < hand.size(); i++) {
            if (i == hand.size() - 1) {
                handString.append("┴――┘");  // Last tile has a different end
            } else {
                handString.append("┴――");
            }
        }

        return handString.toString();
    }
}
