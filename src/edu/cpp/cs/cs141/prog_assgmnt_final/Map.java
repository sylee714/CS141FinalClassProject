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

import java.util.Random;

import java.io.Serializable;

/**
 * This class represents a Map; yet, it has a lot of fields and methods that
 * make the game playable. Thus, this class can be seen as Map/sub-GameEngine
 * class. This is where all the objects that are necessary components of the
 * game are created. It contains move methods for Player and Enemies and their
 * attack methods.
 * 
 * 
 * @author Seungyun
 *
 */
public class Map implements Serializable {

	/**
	 * This is serialVersionUID for Map.
	 */
	private static final long serialVersionUID = -5808445953079391170L;

	/**
	 * This field creates a 2D array of GameEntity. Its initial size is 9 by 9.
	 */
	private GameEntity[][] map = new GameEntity[9][9];

	/**
	 * This field creates a player.
	 */
	private Player player = new Player();

	/**
	 * This field creates an additional bullet power-up.
	 */
	private AdditionalBullet bullet = new AdditionalBullet();

	/**
	 * This field creates a radar power-up.
	 */
	private Radar radar = new Radar();

	/**
	 * This field creates an invincibility power-up.
	 */
	private Invincibility invincible = new Invincibility();

	/**
	 * This field creates a briefcase.
	 */
	private BriefCase briefCase = new BriefCase();

	/**
	 * This field creates an enemy called enemy1 with '1' as its front side
	 * symbol.
	 */
	private Enemy enemy1 = new Enemy("1");

	/**
	 * This field creates an enemy called enemy2 with '2' as its front side
	 * symbol.
	 */
	private Enemy enemy2 = new Enemy("2");

	/**
	 * This field creates an enemy called enemy3 with '3' as its front side
	 * symbol.
	 */
	private Enemy enemy3 = new Enemy("3");

	/**
	 * This field creates an enemy called enemy4 with '4' as its front side
	 * symbol.
	 */
	private Enemy enemy4 = new Enemy("4");

	/**
	 * This field creates an enemy called enemy5 with '5' as its front side
	 * symbol.
	 */
	private Enemy enemy5 = new Enemy("5");

	/**
	 * This field creates an enemy called enemy6 with '6' as its front side
	 * symbol.
	 */
	private Enemy enemy6 = new Enemy("6");

	/**
	 * This field represents an GameEntity array which holds all the enemies.
	 */
	private GameEntity[] holdEnemy = { enemy1, enemy2, enemy3, enemy4, enemy5, enemy6 };

	/**
	 * This field represents whether or not the player is looking through the
	 * rooms, in which they cannot.
	 */
	private boolean roomIndicator = false;

	/**
	 * This field represents an GameEntity array which holds all the power-ups.
	 */
	private GameEntity[] holdPowerUps = { radar, bullet, invincible };

	/**
	 * This field represents whether or not the player found the additional
	 * bullet. Its initial value is false.
	 */
	private boolean bulletIndicator = false;

	/**
	 * This field represents whether or not the player found the radar. Its
	 * initial value is false.
	 */
	private boolean radarIndicator = false;

	/**
	 * This field represents whether or not the player found the invincibility.
	 * Its initial value is false.
	 */
	private boolean invincibleIndicator = false;

	/**
	 * This field represents whether or not the player found the briefcase. Its
	 * initial value is false.
	 */
	private boolean briefCaseIndicator = false;

	/**
	 * This field represents whether or not an enemy found the player. Its
	 * initial value is false.
	 */
	private boolean foundPlayer = false;

	/**
	 * This field represents whether or not player can attack.
	 */
	private boolean playerAttack = false;

	/**
	 * This field depends on the invincibility power-up. When the player
	 * consumes the invincibility power-up, this field's value becomes false in
	 * order to disable enemyAttack method. Otherwise, it stays as true.
	 */
	private boolean ableEnemyAttack = true;

	/**
	 * This field represents whether or not the player is located on northside
	 * of a room.
	 */
	private boolean northSideOfRoom = false;

	/**
	 * This field represents whether or not the game is in hard mode. True means
	 * hard mode and false mean normal mode.
	 */
	private boolean hardMode = false;

	/**
	 * This method returns the value of roomIndicator, either true or false.
	 * 
	 * @return the value of roomIndicator, either true or false
	 */
	public boolean isRoomIndicator() {

		return roomIndicator;

	}

	/**
	 * This method sets the value of roomIndicator, either true or false.
	 * @param roomIndicator, either true or false
	 */
	public void setRoomIndicator(boolean roomIndicator) {

		this.roomIndicator = roomIndicator;

	}

	/**
	 * This method returns the value of hardMode, either true or false.
	 * 
	 * @return the value of hardMode, either true or false
	 */
	public boolean isHardMode() {
		return hardMode;
	}

	/**
	 * This method sets the value of hardMode, either true or false.
	 * 
	 * @param hardMode
	 *            set the value of hardMode, either true or false
	 */
	public void setHardMode(boolean hardMode) {

		this.hardMode = hardMode;

	}

	/**
	 * This method represents enemy's smart visibility, which they check left
	 * tiles to check if there is a player.
	 * 
	 * @param enemy
	 *            each element in holdEnemy
	 */
	public void enemyVisibilityLeft(GameEntity enemy) {

		for (int i = 1; i < enemy.getColumn() + 1; ++i) {

			if (enemy.getColumn() < 0 || enemy.getColumn() > 8) {

				enemy.setPlayerLeft(false);
				break;

			}

			else if (map[enemy.getRow()][enemy.getColumn() - i].getFront().equals("R")
					|| map[enemy.getRow()][enemy.getColumn() - i].getFront().equals("I")
					|| map[enemy.getRow()][enemy.getColumn() - i].getFront().equals("+")
					|| map[enemy.getRow()][enemy.getColumn() - i].getFront().equals("A")
					|| map[enemy.getRow()][enemy.getColumn() - i].getFront().equals("1")
					|| map[enemy.getRow()][enemy.getColumn() - i].getFront().equals("2")
					|| map[enemy.getRow()][enemy.getColumn() - i].getFront().equals("3")
					|| map[enemy.getRow()][enemy.getColumn() - i].getFront().equals("4")
					|| map[enemy.getRow()][enemy.getColumn() - i].getFront().equals("5")
					|| map[enemy.getRow()][enemy.getColumn() - i].getFront().equals("6")) {

				enemy.setPlayerLeft(false);
				break;

			}

			else if (map[enemy.getRow()][enemy.getColumn() - i].getFront().equals("P")) {

				enemy.setPlayerLeft(true);
				break;

			} else {

				enemy.setPlayerLeft(false);

			}

		}

	}

