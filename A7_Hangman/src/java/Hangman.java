
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {

    //scanner to be used for input
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        boolean keepGoing = true;
        while(keepGoing){
            keepGoing = game();
        }

        //Close scanner at end of program
        in.close();
    }

    //Game Loop
    public static boolean game(){
        //possible words for the game
        String[] possibleWords = {"cat", "dog"};

        //get a word for this instance of the game
        ArrayList<Character> wordArr = chooseNewWord(possibleWords);

        //Set up variables
        ArrayList<Character> missedLetters = new ArrayList<Character>();
        ArrayList<Character> guessedLetters = new ArrayList<Character>();
        char guess;
        boolean win = false;


        //Initially populate guessedLetters with blanks
        for(int i = 0; i < wordArr.size();i++){
            guessedLetters.add('_');
        }

        //game loop
        while(missedLetters.size() < 6 && !win){
            //display hangman text art
            System.out.println(textArt(missedLetters.size()));

            //display incorrect and correct guesses
            System.out.println(guessText(missedLetters, guessedLetters));

            //Get the user's guess of letter
            guess = getGuess();

            //if the letter is correct, update guessed letters, otherwise update missed letters
            if(wordArr.contains(guess)){
                updateGuesses(guess, wordArr, guessedLetters);
            }
            else {
                missedLetters.add(guess);
            }

            //check for win
            if(!guessedLetters.contains('_')){
                win = true;
            }
        }

        //display win/lose text
        System.out.println(winLose(win, wordArr));

        //Ask the player if they want to play again
        return again();
    }

    //Chooses a random word from a given array of words and converts it to an ArrayList
    public static ArrayList<Character> chooseNewWord(String[] possibleWords){
        Random rand = new Random();
        int wordIndex = rand.nextInt(possibleWords.length);
        String wordToGuess = possibleWords[wordIndex];
        ArrayList<Character> wordArr = new ArrayList<Character>();

        //put word to guess into wordArr
        for(int i = 0; i < wordToGuess.length();i++){
            wordArr.add(wordToGuess.charAt(i));
        }

        return wordArr;
    }

    //Get user input of guess
    public static char  getGuess(){
        System.out.println("\n\nGuess a letter");
        return in.nextLine().charAt(0);
    }

    //update correctly guessed letters, input is guessed letter, word to be guessed, and the current guessed letters
    public static ArrayList<Character> updateGuesses(char guess, ArrayList<Character> word, ArrayList<Character> guessedLetters){

        for(int i = 0; i < word.size(); i++){
            if(word.get(i) == guess){
                guessedLetters.set(i, guess);
            }
        }

        return guessedLetters;
    }

    //returns text art when given number of missed letters
    public static String textArt(int missedLetters){
        switch(missedLetters){
            case 0:
                return "H A N G M A N\n" +
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
                        "\n";
            case 1:
                return "H A N G M A N\n" +
                        "\n" +
                        "+---+\n" +
                        "\n" +
                        " O    |\n" +
                        "\n" +
                        "      |\n" +
                        "\n" +
                        "      |\n" +
                        "\n" +
                        "    ===\n" +
                        "\n";
            case 2:
                return "H A N G M A N\n" +
                        "\n" +
                        "+---+\n" +
                        "\n" +
                        "  O   |\n" +
                        "\n" +
                        "  |   |\n" +
                        "\n" +
                        "      |\n" +
                        "\n" +
                        "    ===\n" +
                        "\n";
            case 3:
                return "H A N G M A N\n" +
                        "\n" +
                        "+---+\n" +
                        "\n" +
                        "  O   |\n" +
                        "\n" +
                        " /|   |\n" +
                        "\n" +
                        "      |\n" +
                        "\n" +
                        "    ===\n" +
                        "\n";
            case 4:
                return "H A N G M A N\n" +
                        "\n" +
                        "+---+\n" +
                        "\n" +
                        "  O   |\n" +
                        "\n" +
                        " /|\\  |\n" +
                        "\n" +
                        "      |\n" +
                        "\n" +
                        "    ===\n" +
                        "\n";
            case 5:
                return "H A N G M A N\n" +
                        "\n" +
                        "+---+\n" +
                        "\n" +
                        "  O   |\n" +
                        "\n" +
                        " /|\\  |\n" +
                        "\n" +
                        " /    |\n" +
                        "\n" +
                        "    ===\n" +
                        "\n";
            case 6:
                return "H A N G M A N\n" +
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
                        "\n";
            default:
                return "There was an error displaying the text art";

                /*
                 */
        }
    }

    //returns text for incorrect and correct guesses
    public static String guessText(ArrayList<Character> missedLetters, ArrayList<Character> guessedLetters){
        String output = "";
        //display missed letters
        output += "Missed Letters:";
        for (Character missedLetter : missedLetters) {
            output += missedLetter;
        }
        output += "\n";

        //display guessed letters and blanks
        for (Character guessedLetter : guessedLetters) {
            output += guessedLetter;
        }

        return output;
    }

    //Returns win/lose text
    public static String winLose(boolean win, ArrayList<Character> word){
        String guessWord = "";
        for (Character character : word) {
            guessWord += character;
        }
        if(win){
            return("Good Job, you guessed the word!");
        } else{
            return "You did not guess the word. The secret word was: " + guessWord;
        }

    }

    //Asks the player if they want to play again, and returns answer as a boolean
    public static boolean again(){
        System.out.println("Would you like to play again? (y/n)");
        return(in.nextLine().charAt(0) == 'y');
    }

}

