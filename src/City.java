import java.util.ArrayList;

public class City {
    private final ArrayList<Vehicle> vehicles = new ArrayList<>();
    private final ArrayList<TrafficLight> trafficLights = new ArrayList<>();
    private final ArrayList<Road> roads = new ArrayList<>();

    public void addVehicle(Vehicle v) {
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

    public void step() {
        for (Vehicle v: vehicles) {
            v.move();
        }

        for (TrafficLight tl: trafficLights) {
            tl.operate();
        }
    }
}
