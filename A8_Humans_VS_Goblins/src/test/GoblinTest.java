import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {
    Goblin goblin;

    @BeforeEach
    void setUp() {
        goblin = new Goblin();
    }

    @Test
    void getHealth() {
        goblin.setHealth(100);
        assertEquals(100, goblin.getHealth(), "Goblin Health was retrieved incorrectly");
    }

    @Test
    void getStrength() {
        goblin.setStrength(100);
        assertEquals(100, goblin.getStrength(), "Goblin Strength was retrieved incorrectly");
    }

    @Test
    void getXPos() {
        goblin.setXPos(2);
        assertEquals(2,goblin.getXPos(),"Goblin x position retrieved incorrectly");
    }

    @Test
    void getYPos() {
        goblin.setYPos(2);
        assertEquals(2,goblin.getYPos(),"Goblin y position retrieved incorrectly");
    }
}