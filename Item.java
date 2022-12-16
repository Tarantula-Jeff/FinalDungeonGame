/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeontester;

import java.util.Random;

/**
 *
 * @author jeffr
 */
public class Item extends Encounter {

    private String name;
    private int health;
    private int defense;
    private int exp;
    private int Atk;
    private int Speed;
    private int heroLevel;
    private int ExperienceValue;

    public Item(String name) {
        super(name);
    
    Random rand = new Random();
    int attackBoun = 50;
    Atk  = rand.nextInt(attackBoun) + 30;
     
    this.Atk  = Atk;
    int def = 30;
    defense  = rand.nextInt(def) + 0;
     
    this.defense  = defense;
    int spBounds = 50;
    Speed  = rand.nextInt(spBounds) + 20;
     
    this.Speed  = Speed;
    int lifeBounds = 20;
    health  = rand.nextInt(lifeBounds) + 3;
     
    this.health  = health;
    }
    public String toString() {
        return getN();
    }
     public int getAttack()
    {
        return Atk;
    }
    public int getD(){
    return defense; }
     public int getSpeed()
    {
        return Speed;
    }
    public int getHealth()
    {
        return health;
    }
    public String getName(){
    return name;
    }

}
