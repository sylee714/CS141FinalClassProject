/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.io.Serializable;

/**
 * @author Seungyun
 *
 */
public class Radar extends GameEntity implements Serializable {




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
