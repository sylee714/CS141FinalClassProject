/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 *
 */
public class Main {
	
	public static void main(String args[]) {
		Map map = new Map();
		map.initializeMap();
		map.generateEnemy();
		System.out.println(map.toString());
	}

}
