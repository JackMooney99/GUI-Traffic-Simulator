import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {

    @Test
    void testAddVehicle() {
        City c = new City();
        Car car = new Car();
        c.addVehicle(car);
        assertEquals(car, c.getVehicles().get(0));
    }

    @Test
    void testAddTrafficLight() {
        City c = new City();
        TrafficLight tl = new TrafficLight(1, 1, "red", 0.1);
        c.addTrafficLight(tl);
        assertEquals(tl, c.getTrafficLights().get(0));
    }

    @Test
    void testAddRoad() {
        City c = new City();
        Road r = new Road(null, null);
        c.addRoad(r);
        assertEquals(r, c.getRoads().get(0));
    }
}