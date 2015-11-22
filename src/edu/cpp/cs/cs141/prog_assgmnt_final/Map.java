package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.util.Random;

/**
 * @author Seungyun
 *
 */
public class Map {

	/**
	 * The size of the map.
	 */
	private GameEntity[][] map = new GameEntity[9][9];

	private Player player = new Player();

	private AdditionalBullet bullet = new AdditionalBullet();

	private Radar radar = new Radar();

	private Invincibility invincible = new Invincibility();

	private BriefCase briefCase = new BriefCase();

	private Enemy enemy1 = new Enemy();
	private Enemy enemy2 = new Enemy();
	private Enemy enemy3 = new Enemy();
	private Enemy enemy4 = new Enemy();
	private Enemy enemy5 = new Enemy();
	private Enemy enemy6 = new Enemy();

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
	 * located. When 6 enemies are generated the 'do while loop' stops.
	 */
	public void generateEnemy() {
		int enemyCount = 0;
		Random r = new Random();
		do {

			int row = r.nextInt(9);
			int column = r.nextInt(9);

			if (map[row][column].getFront().equals(" ")
					&& map[row][column] != map[5][0]
					&& map[row][column] != map[5][1]
					&& map[row][column] != map[5][2]
					&& map[row][column] != map[5][3]
					&& map[row][column] != map[6][0]
					&& map[row][column] != map[6][1]
					&& map[row][column] != map[6][2]
					&& map[row][column] != map[6][3]
					&& map[row][column] != map[7][0]
					&& map[row][column] != map[7][2]
					&& map[row][column] != map[7][3]
					&& map[row][column] != map[8][1]
					&& map[row][column] != map[8][2]
					&& map[row][column] != map[8][3]) {

				for (int i = 1; i < 7; ++i) {
					updateEnemyLocation(i, row, column);
				}
				++enemyCount;
			}

		} while (enemyCount < 6);

	}

	public void updateEnemyLocation(int i, int row, int column) {

		switch (i) {
		case 1:
			map[row][column] = enemy1;
			enemy1.setRow(row);
			enemy1.setColumn(column);
			break;
		case 2:
			map[row][column] = enemy2;
			enemy1.setRow(row);
			enemy1.setColumn(column);
			break;
		case 3:
			map[row][column] = enemy3;
			enemy1.setRow(row);
			enemy1.setColumn(column);
			break;
		case 4:
			map[row][column] = enemy4;
			enemy1.setRow(row);
			enemy1.setColumn(column);
			break;
		case 5:
			map[row][column] = enemy5;
			enemy1.setRow(row);
			enemy1.setColumn(column);
			break;
		case 6:
			map[row][column] = enemy6;
			enemy1.setRow(row);
			enemy1.setColumn(column);
			break;
		}

	}

	/**
	 * This method generates a radar. Its position is generated randomly and the
	 * 'if statement' filters positions where it cannot be located. When 1 radar
	 * is generated, the 'do while' loop stops.
	 */
	public void generateRadar() {

		Random r = new Random();
		int numberOfRadar = 0;
		do {
			int row = r.nextInt(9);
			int column = r.nextInt(9);
			if (map[row][column].getFront().equals(" ")) {
				map[row][column] = radar;
				radar.setRow(row);
				radar.setColumn(column);

				++numberOfRadar;
			}

		} while (numberOfRadar < 1);

	}

	/**
	 * This method generates a bullet. Its position is generated randomly and
	 * the 'if statement' filters positions where it cannot be located. When 1
	 * bullet is generated, the 'do while' loop stops.
	 */
	public void generateAdditionalBullet() {
		Random r = new Random();
		int numberOfBullet = 0;

		do {
			int row = r.nextInt(9);
			int column = r.nextInt(9);
			if (map[row][column].getFront().equals(" ")) {
				map[row][column] = bullet;
				bullet.setRow(row);
				bullet.setColumn(column);
				++numberOfBullet;
			}

		} while (numberOfBullet < 1);

	}

