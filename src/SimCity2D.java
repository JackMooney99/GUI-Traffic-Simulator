import javax.swing.*;
import java.awt.*;

public class SimCity2D extends JFrame {
    private City city;
    private CityView cityView;

    public SimCity2D() {
        city = City.loadCity();
        Car car = new Car();
        car.setDirection();
        city.addVehicle(car);
        Road start = city.getCityCells()[0][0].getRoad(Direction.LEFT);
        start.placeVehicle(car, 0);
        initControls();
    }

    void run() {
        int steps = 0;
        while (steps-- < 1000) {
            cityView.getCity().step();
            cityView.repaint();
            try {
                Thread.sleep(75);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void initControls() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sim City 2D");
        //setBounds(400, 200, 800, 700);

        cityView = new CityView(city);
        cityView.setPreferredSize(new Dimension(800, 800));
        getContentPane().add(cityView);

        pack();
        setVisible(true);
    }
}
