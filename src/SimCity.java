public class SimCity {
    public static void main(String[] args) {
        SimCity2D simCity2D = new SimCity2D(City.loadCity("city.txt"));

        // Controller to handle the actions from the user.
        Controller controller = new Controller(simCity2D);
        controller.init();

    }
}
