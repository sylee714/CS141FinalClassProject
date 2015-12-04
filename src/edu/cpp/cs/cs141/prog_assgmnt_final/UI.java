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

import java.util.Scanner;

/**
 * This class is the user interface and it meant to handle interaction with the
 * user and the game engine. This class is responsible for printing out and what
 * the user sees and informing the user of what they can do while they are
 * playing the game.
 *
 * @author Seungyun
 * 
 */
public class UI {

	/**
	 * Initializes an empty GameEngine object.
	 */
	private GameEngine game = null;

	/**
	 * Initializes a Scanner to take in user input.
	 */
	private Scanner keyboard = null;

	/**
	 * Boolean to know whether or not the user decides to quit the game.
	 */
	private boolean quit = false;

	/**
	 * This method is a constructor which takes a GameEngine object as an
	 * argument.
	 * 
	 * @param game
	 *            Constructor for a UI object that takes in a scanner and a Game
	 *            Engine object.
	 */
	public UI(GameEngine game) {

		this.game = game;
		keyboard = new Scanner(System.in);

	}

	/**
	 * Greets user on startup and gives 3 options. Starting a new game, Loading
	 * the previous game, and quitting the game.
	 */
	public void startGame() {

		welcomeMessage();

		while (!quit) {

			int option = mainMenu();

			switch (option) {

			case 1:

				game.generateMap();
				gameLoop();
				break;

			case 2:

				game.load();
				gameLoop();
				break;

			case 3:

				System.out.println("Goodbye! Come back soon!");
				quit = true;
				break;

			default:

				System.out.println("Invalid input. Choose from \"1\",\"2\", or \"3\" please.");
				break;

			}

		}

	}

	/**
	 * Prints a welcome message to the user and game rules.
	 */
	public void welcomeMessage() {

		System.out.println("Welcome to Version 1.00 Find the BriefCase Game!\n");

		System.out.println("\n===========================================================================");
		System.out.println("\nNotes: ");
		System.out.println("	You start with 3 live. The game will end either if you lose all of your\n"
				+ "				life points or you find the briefcase. ");
		System.out.println("	'R' - rooms, only one of them has the briefcase ");
		System.out.println("	'B' - briefcase, the object of the game ");
		System.out.println("	'A' - additional bullet, no effect if you already have 1 bullet ");
		System.out.println("	'+' - radar, gives you the location of the briefcase ");
		System.out.println("	'I' - invincibility, you become invincible for 5 turns ");
		System.out.println("	'1-6' - enemies, they will stab you when you are at an adjacent square\n "
				+ "				and you will lose a life point ");
		System.out.println("\n===========================================================================");

	}

	/**
	 * This method returns the value of option that the user chooses.
	 * 
	 * @return What the user sees on start up. Selection decides whether or not
	 *         game is ran, loaded or quit.
	 */
	private int mainMenu() {

		int option = 0;

		System.out.println("Select an option:\n\n1)New Game\n2)Load Game\n3)Quit Game");

		option = keyboard.nextInt();
		keyboard.nextLine();

		return option;

	}

	/**
	 * This method represent a game loop. It does not end until the game ends.
	 * It asks the user for several options: look, move, shoot, save, main menu,
	 * and debug mode.
	 */
	public void gameLoop() {

		while (!game.endGame()) {

			game.playerImmediateLook();

			System.out.println("Begin your turn!\n");
			System.out.println(game.printBoard());

			System.out.println("This is your turn number: " + game.getTurn() + "\n");
			System.out.println("You have " + game.playerLife() + " live(s).");
			System.out.println("You have " + game.numberOfBullet() + " bullet.");
			System.out.println("There are " + game.remainingEnemy() + " enemies.\n");

			System.out.println("What would you like to do next?\n");
			System.out.println("1)Move \n2)Look \n3)Shoot \n4)Save \n5)Main Menu \n6)Debug Mode \n7)Change Difficulty");

			int choice = keyboard.nextInt();
			keyboard.nextLine();

			switch (choice) {

			// Move
			case 1:

				playerMove();
				if (game.northSideOfRoom()) {
					checkRoom();
				}
				break;

			// Look
			case 2:

				playerLook();
				break;

			// Shoot
			case 3:

				if (game.numberOfBullet() == 1) {

					playerShoot();

				} else {

					System.out.println("You are out of ammo.");
				}

				break;

			// Save
			case 4:
				game.save();
				System.out.println("Save was successful.");

				break;

			// Main Menu
			case 5:

				menu();
				break;

			// Debug
			case 6:

				toggleBoard();
				break;

			// Hard mode or Normal mode
			case 7:

				changeDifficulty();
				break;

			default:

				System.out.println("That isn't a valid input try again please.");
				break;

			}

			if (game.invincible()) {

				game.useInvincible();
				System.out.println("\nYou are invincible for " + game.invincibleTurns() + " turn(s).\n");

			}

			if (game.isHardMode()) {

				hardEndTurn();

			} else {

				normalEndTurn();

			}

		}

	}

