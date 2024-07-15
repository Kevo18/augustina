package main;

import java.awt.image.BufferedImage;


public class Country {
	
	private String name;
	private BufferedImage flagge;
	ArmyManager meineArmee;
	public double vermögen= 100;
	
   public Country() {
	   meineArmee = new ArmyManager();
	 
  }
   
   public String gibName() {
	   return name;
   }

   public BufferedImage gibFlagge() {
	  return flagge; 
   }
   public double gibVermögen() {
	   return vermögen;
   }
   
   public void setzteVermögen(double pV) {
	   vermögen = pV;
   }

   public void setzteName(String pName) {
	   name = pName;
   }

}
