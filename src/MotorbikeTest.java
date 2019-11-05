import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotorbikeTest {

    @Test
    void testLength() {
        Motorbike m = new Motorbike();
        assertEquals(0.5, m.length(), 0.1);
    }
}