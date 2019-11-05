import javax.swing.*;
import java.awt.*;

public class CityView extends JPanel {

    private final City city;

    public CityView(City city) {
        super();
        this.city = city;
    }

    City getCity() {
        return city;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGrid(g);
        drawRoads(g);
        drawTrafficLights(g);
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < City.CITY_HEIGHT; ++i) {
            g.drawLine(0, i * cellHeight(), getWidth(), i * cellHeight());
        }

        for (int i = 0; i < City.CITY_WIDTH; ++i) {
            g.drawLine(i * cellWidth(), 0, i * cellWidth(), getWidth());
        }
    }

    private void drawRoads(Graphics g) {
        for (int i = 0; i < City.CITY_HEIGHT; ++i) {
            for (int j = 0; j < City.CITY_WIDTH; ++j) {
                CityCell cell = city.getCityCells()[i][j];
                drawCell(g, cell);
            }
        }
    }

    private void drawCell(Graphics g, CityCell cell) {

        if (cell.hasRoads()) {
            int x = cell.getX() * cellWidth();
            int y = cell.getY() * cellHeight();

            // central square
            //g.setColor(Color.DARK_GRAY);
            //g.fillRect(x + roadWidth(), y + roadHeight(), roadWidth(), roadHeight());

            // road squares
            if (cell.getRoad(Direction.LEFT) != null) {
                int cy = y + roadHeight() / 2;
                g.setColor(Color.DARK_GRAY);
                g.fillRect(x, cy, roadWidth(), roadHeight());
                drawVehicles(g, cell.getRoad(Direction.LEFT), x, cy);
            }

            if (cell.getRoad(Direction.UP) != null) {
                int cx = x + roadWidth() / 2;
                g.setColor(Color.DARK_GRAY);
                g.fillRect(cx, y, roadWidth(), roadHeight());
                drawVehicles(g, cell.getRoad(Direction.UP), cx, y);
            }

            if (cell.getRoad(Direction.RIGHT) != null) {
                int cx = x + roadWidth();
                int cy = y + roadHeight() / 2;
                g.setColor(Color.DARK_GRAY);
                g.fillRect(cx, cy, roadWidth(), roadHeight());
                drawVehicles(g, cell.getRoad(Direction.RIGHT), cx, cy);
            }

            if (cell.getRoad(Direction.DOWN) != null) {
                int cx = x + roadWidth() / 2;
                int cy = y + roadHeight();
                g.setColor(Color.DARK_GRAY);
                g.fillRect(cx, cy , roadWidth(), roadHeight());
                drawVehicles(g, cell.getRoad(Direction.DOWN), cx, cy);
            }
        }
    }

    private void drawTrafficLights(Graphics g) {
        for (TrafficLight tl: city.getTrafficLights()) {
            g.setColor(tl.getColour().equals("green") ? Color.GREEN : Color.RED);
            g.fillRect((int)tl.getX() * cellWidth(), (int)tl.getY() * cellHeight(), 15, 15);
            g.setColor(Color.BLACK);
            g.fillRect((int)tl.getX() * cellWidth(),
                    (int)tl.getY() * cellHeight() + (tl.getColour().equals("green") ? - 15 : 15), 15, 15);
        }
    }

    private void drawVehicles(Graphics g, Road road, int x, int y) {
        g.setColor(Color.GREEN);

        int sectorLength = road.getDirection().isVertical() ?
                roadWidth() / 3: roadHeight() / 3;

        for (Vehicle vehicle: road.getVehicles()) {
            if (road.getDirection().isHorizontal()) {

                g.fillRect(x + vehicle.getPosition(), y, sectorLength, sectorLength);
            } else {
                g.fillRect(x, y + vehicle.getPosition(), sectorLength, sectorLength);
            }
        }
    }

    private int cellWidth() {
        return getWidth() / City.CITY_WIDTH;
    }

    private int cellHeight() {
        return getHeight() / City.CITY_HEIGHT;
    }

    private int roadWidth() {
        return cellWidth() / 2;
    }

    private int roadHeight() {
        return cellHeight() / 2;
    }
}
