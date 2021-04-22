/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
import java.util.*;
public class Main {
    public static void main(String[] args) throws InvalidInputException{
        String firstName1 = "";
        String lastName1 = "";
        int offense1 = 0;
        int defense1 = 0;
        String firstName2 = "";
        String lastName2 = "";
        int offense2 = 0;
        int defense2 = 0;
        
        Scanner keyboard = new Scanner(System.in);
        Random RNG = new Random();
        
        System.out.println("1-on-1 basketball simulation");
        System.out.println("Press 'x' to create 2 players and have them play against eachother.");
        System.out.println("Alternatively, press 'o' to have 2 players randomly generated to play against eachother.");
      
        Player player1 = new Player (firstName1, lastName1, offense1, defense1);
        try {
            initializePlayer1(player1);
        }
        catch (InvalidInputException ex) {
            System.out.println("You entered something other than 'x' or 'o'");
            System.exit(0);
        }
        if (player1.getFirstName().equals("Player") && player1.getLastName().equals("1")) {
            firstName2 = "Player";
            lastName2 = "2";
            offense2 = RNG.nextInt(100 - 25) + 25;
            defense2 = RNG.nextInt(100 - 25) + 25;
        } else {
            System.out.println("Please enter the first name for the second player.");
            firstName2 = keyboard.nextLine();
            System.out.println("Please enter the last name for the second player.");
            lastName2 = keyboard.nextLine();
            System.out.println("Please enter the offensive rating for the second player. Note that this needs to be an integer between 25 and 99.");
            offense2 = keyboard.nextInt();
            System.out.println("Please enter the defensive rating for the second player. Note that this needs to be an integer between 25 and 99.");
            defense2 = keyboard.nextInt();
        }
        try {
           testPlayerStats(player1);
        }
        catch (InvalidStatException ex) {
            System.out.println("You entered an invalid stat for " + player1.getFirstName() + " " + player1.getLastName());
            System.exit(0);
        }
        Player player2 = new Player (firstName2, lastName2, offense2, defense2);
        try {
           testPlayerStats(player2);
        }
        catch (InvalidStatException ex) {
            System.out.println("You entered an invalid stat for " + player2.getFirstName() + " " + player2.getLastName());
            System.exit(0);
        }
        
        System.out.println("Player 1: " + player1.getFirstName() + " " + player1.getLastName() + " Overall: " + player1.getOverall(player1));
        System.out.println("Player 2: " + player2.getFirstName() + " " + player2.getLastName() + " Overall: " + player2.getOverall(player2));
        runSimulation(player1, player2);
    }
    public static void runSimulation(Player player1, Player player2) {
        int p1Score = 0;
        int p2Score = 0;
        int offenseRoll = 0;
        int defenseRoll = 0;
        Random RNG = new Random();
        
        while (p1Score < 21 && p2Score < 21) {
            offenseRoll = RNG.nextInt(player1.getOffense() + 1);
            defenseRoll = RNG.nextInt(player2.getDefense() + 1);
            if (offenseRoll > defenseRoll) {
                p1Score = p1Score + 1;
            }
            if (p1Score >= 21) {
                System.out.println(player1.getFirstName() + " " + player1.getLastName() + " wins " + p1Score + ", " + p2Score);
                break;
            }
            offenseRoll = RNG.nextInt(player2.getOffense() + 1);
            defenseRoll = RNG.nextInt(player1.getDefense() + 1);
            if (offenseRoll > defenseRoll) {
                p2Score = p2Score + 1;
            }
            System.out.println("Score: " + p1Score + ", " + p2Score);
            if (p2Score >= 21) {
                System.out.println(player2.getFirstName() + " " + player2.getLastName() + " wins " + p2Score + ", " + p1Score);
                break;
            }
        }
    }
    public static Player testPlayerStats (Player player) throws InvalidStatException{
        if (player.getOffense() < 25 || player.getOffense() > 99) {
            throw new InvalidStatException("The offensive rating you entered was invalid.");
        }
        if (player.getDefense() < 25 || player.getDefense() > 99) {
            throw new InvalidStatException("The defensive rating you entered was invalid.");
        }
        return player;
    }
    public static Player initializePlayer1 (Player player1) throws InvalidInputException {
        String firstName = "";
        String lastName = "";
        int offense = 0;
        int defense = 0;
        
        Scanner keyboard = new Scanner(System.in);
        Random RNG = new Random();
        
        String input = keyboard.nextLine();
        
        if (input.equalsIgnoreCase("x")) {
            System.out.println("Please enter the first name for the first player.");
            firstName = keyboard.nextLine();
            System.out.println("Please enter the last name for the first player.");
            lastName = keyboard.nextLine();
            System.out.println("Please enter the offensive rating for the first player. Note that this needs to be an integer between 25 and 99.");
            offense = keyboard.nextInt();
            System.out.println("Please enter the defensive rating for the first player. Note that this needs to be an integer between 25 and 99.");
            defense = keyboard.nextInt();
            } else if (input.equalsIgnoreCase("o")) {
            firstName = "Player";
            lastName = "1";
            offense = RNG.nextInt(100 - 25) + 25;
            defense = RNG.nextInt(100 - 25) + 25;
            } else {
            throw new InvalidInputException("Error. You entered something other than 'x' or 'o'.");
        }
        player1.setFirstName(firstName);
        player1.setLastName(lastName);
        player1.setOffense(offense);
        player1.setDefense(defense);
        return player1;
    }
}
