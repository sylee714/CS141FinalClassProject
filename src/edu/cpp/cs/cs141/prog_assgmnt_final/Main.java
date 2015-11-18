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
		//Player player = new Player();
		Map map = new Map();
		GameEngine ge = new GameEngine();
		//map.generateEmptySpace();
		//map.generateRoomsWithBriefCase();
		//map.generatePlayer();
		//map.generateEnemy();
		//map.generateRadar();
		//map.generateAdditionalBullet();
		//map.generateInvincibility();
		ge.generateMap();
		ge.move(3,"P");
		ge.printMap();
		
		//System.out.println(ge.printMap());
		

		
		
	}

}
