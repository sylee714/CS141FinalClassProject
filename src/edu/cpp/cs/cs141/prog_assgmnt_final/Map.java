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

	public GameEntity[][] getMap() {
		return map;
	}

	public void setMap(GameEntity[][] tempMap) {
		this.map = tempMap;
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

	/**
	 * This method generates the player's character at position (8,0) which is
	 * the initial/starting position.
	 */
	public void generatePlayer() {
		map[8][0] = new Player();
		
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

			if (map[row][column].getFront().equals(" ") && map[row][column] != map[5][0]
					&& map[row][column] != map[5][1] && map[row][column] != map[5][2] && map[row][column] != map[5][3]
					&& map[row][column] != map[6][0] && map[row][column] != map[6][1] && map[row][column] != map[6][2]
					&& map[row][column] != map[6][3] && map[row][column] != map[7][0] && map[row][column] != map[7][2]
					&& map[row][column] != map[7][3] && map[row][column] != map[8][1] && map[row][column] != map[8][2]
					&& map[row][column] != map[8][3]) {
				map[row][column] = new Enemy();
				++enemyCount;
			}

		} while (enemyCount < 6);

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
				map[row][column] = new Radar();
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
				map[row][column] = new AdditionalBullet();
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
				map[row][column] = new Invincibility();
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
/*
 * use as refereance
 * 
	public void playerMove(int movement) {
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				if (map[i][j].getFront().equals("P")) {
					GameEntity temp;

					try {
						switch (movement) {
						// Left
						case 1:
			
							temp = map[i][j - 1];
							map[i][j - 1] = map[i][j];
							map[i][j] = temp;

							break;
						// Right
						case 2:
							temp = map[i][j + 1];
							map[i][j + 1] = map[i][j];
							map[i][j] = temp;

							break;
						// Up
						case 3:
							temp = map[i - 1][j];
							map[i - 1][j] = map[i][j];
							map[i][j] = temp;

							break;
						// Down
						case 4:

							temp = map[i + 1][j];
							map[i + 1][j] = map[i][j];
							map[i][j] = temp;

							break;

						}
					} catch (ArrayIndexOutOfBoundsException e) {

					}
				}
			}
		}
	}
*/
	public void playerLook(int direction) {
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				if (map[i][j].getFront().equals("P")) {
					switch (direction) {
					// Left
					case 1:
						map[i][j - 2].setFlipped(true);
						map[i][j - 1].setFlipped(true);
						break;
					// Right
					case 2:
						map[i][j + 2].setFlipped(true);
						map[i][j + 1].setFlipped(true);
						break;
					// Up
					case 3:
						map[i - 2][j].setFlipped(true);
						map[i - 1][j].setFlipped(true);
						break;
					// Down
					case 4:
						map[i + 2][j].setFlipped(true);
						map[i + 1][j].setFlipped(true);
						break;
					}
				}
			}
		}

	}
	
	public void up(String GameEntity) {
		for (int i=0; i < map.length; ++i) {
			for (int j=0; j < map[i].length; ++j) {
				if(map[i][j].getFront().equals(GameEntity)) {
					map[i-1][j] = map[i][j];
					map[i][j] = new EmptySpace();
				}
			}
		}
		
	}
	
	public void down(String GameEntity) {
		for (int i=0; i < map.length; ++i) {
			for (int j=0; j < map[i].length; ++j) {
				if(map[i][j].getFront().equals(GameEntity)) {
					map[i+1][j] = map[i][j];
					map[i][j] = new EmptySpace();
				}
			}
		}
		
	}
	
	public void right(String GameEntity) {
		for (int i=0; i < map.length; ++i) {
			for (int j=0; j < map[i].length; ++j) {
				if(map[i][j].getFront().equals(GameEntity)) {
					map[i][j+1] = map[i][j];
					map[i][j] = new EmptySpace();
				}
			}
		}
		
	}
	
	public void left(String GameEntity) {
		for (int i=0; i < map.length; ++i) {
			for (int j=0; j < map[i].length; ++j) {
				if(map[i][j].getFront().equals(GameEntity)) {
					map[i][j-1] = map[i][j];
					map[i][j] = new EmptySpace();
				}
			}
		}
		
	}
	
	public void enemyMove() {
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				if (map[i][j].getFront().equals("E")) {
					GameEntity temp;
					Random r = new Random();
					int movement;
					movement = r.nextInt(4) + 1;
					switch (movement) {
					// Left
					case 1:
						temp = map[i][j - 1];
						map[i][j - 1] = map[i][j];
						map[i][j] = temp;

						break;
					// Right
					case 2:
						temp = map[i][j + 1];
						map[i][j + 1] = map[i][j];
						map[i][j] = temp;

						break;
					// Up
					case 3:
						temp = map[i - 1][j];
						map[i - 1][j] = map[i][j];
						map[i][j] = temp;

						break;
					// Down
					case 4:

						temp = map[i + 1][j];
						map[i + 1][j] = map[i][j];
						map[i][j] = temp;

						break;

					}
				}
			}
		}
	}
	
	public void search(int movement) {
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				if(map[i][j].equals("P")) {
					switch (movement) {
					case 1: map[i][j].up(i, j);
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
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				if (map[i][j].equals("P")) {
					map[i][j] = new EmptySpace();
				}
			}
		}
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
	 * Space to hold power-ups.
	 */
	public void space() {

	}

	public void setMap(GameEntity gameEntity) {
		// TODO Auto-generated method stub

	}

}
