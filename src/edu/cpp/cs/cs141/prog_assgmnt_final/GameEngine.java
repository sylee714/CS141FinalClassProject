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
	
	public String printMap() {
		return map.toString();
	}
	
	public String printDebug() {
		return map.printDebug();
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
