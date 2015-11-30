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
 * This class represents an Enemy. It extends GameEntity and is serializable, a
 * super constructor is used to assign initial values to front, back, row, and
 * column of specified enemy.
 */
public class Enemy extends GameEntity implements Serializable {

	/**
	 * A super constructor for the class. It allows to set initial values for
	 * front, back, row, column.
	 */
	public Enemy(String front) {
		super(front, "*", 0, 0);
	}

}