	/**
	 * This method represents enemy's smart visibility, which they check right
	 * tiles to check if there is a player.
	 * 
	 * @param enemy
	 *            each element in holdEnemy
	 */
	public void enemyVisibilityRight(GameEntity enemy) {

		int turn = map.length - enemy.getColumn();

		for (int i = 1; i < turn; ++i) {

			if (enemy.getColumn() < 0 || enemy.getColumn() > 8) {

				enemy.setPlayerRight(false);
				break;

			}

			else if (map[enemy.getRow()][enemy.getColumn() + i].getFront().equals("R")
					|| map[enemy.getRow()][enemy.getColumn() + i].getFront().equals("I")
					|| map[enemy.getRow()][enemy.getColumn() + i].getFront().equals("+")
					|| map[enemy.getRow()][enemy.getColumn() + i].getFront().equals("A")
					|| map[enemy.getRow()][enemy.getColumn() + i].getFront().equals("1")
					|| map[enemy.getRow()][enemy.getColumn() + i].getFront().equals("2")
					|| map[enemy.getRow()][enemy.getColumn() + i].getFront().equals("3")
					|| map[enemy.getRow()][enemy.getColumn() + i].getFront().equals("4")
					|| map[enemy.getRow()][enemy.getColumn() + i].getFront().equals("5")
					|| map[enemy.getRow()][enemy.getColumn() + i].getFront().equals("6")) {

				enemy.setPlayerRight(false);
				break;

			}

			else if (map[enemy.getRow()][enemy.getColumn() + i].getFront().equals("P")) {

				enemy.setPlayerRight(true);
				break;

			} else {

				enemy.setPlayerRight(false);

			}

		}

	}

	/**
	 * This method represents enemy's smart visibility, which they check top
	 * tiles to check if there is a player.
	 * 
	 * @param enemy
	 *            each element in holdEnemy
	 */
	public void enemyVisibilityUp(GameEntity enemy) {

		for (int i = 1; i < enemy.getRow() + 1; ++i) {

			if (enemy.getRow() < 0 || enemy.getRow() > 8) {

				enemy.setPlayerUp(false);
				break;

			} else if (map[enemy.getRow() - i][enemy.getColumn()].getFront().equals("R")
					|| map[enemy.getRow() - i][enemy.getColumn()].getFront().equals("I")
					|| map[enemy.getRow() - i][enemy.getColumn()].getFront().equals("+")
					|| map[enemy.getRow() - i][enemy.getColumn()].getFront().equals("A")
					|| map[enemy.getRow() - i][enemy.getColumn()].getFront().equals("1")
					|| map[enemy.getRow() - i][enemy.getColumn()].getFront().equals("2")
					|| map[enemy.getRow() - i][enemy.getColumn()].getFront().equals("3")
					|| map[enemy.getRow() - i][enemy.getColumn()].getFront().equals("4")
					|| map[enemy.getRow() - i][enemy.getColumn()].getFront().equals("5")
					|| map[enemy.getRow() - i][enemy.getColumn()].getFront().equals("6")) {

				enemy.setPlayerUp(false);
				break;

			} else if (map[enemy.getRow() - i][enemy.getColumn()].getFront().equals("P")) {

				enemy.setPlayerUp(true);
				break;

			} else {

				enemy.setPlayerUp(false);

			}

		}

	}

	/**
	 * This method represents enemy's smart visibility, which they check bottom
	 * tiles to check if there is a player.
	 * 
	 * @param enemy
	 *            each element in holdEnemy
	 */
	public void enemyVisibilityDown(GameEntity enemy) {

		int turn = map.length - enemy.getRow();

		for (int i = 1; i < turn; ++i) {

			if (enemy.getRow() < 0 || enemy.getRow() > 8) {

				enemy.setPlayerDown(false);
				break;

			}

			else if (map[enemy.getRow() + i][enemy.getColumn()].getFront().equals("R")
					|| map[enemy.getRow() + i][enemy.getColumn()].getFront().equals("I")
					|| map[enemy.getRow() + i][enemy.getColumn()].getFront().equals("+")
					|| map[enemy.getRow() + i][enemy.getColumn()].getFront().equals("A")
					|| map[enemy.getRow() + i][enemy.getColumn()].getFront().equals("1")
					|| map[enemy.getRow() + i][enemy.getColumn()].getFront().equals("2")
					|| map[enemy.getRow() + i][enemy.getColumn()].getFront().equals("3")
					|| map[enemy.getRow() + i][enemy.getColumn()].getFront().equals("4")
					|| map[enemy.getRow() + i][enemy.getColumn()].getFront().equals("5")
					|| map[enemy.getRow() + i][enemy.getColumn()].getFront().equals("6")) {

				enemy.setPlayerDown(false);
				break;

			} else if (map[enemy.getRow() + i][enemy.getColumn()].getFront().equals("P")) {

				enemy.setPlayerDown(true);
				break;

			} else {

				enemy.setPlayerDown(false);

			}

		}

	}

	/**
	 * This method decides where the enemies should move unto. If any of them
	 * finds the player in any direction, then they will move to the
	 * corresponding direction to follow the player. If they do not find the
	 * player, then they will move randomly.
	 * 
	 * @param playerLeft
	 *            if the player is on the left side tiles
	 * @param playerRight
	 *            the player is on the right side tiles
	 * @param playerUp
	 *            if the player is on the top side tiles
	 * @param playerDown
	 *            if the player is on the bottom side tiles
	 * @param enemy
	 *            each element in holdEnemy
	 */
	public void checkVisibilityHardMode(boolean playerLeft, boolean playerRight, boolean playerUp, boolean playerDown,
			GameEntity enemy) {

		if (playerLeft || playerRight || playerUp || playerDown) {

			enemy.setHardModePlayerNotFound(false);

		} else {

			enemy.setHardModePlayerNotFound(true);

		}

	}

	/**
	 * This method allows the enemies to move in hard mode. They follow the
	 * player once they locate the player; otherwise, they move randomly until
	 * they find the player.
	 * 
	 * @param playerLeft
	 *            if the player is on the left side tiles
	 * @param playerRight
	 *            the player is on the right side tiles
	 * @param playerUp
	 *            if the player is on the top side tiles
	 * @param playerDown
	 *            if the player is on the bottom side tiles
	 * @param hardModePlayerNotFound
	 *            if they did not find the player
	 * @param enemy
	 *            each element in holdEnemy
	 * @param i
	 *            integer value for a 'for-loop'
	 */
	public void enemyHardModeMove(boolean playerLeft, boolean playerRight, boolean playerUp, boolean playerDown,
			boolean hardModePlayerNotFound, GameEntity enemy, int i) {

		int tempRow;
		int tempColumn;
		GameEntity tempSpace;

		if (playerLeft) {

			smartMove(enemy, 4);

		} else if (playerRight) {

			smartMove(enemy, 3);

		} else if (playerUp) {

			smartMove(enemy, 1);

		} else if (playerDown) {

			smartMove(enemy, 2);

		} else if (hardModePlayerNotFound) {

			if (enemy.getFront().equals("1") || enemy.getFront().equals("2") || enemy.getFront().equals("3")
					|| enemy.getFront().equals("4") || enemy.getFront().equals("5") || enemy.getFront().equals("6")) {

				tempRow = enemy.getRow();
				tempColumn = enemy.getColumn();

				enemy.move(checkValidPosition(i));

				tempSpace = map[enemy.getRow()][enemy.getColumn()];
				enemy.setRow(enemy.getRow());
				enemy.setColumn(enemy.getColumn());

				map[tempRow][tempColumn] = tempSpace;

				map[enemy.getRow()][enemy.getColumn()] = enemy;

			}
		}

	}

