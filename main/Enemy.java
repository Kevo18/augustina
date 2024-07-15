package main;

public class Enemy {
	
	private String name;
	
	private double angriff;
	
	private double verteidigung;
	
	private int anzahl;
	
	
	public Enemy(String pName, double pAngriff, double pVerteidigung, int pAnzahl) {
		
		name = pName;
		angriff = pAngriff;
		verteidigung = pVerteidigung;
		anzahl = pAnzahl;
	}
	
	public String gibName() {
		return name;
	}
	public double gibAngriff() {
		return angriff;
	}
	public double gibVerteidigung() {
		return verteidigung;
	}
	public int gibAnzahl() {
		return anzahl;
	}
	
	public void setzteName(String pName) {
		name = pName;
	}
	public void setzteAngriff(double pAngriff) {
		angriff = pAngriff;
	}
	public void setzteVerteidigung(double pVerteidigung) {
		verteidigung = pVerteidigung;
	}
	public void setzteAnzahl(int pA) {
		anzahl = pA;
	}
	
	public void anzahlverringer() {
		anzahl--;
	}

}
