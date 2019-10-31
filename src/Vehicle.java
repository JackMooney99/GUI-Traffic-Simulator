import java.util.Random;

public abstract class Vehicle extends SimItem {
    static final double LENGTH = 1.0;
    private static final int SPEED = 20;

    private double speed;
    private Road road;
    private int roadPos;
    private Direction direction;

    /**
     * Constructor
     */
    public Vehicle() {
        this.speed = 0;
        this.road = null;
        this.roadPos = 0;
    }

    public abstract double length();

    /**
     *
     * @return the car position
     */
    int getPosition() {
        return roadPos;
    }

    /**
     *
     * @param position the car position
     */
    void setPosition(int position) {
        if (road != null && position >= 0 && position < Road.LENGTH) {
            this.roadPos = position;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Direction getDirection() {
        return direction;
    }

    void setDirection() {
        this.direction = Direction.RIGHT;
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
    void setRoad(Road road) {
        this.road = road;
    }

    /**
     *
     * @return the car speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     *
     * @param speed the car speed
     */
    private void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Moves the car to next position on the road.
     * If current position is last position on the current road
     * then current position is set to 0.
     * If current road has next connected road segment
     * then this function moves the car to that segment.
     */
    void move() {
        if (speed == 0) {
            setSpeed(SPEED);
        }

        if (direction.isRightDown() && roadPos + 1 < Road.LENGTH) {
            ++roadPos;
        } else  if (!direction.isRightDown() && roadPos > 0) {
            --roadPos;
        } else {
            Road nextRoad;

            if (direction == road.getDirection()) {
                nextRoad = road.nextRoad();
            } else {
                Road[] nextRoads = road.getAdjacentRoads();
                if (nextRoads.length == 0) {
                    throw new RuntimeException("No Way");
                } else {
                    int r = new Random().nextInt(nextRoads.length);
                    nextRoad = nextRoads[r];
                }
            }

            if (nextRoad == null) {
                throw new RuntimeException("No Way");
            } else {
                if (road.getDirection() != nextRoad.getDirection().opposite()) {
                    direction = nextRoad.getDirection();
                }

                int section = direction.isRightDown() ? 0 : Road.LENGTH - 1;
                road.removeVehicle(this);
                nextRoad.placeVehicle(this, section);
            }
        }
    }

    /**
     * Stops the car
     */
    public void stop() {
        setSpeed(0);
    }
}
