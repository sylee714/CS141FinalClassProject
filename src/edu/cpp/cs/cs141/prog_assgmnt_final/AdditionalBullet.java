/**
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #Final (Group Project)
 *
 * <description-of-assignment>
 *
 * Team Liquid 
 *   <Anthony Vu, Victor Darkes, Seungyun Lee, Jeffrey Lee>
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.io.Serializable;

/**
 * 
 * This class represents a power-up called AdditionalBullet. It extends
 * GameEntity class and it uses a super constructor to assign initial values of
 * front, back, row, column of the AdditionalBullet.
 * 
 * @author Seungyun
 * 
 */
public class AdditionalBullet extends GameEntity implements Serializable {

	/**
	 * 
	 * A super constructor for the class. It allows to set initial values for
	 * front, back, row, column.
	 * 
	 * @author Seungyun
	 * 
	 */
	public AdditionalBullet() {

		super("A", "*", 0, 0);

	}

	/**
	 * 
	 * This field represents additional bullet, which can be picked up by the
	 * player. Its initial value is 1. It's only effective when the player has
	 * no bullet.
	 * 
	 */
	private int bullet = 1;

}
