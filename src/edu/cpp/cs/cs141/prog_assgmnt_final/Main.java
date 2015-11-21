/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.util.Random;

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
		map.generateEnemy();
		map.generateRadar();
		map.generateAdditionalBullet();
		map.generateInvincibility();
		map.movePlayer(3);
		map.visibilityOfPlayer(3);
		
		

		System.out.println(map.toString());
		System.out.println(map.printDebug());
		

	}

}
