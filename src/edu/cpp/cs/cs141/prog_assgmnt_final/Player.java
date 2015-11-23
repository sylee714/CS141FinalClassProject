/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 *
 */
public class Player extends GameEntity {

	
	private Gun gun = new Gun();

	public Player() {
		super("P", "P", 0, 0);
		
	}

	/**
	 * This field represents the initial life points that player will start
	 * with.
	 */
	
	private int life = 3;


	/**
	 * This field represents if player is got attacked by an enemy.
	 */
	private boolean underAttack = true;

	/**
	 * This field represents if player picked up radar power-up or not.
	 */
	private boolean radar = false;
	
	
	/**
	 * This field represents if player picked up invincible power-up or not.
	 */
	
	private boolean invincible = false;
	

	//Set methods for life and powerups
	public int setLife(life)
	{
		playerLife = life;
		return playerLife;
	}
	
	public boolean setRadar(radar)
	{
		playerRadar = radar;
		return playerRadar;
	}
	
	public boolean setinvincible(invincible)
	{
		playerInvincibile = invincible;
		return playerInvincibile;
	}
	
	/**
	 * This field indicates if an enemy is detected.
	 */
	private boolean detected = false;

	/**
	 * This method is attacking method
	 * 
	 * @return
	 */
	public void attack() {
		
	}

	/**
	 * This method is looking method which enables the player to look two-tiles
	 * ahead of him/her.
	 */
	public void look(int direction) {
		switch(direction) {
		//up
		case 1:
			break;
		//down
		case 2:
			break;
		//right
		case 3:
			break;
		//left
		case 4:
			break;
		}
	}


	/**
	 * This method indicates if player got attacked by an enemy. If it did, it
	 * will lose 1 life point.
	 */
	public void gotDamaged() {
		if (underAttack) {
			life -= 1;
		}
	}

	/**
	 * This method is picking up power-ups.
	 */
	public void pickPowerUp() {

	}

	/**
	 * This method is using power-ups.
	 */
	public void usePowerUp() {

	}

	/**
	 * When player finds the brief case, picking up method will pick up the
	 * brief case.
	 */
	public void pickUpBriefCase() {

	}

	/**
	 * @return the life
	 */
	public int getLife() {
		return life;
	}

	/**
	 * @param life
	 *            the life to set
	 */
	public void setLife(int life) {
		this.life = life;
	}

}
