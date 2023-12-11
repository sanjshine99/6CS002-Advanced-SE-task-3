/**
 * The Domino class represents a domino tile with highValue and lowValue values, along with
 * coordinates for placement on a game board. It includes methods for placement,
 * inversion, comparison, and string representation.
 */

package base;

public class Domino implements Comparable<Domino> {
    public int highValue;
    public int lowValue;
    public int horizontalPositionX;
    public int horizontalPositionY;
    public int verticalPositionX;
    public int verticalPositionY;
    public boolean isPlaced;

    public Domino(int highValue, int lowValue) {
        this.highValue = highValue;
        this.lowValue = lowValue;
        this.isPlaced = false;
    }

    public void place(int horizontalPositionX, int horizontalPositionY, int verticalPositionX, int verticalPositionY) {
        this.horizontalPositionX = horizontalPositionX;
        this.horizontalPositionY = horizontalPositionY;
        this.verticalPositionX = verticalPositionX;
        this.verticalPositionY = verticalPositionY;
        this.isPlaced = true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("[%d%d]", highValue, lowValue));

        if (!isPlaced) {
            result.append(" unplaced");
        } else {
            result.append(String.format("(%d,%d)", horizontalPositionX + 1, horizontalPositionY + 1));
            result.append(String.format("(%d,%d)", verticalPositionX + 1, verticalPositionY + 1));
        }

        return result.toString();
    }

    /**
     * Turn the domino around 180 degrees clockwise.
     */
    public void invert() {
        int tempX = horizontalPositionX; // rename tx to tempX
        horizontalPositionX = verticalPositionX;
        verticalPositionX = tempX;

        int tempY = horizontalPositionY; // rename ty to tempy
        horizontalPositionY = verticalPositionY;
        verticalPositionY = tempY;
    }

    public boolean isHorizontalPlacement() {
        return horizontalPositionY == verticalPositionY;
    }

    @Override
    public int compareTo(Domino other) {
        if (this.highValue < other.highValue) {
            return 1;
        }
        return this.lowValue - other.lowValue;
    }


    public int getHighValue() {
        return highValue;
    }

    public int getLowValue() {
        return lowValue;
    }

    public boolean isPlaced() {
        return isPlaced;
    }
    public void setPlaced(boolean placed) {
        this.isPlaced = placed;
    }

    public int getHorizontalPositionX() {
        return  horizontalPositionX;
    }

    public int getHorizontalPositionY() {
        return  horizontalPositionY;
    }

    public int getVerticalPositionX() {
        return verticalPositionX;
    }

    public int getVerticalPositionY() {
        return verticalPositionY;
    }
}
