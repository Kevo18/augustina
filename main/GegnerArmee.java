package main;

public class GegnerArmee {
	
	private int gegnerListegröße=10;
	
	private int gegnerArmeeGröße;
	private double gegnerArmeeAngriff;
	private double gegnerArmeeVerteidigung;
	
	
	Enemy[] gegnerListe= new Enemy[gegnerListegröße];
	
	
	public GegnerArmee() {
		
		
	}
	
	
	
	public int gibArmeegröße() {
		return gegnerArmeeGröße;
	}
	public double gibArmeeAngriff() {
		return gegnerArmeeAngriff;
	}
	public double gibArmeeVerteidigung() {
		return gegnerArmeeVerteidigung;
	}
	
	
	public void reduziereAnzahl(int index) {
		
		gegnerListe[index].anzahlverringer();
	}
	
	
	
	
	public void berechneArmeeGröße() {
		
		for(int i = 0; i < gegnerListegröße; i++){
			
			gegnerArmeeGröße= gegnerArmeeGröße + gegnerListe[i].gibAnzahl();
			
		}
		
	}
	
	public void berechneArmeeAngriff() {
		
	for(int i = 0; i < gegnerListegröße; i++){
			
		gegnerArmeeAngriff=gegnerArmeeAngriff + gegnerListe[i].gibAnzahl()*gegnerListe[i].gibAngriff();
	  }
	}
	
	public void berechneArmeeVerteidigung() {
		
		for(int i = 0; i < gegnerListegröße; i++){
				
			gegnerArmeeVerteidigung=gegnerArmeeVerteidigung + gegnerListe[i].gibAnzahl()*gegnerListe[i].gibVerteidigung();
		  }
		}
	
	
	
	
	
	
	public void erstelleEnemy(int pN1, int pN2, int pN3, int pN4, int pN5, int pN6, int pN7, int pN8, int pN9, int pN10) {
		
	
		gegnerListe[0]= new Enemy("m1", 1, 1, pN1);
		gegnerListe[1]= new Enemy("m2", 2, 1, pN2);
		gegnerListe[2]= new Enemy("m3", 3, 8, pN3);
		gegnerListe[3]= new Enemy("m4", 4, 2, pN4);
		gegnerListe[4]= new Enemy("m5", 5, 7, pN5);
		gegnerListe[5]= new Enemy("m6", 6, 4, pN6);
		gegnerListe[6]= new Enemy("m7", 7, 9, pN7);
		gegnerListe[7]= new Enemy("m8", 8, 3, pN8);
		gegnerListe[8]= new Enemy("m9", 9, 6, pN9);
		gegnerListe[9]= new Enemy("m10", 10, 10, pN10);
		
		
		
	}
	
	

}
