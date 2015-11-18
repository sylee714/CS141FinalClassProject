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

	private boolean endGame;

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

	public void move(int movement) {
		map.findPlayer();
		int row = map.getRow();
		int column = map.getColumn();
		
		System.out.println("checks initial get values: " + row + " " + column);
		
		switch (movement) {
		// up
		case 1:
			map.setRow(row--);
			break;
		// down
		case 2:
			map.setRow(row++);
			break;
		// left
		case 3:
			map.setColumn(column--);
			break;
		// right
		case 4:
			map.setColumn(column++);
			break;
		}
		
		System.out.println("final values after switch: " + row + " " + column);
	}

}
