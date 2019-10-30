/*
 * Represents a road segment
 */
public class Road /*extends SimItem*/ {
    public static final int LENGTH = 100;
    /*
     * the length
     */
    private int length;
    /*
     * the next connected road segment
     */
    private Road next;

    /*
     * Default constructor
     */
    public Road() {
        setLength(LENGTH);
        setNext(null);
    }

    /**
     * Constructor
     * @param length the length
     */
    public Road(double x, double y, int length) {
        //super(x, y);
        setLength(length);
        setNext(null);
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length
     */
    public void setLength(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException();
        }
        this.length = length;
    }

    /**
     * @return the next connected road segment
     */
    public Road getNext() {
        return next;
    }

    /**
     * @param next the next connected road segment
     */
    public void setNext(Road next) {
        this.next = next;
    }
}