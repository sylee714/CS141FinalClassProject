/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 * 
 */
public class AdditionalBullet extends GameEntity {
	
	public AdditionalBullet() {
		super("A", "*", 0, 0);
		
	}
	/**
	 * This field represents additional bullet which can be
	 * picked up by the player. It's only effective when the gun
	 * is empty.
	 * 
	 */
	private int bullet = 1;
	
	/** 
	 * This field represent the location of additional bullet when
	 * the game starts. 
	 * 
	 * @param index number of row
	 * @param index number of column
	 */
	public void location(int row, int column) {
		
	}

}
