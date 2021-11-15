import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessTheNumberTest {
    GuessTheNumber guessTheNumber;

    @BeforeEach
    void setUp() {
        guessTheNumber = new GuessTheNumber();
    }

    @Test
    void guessLow() {
        assertEquals(false, guessTheNumber.guess(10, "Bob", 3, 4), "Low guess returns true");
    }
    @Test
    void guessHigh() {
        assertEquals(false, guessTheNumber.guess(10, "Bob", 3, 14), "High guess returns true");
    }
    @Test
    void guessRight() {
        assertEquals(true, guessTheNumber.guess(10, "Bob", 3, 10), "Correct guess returns false");
    }
}