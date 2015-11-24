/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.util.Random;

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

	private Player player = new Player();

	private Enemy enemy = new Enemy();

	private int turn = 3;

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
	 * @param debug the debug to set
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
			if(isDebug() == false){
				return map.toString();
				
			}
			else{
				return map.printDebug();
			}
	}
	
	public String displayBoard() {
		return map.toString();
	}

	/**
	 * 
	 * @param direction
	 *            player has immediate visibility of each turn.
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
	public  void playerMove(int direction) {
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
*/
	public boolean playerMove(int direction) {
		boolean temp = false;

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

		//System.out.println("GameEngineClass PlayerMove() temp variable: " + temp);

		temp = (temp == true) ? true : false;
		
		return temp;
	}
	
	public String printDebug() {
		return map.printDebug();
	}

	public void playerTurn() {

	}

	public void moveEnemy() {
		Random random = new Random();
		int i = (random.nextInt(3) + 1);
		try {
			map.moveEnemy(i);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Enemies move out of bounds");
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
