public abstract class Vehicle extends SimItem {

    public static final double LENGTH = 1.0;
    private double speed;
    private Road road;
    private int roadPos;
    private int direction;

    /**
     * Constructor
     * @param road a road segment
     * @param roadPos a position on the road
     * @param speed a current speed of the vehicle
     */
    public Vehicle(double x, double y, Road road, int roadPos, int dir, int speed) {
        super(x, y);
        this.speed = speed;
        this.road = road;
        this.roadPos = roadPos;
        this.direction = dir;
    }

    public abstract double length();

    /**
     *
     * @return the vehicle position
     */
    public int getPosition() {
        return roadPos;
    }

    /**
     *
     * @param position the vehicle position
     */
    public void setPosition(int position) {
        if (road != null && position >= 0 && position < road.getLength()) {
            this.roadPos = position;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     *
     * @return the road segment
     */
    public Road getRoad() {
        return road;
    }

    /**
     *
     * @param road the road segment
     */
    public void setRoad(Road road) {
        this.road = road;
    }

    /**
     *
     * @return the vehicle speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     *
     * @param speed the vehcile speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Moves the vehicle to next position on the road.
     * If current position is last position on the current road
     * then current position is set to 0.
     * If current road has next connected road segment
     * then this function moves the vehicle to that segment.
     */
    public void move() {
        if (speed == 0) {
            setSpeed(20);
        }

        if (roadPos + 1 < road.getLength()) {
            ++roadPos;
        } else {
            roadPos = 0;
            if (road.getNext() != null) {
                road = road.getNext();
            }
        }
    }

    /**
     * Stops the vehicle
     */
    public void stop() {
        setSpeed(0);
    }
}
