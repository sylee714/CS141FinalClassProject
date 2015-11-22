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


	private Player player = new Player();

	private Enemy enemy = new Enemy();

	private int turn = 3;
	
	private boolean attacked = false;

	private boolean endGame;


	public void generateMap() {
		map.generateEmptySpace();
		map.generateRoomsWithBriefCase();
		map.generatePlayer();
		map.generateEnemy();
		map.generateRadar();
		map.generateAdditionalBullet();
		map.generateInvincibility();
	}
	
	public String displayBoard() {
		return map.toString();
	}
	
	
	public String printDebug() {
		return map.printDebug();
	}



	/**
	 * 
	 * @param direction
	 *            where the player chooses to look
	 */
	public void visibilityOfPlayer(int direction) {

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
		default:
			System.out.println("That isn't a valid choice player.");
			break;
		}

	}
	
	public void playerMove(int direction) {
		switch (direction) {
		// left
		case 1:
			map.movePlayer(4);
			break;
		// Right
		case 2:
			map.movePlayer(3);
			break;
		// Up
		case 3:
			map.movePlayer(1);
			break;
		// Down
		case 4:
			map.movePlayer(2);
			break;
		default:
			System.out.println("That isn't a valid input player.");
			break;

		}

	}
	
	public boolean gameWon() {
		boolean won = false;
		return won;

	}

		
	public void playerTurn() {


	}

	public void EnemyTurn() {

	}

	public void backToSpawnLocation() {

	}

	public void endingGame() {

	}

	public void backToInitialSpawnLocation() {

	}



}
