/**
 * Direction represents the direction within a 2D plane. Each direction stores a relative position:
 */
public enum Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN;


    /**
     * Gets the inverted direction.
     */
    public Direction opposite() {
        if (this.ordinal() == 0) {
            return RIGHT;
        } else if (this.ordinal() == 1) {
            return LEFT;
        } else if (this.ordinal() == 2) {
            return DOWN;
        } else {
            return UP;
        }
    }

    public boolean isRightDown() {
        return this == DOWN || this == RIGHT;
    }

    public boolean isHorizontal() {
        return this == LEFT || this == RIGHT;
    }

    public boolean isVertical() {
        return this == UP || this == DOWN;
    }
}
