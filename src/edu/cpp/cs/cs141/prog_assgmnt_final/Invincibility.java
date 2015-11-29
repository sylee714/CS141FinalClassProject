/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.io.Serializable;

/**
 * @author Seungyun
 *
 */
public class Invincibility extends GameEntity implements Serializable {

	public Invincibility() {
		super("I", "*", 0, 0);
	}

	/**
	 * The player will be invincible for 5 turns.
	 */
	private int numberOfTurns = 6;

	/**
	 * This boolean field makes the player when he/she uses the power-up.
	 */
	private boolean invincible = false;

	/**
	 * This method sets the value of the boolean invincible.
	 * 
	 * @param invincible
	 *            the invincible to set
	 */
	public void setInvincible(boolean invincible) {
		this.invincible = invincible;
	}

	/**
	 * This method will keep track of invincible turns.
	 */
	public void countingTurn() {
		
			--numberOfTurns;
	}

	/**
	 * @return the numberOfTurns
	 */
	public int getNumberOfTurns() {
		return numberOfTurns;
	}

	/**
	 * @param numberOfTurns the numberOfTurns to set
	 */
	public void setNumberOfTurns(int numberOfTurns) {
		this.numberOfTurns = numberOfTurns;
	}

	

}
