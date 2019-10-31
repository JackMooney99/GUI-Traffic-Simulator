public class CityCell {
    private static final int NUM_ROADS = 4;

    private final int x;
    private final int y;
    private final City city;

    private Road[] roads = new Road[NUM_ROADS];

    public CityCell(int x, int y, City city) {
        this.x = x;
        this.y = y;
        this.city = city;

        for (int i = 0; i < NUM_ROADS; ++i) {
            roads[i] = null;
        }
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    City getCity() {
        return city;
    }

    void setRoad(Direction direction) {
        Road road = new Road(this, direction);
        roads[direction.ordinal()] = road;
    }

    Road getRoad(Direction direction) {
        return roads[direction.ordinal()];
    }

    boolean hasRoads() {
        for (int i = 0; i < NUM_ROADS; ++i) {
            if (roads[i] != null) {
                return true;
            }
        }
        return false;
    }

    Road[] getAdjacentRoads() {
        int num = 0;
        for (Direction dir: Direction.values()) {
            if (getRoad(dir) != null) {
                ++num;
            }
        }
        Road[] roads = new Road[num];
        num = 0;

        for (Direction dir: Direction.values()) {
            if (getRoad(dir) != null) {
                roads[num++] = getRoad(dir);
            }
        }
        return roads;
    }
}