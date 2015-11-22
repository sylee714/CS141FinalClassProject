/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 *
 */
public class Radar extends GameEntity {

	Boolean found = false;

	public Radar() {
		super("+", "*", 0, 0);
	}

	/**
	 * @return the found
	 */
	public Boolean getFound() {
		return found;
	}

	/**
	 * @param found the found to set
	 */
	public void setFound(Boolean found) {
		this.found = found;
	}

	

}