	/**
	 * Runs all the methods that should take effect once the player's turn is
	 * over.
	 */
	public void normalEndTurn() {

		game.enemyTurn();
		game.moveEnemy();
		game.enemyTurn();

		game.setNotFlipped();

		useRadar();

		if (game.isFoundPlayer()) {

			System.out.println("You died. You have " + game.playerLife() + " live(s).\n");

			game.lifeReset();

		}

	}

	/**
	 * This method runs hard mode methods.
	 */
	public void hardEndTurn() {

		game.enemyTurn();
		game.hardMode();
		game.enemyTurn();

		game.setNotFlipped();

		useRadar();

		if (game.isFoundPlayer()) {

			System.out.println("You died. You have " + game.playerLife() + " live(s).\n");

			game.lifeReset();

		}

	}

	/**
	 * Allows the user to return to the main menu.
	 */
	public void menu() {

		int option = mainMenu();

		switch (option) {

		case 1:

			game.generateMap();
			gameLoop();
			break;

		case 2:

			game.load();
			gameLoop();
			break;

		case 3:

			System.out.println("Goodbye! Come back soon!");
			System.exit(0);
			break;

		default:

			System.out.println("Invalid input. Choose from \"1\",\"2\", or \"3\" please.");
			break;

		}

	}

	/**
	 * Activates the radar power up if it is found by the user. Display's it's
	 * coordinates to the user.
	 */
	public void useRadar() {

		game.useRadar(game.foundRadar());

		if (game.foundRadar()) {

			System.out.println("\nThe brief case is loacated at: " + "Row: " + game.briefCaseRow() + " Column: "
					+ game.briefCaseColumn() + "\n");

		}

	}

	/**
	 * Shoots in the direction the user selects. Either Up, Down, Left, or
	 * Right.
	 */
	public void playerShoot() {

		System.out.println("Choose a direction to shoot.\n");
		System.out.println("1)Left \n2)Right \n3)Up \n4)Down");

		int direction = keyboard.nextInt();
		keyboard.nextLine();

		switch (direction) {

		case 1:
			game.playerAttack(direction);
			break;

		case 2:
			game.playerAttack(direction);
			break;

		case 3:
			game.playerAttack(direction);
			break;

		case 4:
			game.playerAttack(direction);
			break;

		}

	}

	/**
	 * Reveals the two immediate spaces in any direction the user chooses. Then
	 * it allows them to Move, Shoot, Save or go back to the Main Menu.
	 */
	public void playerLook() {

		System.out.println("Choose a direction to look in.\n");
		System.out.println("1)Left \n2)Right \n3)Up \n4)Down");

		int option = keyboard.nextInt();
		keyboard.nextLine();

		try {
			switch (option) {

			// Left
			case 1:

				game.visibilityOfPlayer(1);

				if (game.isRoomIndicator()) {

					System.out.println("\nYou cannot look through the rooms.\n");

				} else {

					if (game.playerDetect()) {

						System.out.println("\nEnemy Ahead!!!\n");
						game.setPlayerDetect(false);

					} else {

						System.out.println("\nClear\n");

					}

				}

				break;

			// Right
			case 2:

				game.visibilityOfPlayer(2);

				if (game.isRoomIndicator()) {

					System.out.println("\nYou cannot look through the rooms.\n");

				} else {

					if (game.playerDetect()) {

						System.out.println("Enemy Ahead!!!");
						game.setPlayerDetect(false);

					} else {

						System.out.println("Clear");

					}

				}

				break;

			// Up
			case 3:

				game.visibilityOfPlayer(3);

				if (game.isRoomIndicator()) {

					System.out.println("\nYou cannot look through the rooms.\n");

				} else {

					if (game.playerDetect()) {

						System.out.println("Enemy Ahead!!!");
						game.setPlayerDetect(false);

					} else {

						System.out.println("Clear");

					}

				}

				break;

			// Down
			case 4:

				game.visibilityOfPlayer(4);

				if (game.isRoomIndicator()) {

					System.out.println("\nYou cannot look through the rooms.\n");

				} else {

					if (game.playerDetect()) {

						System.out.println("\nEnemy Ahead!!!\n");
						game.setPlayerDetect(false);

					} else {

						System.out.println("\nClear\n");

					}

				}

				break;

			default:

				System.out.println("\nThat isn't a valid choice. Please, try it again.");

				break;

			}

		} catch (ArrayIndexOutOfBoundsException e) {

			System.out.println("You currently can't look in that direction. Look in a valid direction.\n");

		}

		System.out.println(game.printBoard());

		System.out.println("What would you like to do next?\n");

		System.out.println("1)Move \n2)Shoot \n3)Save \n4)Main Menu \n5)Debug Mode");

		int choice = keyboard.nextInt();
		keyboard.nextLine();

		switch (choice) {

		// Move
		case 1:

			playerMove();

			if (game.northSideOfRoom()) {

				checkRoom();
			}
			break;

		// Shoot
		case 2:

			if (game.numberOfBullet() == 1) {

				playerShoot();

			} else {

				System.out.println("You are out of ammo.\n");

			}
			break;

		// Save
		case 3:

			game.save();
			System.out.println("Save was successful.\n");
			break;

		// Main Menu
		case 4:

			menu();
			break;

		// Debug
		case 5:

			toggleBoard();
			break;

		// Hard mode or Normal mode
		case 6:

			changeDifficulty();
			break;

		default:

			System.out.println("That isn't a valid input. Please, try it again.\n");
			break;

		}

	}

