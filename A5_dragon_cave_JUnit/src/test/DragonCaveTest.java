import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonCaveTest {

    DragonCave dragonCave;

    @BeforeEach
    void setUp() {
        dragonCave = new DragonCave();
    }

    @Test
    void output1() {
        assertEquals("You approach the cave...\n" +
                "\n" +
                "It is dark and spooky...\n" +
                "\n" +
                "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                "\n" +
                "Gobbles you down in one bite!",dragonCave.output(1), "Input of 1 had unexpected output");
    }
    @Test
    void output2() {
        assertEquals("The dragon welcomes you into the cave...\n" +
                "\n" +
                "It leads you into a huge cavern filled with wealth\n" +
                "\n" +
                "You fill your pockets with gold and gems\n" +
                "\n" +
                "You got away rich (this time)",dragonCave.output(2), "Input of 2 had unexpected output");
    }
}