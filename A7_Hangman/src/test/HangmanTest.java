import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {
    Hangman hangman;

    @BeforeEach
    void setUp() {
        hangman = new Hangman();
    }

    @Test
    void updateGuesses() {
        ArrayList<Character> word = new ArrayList<>();
        ArrayList<Character> guessedLetters = new ArrayList<>();
        word.add('c');
        word.add('a');
        word.add('t');
        guessedLetters.add('_');
        guessedLetters.add('_');
        guessedLetters.add('t');

        assertEquals("[_, a, t]",String.valueOf(hangman.updateGuesses('a',word,guessedLetters)), "Failed to update guessed letters with guess");
    }

    @Test
    void textArt0() {
        assertEquals("H A N G M A N\n" +
                "\n" +
                "+---+\n" +
                "\n" +
                "      |\n" +
                "\n" +
                "      |\n" +
                "\n" +
                "      |\n" +
                "\n" +
                "    ===\n" +
                "\n", hangman.textArt(0), "Initial text art is broken" );
    }

    @Test
    void textArt6() {
        assertEquals("H A N G M A N\n" +
                "\n" +
                "+---+\n" +
                "\n" +
                "  O   |\n" +
                "\n" +
                " /|\\  |\n" +
                "\n" +
                " / \\  |\n" +
                "\n" +
                "    ===\n" +
                "\n", hangman.textArt(6), "Final text art is broken" );
    }

    @Test
    void guessText() {
        ArrayList<Character> missedLetters = new ArrayList<>();
        ArrayList<Character> guessedLetters = new ArrayList<>();
        missedLetters.add('a');
        missedLetters.add('b');
        missedLetters.add('c');
        guessedLetters.add('d');
        guessedLetters.add('o');
        guessedLetters.add('_');
        assertEquals("Missed Letters:abc\n" +
                "do_", hangman.guessText(missedLetters,guessedLetters), "Text displayed before guess does not display correctly");
    }

    @Test
    void lose() {
        ArrayList<Character> test = new ArrayList<>();
        test.add('t');
        test.add('e');
        test.add('s');
        test.add('t');
        assertEquals("You did not guess the word. The secret word was: test", hangman.winLose(false, test));
    }
    @Test
    void win() {
        ArrayList<Character> test = new ArrayList<>();
        test.add('t');
        test.add('e');
        test.add('s');
        test.add('t');
        assertEquals("Good Job, you guessed the word!", hangman.winLose(true, test));
    }
}