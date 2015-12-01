/**
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #Final (Group Project)
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
 * This class represents a power-up called Invincibility. It extends GameEntity
 * class and it uses a super constructor to assign initial values of front,
 * back, row, column of the Invincibility.
 * 
 * @author Seungyun
 *
 */
public class Invincibility extends GameEntity implements Serializable {

	/**
	 * A super constructor for the class. It allows to set initial values for
	 * front, back, row, column.
	 */
	public Invincibility() {

		super("I", "*", 0, 0);

	}

	/**
	 * The player will be invincible for 5 turns. The initial value is 6 because
	 * as soon as the player consumes it, it goes down by 1.
	 */
	private int numberOfTurns = 6;

	/**
	 * This method returns how many invincible turns are left.
	 * 
	 * @return the numberOfTurns that the player is invincible
	 */
	public int getNumberOfTurns() {

		return numberOfTurns;

	}

	/**
	 * This method sets new value for the numberOfTurns field after the player
	 * takes a turn.
	 * 
	 * @param numberOfTurns
	 * 				The new value of numberOfTurns after the player consumes the
	 * 				invincibillity and takes a turn.
	 */
	public void setNumberOfTurns(int numberOfTurns) {

		this.numberOfTurns = numberOfTurns;

	}

	/**
	 * This method counts down the invincible turns.
	 */
	public void countingTurn() {

		numberOfTurns = numberOfTurns - 1;

	}

}
