import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    Human human = new Human();


    @Test
    void isAdjacent() {
        Goblin goblin = new Goblin(30,5,0,1);
        assertTrue(human.isAdjacent(goblin), "Human is not correctly detecting adjacent goblins");
    }



    @Test
    void getHealth() {
        human.setHealth(300);
        assertEquals(300, human.getHealth(),"Health is not being retrieved correctly from Human");
    }

    @Test
    void getStrength() {
        human.setStrength(300);
        assertEquals(300, human.getStrength(),"Strength is not being retrieved correctly from Human");
    }

    @Test
    void getXPos() {
        human.setXPos(2);
        assertEquals(2, human.getXPos(), "Human x position retrieved incorrectly");
    }

    @Test
    void getYPos() {
        human.setYPos(2);
        assertEquals(2, human.getYPos(), "Human y position retrieved incorrectly");
    }
}