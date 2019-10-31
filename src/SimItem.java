public abstract class SimItem implements Drawable {
    private double x;
    private double y;

    SimItem() {
        this(0, 0);
    }

    SimItem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {

    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }
}
