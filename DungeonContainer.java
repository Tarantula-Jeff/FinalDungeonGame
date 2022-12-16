/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeontester;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jeffr
 */
public class DungeonContainer<E> {

    private DungeonCell<E> head;
    private DungeonCell<E> tail;
    private int size;
    private Iterator movement;
    private ArrayList<Encounter> encounter;
    private ArrayList<Item> inventory;
    private int[] inventorystats;
    private String[] statStrings;
    private int playerLocation;
    private char z;
    private final Scanner scanner;

    public DungeonContainer() {
        this.head = null;
        this.tail = null;
        this.scanner = new Scanner(System.in);
        this.inventory = new ArrayList<>();
        this.inventorystats = new int[4];
    }

    public void insert(E val) {
        DungeonCell temp = new DungeonCell(val, null, null);
        if (head == null) {
            temp.setNext(temp);
            temp.setPrevious(temp);
            head = temp;
            tail = head;
        } else {
            temp.setNext(head);
            temp.setPrevious(tail);
            tail.setNext(temp);
            tail = temp;
        }
        size++;

    }

    public DungeonCell getHead() {
        return head;
    }

    public int mainCharacterPos() {
        int location = 0;
        boolean state = false;
        DungeonCell temp = this.head;
        String name = temp.getVal().getClass().getSimpleName();
        while (temp != null) {
            {
                if (name.equals("MainCharacter")) {
                    state = true;
                    break;
                }
            }
            temp = temp.getNext();
            name = temp.getVal().getClass().getSimpleName();
            location++;
        }
        return location;
    }

    public int exitPosition() {
        int location = 0;
        boolean state = false;
        DungeonCell temp = this.head;
        String name = temp.getVal().getClass().getSimpleName();
        while (temp != null) {
            {
                if (name.equals("Exit")) {
                    state = true;
                    break;
                }
            }
            temp = temp.getNext();
            name = temp.getVal().getClass().getSimpleName();
            location++;
        }
        return location;

    }

    public void displayDungeon() {
        System.out.println();
        System.out.print("{() ");

        if (head == null) {

            System.out.println("This dungeon is empty");
            return;
        }

        DungeonCell temp = head;
        int location = mainCharacterPos();
        for (int i = 0; i < location; i++) {
            temp = temp.getNext();
        }
        for (int i = 0; i <= this.size / 2; i++) {
            temp = temp.getNext();
        }
        for (int i = 0; i < this.size; i++) {
            Encounter encounter = (Encounter) temp.getVal();
            System.out.print(encounter.getN());
            temp = temp.getNext();
            if (i < this.size - 1) {
                System.out.print("(--)");
            }
        }
        System.out.print(" ()} ");
        System.out.println();
    }

    public void moveMainCharacterRight() {
        DungeonCell temp = this.head;
        DungeonCell swapCell = this.head;

        int location = this.mainCharacterPos();
        int moveLocation = this.rightOfMainCharacter();

        for (int i = 0; i < location; i++) {
            temp = temp.getNext();

        }
        for (int i = 0; i < moveLocation; i++) {
            swapCell = swapCell.getNext();

        }

        if (swapCell.getVal().getClass().getSimpleName().equals("Item")) {
            Item inventoryitem = (Item) swapCell.getVal();
            System.out.println(inventoryitem.getName() + (" Available") + " .");
            System.out.print(" Pick up item?  Y/N .");
            this.z = this.scanner.next().charAt(0);
            if (Character.toLowerCase(z) == 'y') {
                MainCharacter p = (MainCharacter) temp.val;
                getItem(inventoryitem, p);
                swapCell.setVal(new Encounter("Empty Room"));
                Encounter tryout = (Encounter) swapCell.val;
                swapCell.val = temp.val;
                temp.val = tryout;
            } else {
                Encounter tryout = (Encounter) swapCell.val;
                swapCell.val = temp.val;
                temp.val = tryout;
            }
        } else if (swapCell.getVal().getClass().getSimpleName().equals("Enemy")) {

            GoblinEnemy e = (GoblinEnemy) swapCell.val;
            System.out.println();
            System.out.println("The " + e.getNom() + " has the following stats: ");
            e.getStats();
            System.out.println("Would you like to battle this enemy? Enter Y for yes or N for no.");
            this.z = this.scanner.next().charAt(0);
            if (Character.toLowerCase(z) == 'y') {
                MainCharacter p = (MainCharacter) temp.getVal();
                battle(p, e);
                if (e.getHealth() <= 0) {
                    swapCell.setVal(new Encounter("Empty Room"));
                    p.increaseExperience(1);
                    Encounter tryout = (Encounter) swapCell.val;
                    swapCell.val = temp.val;
                    temp.val = tryout;
                } else {
                    Encounter tryout = (Encounter) swapCell.val;
                    swapCell.val = temp.val;
                    temp.val = tryout;
                }
            } else {
                Encounter tryout = (Encounter) swapCell.val;
                swapCell.val = temp.val;
                temp.val = tryout;
            }
        } else {
            Encounter tryout = (Encounter) swapCell.val;
            swapCell.val = temp.val;
            temp.val = tryout;
        }
    }

