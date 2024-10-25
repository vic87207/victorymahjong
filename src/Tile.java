/*
This is the Tile class, with suites and values.
We are also going to check if they honor cards or flowers
 */

public class Tile {

    public enum Suit {
        MILLION, BAMBOO, DOT, WIND, DRAGON, FLOWER
    }

    private enum chinese_numbers {
        一, 二, 三, 四, 五, 六, 七, 八, 九
    }

    private enum wind {
        東, 南, 西, 北
    }

    private enum dragon {
        中, 發, 白
    }

    private enum flower {
        梅, 蘭, 竹, 菊, 春, 夏, 秋, 冬
    }

    private Suit suit;
    private int value;
    private boolean isHonor;
    private boolean isFlower;

    public Tile(Suit suit, int value, boolean isHonor, boolean isFlower) {
        this.suit = suit;
        this.value = value;
        this.isHonor = isHonor;
        this.isFlower = isFlower;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public boolean isHonor() {
        return isHonor;
    }

    public boolean isFlower() {
        return isFlower;
    }

    public String getValueAsString() {
        // Return the appropriate value as a string for regular tiles
        if (suit == Suit.MILLION || suit == Suit.BAMBOO || suit == Suit.DOT) {
            return chinese_numbers.values()[value].toString();
        } else if (suit == Suit.WIND) {
            return wind.values()[value].toString();
        } else if (suit == Suit.DRAGON) {
            return dragon.values()[value].toString();
        } else {
            return flower.values()[value].toString();
        }
    }

    public String getSuitAsString() {
        if (this.suit == Suit.MILLION) {
            return "萬";
        } else if (this.suit == Suit.DOT) {
            return "筒";
        } else if (this.suit == Suit.BAMBOO) {
            return "條";
        } else if (this.suit == Suit.WIND) {
            return "風";
        } else{
            return "牌";
        }
    }


    @Override
    public String toString() {
        if (suit == Suit.MILLION){
            return chinese_numbers.values()[value] + " " + "萬";
        }
        if (suit == Suit.BAMBOO){
            return (value + 1) + " " + "條";
        }
        if (suit == Suit.DOT){
            return (value + 1) + " " + "筒";
        }
        if (suit == Suit.WIND){
            return wind.values()[value] + " " + "風";
        }
        if (suit == Suit.DRAGON){
            return " " + dragon.values()[value] + " ";
        }
        else{
            return " " + flower.values()[value] + " ";
        }
    }
}
