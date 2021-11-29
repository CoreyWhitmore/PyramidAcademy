import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        game();
    }

    public static void game(){
        Random rand = new Random();
        Human human = new Human();
        Scanner in = new Scanner(System.in);
        int size = 5;
        int gobs = 3;
        boolean win = false;
        ArrayList<Goblin> goblins = new ArrayList<>();
        //generate goblins
        for (int i = 0; i < gobs; i++){
            Goblin gob = new Goblin(30, 5, (rand.nextInt(size-2)+2), (rand.nextInt(size-2))+2);
            goblins.add(gob);
        }
        Land land = new Land(size, human, goblins);

        System.out.println("Use the N/S/E/W commands to move your character (0) around the map. When your character encounters a goblin (G) they will\n" +
                "fight it is defeated or you die. Kill all the goblins to win.");
        System.out.println(land.toString());
        while(!win){
            human.move(land);
            System.out.println(land.toString());

            //check for nearby goblins
            for(int i = 0; i < gobs; i++){
                Goblin adjGoblin = goblins.get(i);

                //If there are adjacent goblins, initiate combat
                if(human.isAdjacent(adjGoblin)){

                    //Combat - human attacks goblin, if goblin lives it attacks human, loop until one is dead
                    while (human.getHealth() > 0 && adjGoblin.getHealth() > 0){
                        human.attack(adjGoblin);
                        if (adjGoblin.getHealth() > 0){
                            adjGoblin.attack(human);
                        } else {
                            //if goblin is dead remove it from goblins array
                            goblins.remove(i);
                            gobs--;
                            i=0;
                        }
                    }
                    //print human's remaining health
                    System.out.println("Current Health: " + human.getHealth());
                    //print updated map after combat ends
                    System.out.println(land.toString());
                }
            }

            //checks if any of the goblins are still alive, and if not, the player has won
            win = true;
            for (int i = 0; i < gobs; i++){
                if(goblins.get(i).getHealth() >0){
                    win = false;
                    break;
                }
            }
            if(win){
                System.out.println("All the goblins have been exterminated, you win!");
            }
        }
    }
}
