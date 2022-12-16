/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeontester;
import java.util.Random;
import java.util.ArrayList;
import java.lang.Class;
/**
 *
 * @author jeffr
 */
public class Encounter {

    //Character
    private String name;
    private int health;
    private int defense;
    private int exp;
    private int Atk;
    private int Speed;
    private int heroLevel;
    //goblin
    private GoblinEnemy goblin;
    private int ExperienceValue;

    public Encounter(String name) {
        this.name=name;
    }


    public int getDefence() {
        return defense;
    }

    public String getN() {
        return name;
    }

    public int getExp() {
        return exp;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return Speed;
    }

    public int getHeroLevel() {
        return heroLevel;
    }

    public int getAttack() {
        return Atk;
    }

}
