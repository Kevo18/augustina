package main;

public class ArmyManager {
	
	
	int anzahlInfantery = 50;
	int anzahlArtillery = 30;
	int anzahlCavalry = 30;
	
	
	
	
	Infantery meineInfantery;
	Artillery meineArtillery;
	Cavalry meineCavalry;
	
	
    
	private int spielerArmeeGröße = 0;
	private double spielerArmeeAngriff = 0;
	private double spielerArmeeVerteidigung = 0;
	
	public ArmyManager() {
		
		meineInfantery = new Infantery();
		meineArtillery= new Artillery();
		meineCavalry= new Cavalry();
		
		
	}
	
	public int gibAnzahlInfantery() {
		return anzahlInfantery;
	}
  public int gibAnzahlArtillery() {
	  return anzahlArtillery;
	}
  public int gibAnzahlCavalry() {
	  return anzahlCavalry;
 }
  
  public int gibArmeegröße() {
	  return spielerArmeeGröße;
  }
  public double gibArmeeangriff() {
	  return spielerArmeeAngriff;
  }
  public double gibArmeeVerteidigung() {
	  return spielerArmeeVerteidigung;
  }
  
  
  
  
  public void infanteryErhöhen(int pWert) {
	  anzahlInfantery+=pWert;
  }
public void artilleryErhöhen(int pWert) {
	anzahlArtillery+=pWert;
  }
public void cavalryErhöhen(int pWert) {
	anzahlCavalry+=pWert;
}
public void infanteryVerringern(int pWert) {
	anzahlInfantery-=pWert;
}
public void artilleryVerringern(int pWert) {
	anzahlArtillery-=pWert;
}
public void cavalryVerringern(int pWert) {
	anzahlCavalry-=pWert;
}



public void berechneArmeeGröße() {
	
	spielerArmeeGröße= anzahlInfantery + anzahlArtillery + anzahlCavalry;
}
public void berechneArmeeAngriff() {
	
	spielerArmeeAngriff = anzahlInfantery * meineInfantery.gibAngriff() + anzahlArtillery*meineArtillery.gibAngriff() + anzahlCavalry*meineCavalry.gibAngriff();
}
public void berechneArmeeVerteidigung() {
	
	spielerArmeeVerteidigung = anzahlInfantery*meineInfantery.gibVerteidigung()+anzahlArtillery*meineArtillery.gibVerteidigung()+anzahlCavalry*meineCavalry.gibVerteidigung();
}

public void armeeBesiegt() {
	
	 anzahlInfantery = 0;
	 anzahlArtillery = 0;
	 anzahlCavalry = 0;
	
 }
}
