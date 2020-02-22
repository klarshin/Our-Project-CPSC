/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpscproject;

/**
 *
 * @author klarshin
 */
public class Player {
    
    private Location playerLocation;
    private int playerHealth;
    private int playerDamage;
    private Collectible inventory;
    
    public Player(Location aLocation){
        this.playerLocation = new Location(aLocation);
        this.playerHealth = 50;
        this.playerDamage = 5;
        this.inventory = new Collectible();
    }
    
    public Location getLocation(){
        return new Location(this.playerLocation);
    }
    
    public void moveUp(Map aMap){
        if(aMap.isValidMove(new Location(playerLocation.getX(), playerLocation.getY() - 1))){
            playerLocation.setY(playerLocation.getY() - 1);
            aMap.replaceElement(new Location(playerLocation.getX(), playerLocation.getY() + 1), ' ');
        }
        
    }
    
    public void moveLeft(Map aMap){
        if(aMap.isValidMove(new Location(playerLocation.getX() - 1, playerLocation.getY()))){
            playerLocation.setX(playerLocation.getX() - 1);
            aMap.replaceElement(new Location(playerLocation.getX() + 1, playerLocation.getY()), ' ');
        }
        
    }
    
    public void moveDown(Map aMap){
        if(aMap.isValidMove(new Location(playerLocation.getX(), playerLocation.getY() + 1))){
            playerLocation.setY(playerLocation.getY() + 1);
            aMap.replaceElement(new Location(playerLocation.getX(), playerLocation.getY() - 1), ' ');
        }
        
    }
    
    public void moveRight(Map aMap){
        if(aMap.isValidMove(new Location(playerLocation.getX() + 1, playerLocation.getY()))){
            playerLocation.setX(playerLocation.getX() + 1);
            aMap.replaceElement(new Location(playerLocation.getX() - 1, playerLocation.getY()), ' ');
        }
        
    }
    
    public void addHealth(int healthToAdd){
        
        int tempHealth = this.playerHealth + healthToAdd;
        if(tempHealth > 100){
            this.playerHealth = 100;
        } else {
            this.playerHealth = tempHealth;
        }
        
    }
    
    public int getHealth(){
        return this.playerHealth;
    }
    
    public void attack(Enemy anEnemy){
        anEnemy.getDamaged(this.playerDamage);
    }
    
    public void getDamage(Enemy anEnemy){
        this.playerHealth -= anEnemy.doesDamage();
    }
    
    public void increaseAttack(int attackToAdd){
        this.playerDamage += attackToAdd;
    }
    
}