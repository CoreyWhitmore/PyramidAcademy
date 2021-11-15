package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        int randNum = rand.nextInt(20) + 1;
        int guess = 0;
        String name = "";
        char response = ' ';

        System.out.println("Hello! What is your name?");
        name = in.nextLine();
        System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.\n" +
                "\n");

        for (int i = 0; i < 6; i++) {
            System.out.println("Take a guess.");
            try {
                guess = in.nextInt();
            } catch (Exception e) {
                System.out.println("You didn't guess a number between 1 and 20, I'm not going to even give you a hint");
            }
            if (randNum > guess) {
                System.out.println("Your guess is too low");
            }
            if (randNum < guess) {
                System.out.println("Your guess is too high");
            }
            if (randNum == guess) {
                System.out.println("Good job, " + name + " You guessed my number in " + (i + 1) + " guesses!\n" +
                        "\n");
                while (response != 'y' && response != 'n') {

                    try {
                        response = in.nextLine().charAt(0);
                    } catch (Exception e) {
                        response = ' ';
                        System.out.println("Would you like to play again? (y or n)");
                    }
                }

            }
            if (i == 5) {
                System.out.println("You didn't guess the number");
                while (response != 'y' && response != 'n') {;
                    try {
                        response = in.nextLine().charAt(0);
                    } catch (Exception e) {
                        response = ' ';
                        System.out.println("Would you like to play again? (y or n)");
                    }
                }
            }
            if(response == 'y'){
                i = -1;
                System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.\n" +
                        "\n");
                response = ' ';
            }
            if(response == 'n') {
                System.exit(0);
            }
        }
    }
}