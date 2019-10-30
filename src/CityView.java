import javax.swing.*;
import java.awt.*;

public class CityView extends JPanel {
    private final City city;

    public CityView(City city) {
        super();
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //g.clearRect(0, 0, getWidth(), getHeight());

        int cell_width = getWidth() / City.CITY_WIDTH;
        int cell_height = getHeight() / City.CITY_HEIGHT;

        int road_width = cell_width / 3;
        int road_height = cell_height / 3;

        for (int i = 0; i < City.CITY_HEIGHT; ++i) {
            g.drawLine(0, i * cell_height, getWidth(), i * cell_height);
        }

        for (int i = 0; i < City.CITY_WIDTH; ++i) {
            g.drawLine(i * cell_width, 0, i * cell_width, getWidth());
        }

        for (int i = 0; i < City.CITY_HEIGHT; ++i) {
            for (int j = 0; j < City.CITY_WIDTH; ++j) {
                CityCell cell = city.getCityCells()[i][j];
                if (cell.hasRoads()) {
                    int x = j * cell_width;
                    int y = i * cell_height;

                    // central square
                    g.fillRect(x + road_width, y + road_height, road_width, road_height);

                    // road squares
                    if (cell.getRoad(Direction.LEFT) != null) {
                        g.fillRect(x, y + road_height, road_width, road_height);
                    }

                    if (cell.getRoad(Direction.UP) != null) {
                        g.fillRect(x + road_width, y, road_width, road_height);
                    }

                    if (cell.getRoad(Direction.RIGHT) != null) {
                        g.fillRect(x + 2 * road_width, y + road_height, road_width, road_height);
                    }

                    if (cell.getRoad(Direction.DOWN) != null) {
                        g.fillRect(x + road_width, y + 2 * road_height, road_width, road_height);
                    }
                }
            }
        }
    }
}
