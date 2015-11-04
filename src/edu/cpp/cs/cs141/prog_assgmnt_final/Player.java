/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 *
 */
public class Player {
	
	/**
	 * This field represents the initial life points
	 * that player will start with. 
	 */
	private int life = 3;
	
	/**
	 * This field represents spaces that player can store
	 * power-ups.
	 */
	private int storage; 
	
	/**
	 * This field represents if player is got attacked by an enemy. 
	 */
	private boolean underAttack = false;
	
	/**
	 * This field represents if player picked up radar power-up or not.
	 */
	private boolean radar = false;
	
	/**
	 * This field represents if player picked up invincible power-up or not. 
	 */
	private boolean invincible = false;
	
	/**
	 * This method decides the starting point of the player.
	 * @param index number of row
	 * @param index number of column
	 */
	public void location(int row, int column) {
		
	}
	
	/**
	 * This method is attacking method
	 * @return
	 */
	public boolean attacking() {
		return false;
	}
	
	/**
	 * This method is looking method which enables the player 
	 * to look two-tiles ahead of him/her.
	 * @return
	 */
	public boolean looking() {
		return false;
	}
	
	/**
	 * This method is moving method. 
	 * Up, down, right, and left only.
	 * @param movement
	 * @return
	 */
	public int moving (int movement) {
		return 0; 
	}
	
	/**
	 * This method indicates if player got attacked by an enemy.
	 * If it did, it will lose 1 life point.
	 */
	public void gotAttacked() {
		if (underAttack) {
			life -= 1;
		}
	}

	/**
	 * This method is picking up power-ups.
	 */
	public void pickingPowerUp() {
		
	}
	
	/**
	 * This method is using power-ups.
	 */
	public void usingPowerUp() {
		
	}
	
	/**
	 * This method allows player to store radar and invincible
	 * power-ups.
	 */
	public void storingPowerUp() {
		
	}
	
	/**
	 * When player finds the brief case, picking up method will pick up the brief case.
	 */
	public void pickingUpBriefCase() {
		
	}
	
	/**
	 * If player gets attacked by an enemy, it goes back to its starting point.
	 */
	public void backToStartingPoint() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
