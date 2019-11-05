import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {

    @Test
    void testGetVehicles() {
        Road r = new Road(new CityCell(0, 0), Direction.DOWN);
        r.placeVehicle(new Car(), 1);
        r.placeVehicle(new Car(), 2);
        assertEquals(2, r.getVehicles().size());
    }

    @Test
    void testGetDirection() {
        Road r = new Road(new CityCell(0, 0), Direction.DOWN);
        assertEquals(Direction.DOWN, r.getDirection());
    }

    @Test
    void testPlaceVehicle() {
        Road r = new Road(new CityCell(0, 0), Direction.DOWN);
        r.placeVehicle(new Car(), 1);
        r.placeVehicle(new Car(), 2);
        assertEquals(2, r.getVehicles().size());
    }

    @Test
    void testRemoveVehicle() {
        Road r = new Road(new CityCell(0, 0), Direction.DOWN);
        Car c = new Car();
        r.placeVehicle(c, 1);
        r.placeVehicle(new Car(), 2);
        assertEquals(2, r.getVehicles().size());
        r.removeVehicle(c);
        assertEquals(1, r.getVehicles().size());
    }
}