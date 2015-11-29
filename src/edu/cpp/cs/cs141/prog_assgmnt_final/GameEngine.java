/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import edu.cpp.cs.cs141.prog_assgmnt_final.Map;

import java.io.*;
import java.util.Random;

/**
 * @author Seungyun
 *
 */
public class GameEngine {

	private static final Object GameDataSave = null;

	private Map map = null;

	public GameEngine(Map map) {
		this.map = map;
	}

	private int turn = 0;

	private boolean attacked = false;

	private boolean endGame = false;

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
		// map.useRadar();

	}

	public int briefCaseRow() {
		return map.briefCaseRow();
	}

	public int briefCaseColumn() {
		return map.briefCaseColumn();
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

	public boolean foundRadar() {

		return map.isRadarIndicator();
	}

	public void useRadar(boolean foundRadar) {

		if (foundRadar) {
			map.useRadar();
		}

	}

	/*
	 * public void visibilityOfPlayer(int direction) {
	 * 
	 * switch (direction) { // Left case 1: map.visibilityOfPlayer(1); break; //
	 * Right case 2: map.visibilityOfPlayer(2); break; // Up case 3:
	 * map.visibilityOfPlayer(3); break; // Down case 4:
	 * map.visibilityOfPlayer(4); break; default: System.out.println(
	 * "That isn't a valid choice player."); break; } }
	 */
	/**
	 * @param direction
	 * @return
	 */

	public boolean playerMove(int direction) {
		boolean temp = true;

		switch (direction) {
		// left
		case 1:
			temp = map.movePlayer(4);
			if (map.isRadarIndicator()) {
				map.useRadar();
			}
			break;
		// Right
		case 2:
			temp = map.movePlayer(3);
			if (map.isRadarIndicator()) {
				map.useRadar();
			}
			break;
		// Up
		case 3:
			temp = map.movePlayer(1);
			if (map.isRadarIndicator()) {
				map.useRadar();
			}
			break;
		// Down
		case 4:
			temp = map.movePlayer(2);
			if (map.isRadarIndicator()) {
				map.useRadar();
			}
			break;
		}

		temp = (temp == true) ? true : false;

		return temp;
	}

	public String printDebug() {
		return map.printDebug();
	}

	public void playerTurn() {

	}

	public int getTurn() {
		return turn;
	}

	public void moveEnemy() {
		try {
			map.moveEnemy();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("An enemy moved out of bounds");
		}
	}

	public void backToSpawnLocation() {
		map.generatePlayer();
	}

	public int numberOfBullet() {
		return map.bullet();
	}

	public void playerAttack(int direction) {

		switch (direction) {

		// left
		case 1:
			if (map.checkBullet()) {
				map.shootLeft();
				map.useBullet();
			}
			break;
		// right
		case 2:
			if (map.checkBullet()) {
				map.shootRight();
				map.useBullet();
			}
			break;
		// up
		case 3:
			if (map.checkBullet()) {
				map.shootUp();
				map.useBullet();
			}
			break;
		// down
		case 4:
			if (map.checkBullet()) {
				map.shootDown();
				map.useBullet();
			}
			break;
		}

	}

	/**
	 * 
	 * @param direction
	 *            player has immediate visibility of each turn.
	 */

	public void visibilityOfEnemy() {
		try {
			map.visibilityOfEnemy(1);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			map.visibilityOfEnemy(2);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			map.visibilityOfEnemy(3);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
			map.visibilityOfEnemy(4);
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	public void enemyTurn() {
		
		map.useInvincibleboolean(map.isInvincibleIndicator()); 
		
		if (map.isAbleEnemyAttack()) {
			
		visibilityOfEnemy();
		
		map.enemyAttack(map.isFoundPlayer());
		
		System.out.println("Found Player: " + map.isFoundPlayer());
		
		map.playerGotDamaged(map.isFoundPlayer());
		
		map.initialPoint();
		
		}

		
	}

	public boolean endGame() {
		if (map.playerLife() == 0) {
			endGame = true;
		}
		return endGame;

	}

	public void playerDetect() {
		map.playerDetect();
	}

	public void setNotFlipped() {
		map.setNotFlipped();

	}

	public void save() {
		try {

			FileOutputStream fos = new FileOutputStream("Save.dat");

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(map);

			fos.close();

		} catch (IOException e) {

			System.out.println(e.getMessage());

		}

	}

	public void load() {

		try {

			FileInputStream fis = new FileInputStream("Save.dat");

			ObjectInputStream ois = new ObjectInputStream(fis);

			try {

				map = (Map) ois.readObject();

			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}

			fis.close();
		} catch (IOException e) {

		}

	}

}
