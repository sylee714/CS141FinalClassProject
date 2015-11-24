/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.util.Scanner;

/**
 * @author Seungyun
 *
 */
public class UI {

	private GameEngine game = null;

	private Scanner keyboard = null;

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
		boolean quit = false;
		while (!quit) {
			int option = mainMenu();
			switch (option) {
			case 1:
				game.generateMap();
				gameLoop();
				break;
			// calls on loadGame() to open previously saved game
			case 2:
				// loadGame();
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
	 * Prints a welcome message to the player.
	 */
	public void welcomeMessage() {
		System.out.println("Hi There Player!\n");
	}

	private int mainMenu() {
		int option = 0;
		System.out.println("Select an option:\n\n1)New Game\n2)Load Game\n3)Quit Game");
		option = keyboard.nextInt();
		keyboard.nextLine();

		return option;

	}

	public void gameLoop() {

		while (!game.gameWon()) {

			System.out.println("Begin your turn player!\n");
			visibilityOfPlayer();
			System.out.println(game.printDebug());
			// System.out.println(game.displayBoard());
			System.out.println("Chose a direction to look in.\n");
			System.out.println("1)Left \n2)Right \n3)Up \n4)Down");

			int option = keyboard.nextInt();
			try {
				switch (option) {
				// Left
				case 1:
					game.playerLook(1);
					break;
				// Right
				case 2:
					game.playerLook(2);
					break;
				// Up
				case 3:
					game.playerLook(3);
					break;
				// Down
				case 4:
					game.playerLook(4);
					break;
				default:
					System.out.println("That isn't a valid choice player.");
					break;

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("You currently can't look in that direction player. Look in a valid direction.\n");
			}
			game.playerDetect();
			System.out.println("What would you like to do next?\n");
			// System.out.println(game.printDebug());
			// System.out.println(game.displayBoard());
			System.out.println("1)Move \n2)Shoot \n3)Save \n4)Quit");

			int choice = keyboard.nextInt();

			switch (choice) {
			// Move
			case 1:
				System.out.println("Chose a direction to move in.\n");
				System.out.println("1)Left \n2)Right \n3)Up \n4)Down");

				playerMove();

				break;
			// Shoot
			case 2:
				break;
			// Save
			case 3:
				break;
			// Quit
			case 4:
				break;
			default:
				System.out.println("That isn't a valid input try again please.");
				break;

			}
			// game.enemyMove();
			game.setNotFlipped();
			game.useRadar();
			// System.out.println(game.printDebug());
			// System.out.println(game.displayBoard());
		}

	}

	public void playerMove() {

		boolean temp = false;

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

			//System.out.println("UIClass playerMove() temp variable: " + temp);

			if (temp == true)
				temp = true;
			else {
				temp = false;
				System.out.println(game.printDebug());
				System.out.println("Invalid move. Please enter new direction: ");
			}

		} while (temp == false);

	}

	public void visibilityOfPlayer() {
		game.visibilityOfPlayer();
	}

}
