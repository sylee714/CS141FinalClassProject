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
 * This class represents a Player. It extends GameEntity class and it uses a
 * super constructor to assign initial values of front, back, row, column of the
 * Player. It also has attributes and behaviors such as life, bullet, attack,
 * detect enemies, get damaged.
 * 
 * @author Seungyun
 *
 */
public class Player extends GameEntity implements Serializable {

	/**
	 * This is serialVersionUID for Player.
	 */
	private static final long serialVersionUID = -2119382567041410642L;

	/**
	 * A super constructor for the class. It allows to set initial values for
	 * front, back, row, column.
	 */
	public Player() {
		super("P", "P", 0, 0);

	}

	/**
	 * This field represents the initial life points that player will start
	 * with, which is 3.
	 */
	private int life = 3;

	/**
	 * This field represent the bullet. The player starts with one bullet. The
	 * maximum is 1.
	 */
	private int bullet = 1;

	/**
	 * This field represents whether or not the player can attack, if the player
	 * has a bullet = true; otherwise, false.
	 */
	private boolean attack = true;

	/**
	 * This field indicates if an enemy is detected.
	 */
	private boolean dangerAhead = false;

	/**
	 * This method returns the value of dangerAhead, either true or false.
	 * 
	 * @return the value of dangerAhead, either true or false
	 */
	public boolean isDangerAhead() {

		return dangerAhead;

	}

	/**
	 * This method sets the value of dangerAhead, either true or false.
	 * 
	 * @param dangerAhead
	 *            set the value of dangerAhead, either true or false
	 */
	public void setDangerAhead(boolean dangerAhead) {

		this.dangerAhead = dangerAhead;

	}

	/**
	 * This method returns the number of life that player has.
	 * 
	 * @return the life points the player has
	 */
	public int getLife() {

		return life;

	}

	/**
	 * This method returns the number of bullet the player has.
	 * 
	 * @return the number of bullet the player has
	 */
	public int getBullet() {

		return bullet;

	}

	/**
	 * This method sets the value of bullet. The maximum is 1.
	 * 
	 * @param bullet
	 *            set the number of bullet
	 */
	public void setBullet(int bullet) {

		this.bullet = bullet;

	}

	/**
	 * This method returns the value of attack, either true or false. True means
	 * the player has a bullet and false means the player has no bullet.
	 * 
	 * @return the value of attack, either true or false
	 */
	public boolean isAttack() {

		return attack;

	}

	/**
	 * This method sets the value of attack, either true or false.
	 * 
	 * @param attack
	 *            set the value of attack, either true or false
	 */
	public void setAttack(boolean attack) {

		this.attack = attack;

	}

	/**
	 * This method indicates if player got attacked by an enemy. If it did, it
	 * will lose 1 life point.
	 */
	public void gotDamaged() {

		life -= 1;

	}

}
