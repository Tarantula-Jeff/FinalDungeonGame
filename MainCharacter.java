/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeontester;

/**
 *
 * @author jeffr
 */
public class MainCharacter extends Encounter {

    private String name;
    private int heroLevel;
    private int attack;
    private int speed;
    private int health;
    private int defence;
    private int exp;
    private DungeonContainer heads;
    private String stats;
    private int maxLife;
    


    public MainCharacter(String name) {
        super(name);
        
       this.heroLevel = 1;
        this.health = 30;
        this.attack = 15;
        this.speed = 50;
        this.defence = 30;
        this.maxLife = 150;
        this.exp = 1;  

    }
//     public void getStats()
//    {
//      System.out.print("Your Stats are: ");
//      System.out.print("Level: " + heroLevel);
//      System.out.println("Health: " + health);
//      System.out.println("Speed: " + speed);
//      System.out.println("Defense: " + defence);
//      System.out.println("Attack: " +attack);
//      System.out.println("Experience: " +exp);
//    }
    
     public void setStats(int atk, int spd, int dfn, int hlth)
    {
        setAttack(atk);
        setSpeed(spd);
        setDefense(dfn);
        gainLife(hlth);
        
    }

    public String getStats()
    {
        return this.stats = String.join(System.getProperty("line.separator"),
        "Your Stats are: ",
        "Level: " + heroLevel + "",
        "Health: " + health + "",
        "Speed: " + speed +"",
        "Defense: " + defence+ "",
        "Attack: " +attack+ "",
        "Experience: " +exp+ "");
    }
    public int getDef() {
        return getDefence();
    }

    public String getNom() {
        return getN();
    }

    public String toString() {
        return getNom();
    }

    public int gethealth() {
        return getHealth();
    }

    public int getspeed() {
        return getSpeed();
    }

    public int getherolevel() {
        return getHeroLevel();
    }

    public int getexp() {
        return getExp();
    }

    public int getatk() {
        return getAttack();
    }
    
     public void setAttack(int atk)
    {
        this.attack += atk;
    }
      public void setLevel(int level)
    {
        this.heroLevel += level;
    }
     public void setDefense(int dfn)
    {
        this.defence += dfn;
    } 
     public void setHealth(int hlth)
    {
        this.health = hlth;
    }
      public void setSpeed(int spd)
    {
        this.speed += spd;
    }
      public void subtractDamage(int dmg)
    {
        this.health -= dmg;
        if (health == 0)
        {
            System.out.print("\nYOU DIED.\n");
            System.exit(0);
        }
    }
      public void increaseExperience(int incExp){
      this.exp += incExp;
      }
       public void gainLife(int lifeGain)
    {
        // put your code here
        this.health += lifeGain;
        
        if (health >= maxLife)
        {
            this.health = maxLife;
        }
        
    }
   
}
