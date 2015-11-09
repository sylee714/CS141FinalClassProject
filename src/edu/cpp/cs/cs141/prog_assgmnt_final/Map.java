package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.util.Random;

public class Map {

	private EmptySpace emptySpace = new EmptySpace();
	/**
	 * The size of the map.
	 */
	private GameEntity[][] map = new GameEntity[9][9];

	public void generateEmptySpace() {
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				map[i][j] = new EmptySpace();
			}
		}
	}

	public void generateEnemy() {

		Random ranNum = new Random();

		int enemyCounter = 0;

		do {
			int row = ranNum.nextInt(8);
			int column = ranNum.nextInt(4);

			if (map[row][column] == emptySpace) {
				map[row][column] = new Enemy();
				enemyCounter++;
			}
		} while (enemyCounter <= 4);

		int countEnemy = 0;

		for (int i = 0; i < 5; ++i) {

			for (int j = 0; j < 9; ++j) {

				while (countEnemy < 7) {
					map[i][j] = new Enemy();

				}
				++countEnemy;
			}
		}

	}

	/**
	 * Generates initial map state.
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

		int randomNumber = r.ints(1, 1, 10).findFirst().getAsInt();

		switch (randomNumber) {
		case 1:
			map[1][1] = new BriefCase();
			break;
		case 2:
			map[1][4] = new BriefCase();
			break;
		case 3:
			map[1][7] = new BriefCase();
			break;
		case 4:
			map[4][1] = new BriefCase();
			break;
		case 5:
			map[4][4] = new BriefCase();
			break;
		case 6:
			map[4][7] = new BriefCase();
			break;
		case 7:
			map[7][1] = new BriefCase();
			break;
		case 8:
			map[7][4] = new BriefCase();
			break;
		case 9:
			map[7][7] = new BriefCase();
			break;
		}

	}

	public void generateBriefCase() {

		Random r = new Random();
		int[] fiveRandomNumbers = r.ints(5, 0, 11).toArray();
		int randomNumber = r.ints(1, 0, 8).findFirst().getAsInt();

		// System.out.println(randomNumber);

		map[randomNumber][randomNumber] = new BriefCase();

	}

	public void makeRooms() {

		Random r = new Random();
		int[] fiveRandomNumbers = r.ints(5, 0, 11).toArray();
		int randomNumber = r.ints(1, 1, 9).findFirst().getAsInt();

		System.out.println(randomNumber);

	}

	public void generatePlayer() {
		map[8][0] = new Player();
	}

	public void generatePowerUps() {

		map[0][6] = new AdditionalBullet();
		map[0][7] = new Radar();
		map[0][8] = new Invincibility();

	}
	// for(int i = 0; i < map.length; i++)
	// for(int j = 0; j < map[i].length; i++) {
	// while (map[i][j] == null)

	// enemy.generateEnemies();

	// }
	// }

	public String toString() {
		String result = "";
		for (GameEntity[] row : map) {
			for (GameEntity m : row) {
				if (m.isFlipped())
					result += " " + m.getFront() + " ";
				else
					result += " " + m.getBack();
			}

			result += "\n";
		}
		return result;

	}

	/**
	 * Visibility of the map.
	 */
	private boolean visible = false;

	/**
	 * If a space is occupied by enemies or player.
	 */
	private boolean occupied = false;

	/**
	 * Location of 9 rooms which is equally distributed.
	 */
	public void locationOfRoom() {

	}

	/**
	 * Space to hold power-ups.
	 */
	public void space() {

	}

}