    // move player left in the linked list
    public void movePlayerLeft() {
        DungeonCell temp = this.head;
        DungeonCell swapCell = this.head;

        int location = this.mainCharacterPos();
        int moveLocation = this.leftOfPlayer();

        for (int i = 0; i < location; i++) {
            temp = temp.getNext();

        }
        for (int i = 0; i < moveLocation; i++) {
            swapCell = swapCell.getNext();

        }

        if (swapCell.getVal().getClass().getSimpleName().equals("Item")) {
            Item inventoryitem = (Item) swapCell.val;
            System.out.println("This room contains a " + inventoryitem.getName() + " .");
            System.out.print("Pick up item? Enter Y/N .");
            this.z = this.scanner.next().charAt(0);
            if (Character.toLowerCase(z) == 'y') {
                MainCharacter p = (MainCharacter) temp.val;
                getItem(inventoryitem, p);
                swapCell.setVal(new Encounter("Empty Room"));
                Encounter tryout = (Encounter) temp.val;
                temp.val = swapCell.val;
                swapCell.val = tryout;
            } else {
                Encounter tryout = (Encounter) temp.val;
                temp.val = swapCell.val;
                swapCell.val = tryout;
            }
        } else if (swapCell.getVal().getClass().getSimpleName().equals("Enemy")) {
            GoblinEnemy e = (GoblinEnemy) swapCell.val;
            System.out.println();
            System.out.println("The " + e.getNom() + " has the following stats: ");
            e.getStats();
            System.out.println("Fight enemy? Enter Y/N");
            this.z = this.scanner.next().charAt(0);
            if (Character.toLowerCase(z) == 'y') {
                MainCharacter p = (MainCharacter) temp.val;
                battle(p, e);
                if (e.getHealth() <= 0) {
                    swapCell.setVal(new Encounter("Empty Room"));
                    p.increaseExperience(1);
                    Encounter tryout = (Encounter) temp.val;
                    temp.val = swapCell.val;
                    swapCell.val = tryout;
                } else {
                    Encounter tryout = (Encounter) temp.val;
                    temp.val = swapCell.val;
                    swapCell.val = tryout;
                }
            } else {
                Encounter tryout = (Encounter) temp.val;
                temp.val = swapCell.val;
                swapCell.val = tryout;
            }
        } else {
            Encounter tryout = (Encounter) temp.val;
            temp.val = swapCell.val;
            swapCell.val = tryout;
        }
    }

    // return index of cell to the right of player position
    public int rightOfMainCharacter() {
        int locationMove = 0;
        boolean flag = false;
        DungeonCell temp = this.head;

        while (temp != null) {
            if (temp.prev.getVal().getClass().getSimpleName().equals("MainCharacter")) {
                flag = true;
                break;
            }

            temp = temp.getNext();

            locationMove++;
        }
        return locationMove;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void exitLevel() {
        DungeonCell temp = this.head;
        DungeonCell swapCell = this.head;

        int position = this.mainCharacterPos();
        int moveLocation = this.exitPosition();
        for (int i = 0; i < position; i++) {
            temp = temp.getNext();
        }

        for (int i = 0; i < moveLocation; i++) {
            swapCell = swapCell.getNext();
        }
        temp.setVal(new Encounter("Empty Room"));
    }

    // returns data of cell in head position
    public E returnHead() {
        return head.getVal();
    }

    // returns data of cell in tail position
    public E returnTail() {
        return tail.getVal();
    }

    // return index of cell to the left of player position
    public int leftOfPlayer() {
        int locationMove = 0;
        boolean state = false;
        DungeonCell temp = this.head;

        while (temp != null) {
            if (temp.getNext().getVal().getClass().getSimpleName().equals("Player")) {
                state = true;
                break;
            }

            temp = temp.getNext();

            locationMove++;
        }
        return locationMove;
    }

    public boolean battle(MainCharacter p, GoblinEnemy e) {
        boolean state = false;
        int dmg = 0;
        while (!state) {
            if (e.getSpeed() > p.getSpeed()) {
                dmg = e.getAttack() - p.getDef();
                if (dmg > 0) {
                    p.subtractDamage(dmg);
                    state = true;
                    break;
                }
                state = true;
                break;
            } else {
                dmg = p.getAttack() - e.getDefense();
                if (dmg > 0) {
                    e.subtractDamage(dmg);
                    if (e.getHealth() <= 0) {
                        System.out.print("\n" + e.getNom() + " defeated! \n");
                        state = true;
                        break;
                    }
                    state = true;
                    break;
                }
                state = true;
                break;
            }
        }
        return state;

    }

    public void getItem(Item inventoryitem, MainCharacter p) {
        inventory.add(inventoryitem);
        System.out.println();
        System.out.println("The " + inventoryitem.getName() + " you picked up has the following stats: ");

        updateInventory(p, inventoryitem);

    }

    public boolean emptyCheck() {
        return head == null;
    }

    public void fightEnemyRight(GoblinEnemy e, MainCharacter p) {

        battle(p, e);
    }

    public void fightEnemyLeft(GoblinEnemy e, MainCharacter p) {

        System.out.println();
        System.out.println("The " + e.getN() + " has the following stats: ");
        e.getStats();

        battle(p, e);

    }

    public void updateInventory(MainCharacter p, Item i) {
        int atk;
        int spd;
        int dfn;
        int hlth;

        i = inventory.get(inventory.size() - 1);
        inventorystats[0] = atk = i.getAttack();
        inventorystats[1] = spd = i.getSpeed();
        inventorystats[2] = dfn = i.getD();
        inventorystats[3] = hlth = i.getHealth();
        p.setStats(inventorystats[0], inventorystats[1], inventorystats[2], inventorystats[3]);
        System.out.println("Attack bonus : " + atk + "\nSpeed bonus : " + spd + "\nDefense Bonus : " + dfn + "\nHealth Bonus : " + hlth);
    }
//Alternative to display Dungeon

    public void display() {
        DungeonCell cell = head;
        if (head != null) {
            do {
                System.out.print(cell.getVal() + "---");
                cell = cell.getNext();
            } while (cell != head);
            System.out.println();
        }
    }

}
