/**
 * 
 */
package edu.cpp.cs.cs141.prog_assgmnt_final;

import java.io.*;
import java.util.Scanner;
/**
 * @author Seungyun
 *
 */
public class GameSaveData {

//Output Stream  
  FileOutputStream outStream = new FileOutputStream("Objects.dat");
  
  ObjectOutputStream objectOutputFile = new ObjectOutputStream(outStream);
  
  objectOutputFile.writeObject();
  
  objectOutputFile.close();
  
//Input Stream
  FileInputStream inStream = new FileInputStream("Objects.dat");
  
  ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
  
  ( ) objectInputFile.readObject();
  
  objectInputFile.close();
  
  
  
 /*
  //need the positions of the player, enemies, powerups, and briefcase.
  playerinfo()
  {
    getLife()
    {
     int Life = player.setLife();
     return Life;
    }
    getRadar()
    {
      boolean radar = player.setRadar();
      return radar;
    }
    getInvincibility()
    {
      boolean invincibility = player.setInvincibile();
      return invincibility;
    }
  }
  
  //need the lives, bullets, powerups currently using, powerups left, enemies left

}
*/
