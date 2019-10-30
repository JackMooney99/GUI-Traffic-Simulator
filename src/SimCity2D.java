import javax.swing.*;

public class SimCity2D extends JFrame {
    City city;
    CityView cityView;

    public SimCity2D() {
        city = City.loadCity("city.txt");
        initControls();
    }

    public void run() {
        int steps = 0;
        while (steps-- < 1000) {
            cityView.getCity().step();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void initControls() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sim City 2D");
        setBounds(400, 200, 800, 600);

        cityView = new CityView(city);
        getContentPane().add(cityView);

        setVisible(true);
    }
}