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
	private boolean isFlipped = false;

	public GameEntity(String front, String back) {
		this.front = front;
		this.back = back;
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
	
	public int up(int row, int column) {
		row = row - 1;
		return row;
	}
	
	public int down(int row, int column) {
		row = row + 1;
		return row;
	}
	
	public int right(int row, int column) {
		column = column + 1;
		return column;
	}
	
	public int left(int row, int column) {
		column = column - 1;
		return column;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
