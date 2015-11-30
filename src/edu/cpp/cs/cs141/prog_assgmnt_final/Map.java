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

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * @author Seungyun
 *
 */
public class Map implements Serializable {
	/**
	 * 
	 * This field creates a 2D array of GameEntity. Its initial size is 9 by 9.
	 * 
	 */
	private GameEntity[][] map = new GameEntity[9][9];

	/**
	 * 
	 * This field creates a player.
	 * 
	 */
	private Player player = new Player();

	/**
	 * 
	 * This field creates an additional bullet power-up.
	 * 
	 */
	private AdditionalBullet bullet = new AdditionalBullet();

	/**
	 * 
	 * This field creates a radar power-up.
	 * 
	 */
	private Radar radar = new Radar();

	/**
	 * 
	 * This field creates an invincibility power-up.
	 * 
	 */
	private Invincibility invincible = new Invincibility();

	/**
	 * 
	 * This field creates a briefcase.
	 * 
	 */
	private BriefCase briefCase = new BriefCase();

	/**
	 * 
	 * This field creates an enemy called enemy1 with '1' as its front side
	 * symbol.
	 * 
	 */
	private Enemy enemy1 = new Enemy("1");

	/**
	 * 
	 * This field creates an enemy called enemy2 with '2' as its front side
	 * symbol.
	 * 
	 */
	private Enemy enemy2 = new Enemy("2");

	/**
	 * 
	 * This field creates an enemy called enemy3 with '3' as its front side
	 * symbol.
	 * 
	 */
	private Enemy enemy3 = new Enemy("3");

	/**
	 * 
	 * This field creates an enemy called enemy4 with '4' as its front side
	 * symbol.
	 * 
	 */
	private Enemy enemy4 = new Enemy("4");

	/**
	 * 
	 * This field creates an enemy called enemy5 with '5' as its front side
	 * symbol.
	 * 
	 */
	private Enemy enemy5 = new Enemy("5");

	/**
	 * 
	 * This field creates an enemy called enemy6 with '6' as its front side
	 * symbol.
	 * 
	 */
	private Enemy enemy6 = new Enemy("6");

	/**
	 * 
	 * This field represents an GameEntity array which holds all the enemies.
	 * 
	 */
	private GameEntity[] holdEnemy = { enemy1, enemy2, enemy3, enemy4, enemy5, enemy6 };

	/**
	 * 
	 * This field represents an GameEntity array which holds all the power-ups.
	 * 
	 */
	private GameEntity[] holdPowerUps = { radar, bullet, invincible };

	/**
	 * 
	 * This field represents whether or not the player found the additional
	 * bullet. Its initial value is false.
	 * 
	 */
	private boolean bulletIndicator = false;

	/**
	 * 
	 * This field represents whether or not the player found the radar. Its
	 * initial value is false.
	 * 
	 */
	private boolean radarIndicator = false;

	/**
	 *
	 * This field represents whether or not the player found the invincibility.
	 * Its initial value is false.
	 * 
	 */
	private boolean invincibleIndicator = false;

	/**
	 * 
	 * This field represents whether or not the player found the briefcase. Its
	 * initial value is false.
	 * 
	 */
	private boolean briefCaseIndicator = false;

	/**
	 * 
	 * This field represents whether or not an enemy found the player. Its
	 * initial value is false.
	 * 
	 */
	private boolean foundPlayer = false;

	/**
	 * 
	 * This field represents whether or not player can attack.
	 * 
	 */
	private boolean playerAttack = false;

	/**
	 * 
	 * This field depends on the invincibility power-up. When the player
	 * consumes the inivincibility power-up, this field's value becomes false in
	 * order to disable enemyAttack method. Otherwise, it stays as true.
	 * 
	 */
	private boolean ableEnemyAttack = true;

	/**
	 * 
	 * This field represents whether or not the player is located on northside
	 * of a room.
	 * 
	 */
	private boolean northSideOfRoom = false;

