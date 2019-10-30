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

    public void setRoad(Road road, Direction direction) {
        roads[direction.ordinal()] = road;
    }

    public Road getRoad(Direction direction) {
        return roads[direction.ordinal()];
    }

    public boolean hasRoads() {
        for (int i = 0; i < NUM_ROADS; ++i) {
            if (roads[i] != null) {
                return true;
            }
        }
        return false;
    }
}
