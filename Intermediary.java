/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeontester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.lang.Class;
import java.util.Arrays;

/**
 *
 * @author jeffr
 */
public class Intermediary {

    private int levelNumber;
    private ArrayList<Encounter> encounter;
    private MainCharacter player;
    Scanner scanner;
    private DungeonContainer dC;
    private char z;
    private ArrayList<Item> inventory;

    public ArrayList<Encounter> getEncounter() {
        return encounter;
    }

    public Intermediary() {
        this.scanner = new Scanner(System.in);
        this.player = new MainCharacter("You");
    }

    public void introduction() {
        System.out.println("WELCOME TO THE DUNGEON OF TERROR!\n");
        System.out.println("Please enter the size of your dungeon: ");
        int input = scanner.nextInt();
        System.out.println("Dungeon of " + input + " rooms awaits you! You will face many enemies!");
        insideDungeon(input);
    }

    public void gameMenu() {
        while (true) {
            //introduction();
            System.out.println();
            System.out.println("    ____Menu____  ");
            System.out.println("A - Show Position");
            System.out.println("B - Show inventory");
            System.out.println("C - Show stats");
            System.out.println("D - Move");
            System.out.println("E - Exit Options");
            System.out.println("X - End Game");

            this.z = this.scanner.next().charAt(0);

            this.getEncounter();
            this.menuInput(z);
        }

    }

    public char menuInput(char z) {
        if (Character.toLowerCase(z) == 'a') {
            this.dC.displayDungeon();
        } else if (Character.toLowerCase(z) == 'b') {
            this.inventoryMenu();
        } else if (Character.toLowerCase(z) == 'c') {
            this.printStats();
        } else if (Character.toLowerCase(z) == 'd') {
            this.movePlayer();
        } else if (Character.toLowerCase(z) == 'e') {
            this.getExit();
        } else if (Character.toLowerCase(z) == 'x') {
            this.end();
        } else {
            System.out.println("Invalid Selection");
        }
        return this.z;
    }

    public void end() {
        System.out.print("\nGAME OVER\n");
        System.exit(0);
    }

    public boolean movePlayer() {
        boolean movement = false;
        while (!movement) {
            System.out.print("Please enter L or R to move left or right.");
            this.z = this.scanner.next().charAt(0);
            if (Character.toLowerCase(z) == 'l') {
                this.dC.movePlayerLeft();
                movement = true;
            } else if (Character.toLowerCase(z) == 'r') {
                this.dC.moveMainCharacterRight();
                movement = true;
            } else {
                System.out.println("Invalid input");

            }
        }
        return movement;
    }

    public int insideDungeon(int input) {
        levelNumber++;
        DungeonContainer<Encounter> dC = new DungeonContainer<>();
        this.encounter = new ArrayList<>();
        encounter.add(this.player);
        encounter.add(new Exit("Exit Door"));

        String[] monsters = {"Goblin", "Stone Goles", "RobotMenachem-Monster",
            "AirHead Monster", "Axe", "ShitMonster", "DSA-Monster"};

        Random rand = new Random();

        while (encounter.size() < input) {
            int i = rand.nextInt(monsters.length);
            if (i < 4) {
                encounter.add(new GoblinEnemy(monsters[i]));
            } else {
                encounter.add(new Item(monsters[i]));
            }
            Collections.shuffle(encounter);
        }
        this.dC = dC;
        ArrayList<Encounter> game = this.getEncounter();
        for (Encounter room : game) {
            dC.insert(room);

        }
        dC.displayDungeon();

        return levelNumber;
    }
//This shows from player to exit

    public void getExit() {
        int exitLocation = this.dC.exitPosition();
        int playerLocation = this.dC.mainCharacterPos();
        int exitDistance = Math.abs(exitLocation - playerLocation);

        System.out.println("Have you grown weary of this torment?");
        System.out.println("If you would like to exit, enter 'e'.");
        System.out.println("If you would like to see the distance to the exit, enter 'y'.");
        char z = this.scanner.next().charAt(0);

        if (Character.toLowerCase(z) == 'y') {

            if (exitDistance > this.encounter.size() / 2) {
                exitDistance = this.encounter.size() - exitDistance;
            }
            System.out.println("The exit is ");
            if (exitDistance == 1) {
                System.out.print("next to you!");
            } else {
                System.out.print(exitDistance + " rooms away.");
            }

        } else if (Character.toLowerCase(z) == 'e') {

            moveToExit();

        } else {
            System.out.println("Please try again");
        }

    }

    public void inventoryMenu() {
        System.out.println("Inventory: " + this.dC.getInventory());
    }

    public void moveToExit() {
        System.out.println();
        System.out.println();
        System.out.println("Beware, adventurer! What awaits you is not kind...");
        System.out.println("Welcome to level " + (this.levelNumber + 1) + "!");
        System.out.println("The deeper you go, the harder you must fight.");
        this.insideDungeon(this.encounter.size() * 2);
    }

    public void printStats() {
        System.out.println(player.getStats());
    }
//Alternate printing method

    public void prin() {
        this.dC = dC;
        ArrayList<Encounter> game = this.getEncounter();
        for (Encounter room : game) {
            dC.insert(room);

        }
        System.out.println(game);

    }

}