	/**
	 * 
	 * This method returns the value of briefCaseIndicator.
	 * 
	 * @return the value of briefCaseIndicator, either true or false
	 * 
	 */
	public boolean isBriefCaseIndicator() {

		return briefCaseIndicator;

	}

	/**
	 * 
	 * This method allows to set the value of briefCaseIndicator.
	 * 
	 * @param briefCaseIndicator
	 *            to set the value of briefCaseIndicator, either true or false
	 * 
	 */
	public void setBriefCaseIndicator(boolean briefCaseIndicator) {

		this.briefCaseIndicator = briefCaseIndicator;

	}

	/**
	 * 
	 * This method returns the value of northSideOfRoom.
	 * 
	 * @return the value of northSideOfRoom, either true or false
	 * 
	 */
	public boolean isNorthSideOfRoom() {

		return northSideOfRoom;

	}

	/**
	 * 
	 * This method returns the value of ableEnemyAttack.
	 * 
	 * @return the value of ableEnemyAttack, either true or false
	 * 
	 */
	public boolean isAbleEnemyAttack() {

		return ableEnemyAttack;

	}

	/**
	 * 
	 * This method returns the life points the player has.
	 * 
	 * @return player's life points
	 * 
	 */
	public int playerLife() {

		return player.getLife();

	}

	/**
	 * 
	 * This method returns the value of foundPlayer, either true or false.
	 * 
	 * @return the value of foundPlayer, either true or false
	 * 
	 */
	public boolean isFoundPlayer() {

		return foundPlayer;

	}

	/**
	 * 
	 * This method returns the value of bulletIndicator, either true or false.
	 * 
	 * @return the value of bulletIndicator, either true or false
	 * 
	 */
	public boolean isBulletIndicator() {
		return bulletIndicator;
	}

	/**
	 * 
	 * This method
	 * 
	 * @param bulletIndicator
	 *            the bulletIndicator to set
	 * 
	 */
	public void setBulletIndicator(boolean bulletIndicator) {
		this.bulletIndicator = bulletIndicator;
	}

	/**
	 * 
	 * 
	 * 
	 * @return the radarIndicator
	 * 
	 */
	public boolean isRadarIndicator() {
		return radarIndicator;
	}

	/**
	 * 
	 * 
	 * 
	 * @param radarIndicator
	 *            the radarIndicator to set
	 * 
	 */
	public void setRadarIndicator(boolean radarIndicator) {
		this.radarIndicator = radarIndicator;
	}

	/**
	 * 
	 * 
	 * 
	 * @return the invincibleIndicator
	 * 
	 */
	public boolean isInvincibleIndicator() {
		return invincibleIndicator;
	}

	/**
	 * 
	 * 
	 * 
	 * @param invincibleIndicator
	 *            the invincibleIndicator to set
	 * 
	 */
	public void setInvincibleIndicator(boolean invincibleIndicator) {
		this.invincibleIndicator = invincibleIndicator;
	}

	/**
	 * 
	 * 
	 * 
	 * @return the playerAttack
	 * 
	 */
	public boolean isPlayerAttack() {
		return playerAttack;
	}

