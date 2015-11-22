/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 *
 */
public abstract class GameEntity {

	private String front = "";
	private String back = "";
	private int row = 0;
	private int column = 0;
	private boolean isFlipped = false;
	private boolean attack = false;

	public GameEntity(String front, String back, int row, int column) {
		this.front = front;
		this.back = back;
		this.row = row;
		this.column = column;
	}

	public boolean isFlipped() {
		return isFlipped;
	}

	public void setFlipped(boolean isFlipped) {
		this.isFlipped = isFlipped;
	}

	public String getFront() {
		return front;
	}

	public String getBack() {
		return back;
	}
	
	

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * This method is moving method. Up, down, right, and left only.
	 * 
	 * @param movement
	 * @return
	 */
	public void move(int movement) {

		switch (movement) {
		// up
		case 1:
			row = row - 1;
			break;
		// down
		case 2:
			row = row + 1;
			break;
		// right
		case 3:
			column = column + 1;
			break;
		// left
		case 4:
			column = column - 1;
			break;

		}

	}

	public void setAttack(boolean attack) {
		this.attack = attack;
	}

	public boolean isAttack() {
		// TODO Auto-generated method stub
		return attack;
	}

}
