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


	private Map map = new Map();

	public GameEngine(Map map) {
		this.map = map;
	}

	private int turn = 3;

	private boolean attacked = false;

	private boolean endGame;

	public void generateMap() {
		map.generateEmptySpace();
		map.generateRoomsWithBriefCase();
		map.generatePlayer();
		map.generateEnemy();
		map.generatePowerUps();
	}

	public String displayBoard() {
		return map.toString();
	}

	/**
	 * 
	 * @param direction
	 *            player has immediate visibility of each turn.
	 */



	/**
	 * @param direction
	 *            the player can "Look".
	 */

	public void playerLook(int direction) {
		
		switch (direction) {
		// Left
		case 1:
			map.visibilityOfPlayer(1);
			break;
		// Right
		case 2:
			map.visibilityOfPlayer(2);
			break;
		// Up
		case 3:
			map.visibilityOfPlayer(3);
			break;
		// Down
		case 4:
			map.visibilityOfPlayer(4);
			break;
		}

	}

	public void playerMove(int direction) {
		

		switch (direction) {
		// left
		case 1:
			map.movePlayer(1);
			break;
		// Right
		case 2:
			map.movePlayer(2);
			break;
		// Up
		case 3:
			map.movePlayer(3);
			break;
		// Down
		case 4:
			map.movePlayer(4);
			break;
		}

	
	}

	public String printDebug() {
		return map.printDebug();
	}


	public void enemyMove() {
		map.moveEnemy();
	}


	public boolean gameWon() {
		boolean won = false;
		return won;

	}

	public void backToInitialSpawnLocation() {
		map.initialPoint();

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
