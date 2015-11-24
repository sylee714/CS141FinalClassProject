/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 *
 */
public class Enemy extends GameEntity {

	public Enemy() {
		super("E", "*", 0, 0);
	}

	/**
	 * Life point of an enemy.
	 */
	private int life = 1;

	/**
	 * This field indicates if an enemy found the player.
	 */
	private boolean detected = false;

	/**
	 * This field represents the status of an enemy.
	 */
	private boolean alive = true;

	/**
	 * 
	 */
	private boolean attack = false;

	/**
	 * @return the attack
	 */
	public boolean isAttack() {
		return attack;
	}

	/**
	 * @param attack
	 *            the attack to set
	 */
	public void setAttack(boolean attack) {
		this.attack = attack;
	}

	/**
	 * Initial spawn point of an enemy.
	 */
	public void location() {

	}

	/**
	 * This moving method will make an enemy to move randomly.
	 * 
	 * @param movement
	 * @return
	 */
	public int moving(int movement) {
		return 0;
	}

	/**
	 * This method attacks player if the player is located an adjacent tile.
	 */
	public void attack() {

	}

	/**
	 * If an enemy gets a shot by player, it dies.
	 */
	public void gotShot() {
		life -= 1;
		alive = false;
	}

	/**
	 * This method will check if player is next to enemy's tile.
	 */
	public void detectPlayer() {

	}

}
