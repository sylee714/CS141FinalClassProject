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
 * This class represents a GameEntity. This is the superclass for classes:
 * AdditionalBullet, Invincibility, Radar, BriefCase, Room, EmptySpace, Enemy,
 * and Player. This class had attributes and methods that are shared by the
 * sub-classes.
 */
public abstract class GameEntity implements Serializable {

	/**
	 * This field represents the front side of an GameEntity.
	 */
	private String front = "";

	/**
	 * This field represents the back side of an GameEntity.
	 */
	private String back = "";

	/**
	 * This field represents the row index number of an GameEntity.
	 */
	private int row = 0;

	/**
	 * This field represents the column index number of an GameEntity.
	 */
	private int column = 0;

	/**
	 * This field represents whether an GameEntity is flipped or not. If it's
	 * true, it shows the front side; otherwise, it shows the back side.
	 */
	private boolean isFlipped = false;

	/**
	 * This field represents whether or not an GameEntity attacks. If it's true,
	 * then the GameEntity attacks;, otherwise, it does not attack. This is only
	 * shared with Player and Enemy classes.
	 */
	private boolean attack = false;

	/**
	 * 
	 * This is a constructor which allows to set initial values of front, back,
	 * row, and column.
	 * 
	 * @param front
	 *            Front side symbol of an GameEntity.
	 * @param back
	 *            Back side symbol of an GameEntity.
	 * @param row
	 *            Row index number of an GameEntity, where it's located at.
	 * @param column
	 *            Column index number of an GameEntity, where it's located at.
	 * 
	 */
	public GameEntity(String front, String back, int row, int column) {
		this.front = front;
		this.back = back;
		this.row = row;
		this.column = column;
	}

	public void attack(boolean attack) {

	}

	/**
	 * This method sets the boolean value for the boolean field 'attack.'
	 * 
	 * @param attack
	 *            Boolean value either true or false.
	 */
	public void setAttack(boolean attack) {
		this.attack = attack;
	}

	/**
	 * 
	 * This method returns true, if 'attack' is true, and false, is 'attack' is
	 * false.
	 * 
	 * @return true if 'attack' is true; false, if 'attack' is false
	 */
	public boolean isAttack() {
		return attack;
	}

	/**
	 * 
	 * This method returns true, if 'isFlipped' is true, and false, if
	 * 'isFlipped' is false.
	 * 
	 * @return true if 'isFlipped' is true; false, if 'isFlipped' is false
	 * 
	 */
	public boolean isFlipped() {
		return isFlipped;
	}

	/**
	 * 
	 * This method sets the boolean value for the boolean field 'isFlipped.'
	 * 
	 * @param isFlipped
	 *            Boolean value either true or false.
	 * 
	 */
	public void setFlipped(boolean isFlipped) {
		this.isFlipped = isFlipped;
	}

	/**
	 * 
	 * This method returns a front side symbol of an GameEntity.
	 * 
	 * @return front side symbol
	 * 
	 */
	public String getFront() {
		return front;
	}

	/**
	 * 
	 * This method returns a back side symbol of an GameEntity.
	 * 
	 * @return back side symbol
	 * 
	 */
	public String getBack() {
		return back;
	}

	/**
	 * This method returns a current row index number of an GameEntity.
	 * 
	 * @return current row index number
	 * 
	 */
	public int getRow() {
		return row;
	}

	/**
	 * This method sets a new row index number of an GameEntity.
	 * 
	 * @param row
	 *            The new row index number where an GameEntity will be located
	 *            at.
	 * 
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * This method returns a current column index number of an GameEntity.
	 * 
	 * @return current column index number
	 * 
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * This methods sets a new column index number of an GameEntity.
	 * 
	 * @param column
	 *            The new column index number where an GameEntity will be
	 *            located at.
	 * 
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * 
	 * This method is moving method. Up, down, right, and left only. Only the
	 * player and enemies can move.
	 * 
	 * @param movement
	 *            The direction where an GameEntity wants to move.
	 * 
	 */
	public void move(int movement) {

		switch (movement) {
		// up
		case 1:
			row = row - 1;
			break;
		// down
		case 2:
			row = row + 1;
			break;
		// right
		case 3:
			column = column + 1;
			break;
		// left
		case 4:
			column = column - 1;
			break;

		}

	}
}
