package main;

public class Artillery {
	
	String name;
	double verteidigung;
	double angriff;
	double kosten;
	
	public Artillery() {
		
		name = "Artillerie";
		verteidigung = 0.75;
		angriff = 2;
		kosten = 4;
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
