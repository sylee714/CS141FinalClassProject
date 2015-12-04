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
 * This class represents a GameEngine. This is where all the methods that were
 * created in the Map class get called and put together. This class makes the
 * game run. This class keeps a track of all the information such as life
 * points, number of bullet, number of turns, and more on. It also has save and
 * load methods which lets the user to save the game and play it later on.
 * 
 * @author Seungyun
 *
 */
public class GameEngine {

	/**
	 * This field creates the Map that will be used for the game.
	 */
	private Map map = null;

	/**
	 * This is a constructor for GameEngine, it takes a Map as an argument.
	 * 
	 * @param map
	 *            that contains all the objects
	 */
	public GameEngine(Map map) {

		this.map = map;

	}

	/**
	 * This field represents how many turns the user takes.
	 */
	private int turn = 0;

	/**
	 * This field represents whether the game has ended or not.
	 */
	private boolean endGame = false;

	/**
	 * This field represents whether the user chooses to play on debug mode or
	 * not.
	 */
	private boolean debug = false;

	/**
	 * This method generates the map. It calls the methods that generate all the
	 * needed objects.
	 */
	public void generateMap() {

		map.generateEmptySpace();
		map.generateRoomsWithBriefCase();
		map.generatePlayer();
		map.generateEnemy();
		map.generatePowerUps();

	}

	/**
	 * This method returns the value of turn, telling the user how many turns
	 * that they have taken.
	 * 
	 * @return the value of turn
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * This method returns the value of debug, either true or false. If it's
	 * true, the game is in debug mode.
	 * 
	 * @return the value of debug, either true or false
	 */
	public boolean isDebug() {
		return debug;
	}

	/**
	 * This method sets the value of debug, either true or false.
	 * 
	 * @param debug
	 *            set the debug, either true or false
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/**
	 * This method prints the map in debug mode.
	 * 
	 * @return debugged map
	 */
	public String printDebug() {
		return map.printDebug();
	}

	/**
	 * This method prints the map, either in debug mode or in normal mode,
	 * depending on the user' choice.
	 * 
	 * @return the debugged map or the normal map
	 */
	public String printBoard() {

		if (isDebug() == false) {

			return map.toString();

		} else {

			return map.printDebug();
		}

	}

	/**
	 * This method prints the normal map
	 * 
	 * @return normal map
	 */
	public String displayBoard() {

		return map.toString();

	}

	/**
	 * This method indicates if the player found the radar.
	 * 
	 * @return
	 */
	public boolean foundRadar() {

		return map.isRadarIndicator();
	}

	/**
	 * This method takes foundRadar as an argument. If it's true, then it gives
	 * the location of the briefcase to the user.
	 * 
	 * @param the
	 *            value of foundRadar, either true or false
	 */
	public void useRadar(boolean foundRadar) {

		if (foundRadar) {

			map.useRadar();

		}

	}

	/**
	 * This method returns the row index number of the briefcase.
	 * 
	 * @return the row index number of the briefcase
	 */
	public int briefCaseRow() {

		return map.briefCaseRow();

	}

	/**
	 * This method returns the column index number of the briefcase.
	 * 
	 * @return the column index number of the briefcase
	 */
	public int briefCaseColumn() {

		return map.briefCaseColumn();

	}

	/**
	 * This method returns how many turns that the player can be invincible.
	 * 
	 * @return invincible turns
	 */
	public int invincibleTurns() {

		return map.invincibleTurns();

	}

	/**
	 * This method returns the value of invincibleIndicator, either true or
	 * false.
	 * 
	 * @return the value of invincibleIndicator, either true or false
	 */
	public boolean invincible() {

		return map.isInvincibleIndicator();

	}

	/**
	 * This method uses the invinciblility when the player consumes it.
	 */
	public void useInvincible() {

		map.useInvincible(map.invincibleTurns());

	}

	/**
	 * This method returns the value of briefCaseIndicator, which tells the user
	 * if they found the briefcase.
	 * 
	 * @return the value of briefCaseIndicator, either true or false
	 */
	public boolean briefCaseIndicator() {

		return map.isBriefCaseIndicator();

	}

	/**
	 * This method returns how many bullet the player has.
	 * 
	 * @return the value of bullet, either 0 or 1
	 */
	public int numberOfBullet() {

		return map.bullet();

	}

	/**
	 * This method returns the value of northSideOfRoom, either true or false.
	 * If it's true, then the player is at the top side of a room.
	 * 
	 * @return the value of northSideOfRoom, either true or false
	 */
	public boolean northSideOfRoom() {

		return map.isNorthSideOfRoom();

	}

	/**
	 * This method lets the player to check the rooms to find the briefcase.
	 */
	public void checkRoom() {

		map.searchRoom(map.isNorthSideOfRoom());

	}