	/**
	 * This method lets the enemies to move in a smart way.
	 * 
	 * @param enemy
	 *            each element in holdEnemy
	 * @param direction
	 *            direction where they want to move
	 */
	public void smartMove(GameEntity enemy, int direction) {

		int tempRow;
		int tempColumn;
		GameEntity tempSpace;

		tempRow = enemy.getRow();
		tempColumn = enemy.getColumn();

		enemy.move(direction);

		if (enemy.getFront().equals("1") || enemy.getFront().equals("2") || enemy.getFront().equals("3")
				|| enemy.getFront().equals("4") || enemy.getFront().equals("5") || enemy.getFront().equals("6")) {

			tempSpace = map[enemy.getRow()][enemy.getColumn()];

			enemy.setRow(enemy.getRow());
			enemy.setColumn(enemy.getColumn());

			map[tempRow][tempColumn] = tempSpace;
			map[enemy.getRow()][enemy.getColumn()] = enemy;

		}

	}

	/**
	 * This method represent hard mode. Now the enemies do not move randomly
	 * unless they do not find the player, but once they find the player they
	 * will follow the player.
	 */
	public void hardMode() {

		for (int i = 0; i < holdEnemy.length; ++i) {

			enemyVisibilityLeft(holdEnemy[i]);
			enemyVisibilityRight(holdEnemy[i]);
			enemyVisibilityUp(holdEnemy[i]);
			enemyVisibilityDown(holdEnemy[i]);
			checkVisibilityHardMode(holdEnemy[i].isPlayerLeft(), holdEnemy[i].isPlayerRight(),
					holdEnemy[i].isPlayerUp(), holdEnemy[i].isPlayerDown(), holdEnemy[i]);

			enemyHardModeMove(holdEnemy[i].isPlayerLeft(), holdEnemy[i].isPlayerRight(), holdEnemy[i].isPlayerUp(),
					holdEnemy[i].isPlayerDown(), holdEnemy[i].isHardModePlayerNotFound(), holdEnemy[i], i);

		}

	}

	/**
	 * This method returns the value of briefCaseIndicator.
	 * 
	 * @return the value of briefCaseIndicator, either true or false
	 */
	public boolean isBriefCaseIndicator() {

		return briefCaseIndicator;

	}

	/**
	 * This method allows to set the value of briefCaseIndicator.
	 * 
	 * @param briefCaseIndicator
	 *            to set the value of briefCaseIndicator, either true or false
	 */
	public void setBriefCaseIndicator(boolean briefCaseIndicator) {

		this.briefCaseIndicator = briefCaseIndicator;

	}

	/**
	 * This method returns the value of northSideOfRoom.
	 * 
	 * @return the value of northSideOfRoom, either true or false
	 */
	public boolean isNorthSideOfRoom() {

		return northSideOfRoom;

	}

	/**
	 * This method returns the value of ableEnemyAttack.
	 * 
	 * @return the value of ableEnemyAttack, either true or false
	 */
	public boolean isAbleEnemyAttack() {

		return ableEnemyAttack;

	}

	/**
	 * This method returns the life points the player has.
	 * 
	 * @return player's life points
	 */
	public int playerLife() {

		return player.getLife();

	}

	/**
	 * This method returns the value of foundPlayer, either true or false.
	 * 
	 * @return the value of foundPlayer, either true or false
	 */
	public boolean isFoundPlayer() {

		return foundPlayer;

	}

	/**
	 * This method sets the value of foundPlayer, either true or false.
	 * @param foundPlayer, either true or false
	 */
	public void setFoundPlayer(boolean foundPlayer) {
		this.foundPlayer = foundPlayer;
	}

	/**
	 * This method returns the value of bulletIndicator, either true or false.
	 * 
	 * @return the value of bulletIndicator, either true or false
	 */
	public boolean isBulletIndicator() {
		return bulletIndicator;
	}

	/**
	 * This method sets the value of bulletIndicator, either true or false.
	 * 
	 * @param bulletIndicator
	 *            set the value of bulletIndicator, either true or false
	 */
	public void setBulletIndicator(boolean bulletIndicator) {
		this.bulletIndicator = bulletIndicator;
	}

	/**
	 * This method returns the value of radarIndicator, either true or false.
	 * 
	 * @return the radarIndicator
	 */
	public boolean isRadarIndicator() {
		return radarIndicator;
	}

	/**
	 * This method sets the value of radarIndicator, either true or false.
	 * 
	 * @param radarIndicator
	 *            set the value of radarIndicator, either true or false
	 */
	public void setRadarIndicator(boolean radarIndicator) {
		this.radarIndicator = radarIndicator;
	}

	/**
	 * This method returns the value of invincibleIndicator, either true or
	 * false.
	 * 
	 * @return the invincibleIndicator
	 */
	public boolean isInvincibleIndicator() {
		return invincibleIndicator;
	}

	/**
	 * This method sets the value of invincibleIndicator, either true or false.
	 *
	 * @param invincibleIndicator
	 *            set the value of invincibleIndicator, either true or false
	 * 
	 */
	public void setInvincibleIndicator(boolean invincibleIndicator) {
		this.invincibleIndicator = invincibleIndicator;
	}

	/**
	 * This method returns the value of playerAttack, either true or false.
	 * 
	 * @return the value of playerAttack, either true or false
	 */
	public boolean isPlayerAttack() {
		return playerAttack;
	}

	/**
	 * This method sets the value of playerAttack, either true or false.
	 * 
	 * @param playerAttack
	 *            set the value of playerAttack, either true or false
	 */
	public void setPlayerAttack(boolean playerAttack) {
		this.playerAttack = playerAttack;
	}

	/**
	 * This method returns the value of dangerAhead, either true or false. If
	 * it's true, then enemies have been sighted by the player.
	 * 
	 * @return the value of dangerAhead, either true or false
	 */
	public boolean isPlayerDetect() {

		return player.isDangerAhead();

	}

	/**
	 * This method sets the value of dangerAhead, either true or false.
	 * 
	 * @param danger,
	 *            either true or false
	 */
	public void setPlayerDetect(boolean danger) {

		player.setDangerAhead(danger);

	}

	/**
	 * This method fills the map with empty spaces to initialize the map.
	 */
	public void generateEmptySpace() {

		for (int i = 0; i < map.length; ++i) {

			for (int j = 0; j < map[i].length; ++j) {

				map[i][j] = new EmptySpace();
				map[i][j].setRow(i);
				map[i][j].setColumn(j);

			}

		}

	}

	/**
	 * This method generates 9 nine rooms and only one of them has the brief
	 * case. A number will be generated randomly, depending on the number, one
	 * of the room is selected to contain the brief case.
	 */
	public void generateRoomsWithBriefCase() {

		map[1][1] = new Room();
		map[1][4] = new Room();
		map[1][7] = new Room();
		map[4][1] = new Room();
		map[4][4] = new Room();
		map[4][7] = new Room();
		map[7][1] = new Room();
		map[7][4] = new Room();
		map[7][7] = new Room();

		Random r = new Random();

		int randomNumber = r.nextInt(9) + 1;

		switch (randomNumber) {

		case 1:

			map[1][1] = briefCase;
			briefCase.setRow(1);
			briefCase.setColumn(1);
			break;

		case 2:

			map[1][4] = briefCase;
			briefCase.setRow(1);
			briefCase.setColumn(4);
			break;

		case 3:

			map[1][7] = briefCase;
			briefCase.setRow(1);
			briefCase.setColumn(7);
			break;

		case 4:

			map[4][1] = briefCase;
			briefCase.setRow(4);
			briefCase.setColumn(1);
			break;

		case 5:

			map[4][4] = briefCase;
			briefCase.setRow(4);
			briefCase.setColumn(4);
			break;

		case 6:

			map[4][7] = briefCase;
			briefCase.setRow(4);
			briefCase.setColumn(7);
			break;

		case 7:

			map[7][1] = briefCase;
			briefCase.setRow(7);
			briefCase.setColumn(1);
			break;

		case 8:

			map[7][4] = briefCase;
			briefCase.setRow(7);
			briefCase.setColumn(4);
			break;

		case 9:

			map[7][7] = new BriefCase();
			briefCase.setRow(7);
			briefCase.setColumn(7);
			break;

		}

	}

