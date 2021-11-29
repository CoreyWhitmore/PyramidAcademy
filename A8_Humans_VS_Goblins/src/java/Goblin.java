import java.util.Random;

public class Goblin {
    private final Random rand = new Random();
    private int health;
    private int strength;
    private int xPos;
    private int yPos;

    //Default constructor with default stats
    public Goblin(){
        this.health = 50;
        this.strength = 8;
        this.xPos = 0;
        this.yPos = 0;
    }

    //parameterized constructor
    public Goblin(int health, int strength, int xPos, int yPos){
        this.health = health;
        this.strength = strength;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void attack(Human human){
        int damage = (this.strength * rand.nextInt(10))/10;
        human.setHealth(human.getHealth() - damage);
        System.out.println("You were attacked by the goblin and took " + damage + " damage");
        if(human.getHealth() <=0){
            System.out.println("You have died");
        }
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
