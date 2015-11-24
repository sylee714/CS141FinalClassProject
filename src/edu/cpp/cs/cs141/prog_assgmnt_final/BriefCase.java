

/**
 * I'm making a comment
 */

package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 *
 */
public class BriefCase extends GameEntity {
	
	public BriefCase() {
		super("B", "R", 0, 0);
		
	}
	
	/**
	 * This boolean 
	 */
	private boolean retrieved = false;
	
	private boolean found = false;
	
	/**
	 * @return the found
	 */
	public boolean isFound() {
		return found;
	}

	/**
	 * @param found the found to set
	 */
	public void setFound(boolean found) {
		this.found = found;
	}

	/** 
	 * This field represent the location of brief case when
	 * the game starts. It can be only located in one of nine rooms. 
	 * 
	 * @param index number of row
	 * @param index number of column
	 */
	public void location(int x, int y) {
		
	}

	/**
	 * This method allows to set the value of boolean retrieved.
	 * @param retrieved the retrieved to set
	 */
	public void setRetrieved(boolean retrieved) {
		this.retrieved = retrieved;
	}
	
}
