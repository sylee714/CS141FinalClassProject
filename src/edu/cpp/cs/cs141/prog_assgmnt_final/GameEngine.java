/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import edu.cpp.cs.cs141.prog_assgmnt_final.Map;

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

	private boolean attacked = false;

	private boolean endGame;

	private boolean debug = false;

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

	public void generateMap() {
		map.generateEmptySpace();
		map.generateRoomsWithBriefCase();
		map.generatePlayer();
		map.generateEnemy();
		map.generateRadar();
		map.generateAdditionalBullet();
		map.generateInvincibility();
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

	public void playerLook(int direction) {
		switch (direction) {
		// Left
		case 1:
			map.playerLook(1);
			break;
		// Right
		case 2:
			map.playerLook(2);
			break;
		// Up
		case 3:
			map.playerLook(3);
			break;
		// Down
		case 4:
			map.playerLook(4);
			break;
		default:
			System.out.println("That isn't a valid choice player.");
			break;
		}

	}

	public boolean playerMove(int direction) {
		boolean temp = true;

		switch (direction) {
		// left
		case 1:
			temp = map.movePlayer(4);
			break;
		// Right
		case 2:
			temp = map.movePlayer(3);
			break;
		// Up
		case 3:
			temp = map.movePlayer(1);
			break;
		// Down
		case 4:
			temp = map.movePlayer(2);
			break;
		}

		temp = (temp == true) ? true : false;

		return temp;
	}

	public String printDebug() {
		return map.printDebug();
	}

	public void playerTurn() {

	}

	public void enemyMove() {
		map.enemyMove();
	}

	public void backToSpawnLocation() {

	}

	public boolean gameWon() {
		boolean won = false;
		return won;

	}

	public void backToInitialSpawnLocation() {

	}

	public void playerDetect() {
		map.playerDetect();
	}

	public void setNotFlipped() {
		map.setNotFlipped();
	}

	public void useRadar() {
		map.useRadar();
	}
}
