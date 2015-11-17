/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import edu.cpp.cs.cs141.prog_assgmnt_final.Map;

/**
 * @author Seungyun
 *
 */
public class GameEngine {
	
	private Map map = new Map();
	
	private Player player = new Player();
	
	private Enemy enemy = new Enemy();
	
	private int turn = 3;
	
	private boolean endGame;
	
	public void playerTurn() {
		
	}
	public void EnemyTurn() {
		
	}
	
	public void backToSpawnLocation() {
		
	}
	
	public void endingGame() {
		
	}
	
	public void backToInitialSpawnLocation() {
		
	}
	
	public void move(int movement) {
		switch (movement) {
		case 1:
		}
	}
	
	public void up(int x, int y) {
		x =x;
		y= y-1;
	}

}
