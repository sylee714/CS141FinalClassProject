/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Victor Darkes
 *
 */
public class Main {
	
	public static void main(String args[]) {
		Map map = new Map();
		map.generateEmptySpace();
		map.generateRoomsWithBriefCase();
		map.generatePlayer();
		
		//map.generatePowerUps();
		//map.generateEnemies();
		System.out.println(map.toString());
		//map.makeRooms();
	}

}
