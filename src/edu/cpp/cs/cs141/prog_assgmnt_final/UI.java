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
	
	private Scanner keyboard;
	
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

			case 2:

				
				
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
		
	public void saveGame() {
		
	}
	
	public void loadGame() {
		
	}
	
}
