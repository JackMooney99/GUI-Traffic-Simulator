/*
 * Direction represents directions in a 2D plane. Each direction stores a relative position.
 */
public enum Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN;


    /**
     * Gets the opposite direction to this direction.
     * @return
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
}
