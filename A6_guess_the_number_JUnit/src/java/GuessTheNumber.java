import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    //Main method
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        //enter main game
        game(getName());
        in.close();
    }

    //Gets user's name
    public static String getName(){
        System.out.println("Hello! What is your name?");
        return in.nextLine();
    }

    //get the user's guess of number
    public static int getGuess(){
        Scanner in = new Scanner(System.in);
        int guess = -1;
        System.out.println("Take a guess.");

        //get guess
        try {
            guess = in.nextInt();
        } catch (Exception e) {
            System.out.println("You didn't guess a number between 1 and 20. I'll pretend you guessed -1, which is WRONG!");
        }
        return guess;
    }

    //check if the number was low, high, or correct
    public static boolean guess(int randNum, String name, int numGuesses, int guess){

        //check guess
        if(guess == -1){
            //if an error was caught when the player guessed
            return false;
        }
        if (randNum > guess) {
            System.out.println("Your guess is too low");
            return false;
        }
        else if (randNum < guess) {
            System.out.println("Your guess is too high");
            return false;
        }
        System.out.println("Good job, " + name + " You guessed my number in " + (numGuesses) + " guesses!\n" +
                "\n");
        return true;

    }

    //main game function
    public static void game(String name){
        Random rand = new Random();
        int guess;
        int randNum = rand.nextInt(20) + 1;
        boolean win = false;
        int count = 0;
        char again;

        System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.\n" +
                "\n");

        while(!win && count < 6){
            guess = getGuess();
            win = guess(randNum, name, count + 1, guess);
            count++;
        }

        if(!win){
            System.out.println("You did not guess the number. The correct number was: " + randNum);
        }

        System.out.println("Would you like to play again(y/n)");
        again = in.nextLine().charAt(0);

        if(again == 'y'){
            game(name);
        }

    }


}
