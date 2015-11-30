/**
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #Final (Group Project)
 *
 * <description-of-assignment>
 *
 * Team Liquid 
 *   <Anthony Vu, Victor Darkes, Seungyun Lee, Jeffrey Lee>
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.util.Scanner;

/**
 * This class is the user interface and it meant to handle interaction 
 * with the user and the game engine. This class is responsible for 
 * printing out and what the user sees and informing the user of
 * what they can do while they are playing the game.
 *
 */
public class UI {

	/**
	 * 
	 */
	private GameEngine game = null;

	private Scanner keyboard = null;

	private boolean quit = false;

	public UI(GameEngine game) {
		this.game = game;
		keyboard = new Scanner(System.in);
	}

	/**
	 * Greets player on startup and gives 3 options. Starting a new game,
	 * Loading the previous game, and quitting the game.
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
				System.out
						.println("Invalid input. Choose from \"1\",\"2\", or \"3\" please.");
				break;

			}

		}

	}
	


	/**
	 * Prints a welcome message to the user.
	 */
	public void welcomeMessage() {
		System.out.println("Hi There Player!\n");
	}

	/**
	 * @return What the user sees on start up. Selection decided
	 * whether or not game is ran, loaded or quit.
	 */
	private int mainMenu() {
		int option = 0;
		System.out.println("Select an option:\n\n1)New Game\n2)Load Game\n3)Quit Game");
		option = keyboard.nextInt();
		keyboard.nextLine();

		return option;

	}

	public void gameLoop() {

		while (!game.endGame()) {

			System.out.println("Begin your turn player!\n");

			System.out.println(game.printBoard());
			System.out.println("What would you like to do next?\n");

			System.out
					.println("1)Move \n2)Look \n3)Shoot \n4)Save \n5)Main Menu \n6)Debug Mode");

			int choice = keyboard.nextInt();

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
				if (game.numberOfBullet() == 1)
					playerShoot();
				else {
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
			default:
				System.out
						.println("That isn't a valid input try again please.");
				break;
			}

			if (game.invincible()) {
				System.out.println("You consumed invincibility");
				game.useInvincible();
				System.out.println("You are invincible for: "
						+ game.invincibleTurns());
			}

			
			endTurn();
		}

	}

	/**
	 * Runs all the methods that should take effect once the player's turn is
	 * over.
	 */
	public void endTurn() {
		game.moveEnemy();
		game.enemyTurn();
		game.setNotFlipped();
		useRadar();
		if (game.isFoundPlayer())
			System.out.println("You died. You have " + game.playerLife()
					+ " lives left player.\n");
		game.lifeReset();
	}

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
			System.out
					.println("Invalid input. Choose from \"1\",\"2\", or \"3\" please.");
			break;}	
	}
	
	public void useRadar() {
		game.useRadar(game.foundRadar());
		if (game.foundRadar()) {
			System.out.println("The brief case is loacated at: " + "Row: "
					+ game.briefCaseRow() + " Column: "
					+ game.briefCaseColumn());
		}
	}

	public void playerShoot() {
		System.out.println("Choose a direction to shoot.\n");
		System.out.println("1)Left \n2)Right \n3)Up \n4)Down");
		int direction = keyboard.nextInt();
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
		System.out.println("You have " + game.numberOfBullet() + " bullet.");
	}

	public void playerLook() {
		System.out.println("Choose a direction to look in.\n");
		System.out.println("1)Left \n2)Right \n3)Up \n4)Down");
		int option = keyboard.nextInt();
		try {
			switch (option) {
			// Left
			case 1:
				game.visibilityOfPlayer(1);
				break;
			// Right
			case 2:
				game.visibilityOfPlayer(2);
				break;
			// Up
			case 3:
				game.visibilityOfPlayer(3);
				break;
			// Down
			case 4:
				game.visibilityOfPlayer(4);
				break;
			default:
				System.out.println("That isn't a valid choice player.");
				break;

			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out
					.println("You currently can't look in that direction player. Look in a valid direction.\n");
		}
		game.playerDetect();
		System.out.println(game.printBoard());

		System.out.println("What would you like to do next?\n");

		System.out.println("1)Move \n2)Shoot \n3)Save \n4)Main Menu \n5)Debug Mode");

		int choice = keyboard.nextInt();

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
			if (game.numberOfBullet() == 1)
				playerShoot();
			else {
				System.out.println("You are out of ammo.");
			}
			break;
		// Save
		case 3:
			game.save();
			System.out.println("Save was successful.");
			break;
		// Main Menu
		case 4:
			menu();
			break;
		// Debug
		case 5:
			toggleBoard();
			break;
		default:
			System.out.println("That isn't a valid input try again please.");
			break;
		}
	}

	public void playerMove() {

		System.out.println("Choose a direction to move in.\n");
		System.out.println("1)Left \n2)Right \n3)Up \n4)Down");

		// true = correct choice
		boolean temp = true;

		do {
			int direction = keyboard.nextInt();

			switch (direction) {
			// Left
			case 1:
				temp = game.playerMove(1);
				break;
			// Right
			case 2:
				temp = game.playerMove(2);
				break;
			// Up
			case 3:
				temp = game.playerMove(3);
				break;
			// Down
			case 4:
				temp = game.playerMove(4);
				break;
			}

			if (temp == true)
				temp = true;
			else {
				temp = false;
				System.out
						.println("Invalid Input. Please enter new direction: ");
				System.out.println(game.printBoard());
			}

		} while (temp != true);

	}

	public void toggleBoard() {
		if (game.isDebug() == false) {
			game.setDebug(true);
		} else {
			game.setDebug(false);
		}
	}

	public void checkRoom() {
		System.out.println(game.printBoard());
		System.out.println("Do you want to check the room? ");
		System.out.println("1)Yes \n2)No");

		int option = keyboard.nextInt();

		switch (option) {
		case 1:

			game.checkRoom();

			if (game.briefCaseIndicator()) {

				System.out.println("Congratulation! You found the brief case.");
				System.out.println("It took you " + game.getTurn()
						+ " turns to complete the game!");
				System.out.println("You have " + game.playerLife()
						+ " lives left!");

			} else {

				System.out
						.println("Failed... Brief case is not found. Search the other rooms. ");

			}

			break;

		case 2:

			System.out.println("You missed your chance...");

			break;

		}
	}

}
