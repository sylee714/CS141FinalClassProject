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
	
}
