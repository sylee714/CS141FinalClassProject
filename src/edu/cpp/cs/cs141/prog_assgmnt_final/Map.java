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
	 * The size of the map.
	 */
	private GameEntity[][] map = new GameEntity[9][9];

	private Player player = new Player();

	private AdditionalBullet bullet = new AdditionalBullet();

	private Radar radar = new Radar();

	private Invincibility invincible = new Invincibility();

	private BriefCase briefCase = new BriefCase();

	private Enemy enemy1 = new Enemy("1");

	private Enemy enemy2 = new Enemy("2");

	private Enemy enemy3 = new Enemy("3");

	private Enemy enemy4 = new Enemy("4");

	private Enemy enemy5 = new Enemy("5");

	private Enemy enemy6 = new Enemy("6");

	private boolean roomIndicator = false;

	private boolean powerUpIndicator = false;

	private GameEntity[] holdEnemy = { enemy1, enemy2, enemy3, enemy4, enemy5, enemy6 };

	private GameEntity[] holdPowerUps = { radar, bullet, invincible };

	private boolean bulletIndicator = false;

	private boolean radarIndicator = false;

	private boolean invincibleIndicator = false;

	private boolean briefCaseIndicator = false;

	private boolean enemyAttack = true;

	private boolean foundPlayer = false;

	private boolean playerAttack = false;

	/**
	 * @return the foundPlayer
	 */
	public boolean isFoundPlayer() {
		return foundPlayer;
	}

	/**
	 * @return the bulletIndicator
	 */
	public boolean isBulletIndicator() {
		return bulletIndicator;
	}

	/**
	 * @param bulletIndicator
	 *            the bulletIndicator to set
	 */
	public void setBulletIndicator(boolean bulletIndicator) {
		this.bulletIndicator = bulletIndicator;
	}

	/**
	 * @return the radarIndicator
	 */
	public boolean isRadarIndicator() {
		return radarIndicator;
	}

	/**
	 * @param radarIndicator
	 *            the radarIndicator to set
	 */
	public void setRadarIndicator(boolean radarIndicator) {
		this.radarIndicator = radarIndicator;
	}

	/**
	 * @return the invincibleIndicator
	 */
	public boolean isInvincibleIndicator() {
		return invincibleIndicator;
	}

	/**
	 * @param invincibleIndicator
	 *            the invincibleIndicator to set
	 */
	public void setInvincibleIndicator(boolean invincibleIndicator) {
		this.invincibleIndicator = invincibleIndicator;
	}

	/**
	 * @return the playerAttack
	 */
	public boolean isPlayerAttack() {
		return playerAttack;
	}

	/**
	 * @param playerAttack
	 *            the playerAttack to set
	 */
	public void setPlayerAttack(boolean playerAttack) {
		this.playerAttack = playerAttack;
	}

	public boolean detectBriefCase(int row, int column) {

		if (map[row][column].getFront().equals("B")) {

			briefCaseIndicator = true;

		}

		return briefCaseIndicator;
	}

	public boolean detectRoom(int row, int column) {

		if (map[row][column].getBack().equals("R")) {

			roomIndicator = true;

		}

		return roomIndicator;

	}

	public void detectPowerUps(int row, int column) {

		if (map[row][column].getFront().equals("+")) {

			radarIndicator = true;

		} else if (map[row][column].getFront().equals("A")) {

			bulletIndicator = true;

			if (player.getBullet() == 0) {
				player.setBullet(1);
			}

			player.attack(true);

		} else if (map[row][column].getFront().equals("I")) {

			invincibleIndicator = true;
			invincible.countingTurn();
			foundPlayer = false;

		}

	}

	public void pickUpInvincible(boolean invincibleIndicator) {

		enemyAttack = false;

	}

	public void useInvincible() {
		invincible.countingTurn();
	}

	public int invincibleTurn() {

		return invincible.getNumberOfTurns();

	}

	public void pickUpBullet(boolean bulletIndicator) {

		if (player.getBullet() == 0) {
			player.setBullet(1);
		}
	}

	public int bullet() {
		return player.getBullet();
	}

	public boolean checkBullet() {

		if (player.getBullet() == 1) {

			playerAttack = true;
		} else if (player.getBullet() == 0) {
			playerAttack = false;
		}

		return playerAttack;
	}

	public void useBullet() {

		player.setBullet(0);

	}

	public void printNum() {
		System.out.println(map.length);
		System.out.println(player.getColumn());
		System.out.println(map.length - player.getColumn());

		System.out.println(map.length);
		System.out.println(player.getRow());
		System.out.println(map.length - player.getRow());
	}

	public void shootLeft() {

		boolean foundEnemy = false;

		for (int i = 1; i < player.getColumn() + 1; ++i) {

			if (map[player.getRow()][player.getColumn() - i].getFront().equals("1")
					|| map[player.getRow()][player.getColumn() - i].getFront().equals("2")
					|| map[player.getRow()][player.getColumn() - i].getFront().equals("3")
					|| map[player.getRow()][player.getColumn() - i].getFront().equals("4")
					|| map[player.getRow()][player.getColumn() - i].getFront().equals("5")
					|| map[player.getRow()][player.getColumn() - i].getFront().equals("6")) {

				map[player.getRow()][player.getColumn() - i] = new EmptySpace();
				foundEnemy = true;
				break;
			}
			System.out.println("Found Enemy: " + foundEnemy);
			System.out.println(player.getColumn() - i);

		}

	}

	public void shootRight() {

		int turn = map.length - player.getColumn();

		boolean foundEnemy = false;

		for (int i = 1; i < turn; ++i) {

			if (map[player.getRow()][player.getColumn() + i].getFront().equals("1")
					|| map[player.getRow()][player.getColumn() + i].getFront().equals("2")
					|| map[player.getRow()][player.getColumn() + i].getFront().equals("3")
					|| map[player.getRow()][player.getColumn() + i].getFront().equals("4")
					|| map[player.getRow()][player.getColumn() + i].getFront().equals("5")
					|| map[player.getRow()][player.getColumn() + i].getFront().equals("6")) {
				map[player.getRow()][player.getColumn() + i] = new EmptySpace();
				foundEnemy = true;
				break;
			}
			System.out.println("Found Enemy: " + foundEnemy);
			System.out.println(player.getColumn() + i);

		}

	}

	public void shootUp() {

		boolean foundEnemy = false;
		GameEntity tempSpace = new EmptySpace();

		for (int i = 1; i < player.getRow() + 1; ++i) {

			if (map[player.getRow() - i][player.getColumn()].getFront().equals("1")
					|| map[player.getRow() - i][player.getColumn()].getFront().equals("2")
					|| map[player.getRow() - i][player.getColumn()].getFront().equals("3")
					|| map[player.getRow() - i][player.getColumn()].getFront().equals("4")
					|| map[player.getRow() - i][player.getColumn()].getFront().equals("5")
					|| map[player.getRow() - i][player.getColumn()].getFront().equals("6")) {
				map[player.getRow() - i][player.getColumn()] = tempSpace;
				foundEnemy = true;
				break;
			}
			System.out.println("Found Enemy: " + foundEnemy);
			System.out.println(player.getRow() - i);

		}
	}

	public void shootDown() {

		boolean foundEnemy = false;

		int turn = map.length - player.getRow();

		for (int i = 1; i < turn; ++i) {

			if (map[player.getRow() + i][player.getColumn()].getFront().equals("1")
					|| map[player.getRow() + i][player.getColumn()].getFront().equals("2")
					|| map[player.getRow() + i][player.getColumn()].getFront().equals("3")
					|| map[player.getRow() + i][player.getColumn()].getFront().equals("4")
					|| map[player.getRow() + i][player.getColumn()].getFront().equals("5")
					|| map[player.getRow() + i][player.getColumn()].getFront().equals("6")) {

				map[player.getRow() + i][player.getColumn()] = new EmptySpace();
				foundEnemy = true;
				break;
			}
			System.out.println("Found Enemy: " + foundEnemy);
			System.out.println(player.getRow() + i);
		}
	}

	public void useRadar() {

		map[briefCase.getRow()][briefCase.getColumn()].setFlipped(true);

	}

	public int briefCaseRow() {
		return briefCase.getRow();
	}

	public int briefCaseColumn() {
		return briefCase.getColumn();
	}

	/**
	 * This method fills the map with empty spaces to initialize the map.
	 */
	public void generateEmptySpace() {
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				map[i][j] = new EmptySpace();
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
		// System.out.println(player.getRow() + player.getColumn());

	}

	/**
	 * This method generates 6 enemies. Each enemy's position is generated
	 * randomly and the 'if statement' filters positions where enemies cannot be
	 * located. When invalid position is generated and skips an element in the
	 * holdEnemy array, --i in 'else' will make the value of i back to its
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
	 * This method generates 3 enemies. Each power-up's position is generated
	 * randomly and the 'if statement' filters positions where power-ups cannot
	 * be located. When invalid position is generated and skips an element in
	 * the holdEnemy array, --i in 'else' will make the value of i back to its
	 * previous value.
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
					result += " " + m.getFront();
				else
					result += " " + m.getBack();
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
				if (map[i][j].getFront() != " ")
					result += " " + map[i][j].getFront();
				else
					result += " " + "*";
			}

			result += "\n";
		}

		return result;

	}

	public boolean visibilityOfEnemy() {

		boolean foundPlayer = false;

		for (int i = 0; i < 6; ++i) {

			if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() - 1].getFront().equals("P")
					|| map[holdEnemy[i].getRow()][holdEnemy[i].getColumn() + 1].getFront().equals("P")
					|| map[holdEnemy[i].getRow() - 1][holdEnemy[i].getColumn()].getFront().equals("P")
					|| map[holdEnemy[i].getRow() + 1][holdEnemy[i].getColumn()].getFront().equals("P"))
				holdEnemy[i].setAttack(true);
			foundPlayer = holdEnemy[i].isAttack();
		}

		return foundPlayer;
	}

	public void enemyAttack(boolean foundPlayer) {

		map[player.getRow()][player.getColumn()] = new EmptySpace();

	}

	public boolean visibilityOfEnemy(int direction) {

		for (int j = 0; j < holdEnemy.length; ++j) {

			switch (direction) {

			// left
			case 1:

				if (map[holdEnemy[j].getRow()][holdEnemy[j].getColumn() - 1].getFront().equals("P")) {
					foundPlayer = true;
				}

				break;

			// right
			case 2:

				if (map[holdEnemy[j].getRow()][holdEnemy[j].getColumn() + 1].getFront().equals("P")) {
					foundPlayer = true;
				}
				break;

			// up
			case 3:

				if (map[holdEnemy[j].getRow() - 1][holdEnemy[j].getColumn()].getFront().equals("P")) {
					foundPlayer = true;
				}
				break;

			// down
			case 4:

				if (map[holdEnemy[j].getRow() + 1][holdEnemy[j].getColumn()].getFront().equals("P")) {
					foundPlayer = true;
				}
				break;

			}

		}
		return foundPlayer;

	}

	/**
	 * @param direction
	 *            immediate area next to player in which they can see without
	 *            needing to "Look".
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

				printNum();

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

	public void moveEnemy() {
		boolean good = true;
		int tempRow = 0;
		int tempColumn = 0;
		int tempRowFalse = 0;
		int tempColumnFalse = 0;

		for (int i = 0; i < 6; ++i) {
			try {

				tempRow = holdEnemy[i].getRow();
				tempColumn = holdEnemy[i].getColumn();
				tempRowFalse = holdEnemy[i].getRow();
				tempColumnFalse = holdEnemy[i].getColumn();

				Random r = new Random();

				int movement = r.nextInt(4) + 1;

				holdEnemy[i].move(movement);

				holdEnemy[i].setRow(holdEnemy[i].getRow());
				holdEnemy[i].setColumn(holdEnemy[i].getColumn());

				map[tempRow][tempColumn] = new EmptySpace();

				if (map[holdEnemy[i].getRow()][holdEnemy[i].getColumn()].getFront().equals(" ")) {

					map[holdEnemy[i].getRow()][holdEnemy[i].getColumn()] = holdEnemy[i];
					good = true;

				} else {
					holdEnemy[i].setRow(tempRowFalse);
					holdEnemy[i].setColumn(tempColumnFalse);
					map[tempRowFalse][tempColumnFalse] = holdEnemy[i];

				}

			} catch (ArrayIndexOutOfBoundsException e) {
				map[tempRowFalse][tempColumnFalse] = holdEnemy[i];
			}
		}

	}

	public void playerDetect() {
		if (player.isDangerAhead() == true) {
			System.out.println("Danger Ahead!\n");
			player.setDangerAhead(false);
		} else
			System.out.println("Clear!\n");
	}

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

	public void setNotFlipped() {

		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				map[i][j].setFlipped(false);
			}
		}

	}

	public void initialPoint() {
		if (foundPlayer) {
			GameEntity tempSpace = map[8][0];
			map[player.getRow()][player.getColumn()] = tempSpace;
			map[8][0] = player;
			player.setRow(8);
			player.setColumn(0);
		}

	}

}
