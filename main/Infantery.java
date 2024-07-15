package main;

public class Infantery {
	
	String name;
	double verteidigung;
	double angriff;
	double kosten;
	
	
	public Infantery() {
		
		name = "Infanterie";
		verteidigung = 1.00;
		angriff = 1.25;
		kosten=1;
		
	}
	
	public String gibName() {
		return name;
	}
	public double gibVerteidigung() {
		return verteidigung;
	}
	public double gibAngriff() {
		return angriff;
	}
	public double gibKosten() {
		return kosten;
	}

}