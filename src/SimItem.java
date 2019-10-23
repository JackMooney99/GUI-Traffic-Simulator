public abstract class SimItem implements Drawable {
    private double x = 0.0;
    private double y = 0.0;

    public SimItem(double x, double y) {
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
