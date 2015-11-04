/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 *
 */
public class Gun {
	
	private int bullet = 1;
	
	private boolean empty = false;
	
	public void shooting() {
		
		bullet -= 1;
		
		empty = true;
		
	}
	
	public void loading() {
		
	}
	

}
