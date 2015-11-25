/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 *
 */
public class Radar extends GameEntity {




	private boolean found = false;


	public Radar() {
		super("+", "*", 0, 0);
	}

	/**
	 * @return the found
	 */

	

	public boolean getFound() {

		return found;
	}



	

	public void setFound(boolean found) {
		this.found = found;
	}


}
