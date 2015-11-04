/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 *
 */
public class Enemy extends GameObject {
	
	/**
	 * Life point of an enemy.
	 */
	private int life = 1;
	
	/**
	 * This field indicates if an enemy found the player.
	 */
	private boolean detected = false;
	
	/**
	 * This field represents the status of an enemy.
	 */
	private boolean alive = true;
	
	/**
	 * Initial spawn point of an enemy.
	 */
	public void location() {
		
	}
	
	/**
	 * This moving method will make an enemy to move randomly.
	 * @param movement
	 * @return
	 */
	public int moving (int movement) {
		return 0; 
	}
	
	/**
	 * This method attacks player if the player is located an adjacent tile.
	 */
	public void attacking(){
		
	}
	
	/**
	 * If an enemy gets a shot by player, it dies.
	 */
	public void gotShot() {
		life -= 1;
		alive = false;
	}
	
	/**
	 * This method will check if player is next to enemy's tile.
	 */
	public void detectingPlayer() {
		
	}
	
	public void cannotEnterRoom() {
		
	}

}
