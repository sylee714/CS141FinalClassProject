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
 * This class represents an EmptySpace. It extends GameEntity class and it uses
 * a super constructor to assign initial values of front, back, row, column of
 * the EmptySpace.
 */
public class EmptySpace extends GameEntity implements Serializable {

	/**
	 * 
	 * A super constructor for the class. It allows to set initial values for
	 * front, back, row, column.
	 * 
	 */
	public EmptySpace() {
		super(" ", "*", 0, 0);

	}
}
