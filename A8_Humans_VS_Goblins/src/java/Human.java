import java.util.Scanner;
import java.util.Random;

public class Human {
    private final Scanner in = new Scanner(System.in);
    private final Random rand = new Random();
    private int health;
    private int strength;
    private int xPos;
    private int yPos;

    //Default constructor with default stats
    public Human(){
        this.health = 100;
        this.strength = 20;
        this.xPos = 0;
        this.yPos = 0;
    }

    //parameterized constructor
    public Human(int health, int strength, int xPos, int yPos){
        this.health = health;
        this.strength = strength;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void move(Land land){
        char moveChoice;
        System.out.println("Which direction to move?");
        try{
            moveChoice = in.nextLine().charAt(0);
            switch (Character.toLowerCase(moveChoice)){
                case 'n':
                    if(this.yPos > 0){
                        this.yPos--;
                    } else{
                        System.out.println("You can't move off the map");
                        move(land);
                    }
                    break;
                case 's':
                    if(this.yPos < land.getSize()){
                        this.yPos++;
                    } else{
                        System.out.println("You can't move off the map");
                        move(land);
                    }
                    break;
                case 'e':
                    if(this.xPos < land.getSize()){
                        this.xPos++;
                    } else{
                        System.out.println("You can't move off the map");
                        move(land);
                    }
                    break;
                case 'w':
                    if(this.xPos > 0){
                        this.xPos--;
                    } else{
                        System.out.println("You can't move off the map");
                        move(land);
                    }
                    break;
                default:
                    System.out.println("Error: Invalid input, please use N, S, E, or W for movement");
                    move(land);
                    break;
        }

        }
        catch (Exception e){
            System.out.println("Error: Invalid input, please use N, S, E, or W for movement");
            move(land);
        }

    }

    public void attack(Goblin goblin){
        int damage = (this.strength * rand.nextInt(10))/10;
        goblin.setHealth(goblin.getHealth() - damage);
        System.out.println("You attacked the goblin and did " + damage + " damage");
        if(goblin.getHealth() <= 0){
            System.out.println("You killed the goblin");
        }
    }

    public boolean isAdjacent(Goblin goblin){
        //if goblin has same y pos and +/- 1 x pos they are adjacent
        if(goblin.getYPos() == yPos && (goblin.getXPos() == xPos + 1 || goblin.getXPos() == xPos - 1) ){
            return true;
        }
        //if goblin has same x pos and +/- 1 y pos they are adjacent
        if(goblin.getXPos() == xPos && (goblin.getYPos() == yPos + 1 || goblin.getYPos() == yPos - 1) ){
            return true;
        }
        //if they occupy the same space they are adjacent
        if(goblin.getXPos() == xPos && goblin.getYPos() == yPos){
            return true;
        }
        //if neither they are not adjacent
        return false;
    }

    // Getters and setters
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int health){
        this.health = health;
    }

    public int getStrength(){
        return this.strength;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }

    public int getXPos(){
        return this.xPos;
    }
    public void setXPos(int xPos){
        this.xPos = xPos;
    }

    public int getYPos(){
        return this.yPos;
    }
    public void setYPos(int yPos){
        this.yPos = yPos;
    }
}