	/**
	 * Moves the player across the 2D array as long
	 */
	public void playerMove() {

		System.out.println("Choose a direction to move in.\n");
		System.out.println("1)Left \n2)Right \n3)Up \n4)Down");

		boolean temp = false;

		do {

			int direction = keyboard.nextInt();
			keyboard.nextLine();

			switch (direction) {

			// Left
			case 1:

				temp = game.playerMove(1);
				temp = true;
				break;

			// Right
			case 2:

				temp = game.playerMove(2);
				temp = true;
				break;

			// Up
			case 3:

				temp = game.playerMove(3);
				temp = true;
				break;

			// Down
			case 4:

				temp = game.playerMove(4);
				temp = true;
				break;

			}

			if (temp == true)

				temp = true;

			else {

				temp = false;
				System.out.println("Invalid Input. Please enter a new direction: \n");
				System.out.println(game.printBoard());

			}

		} while (!temp);

	}

	/**
	 * Switches the board that is printed from game mode to debug mode.
	 */
	public void toggleBoard() {

		if (game.isDebug() == false) {

			game.setDebug(true);

		} else {

			game.setDebug(false);

		}

	}

	/**
	 * A method that runs when the player walks in front of a room. It asks if
	 * they would like to see the rooms contents and depending on whether or not
	 * the player chooses it will: tell them the contents of the room, or let
	 * them continue through.
	 */
	public void checkRoom() {

		System.out.println(game.printBoard());
		System.out.println("Do you want to check the room? \n");
		System.out.println("1)Yes \n2)No");

		int option = keyboard.nextInt();
		keyboard.nextLine();

		switch (option) {

		case 1:

			game.checkRoom();

			if (game.briefCaseIndicator()) {

				System.out.println("Congratulation! You found the brief case.\n");
				System.out.println("It took you " + game.getTurn() + " turns to complete the game!");
				System.out.println("You have " + game.playerLife() + " lives left!");

				quit = true;

			} else {

				System.out.println("Failed... Brief case is not found. Search the other rooms.\n");

			}

			break;

		case 2:

			System.out.println("You missed your chance...\n");

			break;

		}

	}

	/**
	 * This method lets the user to change the difficulty of the game. It can be
	 * hard mode or normal mode.
	 */
	public void changeDifficulty() {

		System.out.println("\n1)Hard Mode \n2)Normal Mode\n");

		int option = keyboard.nextInt();
		keyboard.nextLine();

		switch (option) {

		case 1:

			game.chooseHardMode(1);
			break;

		case 2:

			game.chooseHardMode(2);
			break;

		}

		System.out.println(game.printBoard());

		System.out.println("What would you like to do next?\n");

		System.out.println("1)Move \n2)Look \n3)Shoot \n4)Save \n5)Main Menu \n6)Debug Mode \n7)Change Difficulty");

		int choice = keyboard.nextInt();
		keyboard.nextLine();

		switch (choice) {

		// Move
		case 1:

			playerMove();
			if (game.northSideOfRoom()) {
				checkRoom();
			}
			break;

		// Look
		case 2:

			playerLook();
			break;

		// Shoot
		case 3:

			if (game.numberOfBullet() == 1) {

				playerShoot();

			} else {

				System.out.println("You are out of ammo.");
			}

			break;

		// Save
		case 4:
			game.save();
			System.out.println("Save was successful.");

			break;

		// Main Menu
		case 5:

			menu();
			break;

		// Debug
		case 6:

			toggleBoard();
			break;

		// Hard mode or Normal mode
		case 7:

			changeDifficulty();
			break;

		default:

			System.out.println("That isn't a valid input try again please.");
			break;

		}

	}

}
