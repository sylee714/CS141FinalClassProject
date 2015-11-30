/**
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment Final (Group Project)
 *
 *  Text-based game in which the player is located on a 9x9 grid unable to see anything,
 *  but where the player is located. The objective is to find a briefcase located 
 *  within one of 9 rooms located throughout the grid. The caveat, there are 6 enemies
 *  located throughout the grid that can kill the player if the two meet. There are 3 power
 *  ups scattered across the board that will aid the player in finding the brief case: 
 *  additional bullet, radar, and invisibility. The additional bullet will refill the player's 
 *  one-shot gun in the event it was shot earlier. The radar power up will located the 
 *  briefcase and disclose the location to the player. Invincibility will make the player 
 *  immune to all enemy attacks up to five turns. Keep in mind, the player has no storage
 *  so none of the power ups can be stored for later use. The player has 3 lives before
 *  game over. A load and save option is available for convenience.
 *
 * Team Liquid 
 *   <Anthony Vu, Victor Darkes, Seungyun Lee, Jeffrey Lee>
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.io.Serializable;

/**
 * @author Seungyun
 *
 */
public class Player extends GameEntity implements Serializable{

	//private Gun gun = new Gun();

	public Player() {
		super("P", "P", 0, 0);
		
	}

	/**
	 * This field represents the initial life points that player will start
	 * with.
	 */
	private int life = 3;
	
	private int bullet = 1;

	/**
	 * This field represents if player is got attacked by an enemy.
	 */
	private boolean underAttack = true;

	private boolean attack = true;
	
	/**
	 * This field indicates if an enemy is detected.
	 */
	private boolean dangerAhead = false;

	/**
	 * @return the dangerAhead
	 */
	public boolean isDangerAhead() {
		return dangerAhead;
	}

	/**
	 * @param dangerAhead the dangerAhead to set
	 */
	public void setDangerAhead(boolean dangerAhead) {
		this.dangerAhead = dangerAhead;
	}


	/**
	 * This method indicates if player got attacked by an enemy. If it did, it
	 * will lose 1 life point.
	 */
	public void gotDamaged() {
		
			life -= 1;
		
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

	/**
	 * @return the bullet
	 */
	public int getBullet() {
		return bullet;
	}

	/**
	 * @param bullet the bullet to set
	 */
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}

	/**
	 * @return the attack
	 */
	public boolean isAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(boolean attack) {
		this.attack = attack;
	}
	
	
	
	

}
