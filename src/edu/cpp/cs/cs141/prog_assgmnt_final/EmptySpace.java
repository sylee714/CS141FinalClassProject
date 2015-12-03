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
 * This class represents an EmptySpace. It extends GameEntity class and it uses
 * a super constructor to assign initial values of front, back, row,
 * column of the EmptySpace.
 * 
 * @author Seungyun
 * 
 */
public class EmptySpace extends GameEntity implements Serializable {

	/**
	 * This is serialVersionUID for EmptySpace
	 */
	private static final long serialVersionUID = 5033841286165565168L;

	/**
	 * A super constructor for the class. It allows to set initial values for
	 * front, back, row, column.
	 */
	public EmptySpace() {

		super(" ", "*", 0, 0);

	}

}
