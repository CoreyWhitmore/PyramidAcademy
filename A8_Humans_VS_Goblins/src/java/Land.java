import java.util.ArrayList;
import java.util.Random;

public class Land {
    private final int size;
    private Human human;
    private ArrayList<Goblin> goblins;
    //default constructor
    public Land(){
        this.size = 5;
        human = new Human();
        goblins = new ArrayList<>();
        goblins.add(new Goblin(30,5,this.size-1,this.size-1));
    }

    //parameterized Constructor
    public Land(int size, Human human, ArrayList<Goblin> goblins){
        this.size = size;
        this.human = human;
        this.goblins = goblins;
    }

    // Creates a text-based map that includes the location of the player and all the goblins
    public String toString(){
        String output = "";
        String locationSymbol;
        for (int y = 0; y < this.size; y++){
            for (int x = 0; x < this.size; x++){
                locationSymbol = " * ";
                if(human.getXPos() == x && human.getYPos() == y){
                    locationSymbol = " 0 ";
                }
                for (Goblin goblin : goblins) {
                    if (goblin.getXPos() == x && goblin.getYPos() == y) {
                        locationSymbol = " G ";
                    }
                }
                output += locationSymbol;
            }
            output += "\n";
        }
        return output;
    }

    public int getSize(){
        return this.size;
    }

}