/*
OLD CODE

OLD GAME OVER CODE
                System.out.println("Game Over :(");
                System.out.println("Do you want to play again? (yes or no)");
                if(in.nextLine().equals("yes")){
                    //SELECT NEW WORD HERE

                    //clear missedLetters arrayList
                    missedLetters.clear();
                    //put word to guess into wordArr
                    for(int i = 0; i < wordToGuess.length();i++){
                        wordArr.add(wordToGuess.charAt(i));
                    }

                    //re-populate guessedLetters with spaces to fill with letters
                    guessedLetters.clear();
                    for(int i = 0; i < wordToGuess.length();i++){
                        guessedLetters.add('_');
                    }
                } else{
                    System.exit(0);
                }

                break;

OLD MAIN CODE

        boolean win = false;
        boolean guessCorrect;
        char currentGuess = ' ';
        String wordToGuess = "cat";
        ArrayList<Character> wordArr = new ArrayList<Character>();
        ArrayList<Character> missedLetters = new ArrayList<Character>();
        ArrayList<Character> guessedLetters = new ArrayList<Character>();

        //put word to guess into wordArr
        for(int i = 0; i < wordToGuess.length();i++){
            wordArr.add(wordToGuess.charAt(i));
        }

        //populate guessedLetters with spaces to fill with letters
        for(int i = 0; i < wordToGuess.length();i++){
            guessedLetters.add('_');
        }

        //Main Game loop
        while(!win){
            //Text art hangman - display based on number of missed letters



            //Show the incorrectly guessed letters
            for(int i = 0; i < missedLetters.size(); i++){
                System.out.print(missedLetters.get(i));
            }

            //Shows missing and correctly guessed letters
            System.out.println("\n");
            for(int i = 0; i < wordToGuess.length();i++){
                System.out.print(guessedLetters.get(i));
            }

            //Gets user input for next guess
            System.out.println("\nGuess a Letter");
            currentGuess = in.nextLine().charAt(0);

            //checks if guess is correct
            guessCorrect = false;
            for(int i = 0; i < wordToGuess.length();i++){
                if(currentGuess == wordArr.get(i)){
                    guessedLetters.set(i, currentGuess);
                    guessCorrect = true;
                }
            }

            //if guess is incorrect, updates missed letters - NEEDS TO ALSO UPDATE HANGMAN
            if(!guessCorrect){
                missedLetters.add(currentGuess);
            }

            //Checks for winstate
            if(!guessedLetters.contains('_')){
                win = true;
            }

            //if game is won
            if(win){
                System.out.println("Yes! The secret word is " + wordToGuess + "! You have won!\n" +
                        "\n" +
                        "Do you want to play again? (yes or no)");

                //restart game if user inputs "yes"
                if(in.nextLine().equals("yes")){
                    win = false;

                    //SELECT NEW WORD HERE

                    //clear missedLetters arrayList
                    missedLetters.clear();
                    //put word to guess into wordArr
                    for(int i = 0; i < wordToGuess.length();i++){
                        wordArr.add(wordToGuess.charAt(i));
                    }

                    //re-populate guessedLetters with spaces to fill with letters
                    guessedLetters.clear();
                    for(int i = 0; i < wordToGuess.length();i++){
                        guessedLetters.add('_');
                    }
                }
            }
        }


 */
