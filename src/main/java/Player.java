/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Player {
    private String firstName;
    private String lastName;
    private int offense;
    private int defense;

    public Player(String firstName, String lastName, int offense, int defense) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.offense = offense;
        this.defense = defense;
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getOffense() {
        return offense;
    }

    public void setOffense(int offense) {
        this.offense = offense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    public int getOverall(Player obj) {
        int overall;
        overall = (int) Math.ceil((float)(obj.getOffense() + obj.getDefense()) / 2);
        return overall;
    }
    
    public String ToString(Player obj) {
        return "First name: " + obj.getFirstName() + "; Last name: " + obj.getLastName() + "; Overall: " + obj.getOverall(obj);
    }
}
