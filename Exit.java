/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dungeontester;

/**
 *
 * @author jeffr
 */
public class Exit extends Encounter
{
   // private DungeonCell empty;
   // private DungeonContainer heads;

    public Exit(String name) {
        super(name);
    }

    public String getname1() {
        return getN();
    }

    public String toString() {
        return getname1();
    }
    

}
