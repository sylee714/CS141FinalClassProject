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

<<<<<<< HEAD
	private Map map = new Map();
	
	public GameEngine(Map map) {
		this.map = map;
	}

=======
	private Map map = null;

	public GameEngine(Map map) {
		this.map = map;
	}
>>>>>>> origin/master

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
<<<<<<< HEAD
	
	public String displayBoard() {
		return map.toString();
	}
	
	
=======

	public String displayBoard() {
		return map.toString();
	}

	/**
	 * 
	 * @param direction
	 *            player has immediate visibility of each turn.
	 */

	public void visibilityOfPlayer() {
		try {
			map.visibilityOfPlayer(1);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			map.visibilityOfPlayer(2);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			map.visibilityOfPlayer(3);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			map.visibilityOfPlayer(4);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	/*
	 * public void visibilityOfPlayer(int direction) {
	 * 
	 * switch (direction) { // Left case 1: map.visibilityOfPlayer(1); break; //
	 * Right case 2: map.visibilityOfPlayer(2); break; // Up case 3:
	 * map.visibilityOfPlayer(3); break; // Down case 4:
	 * map.visibilityOfPlayer(4); break; default:
	 * System.out.println("That isn't a valid choice player."); break; } }
	 */
	/**
	 * @param direction
	 *            the player can "Look".
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

>>>>>>> origin/master
	public String printDebug() {
		return map.printDebug();
	}

<<<<<<< HEAD


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

		
=======
>>>>>>> origin/master
	public void playerTurn() {

	}

	public void EnemyMove() {
		try {
			map.enemyMove();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("You blew it");
		}

	}

	public void backToSpawnLocation() {

	}

	public boolean gameWon() {
		boolean won = false;
		return won;

	}

	public void backToInitialSpawnLocation() {

	}

}
