/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.controller.Game;
import byui.cit260.afghan_trail.model.Player;
import java.util.Scanner;

/**
 *
 * @author jonsi
 */
public abstract class BasicView implements BasicViewInterface {
    
    String[] options = {}; 
    String message;
    
    BasicView(){}
    BasicView(String options[], String message){
        this.options = options;
        this.message = message;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
    public void doAction(String[] options, char action, Game game, Player player){};
    
    
    public void display(Game game, Player player) {
        String optionsString = buildOptionsString(options);
        System.out.println(message + '\n');
      
        
        char userInput = 'a';
        do {
            if (userInput == 'd')
                this.displayHelp();
            userInput = getUserChar(optionsString);
        } while (userInput == 'd');
        
        doAction(options, userInput, game, player);
    }
    
    public void display(){
        String optionsString = buildOptionsString(options);
        System.out.println(message + '\n');
        
        char userInput = getUserChar(optionsString);
        while (userInput == 'd') {
            this.displayHelp();
            userInput = getUserChar(optionsString);
        };
        
        doAction(options, userInput, null, null); 
    }
    
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
                System.out.println("INVALID COMMAND, TRY AGAIN");
        } while (!wasORd);
        return userChar;
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
    
    public static char getUserChar(String[] options){
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
                System.out.println("INVALID COMMAND, TRY AGAIN");
        } while (!validChar);
        return userChar;
    }
    
    private static boolean validateUserChar(int numberOfOptions, char userChar){
        char[] keys = {'W', 'A', 'S', 'D', 'Q', 'E', 'Z','X','C'};
        userChar = Character.toUpperCase(userChar);
        for (int i = 0; i < numberOfOptions; i++){
            if (userChar == keys[i])
                return true;
        }
        return false;
    }
    
    protected static String buildOptionsString(String[] options){
        char[] keys = {'W', 'A', 'S', 'D', 'Q', 'E', 'Z','X','C'};
        assert(keys.length == options.length);
        String optionsString = "";
        for (int i = 0; i < options.length; i++){
            String line = keys[i] + " - " + options[i] + "\n";
            optionsString += line;
        }
        optionsString += ">>>";
        return optionsString;
    }
}
