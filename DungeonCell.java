/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeontester;

/**
 *
 * @author jeffr
 */
public class DungeonCell<E> {

    E val;
    private DungeonCell next;
    DungeonCell prev;

    public DungeonCell(E val) {
        this.val = val;
        this.next = null;
        this.prev = null;

    }

    public DungeonCell(E val, DungeonCell prevCell, DungeonCell nextCell) {
        this.val = val;
        this.next = nextCell;
        this.prev = prevCell;
    }


    public void setVal(E Val) {
        this.val = val;
    }

    public E getVal() {
        return this.val;
    }

    public DungeonCell getNext() {
        return this.next;
    }

    public void setNext(DungeonCell nextCell) {
        this.next = nextCell;
    }

    public DungeonCell getPrevious() {
        return this.prev;
    }

    public void setPrevious(DungeonCell previousCell) {
        this.prev = previousCell;
    }


}
