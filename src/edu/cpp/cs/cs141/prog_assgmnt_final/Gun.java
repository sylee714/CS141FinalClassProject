/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 *
 */
public class Gun {

	/**
	 * This field represents the number of bullet the player starts with.
	 */
	private int bullet = 1;

	/**
	 * This field represents if the gun is empty or loaded.
	 */
	private boolean empty = false;

	/**
	 * This is shooting method.
	 */
	public void shooting() {

		bullet--;

		empty = true;

	}

	/**
	 * This is loading method which gets executed when the player pick ups
	 * bullet power-up.
	 */
	public void load() {
		if (bullet == 0) {
			bullet++;
			empty = false;
		}
	}

	public void collision() {

	}

}
