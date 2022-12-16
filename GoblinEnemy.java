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
public class GoblinEnemy extends Encounter {

    private String name;
    private int health;
    private int defense;
    private int exp;
    private int Atk;
    private int Speed;
    private int heroLevel;
    private GoblinEnemy goblin;
    private int ExperienceValue;

    public GoblinEnemy(String name) {
        super(name);
        Random rand = new Random();
        int attackBoun = 50;
        Atk = rand.nextInt(attackBoun) + 30;
        this.Atk = Atk;
        int def = 30;
        defense = rand.nextInt(def) + 0;
        this.defense = defense;
        int spBounds = 50;
        Speed = rand.nextInt(spBounds) + 20;
        this.Speed = Speed;
        int lifeBounds = 20;
        health = rand.nextInt(lifeBounds) + 3;
        this.health = health;
    }

    public int getDefG() {
        return getDefence();
    }

    public void getStats() {
        //return this.stats = String.join(System.getProperty("line.separator"),
        System.out.print("Health: " + health);
        System.out.println("Speed: " + Speed);
        System.out.println("Defense: " + defense);
        System.out.println("Attack: " + Atk);
    }

    public void subtractDamage(int dmg) {
        this.health -= dmg;
    }

    public void g() {
        System.out.println(getDefG());
    }

    public String getNom() {
        return getN();
    }

    public String toString() {
        return getNom();
    }

    public int gethealthG() {
        return getHealth();
    }

    public int getspeedG() {
        return getSpeed();
    }

    public int getexpG() {
        return getExp();
    }

    public int getatkG() {
        return getAttack();
    }

    public int getDefense() {
        return defense;
    }

}
