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

	public void generateMap() {
		map.generateEmptySpace();
		map.generateRoomsWithBriefCase();
		map.generatePlayer();
		map.generateEnemy();
		map.generateRadar();
		map.generateAdditionalBullet();
		map.generateInvincibility();
	}



	public void move(int movement, String GameEntity) {
		try {
			switch (movement) {

			case 1:
				map.up(GameEntity);
				break;
			case 2:
				map.down(GameEntity);
				break;
			case 3:
				map.right(GameEntity);
				break;
			case 4:
				map.left(GameEntity);
				break;
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	public void move1(int movement) {
		
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
	}

	public void EnemyTurn() {

	}

	public void backToSpawnLocation() {

	}

	public void endingGame() {

	}

	public void backToInitialSpawnLocation() {

	}

	public void up(int x, int y) {
		x = x;
		y = y - 1;
	}

}