	/**
	 * This method returns the value of roomIndicator, either true or false, to
	 * check if the player is trying to look through the rooms.
	 * 
	 * @return the value of roomIndicator, either true or false
	 */
	public boolean isRoomIndicator() {

		return map.isRoomIndicator();
	}

	/**
	 * This method represents the player's look method. The player can look in
	 * left, right, up, or down direction.
	 * 
	 * @param direction
	 *            the player "looks".
	 */
	public void visibilityOfPlayer(int direction) {

		switch (direction) {

		case 1:
			map.leftVisibilityOfPlayer();
			break;

		case 2:
			map.rightVisibilityOfPlayer();
			break;

		case 3:
			map.upVisibilityOfPlayer();
			break;

		case 4:
			map.downVisibilityOfPlayer();
			break;

		}

	}

	/**
	 * This method lets the player to have an immediate vision: one tile in each
	 * direction.
	 */
	public void playerImmediateLook() {

		map.playerImmediateLook();

	}

	/**
	 * This method lets the player detects if enemies are located in the
	 * direction that the player is looking at.
	 */
	public boolean playerDetect() {

		return map.isPlayerDetect();

	}

	/**
	 * This method sets the value of setPlayerDetect, so the value does not stay
	 * as either true or false.
	 * 
	 * @param danger,
	 *            either true or false
	 */
	public void setPlayerDetect(boolean danger) {

		map.setPlayerDetect(danger);

	}

	/**
	 * This method sets everything back to not flipped, except the player, after
	 * the player performs a look action.
	 */
	public void setNotFlipped() {

		map.setNotFlipped();

	}

	/**
	 * This method represents the movement of the player. The player can go
	 * left, right, up, or down. Then, it increases the turn by 1.
	 * 
	 * @param direction
	 *            that the user chooses
	 * @return the value of boolean, either true or false, to check if it's a
	 *         valid move
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

		if (temp == true) {

			turn++;
			return temp;

		} else {

			temp = false;
			return temp;

		}

	}

	/**
	 * This method lets the player to shoot. The player can shoot in any
	 * directions: left, right, up, or down. Then, it increases the turn by 1.
	 * 
	 * @param direction
	 *            the user chooses
	 */
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

		turn++;
	}

	public void chooseHardMode(int option) {

		switch (option) {
		case 1:
			map.setHardMode(true);
			break;
		case 2:
			map.setHardMode(false);
			break;

		}
	}

	public void hardMode() {

		map.hardMode();

	}

	/**
	 * This method lets enemies to move and it catches
	 * 'ArrayIndexOutOfBoundsException' if some enemies happen to go out of
	 * bounds.
	 */
	public void moveEnemy() {
		try {

			map.moveEnemy();

		} catch (ArrayIndexOutOfBoundsException e) {

		}

	}

	/**
	 * This method represents the visibility of enemies. Enemies check the tiles
	 * near by them to see if the player is located.
	 */

	public void visibilityOfEnemy() {

		map.visibilityOfEnemy();

	}

	/**
	 * This method represents enemy's turn. If they find the player, then they
	 * kill the player and the player loses a life point and goes back to the
	 * initial point.
	 */
	public void enemyTurn() {

		if (map.isAbleEnemyAttack()) {

			visibilityOfEnemy();
			map.enemyAttack(map.isFoundPlayer());
			map.playerGotDamaged(map.isFoundPlayer());

		}

	}

	/**
	 * This method returns the value of foundPlayer, either true or false. If
	 * it's true, then enemies attack the player; otherwise, they move randomly.
	 * 
	 * @return the value of foundPlayer, either true of false
	 */
	public boolean isFoundPlayer() {

		return map.isFoundPlayer();

	}

	/**
	 * This returns how many life points the player has.
	 * 
	 * @return the value of life points
	 */
	public int playerLife() {

		return map.playerLife();

	}

	/**
	 * This method sets the foundPlayer back to false when enemies kill the
	 * player so that the value does not stay as true, which will constantly
	 * kill the player.
	 */
	public void lifeReset() {

		map.setFoundPlayer(false);

	}

	public int remainingEnemy() {

		return map.checkEnemyRemaining();

	}

	/**
	 * This method represents the end of the game. The game ends when either the
	 * player loses all the life points or the player finds the briefcase.
	 * 
	 * @return the value of endGame, either true or false
	 */
	public boolean endGame() {
		if (map.playerLife() == 0 || map.isBriefCaseIndicator() == true) {
			endGame = true;
		}
		return endGame;

	}

	/**
	 * This method lets the user to save the game. It serializes the map, where
	 * all the objects are created, then write the file.
	 */
	public void save() {

		try {

			FileOutputStream fos = new FileOutputStream("Save.dat");

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(map);

			fos.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	/**
	 * This method lets the user to load the game that they have saved before.
	 * It reads the saved file.
	 */
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

			e.printStackTrace();

		}

	}

}
