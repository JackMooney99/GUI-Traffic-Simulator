import java.util.Random;

/*
 * Represents a Traffic Light
 */
public class TrafficLight extends SimItem {
    private String colour;
    private double rate;

    /**
     * Constructor
     * @param colour the colour
     * @param rate the rate
     */
    public TrafficLight(double x, double y, String colour, double rate) {
        super(x, y);
        setColour(colour);
        setRate(rate);
    }

    /**
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * @param colour the colour
     */
    public void setColour(String colour) {
        if (colour.equals("green") || colour.equals("red")) {
            this.colour = colour;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /*
     * If colour is "red" then set colour to "green"
     * If colour is "green" then set colour to "red"
     */
    public void toggleColour() {
        if (getColour().equals("red")) {
            setColour("green");
        } else {
            setColour("red");
        }
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @param rate the rate
     */
    public void setRate(double rate) {
        if (rate >= 0.0 && rate <= 1.0) {
            this.rate = rate;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /*
     * Traffic Light operation
     */
    public void operate() {
        double randomRate = new Random().nextDouble();
        if (randomRate < getRate()) {
            toggleColour();
        }
    }
}