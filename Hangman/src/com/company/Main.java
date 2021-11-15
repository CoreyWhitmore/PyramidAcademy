/*
TODO
Word Randomizer
Generate new random word on restart
 */


package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);

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
            switch(missedLetters.size()){
                case 0:
                    System.out.println("H A N G M A N\n" +
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
                            "\n" +
                            "Missed letters:");
                    break;
                case 1:
                    System.out.println("H A N G M A N\n" +
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
                            "\n" +
                            "Missed letters:");
                    break;
                case 2:
                    System.out.println("H A N G M A N\n" +
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
                            "\n" +
                            "Missed letters:");
                    break;
                case 3:
                    System.out.println("H A N G M A N\n" +
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
                            "\n" +
                            "Missed letters:");
                    break;
                case 4:
                    System.out.println("H A N G M A N\n" +
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
                            "\n" +
                            "Missed letters:");
                    break;
                case 5:
                    System.out.println("H A N G M A N\n" +
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
                            "\n" +
                            "Missed letters:");
                    break;
                case 6:
                    System.out.println("H A N G M A N\n" +
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
                            "\n" +
                            "Missed letters:");
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
            }


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
    }
}
