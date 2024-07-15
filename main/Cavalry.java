package main;

public class Cavalry {
	
	String name;
	double verteidigung;
	double angriff;
	double kosten;
	
	public Cavalry() {
		
		name = "Kavellerie";
		verteidigung = 1.00;
		angriff = 1.30;
		kosten=2;
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
