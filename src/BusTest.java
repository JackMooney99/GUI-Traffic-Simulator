import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {

    @Test
    void testLength() {
        Bus b = new Bus();
        assertEquals(3.0, b.length(), 0.1);
    }

}