/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Victor Darkes
 *
 */
public class Main {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		
		
		Map map = new Map();
        //UI ui = new UI(new GameEngine(map));
        //ui.startGame();
		
		//Map map = new Map();
		
		map.generateEmptySpace();
		map.generateRoomsWithBriefCase();
		map.generatePlayer();
		map.generateEnemy();
		map.generatePowerUps();
		System.out.println(map.printDebug());
	
		int i = 0;
		do {
			
			++i;
			map.moveEnemy();
			
			System.out.println(map.printDebug());
			
		} while (i < 3);
		/*
		int i = 0;
		
		do {
			
			++i;
			map.enemy1Move();
			map.enemy2Move();
			map.enemy3Move();
			map.enemy4Move();
			map.enemy5Move();
			map.enemy6Move();
			map.moveEnemy();
			map.movePlayer1(2);
			System.out.println(map.printDebug());
			
		} while (i < 3);
		
		
		//map.movePlayer1(3);
		//map.visibilityOfPlayer(3);
		*/
		

		//System.out.println(map.toString());
		//System.out.println(map.printDebug());
		


	}

}
