/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;

/**
 *
 * @author rizky
 */
public class Banker extends Player{

    private int stats[] = {5,5,5,5};
    
    public Banker() {
        super("Warren", 10, "Banker");
        generateInventory(stats);
    }

    public Banker(String name) {
        super(name, 10, "Banker");
        generateInventory(stats);
    }
    
}
