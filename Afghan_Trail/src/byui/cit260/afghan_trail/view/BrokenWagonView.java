/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.controller.BrokenWagon;
/**
 *
 * @author Brayden
 */
public class BrokenWagonView {

    public BrokenWagonView() {
        
    }
    
    public static void displayHelp(){
        //display event help for each event option
        System.out.print("Broken Wagon Help\n");
    }
   
    public static char display() {
        String[] options = {
            "Fix Wagon",
            "Ignore",
            "Rest",
            "Event Help"
        }; 
        BasicMenu brokenWagonMenu = new BasicMenu(
                "You're wagon is broken", 
                options
        );
        String optionString = brokenWagonMenu.getOptionsString();
        System.out.println(brokenWagonMenu.getMessage() + '\n');
        char userInput = BasicMenu.getUserChar(optionString);
        return userInput;
    }

    
    //TODO
    //ignore()
    //useMedicine()
    //rest()
}