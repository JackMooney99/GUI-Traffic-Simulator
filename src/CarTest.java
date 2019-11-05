import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testLength() {
        Car c = new Car();
        assertEquals(1.0, c.length(), 0.1);
    }

}
