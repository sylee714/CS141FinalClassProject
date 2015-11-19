/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

/**
 * @author Seungyun
 *
 */
public class Radar extends GameEntity {
	
	Boolean isfound = false;

	public Radar() {
		super("+", "*");
	}

	/**
	 * This method finds the location of the brief case. We call the setlocation() 
	 * of the breifcase class to find the random values previously generated.
	 */
	public void locatingBriefCase() {
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map.length; j++)
			{
				if(map[i][j] == "B")
				{
					isfound = true;
				}
				else 
				setlocation();
			}
		//Briefcase.setlocation();
	}

	/**
	 * This field represent the location of radar when the game starts.
	 * 
	 * @param index
	 *            number of row
	 * @param index
	 *            number of column
	 */
	public void setlocation(int x, int y) {
	
	}

}
