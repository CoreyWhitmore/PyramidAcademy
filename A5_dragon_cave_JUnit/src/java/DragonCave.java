import java.util.Scanner;


public class DragonCave {

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
        int playerInput = 0;

        //Starting Message
        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "\n" +
                "and will share his treasure with you. The other dragon\n" +
                "\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "\n" +
                "Which cave will you go into? (1 or 2)");
        //Ask for input until user enters 1 or 2
        try {
            playerInput = in.nextInt();
        }
        catch(Exception e) {
            System.out.println("The value entered is invalid, please restart and enter 1 or 2");
        }

        System.out.println(output(playerInput));


    }

    public static String output(int playerInput){
        if(playerInput != 1 && playerInput != 2){
            return ("The value entered is invalid, please restart and enter 1 or 2");
        }

        if(playerInput == 1){
            return ("You approach the cave...\n" +
                    "\n" +
                    "It is dark and spooky...\n" +
                    "\n" +
                    "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                    "\n" +
                    "Gobbles you down in one bite!");
        }

        return ("The dragon welcomes you into the cave...\n" +
                "\n" +
                "It leads you into a huge cavern filled with wealth\n" +
                "\n" +
                "You fill your pockets with gold and gems\n" +
                "\n" +
                "You got away rich (this time)"
        );
    }
}
