import javax.swing.*;

public class CityView extends JPanel {
    private final City city;

    public CityView(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }
}