	/**
	 * 
	 * 
	 * 
	 * @param playerAttack
	 *            the playerAttack to set
	 * 
	 */
	public void setPlayerAttack(boolean playerAttack) {
		this.playerAttack = playerAttack;
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
	 * 
	 * This method generates 9 nine rooms and only one of them has the brief
	 * case. A number will be generated randomly, depending on the number, one
	 * of the room is selected to contain the brief case.
	 * 
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
	 * 
	 * This method generates the player's character at position (8,0) which is
	 * the initial/starting position.
	 * 
	 */
	public void generatePlayer() {

		map[8][0] = player;
		player.setRow(8);
		player.setColumn(0);

	}

	/**
	 * 
	 * This method generates 6 enemies. Each enemy's position is generated
	 * randomly and the 'if statement' filters positions where enemies cannot be
	 * located. When invalid position is generated and skips an element in the
	 * holdEnemy array, --i in 'else' will make the value of i go back to its
	 * previous value.
	 * 
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
	 * 
	 * This method generates 3 power-ups. Each power-up's position is generated
	 * randomly and the 'if statement' filters positions where power-ups cannot
	 * be located. When invalid position is generated and skips an element in
	 * the holdEnemy array, --i in 'else' will make the value of i go back to
	 * its previous value.
	 * 
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
	 * 
	 * This method checks if the player is located on the northside of a room.
	 * 
	 * @param row
	 *            index number
	 * @param column
	 *            index number
	 * @return the value of checkPosition, either true or false
	 * 
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
	 * 
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
	 * 
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
	 * 
	 * This method takes row and column as an argument and checks if the room
	 * that the player wants to check has the briefcase. If the room has the
	 * briefcase, it returns briefCaseIndicator as true; otherwise, false.
	 * 
	 * @param row
	 *            index number
	 * @param column
	 *            index number
	 * @return the value of briefCaseIndicator, either true or false
	 * 
	 */
	public boolean detectBriefCase(int row, int column) {

		if (map[row][column].getFront().equals("B")) {

			briefCaseIndicator = true;

		}

		return briefCaseIndicator;
	}

	/**
	 * 
	 * This method allows the player to search the rooms. If the room has the
	 * briefcase, it will give briefCaseIndicator as true; otherwise, false.
	 * 
	 * @param the
	 *            value of northSideOfRoom, either true or false
	 * @return the value of northSideOfRoom, either true or false
	 * 
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
	 * 
	 * This method takes row and column as an argument and checks if the
	 * player's new location has one of te power-ups. If it does, then it
	 * returns one of the power-up indicator as true; otherwise. false.
	 * 
	 * @param row
	 *            index number
	 * @param column
	 *            index number
	 * 
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

		} else {

			radarIndicator = false;
			bulletIndicator = false;
			invincibleIndicator = false;
		}

	}

	/**
	 * 
	 * This method makes the player to use the invincible power-up as soon as he
	 * or she consumes it. Then, the player will be invincible for 5 turns by
	 * disabling eneny's attack method, returning ableEnemyAttack as true.
	 * Otherwise, false.
	 * 
	 * @param remaining
	 *            number of invincibleTurns
	 * @return the value of ableEnemyAttack, either true or false
	 * 
	 */
	public boolean useInvincible(int invincibleTurns) {

		if (invincibleTurns != 0) {

			invincible.countingTurn();

			invincible.setNumberOfTurns(invincible.getNumberOfTurns());

			ableEnemyAttack = false;

		} else if (invincibleTurns == 0) {

			ableEnemyAttack = true;

		}

		return ableEnemyAttack;

	}

	/**
	 * 
	 * This method returns the number of remaining invincible turns.
	 * 
	 * @return the number of remaining invincible turns
	 * 
	 */
	public int invincibleTurns() {

		return invincible.getNumberOfTurns();
	}

	/**
	 * 
	 * This method allows the player to pick up the additional bullet power-up.
	 * If the player has no bullet, then he or she gets one bullet; otherwise,
	 * no effect.
	 * 
	 * @param value
	 *            of bulletIndicator, either true or false
	 */
	public void pickUpBullet(boolean bulletIndicator) {

		if (player.getBullet() == 0) {

			player.setBullet(1);

		}

	}

	/**
	 * 
	 * This method returns how many bullet the player has.
	 * 
	 * @return the number of bullet that that player has
	 */
	public int bullet() {

		return player.getBullet();

	}

	/**
	 * 
	 * This method checks how many bullet the player has. If the player has 1
	 * bullet, then the player is allowed to shoot; otherwise, the player cannot
	 * shoot. If the player can shoot, it returns playerAttack as true;
	 * otherwise, false.
	 * 
	 * @return the value of playerAttack, either true or false
	 * 
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
	 * 
	 * This method consumes one bullet, when the player shoots.
	 * 
	 */
	public void useBullet() {

		player.setBullet(0);

	}

	/**
	 * 
	 * This method allows the player to shoot left. The for-loop checks the left
	 * sides of the player and if it finds a room or an enemy, the for-loop
	 * breaks. If it's an enemy, then it replace enemy with a new EmptySpace()
	 * with enemyDie() method.
	 * 
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
	 * 
	 * This method allows the player to shoot right. The for-loop checks the
	 * right sides of the player and if it finds a room or an enemy, the
	 * for-loop breaks. If it's an enemy, then it replace enemy with a new
	 * EmptySpace() with enemyDie() method.
	 * 
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
	 * 
	 * This method allows the player to shoot up. The for-loop checks the top
	 * sides of the player and if it finds a room or an enemy, the for-loop
	 * breaks. If it's an enemy, then it replace enemy with a new EmptySpace()
	 * with enemyDie() method.
	 * 
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
	 * 
	 * This method allows the player to shoot down. The for-loop checks the
	 * bottom sides of the player and if it finds a room or an enemy, the
	 * for-loop breaks. If it's an enemy, then it replace enemy with a new
	 * EmptySpace() with enemyDie() method.
	 * 
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
	 * 
	 * This method replaces an enemy with a new EmptySpace(). It deletes a
	 * corresponding enemy from the holdEnemy array when 'if-statement' finds
	 * one.
	 * 
	 * @param row
	 *            Row index number of an enemy
	 * @param column
	 *            Column index number of an enemy
	 * 
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
	 * 
	 * This method allows the player to use the radar when the player consumes
	 * the radar power-up.
	 * 
	 */
	public void useRadar() {

		map[briefCase.getRow()][briefCase.getColumn()].setFlipped(true);

	}

	/**
	 * 
	 * This method returns the row index number of the briefcase when the player
	 * uses the radar.
	 * 
	 * @return the row index number of the briefcase
	 * 
	 */
	public int briefCaseRow() {

		return briefCase.getRow();

	}

	/**
	 * 
	 * This method returns the column index nubmer of the briefcase when the
	 * player uses the radar.
	 * 
	 * @return the column index number of the briefcase
	 * 
	 */
	public int briefCaseColumn() {

		return briefCase.getColumn();

	}

	/**
	 * @return
	 */
	public boolean visibilityOfEnemyLeft() {
		for (int i = 0; i < holdEnemy.length; i++) {
			try {
				// System.out.println("1st map works");
				if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() - 1].getFront().equals("P")) {
					foundPlayer = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// System.out.println("1st map doesn't work");

				// insert 2nd try catch

				try {
					// System.out.println("2nd map works");
					if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() + 1].getFront().equals("P")) {
						foundPlayer = true;
					}
				} catch (ArrayIndexOutOfBoundsException f) {
					// System.out.println("2nd map doesn't work");

					// insert 3rd try catch
					try {
						// System.out.println("4th map works");
						if (map[holdEnemy[i].getRow() + 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
							foundPlayer = true;
						}
					} catch (ArrayIndexOutOfBoundsException g) {
						System.out.println("4th map doesn't work");
						// insert 4th try catch
						try {
							// System.out.println("4th map works");
							if (map[holdEnemy[i].getRow() + 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
								foundPlayer = true;
							}
						} catch (ArrayIndexOutOfBoundsException h) {
							// System.out.println("4th map doesn't work");
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
	 * @return
	 */
	public boolean visibilityOfEnemyRight() {
		for (int i = 0; i < holdEnemy.length; i++) {
			try {
				// System.out.println("2nd map works");
				if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() + 1].getFront().equals("P")) {
					foundPlayer = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// System.out.println("2nd map doesn't work");
				// insert 2nd try catch
				try {
					// System.out.println("3rd map works");
					if (map[holdEnemy[i].getRow() - 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
						foundPlayer = true;
					}
				} catch (ArrayIndexOutOfBoundsException f) {
					// System.out.println("3rd map doesn't work");
					// / insert 3rd try catch
					try {
						// System.out.println("4th map works");
						if (map[holdEnemy[i].getRow() + 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
							foundPlayer = true;
						}
					} catch (ArrayIndexOutOfBoundsException g) {
						// System.out.println("4th map doesn't work");
						// insert 4th try catch
						try {
							// System.out.println("1st map works");
							if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() - 1].getFront().equals("P")) {
								foundPlayer = true;
							}
						} catch (ArrayIndexOutOfBoundsException h) {
							// System.out.println("1st map doesn't work");
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
	 * @return
	 */
	public boolean visibilityOfEnemyUp() {
		for (int i = 0; i < holdEnemy.length; i++) {
			try {
				// System.out.println("3rd map works");
				if (map[holdEnemy[i].getRow() - 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
					foundPlayer = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// System.out.println("3rd map doesn't work");
				// insert 2nd try catch
				try {
					// System.out.println("4th map works");
					if (map[holdEnemy[i].getRow() + 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
						foundPlayer = true;
					}
				} catch (ArrayIndexOutOfBoundsException f) {
					// System.out.println("4th map doesn't work");

					// insert 3rd try catch
					try {
						// System.out.println("1st map works");
						if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() - 1].getFront().equals("P")) {
							foundPlayer = true;
						}
					} catch (ArrayIndexOutOfBoundsException g) {
						// System.out.println("1st map doesn't work");

						// insert 4th try catch
						try {
							// System.out.println("2nd map works");
							if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() + 1].getFront().equals("P")) {
								foundPlayer = true;
							}
						} catch (ArrayIndexOutOfBoundsException h) {
							// System.out.println("2nd map doesn't work");
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
	 * @return
	 */
	public boolean visibilityOfEnemyDown() {
		for (int i = 0; i < holdEnemy.length; i++) {
			try {
				// System.out.println("4th map works");
				if (map[holdEnemy[i].getRow() + 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
					foundPlayer = true;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// System.out.println("4th map doesn't work");

				// insert 2nd try catch
				try {
					// System.out.println("1st map works");
					if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() - 1].getFront().equals("P")) {
						foundPlayer = true;
					}
				} catch (ArrayIndexOutOfBoundsException f) {
					// System.out.println("1st map doesn't work");

					// /insert 3rd tr catch
					try {
						// System.out.println("2nd map works");
						if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() + 1].getFront().equals("P")) {
							foundPlayer = true;
						}
					} catch (ArrayIndexOutOfBoundsException g) {
						// System.out.println("2nd map doesn't work");

						// insert 4th try catch
						try {
							// System.out.println("3rd map works");
							if (map[holdEnemy[i].getRow() - 1][holdEnemy[i].getColumn()].getFront().equals("P")) {
								foundPlayer = true;
							}
						} catch (ArrayIndexOutOfBoundsException h) {
							// System.out.println("3rd map doesn't work");
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
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void visibilityOfEnemy() throws ArrayIndexOutOfBoundsException {

		visibilityOfEnemyLeft();
		visibilityOfEnemyRight();
		visibilityOfEnemyUp();
		visibilityOfEnemyDown();

	}

	/**
	 * @param foundPlayer
	 */
	public void enemyAttack(boolean foundPlayer) {

		if (foundPlayer) {

			map[player.getRow()][player.getColumn()] = new EmptySpace();
			initialPoint();
			playerGotDamaged();

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
	 * 
	 */
	public void playerGotDamaged() {

		player.gotDamaged();

	}

	/**
	 * @param direction
	 */
	public void visibilityOfPlayer(int direction) {

		for (int i = 1; i < 3; ++i) {

			switch (direction) {

			// left
			case 1:

				map[player.getRow()][player.getColumn() - i].setFlipped(true);
				if (map[player.getRow()][player.getColumn() - i].getFront().equals("E"))
					player.setDangerAhead(true);

				break;

			// right
			case 2:

				map[player.getRow()][player.getColumn() + i].setFlipped(true);
				if (map[player.getRow()][player.getColumn() + i].getFront().equals("E"))
					player.setDangerAhead(true);

				break;

			// up
			case 3:

				map[player.getRow() - i][player.getColumn()].setFlipped(true);
				if (map[player.getRow() - i][player.getColumn()].getFront().equals("E"))
					player.setDangerAhead(true);

				break;

			// down
			case 4:

				map[player.getRow() + i][player.getColumn()].setFlipped(true);
				if (map[player.getRow() + i][player.getColumn()].getFront().equals("E"))
					player.setDangerAhead(true);

				break;

			}

		}
	}
	
	/**
	 * 
	 * This method sets everything to setFlipped(false) after the player takes
	 * an action.
	 * 
	 */
	public void setNotFlipped() {

		for (int i = 0; i < map.length; ++i) {

			for (int j = 0; j < map[i].length; ++j) {

				map[i][j].setFlipped(false);

			}

		}

	}

	/**
	 * 
	 */
	public void playerDetect() {
		if (player.isDangerAhead() == true) {
			System.out.println("Danger Ahead!\n");
			player.setDangerAhead(false);
		} else
			System.out.println("Clear!\n");
	}

	/**
	 * @param movement
	 * @return
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
	 * @param i
	 * @return
	 */
	public int checkValidPosition(int i) {
		Random r = new Random();
		int movement;
		boolean check = true;

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
			// System.out.println(checkRow + " " + checkColumn);
			// check to make sure enemies don't go out of bounds
			if (checkColumn < 0 || checkColumn > 8 || checkRow < 0 || checkRow > 8)
				check = false;
			else {
				// prevent stepping into room or on power ups
				if (map[checkRow][checkColumn].getFront().equals(" "))
					check = true;
				else {
					check = false;
					// System.out.println("enemy: " + i +
					// " tried to enter a room");
				}
			}
			// System.out.println(check);

		} while (check != true);

		return movement;
	}

	// deleted by anthony in Collision update

	/**
	 * 
	 */
	public void moveEnemy() {
		int tempRow = 0;
		int tempColumn = 0;
		GameEntity tempSpace;

		for (int i = 0; i < 6; ++i) {

			tempRow = holdEnemy[i].getRow();
			tempColumn = holdEnemy[i].getColumn();

			holdEnemy[i].move(checkValidPosition(i));
			// System.out.println("1");
			tempSpace = map[holdEnemy[i].getRow()][holdEnemy[i].getColumn()];
			holdEnemy[i].setRow(holdEnemy[i].getRow());
			holdEnemy[i].setColumn(holdEnemy[i].getColumn());
			// System.out.println("2");
			map[tempRow][tempColumn] = tempSpace;
			// System.out.println("3" + "\n ------ " + i);

			map[holdEnemy[i].getRow()][holdEnemy[i].getColumn()] = holdEnemy[i];

		}
	}

	/**
	 * 
	 * This method checks how many enemies are there.
	 * 
	 * @return number of remaining enemies
	 */
	public int checkEnemyRemaining() {

		int numberOfEnemy = 0;

		for (int i = 0; i < map.length; ++i) {

			for (int j = 0; j < map[i].length; ++j) {

				if (map[i][j].equals("E")) {

					numberOfEnemy = numberOfEnemy + 1;

				}

			}

		}

		return numberOfEnemy;
	}

	/**
	 * 
	 * This method prints the map in String so that player can see and play the
	 * game.
	 * 
	 * @return A map that player plays on
	 * 
	 */
	public String toString() {

		String result = "";

		for (GameEntity[] row : map) {

			for (GameEntity m : row) {

				if (m.isFlipped())

					result += " " + m.getFront();

				else

					result += " " + m.getBack();

			}

			result += "\n";

		}

		return result;

	}

	/**
	 * 
	 * This method is debug mode and prints the map in String. It shows all the
	 * position of the game entities.
	 * 
	 * @return A map that shows every position of the game entities.
	 * 
	 */
	public String printDebug() {

		String result = "";

		for (int i = 0; i < map.length; ++i) {

			for (int j = 0; j < map[i].length; ++j) {

				if (map[i][j].getFront() != " ")

					result += " " + map[i][j].getFront();

				else

					result += " " + "*";

			}

			result += "\n";
		}

		return result;

	}
	
}
