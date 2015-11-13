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
		Player player = new Player();
		Map map = new Map();
		map.generateEmptySpace();
		map.generateRoomsWithBriefCase();
		map.generatePlayer();
		map.generateEnemy();
		map.generateRadar();
		map.generateAdditionalBullet();
		map.generateInvincibility();

		System.out.println(map.debugMode());
		System.out.println(map.toString());

		
	}

}
