import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class City {
    static final int CITY_WIDTH = 10;
    static final int CITY_HEIGHT = 10;

    private CityCell[][] cityCells = new CityCell[CITY_HEIGHT][CITY_WIDTH];

    private final ArrayList<Vehicle> vehicles = new ArrayList<>();
    private final ArrayList<TrafficLight> trafficLights = new ArrayList<>();
    private final ArrayList<Road> roads = new ArrayList<>();

    public City() {
        for (int i = 0; i < CITY_HEIGHT; ++i) {
            for (int j = 0; j < CITY_WIDTH; ++j) {
                cityCells[i][j] = new CityCell(j, i, this);
            }
        }
    }

    CityCell[][] getCityCells() {
        return cityCells;
    }

    void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public void addTrafficLight(TrafficLight tl) {
        trafficLights.add(tl);
    }

    public void addRoad(Road r) {
        roads.add(r);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public ArrayList<TrafficLight> getTrafficLights() {
        return trafficLights;
    }

    public ArrayList<Road> getRoads() {
        return roads;
    }

    void step() {
        for (Vehicle v: vehicles) {
            v.move();
        }

        for (TrafficLight tl: trafficLights) {
            tl.operate();
        }
    }

    private void addRoad(int startX, int startY, int endX, int endY) {
        int x1 = startX / 2;
        int y1 = startY / 2;
        int x2 = endX / 2;
        int y2 = endY / 2;

        if (startX == endX) { // vertical road
            CityCell startCell = cityCells[y1][x1];
            CityCell endCell = cityCells[y2][x2];

            if (startY % 2 == 0) {
                startCell.setRoad(Direction.UP);
            }
            startCell.setRoad(Direction.DOWN);

            endCell.setRoad(Direction.UP);
            if (endY % 2 == 1) {
                endCell.setRoad(Direction.DOWN);
            }

            for (int y = y1 + 1; y < y2; ++y) {
                CityCell cell = cityCells[y][x1];
                cell.setRoad(Direction.UP);
                cell.setRoad(Direction.DOWN);
            }

        } else if (startY == endY) { // horizontal road
            CityCell startCell = cityCells[y1][x1];
            CityCell endCell = cityCells[y2][x2];

            if (startX % 2 == 0) {
                startCell.setRoad(Direction.LEFT);
            }
            startCell.setRoad(Direction.RIGHT);

            endCell.setRoad(Direction.LEFT);
            if (endX % 2 == 1) {
                endCell.setRoad(Direction.RIGHT);
            }

            for (int x = x1 + 1; x < x2; ++x) {
                CityCell cell = cityCells[y1][x];
                cell.setRoad( Direction.LEFT);
                cell.setRoad(Direction.RIGHT);
            }
        }  // invalid road

    }

    static City loadCity() {
        City city = new City();

        try {
            Scanner scanner = new Scanner(new File("city.txt"));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String roadStr = scanner.nextLine();
                String[] s = roadStr.split(",");
                if (s.length == 4) {
                    int x1 = Integer.parseInt(s[0]) - 1;
                    int y1 = Integer.parseInt(s[1]) - 1;

                    int x2 = Integer.parseInt(s[2]) - 1;
                    int y2 = Integer.parseInt(s[3]) - 1;

                    city.addRoad(x1, y1, x2, y2);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return city;
    }
}