	/**
	 * This method generates a invincible power-up. Its position is generated
	 * randomly and the 'if statement' filters positions where it cannot be
	 * located. When 1 invincible power-up is generated, the 'do while' loop
	 * stops.
	 */
	public void generateInvincibility() {
		Random r = new Random();
		int numberOfInvicible = 0;

		do {
			int row = r.nextInt(9);
			int column = r.nextInt(9);
			if (map[row][column].getFront().equals(" ")) {
				map[row][column] = invincible;
				invincible.setRow(row);
				invincible.setColumn(column);
				++numberOfInvicible;
			}

		} while (numberOfInvicible < 1);

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

<<<<<<< HEAD
	public void movePlayer(int movement) {
		int tempRow = player.getRow();
		int tempColumn = player.getColumn();
		
		

		player.move(movement);
		
		GameEntity tempSpace = map[player.getRow()][player.getColumn()];
		
		player.setRow(player.getRow());
		player.setColumn(player.getColumn());

		map[tempRow][tempColumn] = tempSpace;
		map[player.getRow()][player.getColumn()] = player;
	
	}

=======
	/**
	 * @param direction
	 *            immediate area next to player in which they can see without
	 *            needing to "Look".
	 */
>>>>>>> origin/master
	public void visibilityOfPlayer(int direction) {
		for (int i = 1; i < 2; ++i) {
			switch (direction) {
			// left
			case 1:
				map[player.getRow()][player.getColumn() - i].setFlipped(true);
				break;
			// right
			case 2:
				map[player.getRow()][player.getColumn() + i].setFlipped(true);
				break;
			// up
			case 3:
				map[player.getRow() - i][player.getColumn()].setFlipped(true);
				break;
			// down
			case 4:
				map[player.getRow() + i][player.getColumn()].setFlipped(true);
				break;

			}
		}
	}
<<<<<<< HEAD
	
	public void enemyMove2() {
		for (int i = 1; i < 7; ++i) {
			
		}
=======

	/**
	 * @param direction
	 *            the player can "Look" in.
	 */
	public void playerLook(int direction) {
		for (int i = 1; i < 3; ++i) {
			switch (direction) {
			// left
			case 1:
				map[player.getRow()][player.getColumn() - i].setFlipped(true);
				break;
			// right
			case 2:
				map[player.getRow()][player.getColumn() + i].setFlipped(true);
				break;
			// up
			case 3:
				map[player.getRow() - i][player.getColumn()].setFlipped(true);
				break;
			// down
			case 4:
				map[player.getRow() + i][player.getColumn()].setFlipped(true);
				break;

			}
		}
	}

	public void movePlayer(int movement) {
		int tempRow = player.getRow();
		int tempColumn = player.getColumn();

		player.move(movement);
		player.setRow(player.getRow());
		player.setColumn(player.getColumn());

		map[tempRow][tempColumn] = new EmptySpace();
		map[player.getRow()][player.getColumn()] = player;
		// System.out.println(tempRow + tempColumn);
		// System.out.println(player.getRow() + player.getColumn());

>>>>>>> origin/master
	}
	

	/*
	 * use as refereance
	 * 
	 * public void playerMove(int movement) { for (int i = 0; i < map.length;
	 * ++i) { for (int j = 0; j < map[i].length; ++j) { if
	 * (map[i][j].getFront().equals("P")) { GameEntity temp;
	 * 
	 * try { switch (movement) { // Left case 1:
	 * 
	 * temp = map[i][j - 1]; map[i][j - 1] = map[i][j]; map[i][j] = temp;
	 * 
	 * break; // Right case 2: temp = map[i][j + 1]; map[i][j + 1] = map[i][j];
	 * map[i][j] = temp;
	 * 
	 * break; // Up case 3: temp = map[i - 1][j]; map[i - 1][j] = map[i][j];
	 * map[i][j] = temp;
	 * 
	 * break; // Down case 4:
	 * 
	 * temp = map[i + 1][j]; map[i + 1][j] = map[i][j]; map[i][j] = temp;
	 * 
	 * break;
	 * 
	 * } } catch (ArrayIndexOutOfBoundsException e) {
	 * 
	 * } } } } }
	 */
	/*
	 * public void playerLook(int direction) { for (int i = 0; i < map.length;
	 * ++i) { for (int j = 0; j < map[i].length; ++j) { if
	 * (map[i][j].getFront().equals("P")) { switch (direction) { // Left case 1:
	 * map[i][j - 2].setFlipped(true); map[i][j - 1].setFlipped(true); break; //
	 * Right case 2: map[i][j + 2].setFlipped(true); map[i][j +
	 * 1].setFlipped(true); break; // Up case 3: map[i - 2][j].setFlipped(true);
	 * map[i - 1][j].setFlipped(true); break; // Down case 4: map[i +
	 * 2][j].setFlipped(true); map[i + 1][j].setFlipped(true); break; } } } }
	 * 
	 * }
	 */
	public void enemyMove() {
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				if (map[i][j].getFront().equals("E")) {
					GameEntity temp;
					Random r = new Random();
					int movement;
					movement = r.nextInt(4) + 1;

					try {
						switch (movement) {
						// Left

						case 1:
							try {
								temp = map[i][j - 1];
								map[i][j - 1] = map[i][j];
								map[i][j] = temp;
							} catch (ArrayIndexOutOfBoundsException e) {
								System.out.println("Left");
							}
							break;
						// Right
						case 2:
							try {
								temp = map[i][j + 1];
								map[i][j + 1] = map[i][j];
								map[i][j] = temp;
							} catch (ArrayIndexOutOfBoundsException e) {
								System.out.println("Right");
							}

							break;
						// Up
						case 3:
							try {
								temp = map[i - 1][j];
								map[i - 1][j] = map[i][j];
								map[i][j] = temp;
							} catch (ArrayIndexOutOfBoundsException e) {
								System.out.println("Up");
							}
							break;
						// Down
						case 4:
							try {
								temp = map[i + 1][j];
								map[i + 1][j] = map[i][j];
								map[i][j] = temp;
							} catch (ArrayIndexOutOfBoundsException e) {
								System.out.println("down");
							}

							break;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("You dork");

					}
				}
			}
		}
	}

	public void setNotFlipped() {
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				map[i][j].setFlipped(false);
			}
		}
	}

	public void initialPoint() {
		
		GameEntity tempSpace = map[8][0]; 
		map[player.getRow()][player.getColumn()] = tempSpace;
		map[8][0] = player;
		player.setRow(8);
		player.setColumn(0);
	
	}

}
