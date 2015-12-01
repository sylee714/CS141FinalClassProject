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

	private Map map = null;

	public GameEngine(Map map) {
		this.map = map;
	}

	private int turn = 0;

	private boolean endGame = false;

	private boolean debug = false;

	public void generateMap() {

		map.generateEmptySpace();
		map.generateRoomsWithBriefCase();
		map.generatePlayer();
		map.generateEnemy();
		map.generatePowerUps();
	}

	public int getTurn() {
		return turn;
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

	public boolean foundRadar() {

		return map.isRadarIndicator();
	}

	public void useRadar(boolean foundRadar) {
		if (foundRadar) {
			map.useRadar();
		}
	}

	public int briefCaseRow() {
		return map.briefCaseRow();
	}

	public int briefCaseColumn() {
		return map.briefCaseColumn();
	}

	public int invincibleTurns() {

		return map.invincibleTurns();
	}

	public boolean invincible() {
		return map.isInvincibleIndicator();
	}

	public void useInvincible() {
		map.useInvincible(map.invincibleTurns());
	}

	public boolean briefCaseIndicator() {
		return map.isBriefCaseIndicator();
	}

	public int numberOfBullet() {
		return map.bullet();
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

	public void playerDetect() {
		map.playerDetect();
	}

	public void setNotFlipped() {
		map.setNotFlipped();

	}

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
		if (temp == true) {
			turn++;
			return temp;

		} else {
			temp = false;
			return temp;
		}
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
		turn++;
	}

	public void chooseHardMode(int option) {

		switch (option) {
		case 1:
			map.setHardMode(true);
			break;
		case 2:
			map.setHardMode(false);
			break;

		}
	}

	public boolean hardMode() {

		return map.isHardMode();

	}

	public void smartEnemyLook() {

		map.enemyHardModeVisibility();
		map.checkVisibilityHardMode(map.isPlayerLeft(), map.isPlayerRight(), map.isPlayerUp(), map.isPlayerDown());

	}

	public boolean playerLeft() {

		return map.isPlayerLeft();

	}

	public boolean playerRight() {

		return map.isPlayerRight();

	}

	public boolean playerUp() {

		return map.isPlayerUp();

	}

	public boolean playerDown() {

		return map.isPlayerDown();

	}
	
	public boolean hardModePlayerNotFound() {
		
		return map.isHardModePlayerNotFound();
				
	}

	public void smartEnemyMove() {

		try {

			map.enemyHardModeMove(map.isPlayerLeft(), map.isPlayerRight(), map.isPlayerUp(), map.isPlayerDown(),
					map.isHardModePlayerNotFound());

		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	public void moveEnemy() {
		try {
			map.moveEnemy();
		} catch (ArrayIndexOutOfBoundsException e) {
			// System.out.println("An enemy moved out of bounds");
		}
	}


	/**
	 * 
	 * @param direction
	 *            player has immediate visibility of each turn.
	 */

	public void visibilityOfEnemy() {
		map.visibilityOfEnemy();
	}

	public void enemyTurn() {
		
		//smartEnemyLook();

		if (map.isAbleEnemyAttack()) {

			//smartEnemyLook();
			//visibilityOfEnemy();
			map.enemyAttack(map.isFoundPlayer());
			map.playerGotDamaged(map.isFoundPlayer());
			map.initialPoint();

		}

	}

	public boolean isFoundPlayer() {
		return map.isFoundPlayer();
	}

	public int playerLife() {

		return map.playerLife();
	}

	public void backToSpawnLocation() {
		map.generatePlayer();
	}

	public void lifeReset() {
		map.setFoundPlayer(false);
	}

	public boolean endGame() {
		if (map.playerLife() == 0 || map.isBriefCaseIndicator() == true) {
			endGame = true;
		}
		return endGame;

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
