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
	
	GameEngine ge = new GameEngine();
	
	//private Scanner keyboard;
	
	Scanner keyboard = new Scanner(System.in);
	
	public void startMessage() {
		System.out.println("Hi There Player!");
	}
	
	public void startGame() {

		printWelcomeMessage();

		boolean quit = false;

		while (!quit) {

			int option = mainMenu();

			switch (option) {

			case 1:

				gameLoop();
				break;
			//calls on loadGame() to open previously saved game
			case 2:
				//loadGame();
				break;
				
			case 3: 
				
				quit = true;
				break;

			default:

				System.out.println("Invalid option. Try again...");
				break;

			}

		}

	}

	private void printWelcomeMessage() {

		System.out.println("Welcome to \n");

	}

	private int mainMenu() {

		int option = 2;

		System.out.println("Select an option:\n" + "\t1. Start New Game.\n" + "\t2. Load." + "\t3. Quit.");

		option = keyboard.nextInt();

		keyboard.nextLine();

		return option;

	}
	
	public void gameLoop() {
		
	}
	/*At this point, maybe a SavedGame class with all the boolean values would be helpful.
	To load a game, simply load a jar file named SavedGame. 
	The new calss loadgameloop() would call all the other classes required to start with the boolean values at SavedGame().
	*/
	
	/*	
	public void saveGame() {
		//uses a variable to save the game under a user specified name.
		//maybe an array of string would be better for more saved games.
		String nameFile = "";
		System.out.println("What would you like to name your file?");
		nameFile = keyboard.nextLine();
		
		File file = new File("nameFile.txt"); 
	}
	
	public void loadGame() {
		//creates a string variable line to hold the information read from the file
		String line = "";
		System.out.println("Which file would you like to load?");
		nameFile = keyboard.nextLine();
		
		Scanner fileScanner = new Scanner("nameFile.txt");
		line = fileScanner.nextLine();
		
		while( line != null)
		{
		
		}
	}
	*/ 
}
