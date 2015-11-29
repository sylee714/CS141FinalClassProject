
/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Victor Darkes
 *
 */
public class Main {

	public static void main(String args[]) {

		Map map = new Map();
		UI ui = new UI(new GameEngine(map));
		ui.startGame();

	}

}
