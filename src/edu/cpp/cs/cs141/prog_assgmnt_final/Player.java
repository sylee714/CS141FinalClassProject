/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.io.Serializable;

/**
 * @author Seungyun
 *
 */
public class Player extends GameEntity implements Serializable{

	//private Gun gun = new Gun();

	public Player() {
		super("P", "P", 0, 0);
		
	}

	/**
	 * This field represents the initial life points that player will start
	 * with.
	 */
	private int life = 3;
	
	private int bullet = 1;

	/**
	 * This field represents if player is got attacked by an enemy.
	 */
	private boolean underAttack = true;

	private boolean attack = true;
	
	/**
	 * This field indicates if an enemy is detected.
	 */
	private boolean dangerAhead = false;

	/**
	 * @return the dangerAhead
	 */
	public boolean isDangerAhead() {
		return dangerAhead;
	}

	/**
	 * @param dangerAhead the dangerAhead to set
	 */
	public void setDangerAhead(boolean dangerAhead) {
		this.dangerAhead = dangerAhead;
	}


	/**
	 * This method indicates if player got attacked by an enemy. If it did, it
	 * will lose 1 life point.
	 */
	public void gotDamaged() {
		
			life -= 1;
		
	}



	/**
	 * @return the life
	 */
	public int getLife() {
		return life;
	}

	/**
	 * @param life
	 *            the life to set
	 */
	public void setLife(int life) {
		this.life = life;
	}

	/**
	 * @return the bullet
	 */
	public int getBullet() {
		return bullet;
	}

	/**
	 * @param bullet the bullet to set
	 */
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}

	/**
	 * @return the attack
	 */
	public boolean isAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(boolean attack) {
		this.attack = attack;
	}
	
	
	
	

}
