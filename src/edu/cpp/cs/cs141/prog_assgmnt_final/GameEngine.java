/**
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #Final (Group Project)
 *
*  Text-based game in which the player is located on a 9x9 grid unable to see anything,
 *  but where the player is located. The objective is to find a briefcase located 
 *  within one of 9 rooms located throughout the grid. The caveat, there are 6 enemies
 *  located throughout the grid that can kill the player if the two meet. There are 3 power
 *  ups scattered across the board that will aid the player in finding the brief case: 
 *  additional bullet, radar, and invisibility. The additional bullet will refill the player's 
 *  one-shot gun in the event it was shot earlier. The radar power up will located the 
 *  briefcase and disclose the location to the player. Invincibility will make the player 
 *  immune to all enemy attacks up to five turns. Keep in mind, the player has no storage
 *  so none of the power ups can be stored for later use. The player has 3 lives before
 *  game over. A load and save option is available for convenience.
 *
 * Team Liquid 
 *   <Anthony Vu, Victor Darkes, Seungyun Lee, Jeffrey Lee>
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import edu.cpp.cs.cs141.prog_assgmnt_final.Map;

import java.io.*;
import java.util.Random;

/**
 * @author Seungyun
 *
 */
public class GameEngine {

	private static final Object GameDataSave = null;

	private Map map = null;

	public GameEngine(Map map) {
		this.map = map;
	}

	private int turn = 0;

	private boolean attacked = false;

	private boolean endGame = false;

	private boolean debug = false;
	
	public void generateMap() {

		map.generateEmptySpace();
		map.generateRoomsWithBriefCase();
		map.generatePlayer();
		map.generateEnemy();
		map.generatePowerUps();

	}
	
	public String printBoard() {
		
		if (isDebug() == false) {
			
			return map.toString();

		} else {
			
			return map.printDebug();
			
		}
		
	}

	public String displayBoard() {
		
		return map.toString();
		
	}
	
	/**
	 * @return the debug
	 */
	public boolean isDebug() {
		
		return debug;
		
	}

	/**
	 * @param debug
	 *            the debug to set
	 */
	public void setDebug(boolean debug) {
		
		this.debug = debug;
		
	}
	
	public String printDebug() {
		
		return map.printDebug();
		
	}

	public int briefCaseRow() {
		return map.briefCaseRow();
	}

	public int briefCaseColumn() {
		return map.briefCaseColumn();
	}

	/**
	 * 
	 * @param direction
	 *            the player "looks".
	 */
	public void visibilityOfPlayer(int direction) {
		switch (direction) {
		case 1:
			map.visibilityOfPlayer(1);

			break;

		case 2:
			map.visibilityOfPlayer(2);
			break;

		case 3:
			map.visibilityOfPlayer(3);
			break;

		case 4:
			map.visibilityOfPlayer(4);
			break;
		}
	}

	public boolean foundRadar() {

		return map.isRadarIndicator();
	}

	public void useRadar(boolean foundRadar) {

		if (foundRadar) {
			map.useRadar();
		}

	}

	/*
	 * public void visibilityOfPlayer(int direction) {
	 * 
	 * switch (direction) { // Left case 1: map.visibilityOfPlayer(1); break; //
	 * Right case 2: map.visibilityOfPlayer(2); break; // Up case 3:
	 * map.visibilityOfPlayer(3); break; // Down case 4:
	 * map.visibilityOfPlayer(4); break; default: System.out.println(
	 * "That isn't a valid choice player."); break; } }
	 */
	/**
	 * @param direction
	 * @return
	 */

	public boolean playerMove(int direction) {
		boolean temp = true;

		switch (direction) {
		// left
		case 1:
			temp = map.movePlayer(4);
			if (map.isRadarIndicator()) {
				map.useRadar();
			}
			break;
		// Right
		case 2:
			temp = map.movePlayer(3);
			if (map.isRadarIndicator()) {
				map.useRadar();
			}
			break;
		// Up
		case 3:
			temp = map.movePlayer(1);
			if (map.isRadarIndicator()) {
				map.useRadar();
			}
			break;
		// Down
		case 4:
			temp = map.movePlayer(2);
			if (map.isRadarIndicator()) {
				map.useRadar();
			}
			break;
		}

		temp = (temp == true) ? true : false;

		return temp;
	}


	public void moveEnemy() {
		try {
			map.moveEnemy();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("An enemy moved out of bounds");
		}
	}

	public void backToSpawnLocation() {
		map.generatePlayer();
	}

	public int numberOfBullet() {
		return map.bullet();
	}

	public void playerAttack(int direction) {

		switch (direction) {

		// left
		case 1:
			if (map.checkBullet()) {
				map.shootLeft();
				map.useBullet();
			}
			break;
		// right
		case 2:
			if (map.checkBullet()) {
				map.shootRight();
				map.useBullet();
			}
			break;
		// up
		case 3:
			if (map.checkBullet()) {
				map.shootUp();
				map.useBullet();
			}
			break;
		// down
		case 4:
			if (map.checkBullet()) {
				map.shootDown();
				map.useBullet();
			}
			break;
		}

	}
	
	public boolean briefCaseIndicator() {
		return map.isBriefCaseIndicator();
	}
	
	public boolean northSideOfRoom() {
		return map.isNorthSideOfRoom();
	}
	

	
	public void checkRoom() {
		
		map.searchRoom(map.isNorthSideOfRoom());
		
	}

	/**
	 * 
	 * @param direction
	 *            player has immediate visibility of each turn.
	 */

	/**
	 * 
	 * @param direction
	 *            player has immediate visibility of each turn.
	 */

	public void visibilityOfEnemy() {
		map.visibilityOfEnemy();
	}
	
	public boolean invincible() {
		return map.isInvincibleIndicator();
	}
	
	public void useInvincible() {
		map.useInvincible(map.invincibleTurns());
	}
	
	public int invincibleTurns() {
		
		return map.invincibleTurns();
	}

	public void enemyTurn() {
		
		if (map.isAbleEnemyAttack()) {
			
		visibilityOfEnemy();
		
		map.enemyAttack(map.isFoundPlayer());
		
		System.out.println("Found Player: " + map.isFoundPlayer());
		
		//map.playerGotDamaged(map.isFoundPlayer());
		
		map.initialPoint();
		
		}

		
	}

	public boolean endGame() {
		if (map.playerLife() == 0 || map.isBriefCaseIndicator() == true) {
			endGame = true;
		}
		return endGame;

	}

	public void playerDetect() {
		map.playerDetect();
	}

	public void setNotFlipped() {
		map.setNotFlipped();

	}

	public void save() {
		try {

			FileOutputStream fos = new FileOutputStream("Save.dat");

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(map);

			fos.close();

		} catch (IOException e) {

			System.out.println(e.getMessage());

		}

	}

	public void load() {

		try {

			FileInputStream fis = new FileInputStream("Save.dat");

			ObjectInputStream ois = new ObjectInputStream(fis);

			try {

				map = (Map) ois.readObject();

			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}

			fis.close();
		} catch (IOException e) {

		}

	}


}