	/**
	 * This method generates the player's character at position (8,0) which is
	 * the initial/starting position.
	 */
	public void generatePlayer() {

		map[8][0] = player;
		player.setRow(8);
		player.setColumn(0);

	}

	/**
	 * This method generates 6 enemies. Each enemy's position is generated
	 * randomly and the 'if statement' filters positions where enemies cannot be
	 * located. When invalid position is generated and skips an element in the
	 * holdEnemy array, --i in 'else' will make the value of i go back to its
	 * previous value.
	 */
	public void generateEnemy() {

		Random r = new Random();

		for (int i = 0; i < holdEnemy.length; ++i) {

			int row = r.nextInt(9);
			int column = r.nextInt(9);

			if (map[row][column].getFront().equals(" ") && map[row][column] != map[5][0]
					&& map[row][column] != map[5][1] && map[row][column] != map[5][2] && map[row][column] != map[5][3]
					&& map[row][column] != map[6][0] && map[row][column] != map[6][1] && map[row][column] != map[6][2]
					&& map[row][column] != map[6][3] && map[row][column] != map[7][0] && map[row][column] != map[7][2]
					&& map[row][column] != map[7][3] && map[row][column] != map[8][1] && map[row][column] != map[8][2]
					&& map[row][column] != map[8][3]) {

				map[row][column] = holdEnemy[i];
				holdEnemy[i].setRow(row);
				holdEnemy[i].setColumn(column);

			} else {

				--i;
			}

		}

	}

	/**
	 * This method generates 3 power-ups. Each power-up's position is generated
	 * randomly and the 'if statement' filters positions where power-ups cannot
	 * be located. When invalid position is generated and skips an element in
	 * the holdEnemy array, --i in 'else' will make the value of i go back to
	 * its previous value.
	 */
	public void generatePowerUps() {

		Random r = new Random();

		for (int i = 0; i < holdPowerUps.length; ++i) {

			int row = r.nextInt(9);
			int column = r.nextInt(9);

			if (map[row][column].getFront().equals(" ")) {

				map[row][column] = holdPowerUps[i];
				holdPowerUps[i].setRow(row);
				holdPowerUps[i].setColumn(column);

			} else {

				--i;

			}

		}

	}

	/**
	 * This method checks if the player is located on the northside of a room.
	 * 
	 * @param row
	 *            index number
	 * @param column
	 *            index number
	 * @return the value of checkPosition, either true or false
	 */
	public boolean checkPositionOfPlayer(int row, int column) {

		boolean checkPosition = false;

		if (player.getRow() == 0 && player.getColumn() == 1) {

			checkPosition = true;

		} else if (player.getRow() == 0 && player.getColumn() == 4) {

			checkPosition = true;

		} else if (player.getRow() == 0 && player.getColumn() == 7) {

			checkPosition = true;

		} else if (player.getRow() == 3 && player.getColumn() == 1) {

			checkPosition = true;

		} else if (player.getRow() == 3 && player.getColumn() == 4) {

			checkPosition = true;

		} else if (player.getRow() == 3 && player.getColumn() == 7) {

			checkPosition = true;

		} else if (player.getRow() == 6 && player.getColumn() == 1) {

			checkPosition = true;

		} else if (player.getRow() == 6 && player.getColumn() == 4) {

			checkPosition = true;

		} else if (player.getRow() == 6 && player.getColumn() == 7) {

			checkPosition = true;

		} else {

			checkPosition = false;

		}

		return checkPosition;

	}

	/**
	 * This method takes row and column as an argument and if the player is
	 * located on the northside of a room, it returns northSideOfRoom as true;
	 * otherwise, false. Then, the player will be asked whether or not to check
	 * the room.
	 * 
	 * @param row
	 *            index number
	 * @param column
	 *            index number
	 * @return the value of northSideOfRoom, either true or false
	 */
	public boolean checkSideOfRoom(int row, int column) {

		if (checkPositionOfPlayer(player.getRow(), player.getColumn())) {

			northSideOfRoom = true;

		} else {

			northSideOfRoom = false;
		}

		return northSideOfRoom;

	}

	/**
	 * This method takes row and column as an argument and checks if the room
	 * that the player wants to check has the briefcase. If the room has the
	 * briefcase, it returns briefCaseIndicator as true; otherwise, false.
	 * 
	 * @param row
	 *            index number
	 * @param column
	 *            index number
	 * @return the value of briefCaseIndicator, either true or false
	 */
	public boolean detectBriefCase(int row, int column) {

		if (map[row][column].getFront().equals("B")) {

			briefCaseIndicator = true;

		}

		return briefCaseIndicator;
	}

	/**
	 * This method allows the player to search the rooms. If the room has the
	 * briefcase, it will give briefCaseIndicator as true; otherwise, false.
	 * 
	 * @param northSideOfRoom, either true or false
	 * @return the value of northSideOfRoom, either true or false
	 */
	public boolean searchRoom(boolean northSideOfRoom) {

		if (northSideOfRoom) {

			if (map[player.getRow() + 1][player.getColumn()].getFront().equals("B")) {

				briefCaseIndicator = true;

			} else {

				briefCaseIndicator = false;

			}

		}

		return briefCaseIndicator;

	}

	/**
	 * This method takes row and column as an argument and checks if the
	 * player's new location has one of te power-ups. If it does, then it
	 * returns one of the power-up indicator as true; otherwise. false.
	 * 
	 * @param row
	 *            index number
	 * @param column
	 *            index number
	 */
	public void detectPowerUps(int row, int column) {

		if (map[row][column].getFront().equals("+")) {

			radarIndicator = true;

		} else if (map[row][column].getFront().equals("A")) {

			bulletIndicator = true;

			if (player.getBullet() == 0) {

				player.setBullet(1);
			}

			player.setAttack(true);

		} else if (map[row][column].getFront().equals("I")) {

			invincibleIndicator = true;

		}

	}

	/**
	 * This method makes the player to use the invincible power-up as soon as he
	 * or she consumes it. Then, the player will be invincible for 5 turns by
	 * disabling eneny's attack method, returning ableEnemyAttack as true.
	 * Otherwise, false.
	 * 
	 * @param invincibleTurns, remaining turns
	 * @return the value of ableEnemyAttack, either true or false
	 */
	public boolean useInvincible(int invincibleTurns) {

		if (invincibleTurns != 0) {

			invincible.countingTurn();

			invincible.setNumberOfTurns(invincible.getNumberOfTurns());

			ableEnemyAttack = false;

		} else if (invincibleTurns == 0) {

			invincibleIndicator = false;
			ableEnemyAttack = true;

		}

		return ableEnemyAttack;

	}

