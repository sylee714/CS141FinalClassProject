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
		//boolean quit = false;
		while (!quit) {
			int option = mainMenu();
			switch (option) {
			case 1:
				game.generateMap();
				gameLoop();
				break;
			// calls on loadGame() to open previously saved game
			case 2:
				//.load();
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

		while (!game.endGame()) {

			System.out.println("Begin your turn player!\n");

			System.out.println(game.printBoard());
			System.out.println("What would you like to do next?\n");

			System.out.println("1)Move \n2)Look \n3)Shoot \n4)Save \n5)Quit \n6)Debug Mode");

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

				//System.out.println("Choose a direction to shoot.\n");
				//System.out.println("1)Left \n2)Right \n3)Up \n4)Down");
				//int direction = keyboard.nextInt();

				playerShoot();
				
				//System.out.println();
				break;
			// Save
			case 4:
				game.save();
				break;
			// Quit
			case 5:
				
				break;
			// Debug
			case 6:
				toggleBoard();
				break;
			default:
				System.out.println("That isn't a valid input try again please.");
				break;
			}
			
			
			
			System.out.println("You have " + game.numberOfBullet() + " bullet.");
			endTurn();
			
			
		} 

	}

	/**
	 * Runs all the methods that should take effect once the player's turn is
	 * over.
	 */
	public void endTurn() {
		
		game.moveEnemy();

		//game.enemyTurn();

		game.setNotFlipped();
		game.useRadar(game.foundRadar());

		if (game.foundRadar()) {
			System.out.println("The brief case is loacated at: " + "Row: " + game.briefCaseRow() 
				+ " Column: " + game.briefCaseColumn());
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
			System.out.println("You currently can't look in that direction player. Look in a valid direction.\n");
		}
		game.playerDetect();
		System.out.println(game.printBoard());

		System.out.println("What would you like to do next?\n");

		System.out.println("1)Move \n2)Shoot \n3)Save \n4)Quit \n5)Debug Mode");

		int choice = keyboard.nextInt();

		switch (choice) {
		// Move
		case 1:
			playerMove();
			break;
		// Shoot
		case 2:

			//System.out.println("Choose a direction to shoot.\n");
			//System.out.println("1)Left \n2)Right \n3)Up \n4)Down");
			//int direction = keyboard.nextInt();

			playerShoot();
			//System.out.println();
			break;
		// Save
		case 3:
			// GameEngine.save();
			break;
		// Quit
		case 4:
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
				System.out.println("Invalid Input. Please enter new direction: ");
				System.out.println(game.displayBoard());
			}

		} while (temp != true);

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
				
			} else {
				
				System.out.println("Failed... Brief case is not found. Search the other rooms. ");
				
			}
			
			break;
			
		case 2:
			
			System.out.println("You missed your chance...");
			
			break;
			
		}
	}

	public void toggleBoard() {
		if (game.isDebug() == false) {
			game.setDebug(true);
		} else {
			game.setDebug(false);
		}
	}

}
