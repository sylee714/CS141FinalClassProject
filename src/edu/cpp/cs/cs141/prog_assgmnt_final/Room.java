/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 *
 */
public class Room  {
	
	/**
	 * Only one room can be occupied by brief case.
	 */
	private boolean occupied = false;
	
	/**
	 * Player cannot enter a room from sides and bottom.
	 */
	public void collision() {
		
	}
	
	/**
	 * Only the top of a room is the entrance.
	 */
	public void entrance() {
		
	}
	
	/**
	 * When a room has the brief case, the boolean occupied becomes true.
	 * @return
	 */
	public boolean spaceForBriefCase() {
		return occupied = true;
	}

}
