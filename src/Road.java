import java.util.ArrayList;

/**
 * Represents a road segment
 */
public class Road extends SimItem {
    static final int LENGTH = 10;

    private final CityCell cityCell;

    private final Direction direction;

    private final ArrayList<Vehicle> vehicles;

    /**
     * Default constructor
     */
    public Road(CityCell cityCell, Direction direction) {
        this.cityCell = cityCell;
        this.direction = direction;
        this.vehicles = new ArrayList<>();
    }

    ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    Direction getDirection() {
        return direction;
    }

    public CityCell getCityCell() {
        return cityCell;
    }

    void placeVehicle(Vehicle vehicle, int section) {
        vehicles.add(vehicle);
        vehicle.setRoad(this);
        vehicle.setPosition(section);
    }

    void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
        vehicle.setRoad(null);
    }

    Road[] getAdjacentRoads() {
        Road[] roads = new Road[cityCell.getAdjacentRoads().length - 1];
        int num = 0;
        for (Road r: cityCell.getAdjacentRoads()) {
            if (r != this) {
                roads[num++] = r;
            }
        }
        return roads;
    }

    Road nextRoad() {
        if (direction == Direction.RIGHT && cityCell.getX() < City.CITY_WIDTH - 1) {
            return cityCell.getCity().getCityCells()[cityCell.getY()][cityCell.getX() + 1].getRoad(Direction.LEFT);
        } else if (direction == Direction.LEFT && cityCell.getX() > 0) {
            return cityCell.getCity().getCityCells()[cityCell.getY()][cityCell.getX() - 1].getRoad(Direction.RIGHT);
        } if (direction == Direction.DOWN && cityCell.getY() < City.CITY_HEIGHT - 1) {
            return cityCell.getCity().getCityCells()[cityCell.getY() + 1][cityCell.getX()].getRoad(Direction.UP);
        } else if (direction == Direction.UP && cityCell.getY() > 0) {
            return cityCell.getCity().getCityCells()[cityCell.getY() - 1][cityCell.getX()].getRoad(Direction.DOWN);
        }

        return null;
    }
}