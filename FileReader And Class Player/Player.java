/**
 * @(#)Player.java
 *
 *
 * @author 
 * @version 1.00 2018/4/25
 */


public class Player {
	private String userName;
	private int chances = 5;

	
    public Player() {
    }
    
    public void setUserName(){
    	this.userName = userName;
    }
    
    public void setChance(){
    	this.chances = chances;
    }
    
    
    public String getUserName(String userName){
    	return userName;
    }
    
    public int getChances(int chances){
    	return chances;
    }
    
}