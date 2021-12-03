
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Hangman {

    //scanner to be used for input
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        boolean keepGoing = true;

        System.out.println("What is your name?");
        String name = in.nextLine();

        while(keepGoing){
            keepGoing = game(name);
        }

        //Close scanner at end of program
        in.close();
    }

    //Game Loop
    public static boolean game(String name){
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
        String blankWord = "_";
        blankWord = blankWord.repeat(wordArr.size());
        Character[] letters = blankWord.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        guessedLetters.addAll(Arrays.asList(letters));



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

        //display high scores
        highScores(name, missedLetters.size());


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
        Character[] letters = wordToGuess.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        wordArr.addAll(Arrays.asList(letters));

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

        String fileText = "";

        //Read file to fileText
        try {
            fileText = Files.readString(Paths.get("C:/PyramidAcademy/A9_Hangman_Functional/TextArt"));
        }
        catch (Exception e){
            System.out.println("Error reading text art file");
        }

        //split file into array
        String[] wordArtArr = fileText.split(",");

        //return appropriate index
        return wordArtArr[missedLetters];
    }

    //returns text for incorrect and correct guesses
    public static String guessText(ArrayList<Character> missedLetters, ArrayList<Character> guessedLetters){
        String output = "";
        //add missed letters
        output += "Missed Letters:";
        if(missedLetters.size() != 0){
            output += missedLetters.toString().replace(",", "").replace("[", "").replace("]", "");
        }
        output += "\n";
        //add guessed letters
        if (guessedLetters.size() != 0){
            output += guessedLetters.toString().replace(",", "").replace("[", "").replace("]", "");
        }

        return output;
    }

    //Returns win/lose text
    public static String winLose(boolean win, ArrayList<Character> word){
        String guessWord = word.toString().replace(", ", "").substring(1, word.size()-1);
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

    public static void highScores(String name, int score){
        String hsText = "";
        int bestScore = -1;

        //Read file to hsText
        try {
            hsText = Files.readString(Paths.get("C:/PyramidAcademy/A9_Hangman_Functional/HighScores")).replace("[", "").replace("]", "");
        }
        catch (Exception e){
            System.out.println("Error reading High Score");
        }

        //split file into arrayList
        ArrayList<String> hsArr = new ArrayList<>(List.of(hsText.split(", ")));

        if(hsArr.size() > 0 && hsArr.get(0) != "") {
            ArrayList<Integer> hsIntArr = hsArr.stream().map(c -> Integer.parseInt(c.replaceAll("[^\\d.]", ""))).collect(Collectors.toCollection(ArrayList::new));
            bestScore = hsIntArr.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
        }

        if (bestScore == -1 || score < bestScore){
            System.out.println("You got the new high score!");
        }

        //Add high score to hsArr
        hsArr.add(score + " " + name);

        //Update high score file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/PyramidAcademy/A9_Hangman_Functional/HighScores"));
            writer.write(hsArr.toString());

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //display high scores
        System.out.println("-----HIGH SCORES-----");
        System.out.println(hsArr.toString().replace(", ", "\n").replace("[", "").replace("]", ""));

    }

}
