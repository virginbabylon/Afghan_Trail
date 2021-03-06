/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import java.util.Scanner;

/**
 *
 * @author jonsi
 */
public class BasicMenu {
    
    /*
        Properties
    */
    public static String invalidOptionMsg = "INVALID COMMAND, TRY AGAIN";
    public String[] options = {
        "Start Game",
        "Load Game",
        "Exit",
        "Guide"
    }; 
    final private char[] keys = {'W', 'A', 'S', 'D', 'Q', 'E', 'Z','X','C'};
    private String optionsString;   
    

   
    

    /*
        Getters and Setters
    */

    public String[] getOptions() {
        return options;
    }

    public void setOptionsString(String optionsString) {
        this.optionsString = optionsString;
    }
    
    private String buildOptionsString(String[] options){

        String optionsString = "";
        for (int i = 0; i < options.length; i++){
            String line = "  " + keys[i] + " - " + options[i] + "\n";
            optionsString += line;
        }
        optionsString += "  >";
        return optionsString;
    }
        
    public String getOptionsString(){
        return this.optionsString;
    }
    
    /*
        Methods
    */


    
    public static char getUserChar(String optionsString){
        System.out.println(optionsString);
        Scanner inFile;
        inFile = new Scanner(System.in);
        char userChar;
        boolean wasORd = false;
        do {
            userChar = inFile.next().charAt(0);
            userChar = Character.toLowerCase(userChar);
            if (userChar == 'w' || 
                userChar == 'a' || 
                userChar == 's' || 
                userChar == 'd')
                wasORd = true;
            else
                System.out.println(invalidOptionMsg);
        } while (!wasORd);
        return userChar;
    }
    
    public char getUserChar(String[] options){
        int numOfOptions = options.length;
        String menuString = buildOptionsString(options);
        System.out.println(menuString);
        Scanner inFile;
        inFile = new Scanner(System.in);
        char userChar;
        boolean validChar = false;
        do {
            userChar = inFile.next().charAt(0);
            validChar = validateUserChar(numOfOptions, userChar);
            if (!validChar)
                System.out.println(invalidOptionMsg);
        } while (!validChar);
        return userChar;
    }
    
    private boolean validateUserChar(int numberOfOptions, char userChar){
        userChar = Character.toUpperCase(userChar);
        for (int i = 0; i < numberOfOptions; i++){
            if (userChar == keys[i])
                return true;
        }
        return false;
    }
    
    public static String getUserString(String prompt){
        System.out.println(prompt);
        Scanner inFile;
        inFile = new Scanner(System.in);
        String userString;
        boolean goodString = true;
        do {
            userString = inFile.nextLine();
            userString = userString.trim();
        } while (!goodString);
        return userString;
    }
}