	/**
	 * This method returns the number of remaining invincible turns.
	 * 
	 * @return the number of remaining invincible turns
	 */
	public int invincibleTurns() {

		return invincible.getNumberOfTurns();
	}

	/**
	 * This method allows the player to pick up the additional bullet power-up.
	 * If the player has no bullet, then he or she gets one bullet; otherwise,
	 * no effect.
	 * 
	 * @param bulletIndicator, either true or false
	 */
	public void pickUpBullet(boolean bulletIndicator) {

		if (player.getBullet() == 0) {

			player.setBullet(1);

		}

	}

	/**
	 * This method returns how many bullet the player has.
	 * 
	 * @return the number of bullet that that player has
	 */
	public int bullet() {

		return player.getBullet();

	}

	/**
	 * This method checks how many bullet the player has. If the player has 1
	 * bullet, then the player is allowed to shoot; otherwise, the player cannot
	 * shoot. If the player can shoot, it returns playerAttack as true;
	 * otherwise, false.
	 * 
	 * @return the value of playerAttack, either true or false
	 */
	public boolean checkBullet() {

		if (player.getBullet() == 1) {

			playerAttack = true;

		} else if (player.getBullet() == 0) {

			playerAttack = false;

		}

		return playerAttack;
	}

	/**
	 * This method consumes one bullet, when the player shoots.
	 */
	public void useBullet() {

		player.setBullet(0);

	}

	/**
	 * This method allows the player to shoot left. The for-loop checks the left
	 * sides of the player and if it finds a room or an enemy, the for-loop
	 * breaks. If it's an enemy, then it replace enemy with a new EmptySpace()
	 * with enemyDie() method.
	 */
	public void shootLeft() {

		for (int i = 1; i < player.getColumn() + 1; ++i) {

			if (map[player.getRow()][player.getColumn() - i].getFront().equals("R")) {

				break;

			} else if (map[player.getRow()][player.getColumn() - i].getFront().equals("1")
					|| map[player.getRow()][player.getColumn() - i].getFront().equals("2")
					|| map[player.getRow()][player.getColumn() - i].getFront().equals("3")
					|| map[player.getRow()][player.getColumn() - i].getFront().equals("4")
					|| map[player.getRow()][player.getColumn() - i].getFront().equals("5")
					|| map[player.getRow()][player.getColumn() - i].getFront().equals("6")) {

				enemyDie(player.getRow(), player.getColumn() - i);

				break;

			}

		}

	}

	/**
	 * This method allows the player to shoot right. The for-loop checks the
	 * right sides of the player and if it finds a room or an enemy, the
	 * for-loop breaks. If it's an enemy, then it replace enemy with a new
	 * EmptySpace() with enemyDie() method.
	 */
	public void shootRight() {

		int turn = map.length - player.getColumn();

		for (int i = 1; i < turn; ++i) {

			if (map[player.getRow()][player.getColumn() + i].getFront().equals("R")) {

				break;

			} else if (map[player.getRow()][player.getColumn() + i].getFront().equals("1")
					|| map[player.getRow()][player.getColumn() + i].getFront().equals("2")
					|| map[player.getRow()][player.getColumn() + i].getFront().equals("3")
					|| map[player.getRow()][player.getColumn() + i].getFront().equals("4")
					|| map[player.getRow()][player.getColumn() + i].getFront().equals("5")
					|| map[player.getRow()][player.getColumn() + i].getFront().equals("6")) {

				enemyDie(player.getRow(), player.getColumn() + i);

				break;

			}

		}

	}

	/**
	 * This method allows the player to shoot up. The for-loop checks the top
	 * sides of the player and if it finds a room or an enemy, the for-loop
	 * breaks. If it's an enemy, then it replace enemy with a new EmptySpace()
	 * with enemyDie() method.
	 */
	public void shootUp() {

		for (int i = 1; i < player.getRow() + 1; ++i) {

			if (map[player.getRow() - i][player.getColumn()].getFront().equals("R")) {

				break;

			} else if (map[player.getRow() - i][player.getColumn()].getFront().equals("1")
					|| map[player.getRow() - i][player.getColumn()].getFront().equals("2")
					|| map[player.getRow() - i][player.getColumn()].getFront().equals("3")
					|| map[player.getRow() - i][player.getColumn()].getFront().equals("4")
					|| map[player.getRow() - i][player.getColumn()].getFront().equals("5")
					|| map[player.getRow() - i][player.getColumn()].getFront().equals("6")) {

				enemyDie(player.getRow() - i, player.getColumn());

				break;

			}

		}

	}

	/**
	 * This method allows the player to shoot down. The for-loop checks the
	 * bottom sides of the player and if it finds a room or an enemy, the
	 * for-loop breaks. If it's an enemy, then it replace enemy with a new
	 * EmptySpace() with enemyDie() method.
	 */
	public void shootDown() {

		int turn = map.length - player.getRow();

		for (int i = 1; i < turn; ++i) {

			if (map[player.getRow() + i][player.getColumn()].getFront().equals("R")) {

				break;

			} else if (map[player.getRow() + i][player.getColumn()].getFront().equals("1")
					|| map[player.getRow() + i][player.getColumn()].getFront().equals("2")
					|| map[player.getRow() + i][player.getColumn()].getFront().equals("3")
					|| map[player.getRow() + i][player.getColumn()].getFront().equals("4")
					|| map[player.getRow() + i][player.getColumn()].getFront().equals("5")
					|| map[player.getRow() + i][player.getColumn()].getFront().equals("6")) {

				enemyDie(player.getRow() + i, player.getColumn());

				break;

			}

		}

	}

	/**
	 * This method replaces an enemy with a new EmptySpace(). It deletes a
	 * corresponding enemy from the holdEnemy array when 'if-statement' finds
	 * one.
	 * 
	 * @param row
	 *            Row index number of an enemy
	 * @param column
	 *            Column index number of an enemy
	 */
	public void enemyDie(int row, int column) {

		GameEntity tempSpace = new EmptySpace();

		if (map[row][column].getFront().equals("1")) {

			map[row][column] = tempSpace;
			holdEnemy[0] = tempSpace;

		} else if (map[row][column].getFront().equals("2")) {

			map[row][column] = tempSpace;
			holdEnemy[1] = tempSpace;

		} else if (map[row][column].getFront().equals("3")) {

			map[row][column] = tempSpace;
			holdEnemy[2] = tempSpace;

		} else if (map[row][column].getFront().equals("4")) {

			map[row][column] = tempSpace;
			holdEnemy[3] = tempSpace;

		} else if (map[row][column].getFront().equals("5")) {

			map[row][column] = tempSpace;
			holdEnemy[4] = tempSpace;

		} else if (map[row][column].getFront().equals("6")) {

			map[row][column] = tempSpace;
			holdEnemy[5] = tempSpace;

		}
	}

	/**
	 * This method allows the player to use the radar when the player consumes
	 * the radar power-up.
	 */
	public void useRadar() {

		map[briefCase.getRow()][briefCase.getColumn()].setFlipped(true);

	}

