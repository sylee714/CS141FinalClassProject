
/**
 *
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

	private boolean found = false;

	/**
	 * @return the found
	 */
	public boolean isFound() {
		return found;
	}

	/**
	 * @param found
	 *            the found to set
	 */
	public void setFound(boolean found) {
		this.found = found;
	}

}
