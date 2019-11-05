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

    public CityCell(int x, int y) {
        this.x = x;
        this.y = y;
        city = null;
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

    Road setRoad(Direction direction) {
        Road road = new Road(this, direction);
        roads[direction.ordinal()] = road;
        return road;
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
        Road[] roads = null;
        int num = 0;
        for (Direction dir: Direction.values()) {
            if (getRoad(dir) != null) {
                ++num;
            }
        }
        roads = new Road[num];
        num = 0;

        for (Direction dir: Direction.values()) {
            if (getRoad(dir) != null) {
                roads[num++] = getRoad(dir);
            }
        }
        return roads;
    }

    @Override
    public String toString() {
        return "CityCell [x=" + x + ", y=" + y + "]";
    }


}
