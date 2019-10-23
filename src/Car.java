public class Car extends Vehicle {
    /**
     * Constructor
     *
     * @param x
     * @param y
     * @param road    a road segment
     * @param roadPos a position on the road
     * @param dir
     * @param speed   a current speed of the car
     */
    public Car(double x, double y, Road road, int roadPos, int dir, int speed) {
        super(x, y, road, roadPos, dir, speed);
    }

    @Override
    public double length() {
        return LENGTH;
    }
}