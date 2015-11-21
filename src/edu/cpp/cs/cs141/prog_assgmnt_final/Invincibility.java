/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 *
 */
public class Invincibility extends GameEntity {

	public Invincibility() {
		super("I", "*", 0, 0);
	}

	/**
	 * The player will be invincible for 5 turns.
	 */
	private int numberOfTurns = 5;

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
		if (invincible) {
			numberOfTurns -= 1;
		}
	}

	/**
	 * This field represent the location of invincible power-up when the game
	 * starts.
	 * 
	 * @param index
	 *            number of row
	 * @param index
	 *            number of column
	 */
	public void location(int x, int y) {

	}

}
