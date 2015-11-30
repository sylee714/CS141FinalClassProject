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
 * This class represents an Enemy.
 */
public class Enemy extends GameEntity implements Serializable {

	public Enemy(String front) {
		super(front, "*", 0, 0);
	}

	/**
	 * 
	 */
	private boolean attack = false;
	

	/**
	 * @return the attack
	 */
	public boolean isAttack() {
		return attack;
	}

	/**
	 * @param attack
	 *            the attack to set
	 */
	public void setAttack(boolean attack) {
		this.attack = attack;
	}

	/**
	 * Initial spawn point of an enemy.
	 */
	public void location() {

	}



}