	/**
	 * This method returns the row index number of the briefcase when the player
	 * uses the radar.
	 * 
	 * @return the row index number of the briefcase
	 */
	public int briefCaseRow() {

		return briefCase.getRow();

	}

	/**
	 * This method returns the column index number of the briefcase when the
	 * player uses the radar.
	 * 
	 * @return the column index number of the briefcase
	 */
	public int briefCaseColumn() {

		return briefCase.getColumn();

	}

	/**
	 * This method allows enemies to check their left side tile to see if the
	 * player is there. It's surrounded by 'try and catch' to check other sides
	 * as well.
	 * 
	 * @return foundPlayer, either true or false
	 */
	public boolean visibilityOfEnemyLeft() {

		for (int i = 0; i < holdEnemy.length; i++) {

			try {

				if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() - 1].getFront().equals("P")) {
					foundPlayer = true;

				}

			} catch (ArrayIndexOutOfBoundsException e) {

				// insert 2nd try catch
				try {

					if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() + 1].getFront().equals("P")) {
						foundPlayer = true;

					}

				} catch (ArrayIndexOutOfBoundsException f) {

					// insert 3rd try catch
					try {

						if (map[holdEnemy[i].getRow() + 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
							foundPlayer = true;

						}

					} catch (ArrayIndexOutOfBoundsException g) {

						// insert 4th try catch
						try {

							if (map[holdEnemy[i].getRow() + 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
								foundPlayer = true;

							}

						} catch (ArrayIndexOutOfBoundsException h) {

						}
						// end 4th try catch
					}
					// end 3rd try catch
				}
				// end 2nd try catch
			}

		}

		return foundPlayer;

	}

	/**
	 * This method allows enemies to check their right side tile to see if the
	 * player is there. It's surrounded by 'try and catch' to check other sides
	 * as well.
	 * 
	 * @return foundPlayer, either true or false
	 */
	public boolean visibilityOfEnemyRight() {

		for (int i = 0; i < holdEnemy.length; i++) {

			try {

				if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() + 1].getFront().equals("P")) {
					foundPlayer = true;
				}

			} catch (ArrayIndexOutOfBoundsException e) {

				// insert 2nd try catch
				try {

					if (map[holdEnemy[i].getRow() - 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
						foundPlayer = true;

					}

				} catch (ArrayIndexOutOfBoundsException f) {

					// / insert 3rd try catch
					try {

						if (map[holdEnemy[i].getRow() + 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
							foundPlayer = true;

						}

					} catch (ArrayIndexOutOfBoundsException g) {

						// insert 4th try catch
						try {

							if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() - 1].getFront().equals("P")) {
								foundPlayer = true;

							}

						} catch (ArrayIndexOutOfBoundsException h) {

						}
						// insert 4th try catch
					}
					// end 3rd try catch
				}
				// end 2nd try catch
			}

		}

		return foundPlayer;

	}

	/**
	 * This method allows enemies to check their top side tile to see if the
	 * player is there. It's surrounded by 'try and catch' to check other sides
	 * as well.
	 * 
	 * @return foundPlayer, either true or false
	 */
	public boolean visibilityOfEnemyUp() {

		for (int i = 0; i < holdEnemy.length; i++) {

			try {

				if (map[holdEnemy[i].getRow() - 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
					foundPlayer = true;

				}

			} catch (ArrayIndexOutOfBoundsException e) {

				// insert 2nd try catch
				try {

					if (map[holdEnemy[i].getRow() + 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
						foundPlayer = true;

					}

				} catch (ArrayIndexOutOfBoundsException f) {

					// insert 3rd try catch
					try {

						if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() - 1].getFront().equals("P")) {
							foundPlayer = true;

						}

					} catch (ArrayIndexOutOfBoundsException g) {

						// insert 4th try catch
						try {

							if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() + 1].getFront().equals("P")) {
								foundPlayer = true;

							}

						} catch (ArrayIndexOutOfBoundsException h) {

						}
						// end 4th try catch
					}
					// end 3rd try catch
				}
				// end 2nd try catch
			}

		}

		return foundPlayer;

	}

	/**
	 * This method allows enemies to check their bottom side tile to see if the
	 * player is there. It's surrounded by 'try and catch' to check other sides
	 * as well.
	 * 
	 * @return foundPlayer, either true or false
	 */
	public boolean visibilityOfEnemyDown() {

		for (int i = 0; i < holdEnemy.length; i++) {

			try {

				if (map[holdEnemy[i].getRow() + 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
					foundPlayer = true;

				}

			} catch (ArrayIndexOutOfBoundsException e) {

				// insert 2nd try catch
				try {

					if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() - 1].getFront().equals("P")) {
						foundPlayer = true;

					}

				} catch (ArrayIndexOutOfBoundsException f) {

					// /insert 3rd try catch
					try {

						if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() + 1].getFront().equals("P")) {
							foundPlayer = true;

						}

					} catch (ArrayIndexOutOfBoundsException g) {

						// insert 4th try catch
						try {

							if (map[holdEnemy[i].getRow() - 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
								foundPlayer = true;

							}

						} catch (ArrayIndexOutOfBoundsException h) {

						}
						// end 4th try catch
					}
					// end 3rd try catch
				}
				// end 2nd try catch
			}

		}

		return foundPlayer;

	}

	/**
	 * This method filters if there is an EmptySpace in holdEnemy, then that
	 * EmptySpace cannot act like an enemy.
	 * 
	 * @return foundPlayer, either true or false
	 */
	public boolean filterEmptySpace() {

		for (int i = 0; i < holdEnemy.length; ++i) {

			if (holdEnemy[i].getFront().equals(" ")) {

				foundPlayer = false;

			}

		}

		return foundPlayer;

	}

	/**
	 * This method combines all the visibilities of enemies. It throws an
	 * 'ArrayIndexOutOfBoundsException' in order to handle unexpected
	 * exceptions.
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 *             to catch exceptions not caught in the 'try-catch' blocks
	 */
	public void visibilityOfEnemy() throws ArrayIndexOutOfBoundsException {

		visibilityOfEnemyLeft();
		visibilityOfEnemyRight();
		visibilityOfEnemyUp();
		visibilityOfEnemyDown();
		filterEmptySpace();

	}

	/**
	 * This method represents enemy attack and takes the boolean foundPlayer as
	 * an argument and if enemies find the player, then it creates new
	 * EmptySpace where the player was located.
	 * 
	 * @param foundPlayer, either true or false
	 */
	public void enemyAttack(boolean foundPlayer) {

		if (foundPlayer) {

			map[player.getRow()][player.getColumn()] = new EmptySpace();
			initialPoint();

		}

	}

	
	/**
	 * This method damages the player when the enemies find the player.
	 * @param foundPlayer the value of foundPlayer, either true of false
	 */
	public void playerGotDamaged(boolean foundPlayer) {

		if (foundPlayer) {

			player.gotDamaged();

		}

	}

	/**
	 * 
	 * This method sends the player back to its initial point: Row = 8 and
	 * Column = 0, when it gets attacked by an enemy.
	 * 
	 */
	public void initialPoint() {

		if (foundPlayer) {

			GameEntity tempSpace = map[8][0];
			map[player.getRow()][player.getColumn()] = tempSpace;
			map[8][0] = player;
			player.setRow(8);
			player.setColumn(0);

		}

	}

	/**
	 * * This method generates 6 enemies. Each enemy's position is generated
	 * randomly and the 'if statement' filters positions where enemies cannot be
	 * located. When invalid position is generated and skips an element in the
	 * holdEnemy array, --i in 'else' will make the value of i go back to its
	 * previous value.
	 * 
	 * @param foundPlayer the value of foundPlayer, either true or false
	 */
	public void relocateEnemy(boolean foundPlayer) {

		if (foundPlayer) {
			Random r = new Random();

			for (int i = 0; i < map.length; ++i) {

				for (int j = 0; j < map[i].length; ++j) {

					GameEntity tempSpace;
					int row = r.nextInt(9);
					int column = r.nextInt(9);

					if (map[i][j].getFront().equals("1") || map[i][j].getFront().equals("2")
							|| map[i][j].getFront().equals("3") || map[i][j].getFront().equals("4")
							|| map[i][j].getFront().equals("5") || map[i][j].getFront().equals("6")) {
						if (map[row][column].getFront().equals(" ") && map[row][column] != map[5][0]
								&& map[row][column] != map[5][1] && map[row][column] != map[5][2]
								&& map[row][column] != map[5][3] && map[row][column] != map[6][0]
								&& map[row][column] != map[6][1] && map[row][column] != map[6][2]
								&& map[row][column] != map[6][3] && map[row][column] != map[7][0]
								&& map[row][column] != map[7][2] && map[row][column] != map[7][3]
								&& map[row][column] != map[8][1] && map[row][column] != map[8][2]
								&& map[row][column] != map[8][3]) {

							tempSpace = map[row][column];
							map[row][column] = map[i][j];
							map[row][column].setRow(i);
							map[row][column].setColumn(j);
							map[i][j] = tempSpace;
							map[i][j].setRow(row);
							map[i][j].setColumn(column);

						}
					}

				}
			}
		}

	}

	/**
	 * This method lets the player to have immediate left vision.
	 */
	public void playerImmediateLeftLook() {

		try {

			if (map[player.getRow()][player.getColumn() - 1].getFront().equals("R")
					|| map[player.getRow()][player.getColumn() - 1].getFront().equals("B")) {

				map[player.getRow()][player.getColumn() - 1].setFlipped(false);

			} else {

				map[player.getRow()][player.getColumn() - 1].setFlipped(true);

			}

		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	/**
	 * This method lets the player to have immediate right vision.
	 */
	public void playerImmediateRightLook() {

		try {

			if (map[player.getRow()][player.getColumn() + 1].getFront().equals("R")
					|| map[player.getRow()][player.getColumn() + 1].getFront().equals("B")) {

				map[player.getRow()][player.getColumn() + 1].setFlipped(false);

			} else {

				map[player.getRow()][player.getColumn() + 1].setFlipped(true);

			}

		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	/**
	 * This method lets the player to have immediate up vision.
	 */
	public void playerImmediateUpLook() {

		try {

			if (map[player.getRow() - 1][player.getColumn()].getFront().equals("R")
					|| map[player.getRow() - 1][player.getColumn()].getFront().equals("B")) {

				map[player.getRow() - 1][player.getColumn()].setFlipped(false);

			} else {

				map[player.getRow() - 1][player.getColumn()].setFlipped(true);

			}

		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	/**
	 * This method lets the player to have immediate bottom vision.
	 */
	public void playerImmediateDownLook() {

		try {

			if (map[player.getRow() + 1][player.getColumn()].getFront().equals("R")
					|| map[player.getRow() + 1][player.getColumn()].getFront().equals("B")) {

				map[player.getRow() + 1][player.getColumn()].setFlipped(false);

			} else {

				map[player.getRow() + 1][player.getColumn()].setFlipped(true);

			}

		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	/**
	 * This method represents the player's immediate look. The player can see
	 * left, right, up, and down sides, but only one tile in each direction.
	 */
	public void playerImmediateLook() {

		playerImmediateLeftLook();
		playerImmediateDownLook();
		playerImmediateRightLook();
		playerImmediateUpLook();
	}

	/**
	 * This method lets the player to see two tiles ahead in left direction.
	 */
	public void leftVisibilityOfPlayer() {

		for (int i = 0; i < 3; ++i) {

			if (map[player.getRow()][player.getColumn() - i].getFront().equals("R")
					|| map[player.getRow()][player.getColumn() - i].getFront().equals("B")) {

				roomIndicator = true;
				map[player.getRow()][player.getColumn() - i].setFlipped(false);
				break;

			} else {

				map[player.getRow()][player.getColumn() - i].setFlipped(true);

				if (map[player.getRow()][player.getColumn() - i].getFront().equals("1")
						|| map[player.getRow()][player.getColumn() - i].getFront().equals("2")
						|| map[player.getRow()][player.getColumn() - i].getFront().equals("3")
						|| map[player.getRow()][player.getColumn() - i].getFront().equals("4")
						|| map[player.getRow()][player.getColumn() - i].getFront().equals("5")
						|| map[player.getRow()][player.getColumn() - i].getFront().equals("6")) {

					roomIndicator = false;
					player.setDangerAhead(true);
					break;
				}

			}

		}

	}

	/**
	 * This method lets the player to see two tiles ahead in right direction.
	 */
	public void rightVisibilityOfPlayer() {

		for (int i = 1; i < 3; ++i) {

			if (map[player.getRow()][player.getColumn() + i].getFront().equals("R")
					|| map[player.getRow()][player.getColumn() + i].getFront().equals("B")) {

				map[player.getRow()][player.getColumn() + i].setFlipped(false);
				roomIndicator = true;
				break;

			} else {

				map[player.getRow()][player.getColumn() + i].setFlipped(true);

				if (map[player.getRow()][player.getColumn() + i].getFront().equals("1")
						|| map[player.getRow()][player.getColumn() + i].getFront().equals("2")
						|| map[player.getRow()][player.getColumn() + i].getFront().equals("3")
						|| map[player.getRow()][player.getColumn() + i].getFront().equals("4")
						|| map[player.getRow()][player.getColumn() + i].getFront().equals("5")
						|| map[player.getRow()][player.getColumn() + i].getFront().equals("6")) {
					roomIndicator = false;
					player.setDangerAhead(true);
					break;
				}

			}

		}

	}

	/**
	 * This method lets the player to see two tiles ahead in up direction.
	 */
	public void upVisibilityOfPlayer() {

		for (int i = 0; i < 3; ++i) {

			if (map[player.getRow() - i][player.getColumn()].getFront().equals("R")
					|| map[player.getRow() - i][player.getColumn()].getFront().equals("B")) {

				roomIndicator = true;
				map[player.getRow() - i][player.getColumn()].setFlipped(false);
				break;

			} else {

				map[player.getRow() - i][player.getColumn()].setFlipped(true);

				if (map[player.getRow() - i][player.getColumn()].getFront().equals("1")
						|| map[player.getRow() - i][player.getColumn()].getFront().equals("2")
						|| map[player.getRow() - i][player.getColumn()].getFront().equals("3")
						|| map[player.getRow() - i][player.getColumn()].getFront().equals("4")
						|| map[player.getRow() - i][player.getColumn()].getFront().equals("5")
						|| map[player.getRow() - i][player.getColumn()].getFront().equals("6")) {

					roomIndicator = false;
					player.setDangerAhead(true);
					break;
				}

			}

		}
	}

	/**
	 * This method lets the player to see two tiles ahead in down direction.
	 */
	public void downVisibilityOfPlayer() {

		for (int i = 0; i < 3; ++i) {

			if (map[player.getRow() + i][player.getColumn()].getFront().equals("R")
					|| map[player.getRow() + i][player.getColumn()].getFront().equals("B")) {

				roomIndicator = true;
				map[player.getRow() + i][player.getColumn()].setFlipped(false);
				break;

			} else {

				map[player.getRow() + i][player.getColumn()].setFlipped(true);

				if (map[player.getRow() + i][player.getColumn()].getFront().equals("1")
						|| map[player.getRow() + i][player.getColumn()].getFront().equals("2")
						|| map[player.getRow() + i][player.getColumn()].getFront().equals("3")
						|| map[player.getRow() + i][player.getColumn()].getFront().equals("4")
						|| map[player.getRow() + i][player.getColumn()].getFront().equals("5")
						|| map[player.getRow() + i][player.getColumn()].getFront().equals("6")) {

					roomIndicator = false;
					player.setDangerAhead(true);
					break;
				}
			}

		}

	}

	/**
	 * This method sets everything to setFlipped(false) after the player takes
	 * an action.
	 */
	public void setNotFlipped() {

		for (int i = 0; i < map.length; ++i) {

			for (int j = 0; j < map[i].length; ++j) {

				map[i][j].setFlipped(false);

			}

		}

	}

	/**
	 * This method represents the player's movement. It moves the player in the
	 * direction that the user chooses. But it checks if that new location is an
	 * appropriate one.
	 *
	 * @param movement
	 *            which gives new location for the player
	 * @return boolean value, either true or false, to check if it's a valid
	 *         move
	 */
	public boolean movePlayer(int movement) {

		int tempRow = player.getRow();
		int tempColumn = player.getColumn();
		int tempRowFalse = player.getRow();
		int tempColumnFalse = player.getColumn();

		try {
			player.move(movement);

			player.setRow(player.getRow());

			player.setColumn(player.getColumn());

			map[tempRow][tempColumn] = new EmptySpace();

			if (map[player.getRow()][player.getColumn()] != map[1][1]
					&& map[player.getRow()][player.getColumn()] != map[1][4]
					&& map[player.getRow()][player.getColumn()] != map[1][7]
					&& map[player.getRow()][player.getColumn()] != map[4][1]
					&& map[player.getRow()][player.getColumn()] != map[4][4]
					&& map[player.getRow()][player.getColumn()] != map[4][7]
					&& map[player.getRow()][player.getColumn()] != map[7][1]
					&& map[player.getRow()][player.getColumn()] != map[7][4]
					&& map[player.getRow()][player.getColumn()] != map[7][7]) {

				detectPowerUps(player.getRow(), player.getColumn());
				checkSideOfRoom(player.getRow(), player.getColumn());

				map[player.getRow()][player.getColumn()] = player;
				return true;

			} else {
				player.setRow(tempRowFalse);
				player.setColumn(tempColumnFalse);
				map[tempRowFalse][tempColumnFalse] = player;
				return false;
			}

		} catch (ArrayIndexOutOfBoundsException e) {

			player.setRow(tempRowFalse);
			player.setColumn(tempColumnFalse);
			map[tempRowFalse][tempColumnFalse] = player;
			return false;
		}
	}

	/**
	 * This method checks if enemies' new locations are good. Their new location
	 * is chosen randomly.
	 * 
	 * @param i
	 *            which is the index number of holdEnemy
	 * @return valid movement that enemies can use
	 */
	public int checkValidPosition(int i) {

		Random r = new Random();
		int movement;
		boolean check = false;

		do {

			int checkRow = holdEnemy[i].getRow();
			int checkColumn = holdEnemy[i].getColumn();

			movement = r.nextInt(4) + 1;

			switch (movement) {

			case 1:
				checkRow--;
				break;
			case 2:
				checkRow++;
				break;
			case 3:
				checkColumn++;
				break;
			case 4:
				checkColumn--;
				break;

			}

			if (checkColumn < 0 || checkColumn > 8 || checkRow < 0 || checkRow > 8) {

				check = false;

			}

			else {

				// prevent stepping into room or on power ups
				if (map[checkRow][checkColumn].getFront().equals(" ")) {

					check = true;

				}

				else {

					check = false;

				}

			}

		} while (!check);

		return movement;

	}

	/**
	 * This method represents the movement of enemies. After getting valid
	 * movements from checkValidPostion method, enemies move to their new
	 * location randomly.
	 */
	public void moveEnemy() {

		int tempRow = 0;
		int tempColumn = 0;
		GameEntity tempSpace;

		for (int i = 0; i < holdEnemy.length; ++i) {

			if (holdEnemy[i].getFront().equals("1") || holdEnemy[i].getFront().equals("2")
					|| holdEnemy[i].getFront().equals("3") || holdEnemy[i].getFront().equals("4")
					|| holdEnemy[i].getFront().equals("5") || holdEnemy[i].getFront().equals("6")) {

				tempRow = holdEnemy[i].getRow();
				tempColumn = holdEnemy[i].getColumn();

				holdEnemy[i].move(checkValidPosition(i));

				tempSpace = map[holdEnemy[i].getRow()][holdEnemy[i].getColumn()];
				holdEnemy[i].setRow(holdEnemy[i].getRow());
				holdEnemy[i].setColumn(holdEnemy[i].getColumn());

				map[tempRow][tempColumn] = tempSpace;

				map[holdEnemy[i].getRow()][holdEnemy[i].getColumn()] = holdEnemy[i];

			}

		}

	}

	/**
	 * This method checks how many enemies are there.
	 * 
	 * @return number of remaining enemies
	 */
	public int checkEnemyRemaining() {

		int numberOfEnemy = 0;

		for (int i = 0; i < map.length; ++i) {

			for (int j = 0; j < map[i].length; ++j) {

				if (map[i][j].getFront().equals("1") || map[i][j].getFront().equals("2")
						|| map[i][j].getFront().equals("3") || map[i][j].getFront().equals("4")
						|| map[i][j].getFront().equals("5") || map[i][j].getFront().equals("6")) {

					numberOfEnemy = numberOfEnemy + 1;

				}

			}

		}

		return numberOfEnemy;
	}

	/**
	 * This method prints the map in String so that player can see and play the
	 * game.
	 * 
	 * @return A map that player plays on
	 */
	public String toString() {

		String result = "";

		for (GameEntity[] row : map) {

			for (GameEntity m : row) {

				if (m.isFlipped())

					result += "[" + m.getFront() + "]";

				else

					result += "[" + m.getBack() + "]";

			}

			result += "\n";

		}

		return result;

	}

	/**
	 * This method is debug mode and prints the map in String. It shows all the
	 * position of the game entities.
	 * 
	 * @return A map that shows every position of the game entities.
	 */
	public String printDebug() {

		String result = "";

		for (int i = 0; i < map.length; ++i) {

			for (int j = 0; j < map[i].length; ++j) {

				result += "[" + map[i][j].getFront() + "]";

			}

			result += "\n";
		}

		return result;

	}

}
