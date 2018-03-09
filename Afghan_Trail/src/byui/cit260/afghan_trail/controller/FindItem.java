/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
/**
 *
 * @author jonsi
 */
public class FindItem {
    public static void findItem(Player player){
        int typeInt = (int) Math.floor(Math.random() * 4);
        Item foundItem = player.generateRandomItem(typeInt);
        Inventory playerInv = player.getPlayerInventory();
        playerInv.addNewItem(foundItem);
        System.out.print("You found an Item!\n");
        System.out.print("Added " + foundItem.getName() + " to inventory\n");
    }
}
