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
<<<<<<< HEAD
	
	private GameEngine game = null;

	private Scanner keyboard = null;

	public UI(GameEngine game) {
		this.game = game;
		keyboard = new Scanner(System.in);
	}

=======

	private GameEngine game = null;

	private Scanner keyboard = null;

	public UI(GameEngine game) {
		this.game = game;
		keyboard = new Scanner(System.in);
	}

>>>>>>> origin/master
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
<<<<<<< HEAD
				System.out
						.println("Invalid input. Choose from \"1\",\"2\", or \"3\" please.");
=======
				error0();
>>>>>>> origin/master
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
<<<<<<< HEAD

=======
	public void error0()
	{
		System.out.println("Invalid input. Please choose from \"1\",\"2\", or \"3\".");
	}
	public void error1()
	{
		System.out.println("Invalid input. Please select from \"A\", \"B\", \"C\",or \"D\".");
	}
>>>>>>> origin/master
	public void gameLoop() {

		while (!game.gameWon()) {

			System.out.println("Begin your turn player!\n");
<<<<<<< HEAD
			//System.out.println(game.printDebug());
			System.out.println(game.displayBoard());
			System.out.println("Chose a direction to look in.\n");
			System.out.println("1)Left \n2)Right \n3)Up \n4)Down");

			int option = keyboard.nextInt();

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

			// }

			// public void gameLoopMove() {
			System.out.println("What would you like to do next?\n");
			//System.out.println(game.printDebug());
			 System.out.println(game.displayBoard());
=======
			visibilityOfPlayer();
			System.out.println(game.printDebug());
			// System.out.println(game.displayBoard());
			System.out.println("Chose a direction to look in.\n");
			System.out.println("A)Left \nD)Right \nW)Up \nS)Down");

			char charOption = keyboard.nextLine();
			try {
			
			NumOption = REmappedKeys();
				switch (NumOption) {
				// Left
				case '1':
					game.playerLook(1);
					break;
				// Right
				case '2':
					game.playerLook(2);
					break;
				// Up
				case '3':
					game.playerLook(3);
					break;
				// Down
				case '4':
					game.playerLook(4);
					break;
				default:
					System.out.println("That isn't a valid choice player.");
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out
						.println("You currently can't look in that direction player. Look in a valid direction.\n");
			}

			System.out.println("What would you like to do next?\n");
			System.out.println(game.printDebug());
			// System.out.println(game.displayBoard());
>>>>>>> origin/master
			System.out.println("1)Move \n2)Shoot \n3)Save \n4)Quit");

			int choice = keyboard.nextInt();

			switch (choice) {
			// Move
			case 1:
				MoveMe();
			/*	System.out.println("Chose a direction to move in.\n");
				System.out.println("1)Left \n2)Right \n3)Up \n4)Down");

				int direction = keyboard.nextInt();

<<<<<<< HEAD
				switch (direction) {
				// Left
				case 1:
					game.playerMove(1);
					break;
				// Right
				case 2:
					game.playerMove(2);
					break;
				// Up
				case 3:
					game.playerMove(3);
					break;
				// Down
				case 4:
					game.playerMove(4);
					break;
				default:
					System.out.println("That's isn't a direction player. Please try again");
					break;
				}
=======
				try {
					switch (direction) {
					// Left
					case 1:
						game.playerMove(1);
						break;
					// Right
					case 2:
						game.playerMove(2);
						break;
					// Up
					case 3:
						game.playerMove(3);
						break;
					// Down
					case 4:
						game.playerMove(4);
						break;
					default:
						System.out
								.println("That's isn't a direction player. Please try again");
						break;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out
							.println("You currently can't move in that direction player. Move in a valid direction.\n");
				}

>>>>>>> origin/master
			*/
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
<<<<<<< HEAD
				System.out.println("That isn't a valid input try again please.");
				break;

			}
			//System.out.println(game.printDebug());
			 System.out.println(game.displayBoard());
		}

	}
=======
				System.out
						.println("That isn't a valid input try again please.");
				break;

			}
			game.EnemyMove();
			// System.out.println(game.printDebug());
			// System.out.println(game.displayBoard());
		}

	}

	public void visibilityOfPlayer() {
		game.visibilityOfPlayer();
	}
	
	public int REmappedKeys(charOption)
	{
		int intOption = 0;
		
		if(charOption == 'A' || charOption == 'a')
		{
			intOption = 1;
		}
		else if(charOption == 'B' || charOption == 'b')
		{
			intOption = 2;
		}
		else if(charOption == 'C' || charOption == 'c')
		{
			intOption = 3;
		}
		else if(charOption == 'D' || charOption == 'd')
		{
			intOption = 4;
		}
		else 
			error1();
		return intOption;
	}
		
>>>>>>> origin/master
}
void MoveMe()
{
				System.out.println("Chose a direction to move in.\n");
				System.out.println("1)Left \n2)Right \n3)Up \n4)Down");

				int direction = keyboard.nextInt();

<<<<<<< HEAD
boolean validmove(direction){
	boolean legitimate = false;
	while (!legitimate){
				switch (direction) {
				// Left
				case 1:
					game.playerMove(1);
					legitimate = true;
					break;
				// Right
				case 2:
					game.playerMove(2);
					legitimate = true;
					break;
				// Up
				case 3:
					game.playerMove(3);
					legitimate = true;
					break;
				// Down
				case 4:
					game.playerMove(4);
					legitimate = true;
					break;
				default:
					System.out.println("That's isn't a direction player. Please try again");
					break;
				}
	}
}
=======
				try {
					switch (direction) {
					// Left
					case 1:
						game.playerMove(1);
						break;
					// Right
					case 2:
						game.playerMove(2);
						break;
					// Up
					case 3:
						game.playerMove(3);
						break;
					// Down
					case 4:
						game.playerMove(4);
						break;
					default:
						System.out
								.println("That's isn't a direction player. Please try again");
						break;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out
							.println("You currently can't move in that direction player. Move in a valid direction.\n");
				}

>>>>>>> origin/master
}
