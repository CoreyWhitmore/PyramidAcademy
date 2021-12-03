import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LandTest {
    Land land;

    @BeforeEach
    void setUp() {
        land = new Land();
    }

    @Test
    void testToString() {
        assertEquals(" 0  *  *  *  * \n" +
                " *  *  *  *  * \n" +
                " *  *  *  *  * \n" +
                " *  *  *  *  * \n" +
                " *  *  *  *  G \n", land.toString(), "Default map failed to display correctly" );
    }

    @Test
    void getSize() {
        assertEquals(5,land.getSize(),"Default land returns incorrect size");
    }
}

