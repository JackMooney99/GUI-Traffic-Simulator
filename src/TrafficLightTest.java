import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest {

    @Test
    void testToggleColour() {
        TrafficLight tl = new TrafficLight(0,  0, "red", 0.1);
        tl.toggleColour();
        assertEquals("green", tl.getColour());
        tl.toggleColour();
        assertEquals("red", tl.getColour());
    }

}