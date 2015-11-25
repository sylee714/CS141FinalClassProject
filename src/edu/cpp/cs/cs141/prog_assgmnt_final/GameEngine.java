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

	private int turn = 0;

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
	 * @param debug
	 *            the debug to set
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public void generateMap() {
		map.generateEmptySpace();
		map.generateRoomsWithBriefCase();
		map.generatePlayer();
		map.generateEnemy();
		map.generatePowerUps();
	}

	public String printBoard() {
		if (isDebug() == false) {
			return map.toString();

		} else {
			return map.printDebug();
		}
	}

	public String displayBoard() {
		return map.toString();
	}

	/**
	 * 
	 * @param direction
	 *            the player "looks".
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

	/**
	 * @param direction
	 * @return
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

		temp = (temp == true) ? true : false;

		return temp;
	}

	public String printDebug() {
		return map.printDebug();
	}

	/**
	 * Keeps track of how many turns the player makes.
	 */
	public void playerTurn() {
		turn++;
	}

	/**
	 * @return the turn
	 */
	public int getTurn() {
		return turn;
	}

	public void moveEnemy() {
	
		try {
			map.moveEnemy();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Enemies move out of bounds");
		}

	}

	public void backToSpawnLocation() {
		map.generatePlayer();
	}

	public boolean endGame() {
		boolean won = false;
		return won;

	}

	public void playerDetect() {
		map.playerDetect();
	}

	public void setNotFlipped() {
		map.setNotFlipped();
	}
	
	public void Save()
	{
	FileOutputStream outStream = new FileOutputStream("Objects.dat");
  	ObjectOutputStream objectOutputFile = new ObjectOutputStream(outStream);
  	objectOutputFile.writeObject(GameDataSave);
	objectOutputFile.close();	
	}

<<<<<<< HEAD
	public void useRadar() {
		map.useRadar();
	}
	
	/*
	public boolean enemyAttack() {
		map.visibilityOfEnemy();
		map.enemyAttack(foundPlayer);
		
		return foundPlayer;
	}
	*/
=======
	public void Load()
	{
	FileInputStream inStream = new FileInputStream("Objects.dat");
	ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
	objectInputFile.readObject(GameDataSave);
  	objectInputFile.close();
  	
	}
>>>>>>> origin/master
}
