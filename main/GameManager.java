package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class GameManager implements Runnable  {
	
	//private int a = 0; // zählt wie oft der gameThread ausgefürt wurde
	
	public int runde = 0;
	int iBild=0;
	
	private Thread gameThread;
	
	public  HauptFensterUI mainUI;
	
	public  Country spielerLand;
	
	public int gebit1LevelStufe = 1;
	public int gebit2LevelStufe = 1;
	public int gebit3LevelStufe = 1;
	public int gebit4LevelStufe = 1;
	
	public boolean gebit5Freigeschalten = false;
	public boolean gebit5beendet = false;
	
	public int kostenLevel = 0;
	public int angriffsLevel = 0;
	public int verteidigungsLevel = 0;
	
	
	private int kostenKosten = 10;
    private int angriffsLevelKosten = 10;
	private int verteidigungslevelkosten= 10;
	


	
	
	public GameManager(HauptFensterUI hf) {
		
		mainUI=hf;
		
		this.starteSpiel();

		this.starteThraed();

	}
	
	public void setzteKostenLevel(int pZ) {
		kostenLevel+=pZ;
	}
	public void setzteAngriffsLevel(int pZ) {
		angriffsLevel += pZ;
	}
	public void setzteVerteidigungsLevel(int pZ) {
		verteidigungsLevel += pZ;
	}

	public int gibKostenKosten() {
		return kostenKosten;
	}
	public int gibAngriffsLevelKosten() {
		return angriffsLevelKosten;
	}
	public int gibVerteidigungslevelkosten() {
		return verteidigungslevelkosten;
	}
	
	public int gibKostenLevel() {
		return kostenLevel;
	}
	public int gibAngriffsLevel() {
		return angriffsLevel;
	}
	public int gibVerteidigungsLevel() {
		return verteidigungsLevel;
	}
	
	
	
	public int gibGebit1LevelStufe() {
		return gebit1LevelStufe;
	}
	public int gibGebit2LevelStufe() {
		return gebit2LevelStufe;
	}
	public int gibGebit3LevelStufe() {
		return gebit3LevelStufe;
	}
	public int gibGebit4LevelStufe() {
		return gebit4LevelStufe;
	}
	public boolean gibGebit5Freigeschalten() {
		return gebit5Freigeschalten;
	}
	public boolean gibGebit5beendet() {
		return gebit5beendet;
	}
	
	
public void starteThraed() {
		
		gameThread = new Thread(this);
		gameThread.start();

		this.ladeArmeeBilder();
		this.ladeKartenBild();
	}
	
	public void run() { // Thread ruft (wenn thread läuft) diese run() Methode immer auf.
		
		double aktuallisierePause = 500;// Wert in Millisekunden
		
		while(gameThread != null) {

			//a++;
			
			this.aktuallisiere();
			this.ladeMehrArmeeBilder();
			
			try {
				
				Thread.sleep((long) aktuallisierePause);
				
				//System.out.println("Thread wurde ausgeführt: "+ a);
				
				/*
				System.out.println("gebit1level: "+ gebit1LevelStufe);
				System.out.println("gebit2level: "+ gebit2LevelStufe);
				System.out.println("gebit3level: "+ gebit3LevelStufe);
				System.out.println("gebit4level: "+ gebit4LevelStufe);
				System.out.println("gebit5level: "+ gibGebit5Freigeschalten());
				*/
	
			} catch (InterruptedException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	
	public void aktuallisiere() {
		
		mainUI.rundeenAnzahlLabel.setText("Runde: "+ runde);
		
	   this.akktualisiereArmeeAnzahl();
		
		this.akktualisiereArmee();
		
		this.akktualisiereLevel();
		
	    this.aktualisiereLevelStufe();
		
		this.setzteLevelDetails();
		
		this.akktualisiereWerte();
		
		this.akktualisiereForschungsKosten();
		
		this.akktualisiereForschungsLevelBilder();
		
		
		if(gebit5Freigeschalten == false) {
			mainUI.gebiet5Button.setText("Gesperrt");
		}
		if(gebit5Freigeschalten == true) {
			mainUI.gebiet5Button.setText("Gebiete 5");
		}
		
		if(gebit1LevelStufe == 4 && gebit2LevelStufe == 4 && gebit3LevelStufe == 4 && gebit4LevelStufe == 4) {
			gebit5Freigeschalten= true;
		}
		
		if( gebit5beendet == true) {
			mainUI.panelÄndern(mainUI.spielEndepanel);
		}
	}
	
	public void akktualisiereArmeeAnzahl() {
		
		mainUI.infanteryAnzahlLabel.setText("Anzahl: "+ spielerLand.meineArmee.gibAnzahlInfantery());
		mainUI.infanteryAnzahlLabel_2.setText("Anzahl: "+ spielerLand.meineArmee.gibAnzahlArtillery());
		mainUI.infanteryAnzahlLabel_1.setText("Anzahl: "+ spielerLand.meineArmee.gibAnzahlCavalry());
			
	}
	
	public void akktualisiereForschungsKosten() {
		
		if(gibKostenLevel()== 0) {
			kostenKosten= 10;
		}
		if(gibKostenLevel()== 1) {
			kostenKosten= 10*2;
		}
		if(gibKostenLevel()== 2) {
			kostenKosten= 10*3;
		}
		
		if(gibAngriffsLevel()== 0) {
			angriffsLevelKosten= 10;
		}
		if(gibAngriffsLevel()== 1) {
			angriffsLevelKosten= 10*2;
		}
		if(gibAngriffsLevel()== 2) {
			angriffsLevelKosten= 10*3;
		}
		if(gibAngriffsLevel()== 3) {
			angriffsLevelKosten= 10*4;
		}
		
		if(gibVerteidigungsLevel()== 0) {
			verteidigungslevelkosten= 10;
		}
		if(gibVerteidigungsLevel()== 1) {
			verteidigungslevelkosten= 10*2;
		}
		if(gibVerteidigungsLevel()== 2) {
			verteidigungslevelkosten= 10*3;
		}
		if(gibVerteidigungsLevel()== 3) {
			verteidigungslevelkosten= 10*4;
		}	
	}
	
	public void akktualisiereForschungsLevelBilder() {
		
		mainUI.kostenBildLabel.setIcon(ladeBild("/forschung/kostenBild.png"));
		mainUI.angriffBildLabel.setIcon(ladeBild("/forschung/angriffsBild.png"));
		mainUI.verteidigungBildLabel.setIcon(ladeBild("/forschung/verteidigungsBild.png"));
		
		
		if(gibKostenLevel()== 0) {
			mainUI.kostenLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevelNullBild.png"));
			mainUI.kostenKostenLabel.setText("Kosten: "+kostenKosten);
			
			//System.out.println("KostenLevel: "+0);
		}
		if(gibKostenLevel()== 1) {
			mainUI.kostenLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevel1Bild.png"));
			mainUI.kostenKostenLabel.setText("Kosten: "+kostenKosten);
			
			//System.out.println("KostenLevel: "+1);
		}
       if(gibKostenLevel()== 2) {
        	mainUI.kostenLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevel2Bild.png"));
        	mainUI.kostenKostenLabel.setText("Kosten: "+kostenKosten);
        	
        	//System.out.println("KostenLevel: "+2);
		}
       if(gibKostenLevel()== 3) {
        	mainUI.kostenLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevel3Bild.png"));
        	mainUI.kostenKostenLabel.setText("Kosten: "+kostenKosten);
        	//System.out.println("KostenLevel: "+3);
		}
        if(gibKostenLevel()== 4) {
        	mainUI.kostenLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevel4Bild.png"));
        	mainUI.kostenKostenLabel.setText("Max");
        	
        	//System.out.println("KostenLevel: "+4);
		}
		
		
		if(gibAngriffsLevel() == 0) {
			mainUI.angriffLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevelNullBild.png"));
			mainUI.angriffKostenLabel.setText("Kosten: "+angriffsLevelKosten);
			
			//System.out.println("AngriffsLevel: "+0);
			
		}
		if(gibAngriffsLevel()== 1) {
			mainUI.angriffLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevel1Bild.png"));
			mainUI.angriffKostenLabel.setText("Kosten: "+angriffsLevelKosten);
			
			//System.out.println("AngriffsLevel: "+1);
		}
        if(gibAngriffsLevel()== 2) {
        	mainUI.angriffLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevel2Bild.png"));
        	mainUI.angriffKostenLabel.setText("Kosten: "+angriffsLevelKosten);
        	
        	//System.out.println("AngriffsLevel: "+2);
		}
        if(gibAngriffsLevel()== 3) {
        	mainUI.angriffLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevel3Bild.png"));
        	mainUI.angriffKostenLabel.setText("Kosten: "+angriffsLevelKosten);
        	
        	//System.out.println("AngriffsLevel: "+3);
		}
        if(gibAngriffsLevel()== 4) {
        	mainUI.angriffLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevel4Bild.png"));
        	mainUI.angriffKostenLabel.setText("Max");
        	
        	//System.out.println("AngriffsLevel: "+4);
		}
        
        
        
       if(gibVerteidigungsLevel() == 0) {
    	   mainUI.verteidigungLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevelNullBild.png"));
    	   mainUI.verteidigungKostenLabel.setText("Kosten: "+verteidigungslevelkosten);
    	   
    	   //System.out.println("VerteidigungsLevel: "+0);
			
		}
		if(gibVerteidigungsLevel()== 1) {
			mainUI.verteidigungLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevel1Bild.png"));
			mainUI.verteidigungKostenLabel.setText("Kosten: "+verteidigungslevelkosten);
			
			 // System.out.println("VerteidigungsLevel: "+1);
		}
        if(gibVerteidigungsLevel()== 2) {
        	mainUI.verteidigungLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevel2Bild.png"));
        	mainUI.verteidigungKostenLabel.setText("Kosten: "+verteidigungslevelkosten);
        	
        	 // System.out.println("VerteidigungsLevel: "+2);
		}
        if(gibVerteidigungsLevel()== 3) {
        	mainUI.verteidigungLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevel3Bild.png"));
        	mainUI.verteidigungKostenLabel.setText("Kosten: "+verteidigungslevelkosten);
        	
        	  //System.out.println("VerteidigungsLevel: "+3);
		}
        if(gibVerteidigungsLevel()== 4) {
        	mainUI.verteidigungLevelBildLabel.setIcon(ladeBild("/forschung/sterneLevel4Bild.png"));
        	mainUI.verteidigungKostenLabel.setText("Max");
        	
        	  //System.out.println("VerteidigungsLevel: "+4);
		}
		
	}
	
	public void akktualisiereWerte() {
		
		mainUI.statesLabel.setText("Werte: "+"          "+"Vermögen: "+spielerLand.gibVermögen()+"           "+"Armeegröße: "+spielerLand.meineArmee.gibArmeegröße()+"             "+"Armee Angriff: "+spielerLand.meineArmee.gibArmeeangriff()+"              "+"Armee Verteidigung: "+spielerLand.meineArmee.gibArmeeVerteidigung());
	
	}
	
	public void akktualisiereArmee() {
		
		spielerLand.meineArmee.berechneArmeeGröße();
		spielerLand.meineArmee.berechneArmeeAngriff();
		spielerLand.meineArmee.berechneArmeeVerteidigung();
	}

	public void akktualisiereLevel() {
		

		if(mainUI.gebit1Level1 != null) {
			if(mainUI.gebit1Level1.gewinner.equals("Spieler")) {
				gebit1LevelStufe++;
				//System.out.println("gebit1Level1 spiler");
				mainUI.gebit1Level1 = null;
				//System.out.println("gebit1Level1 null");
			}
		}
			
		 if(mainUI.gebit1Level2 != null) {
			 if(mainUI.gebit1Level2.gewinner.equals("Spieler")) {
					gebit1LevelStufe++;
					//System.out.println("gebit1Level2 spiler");
					mainUI.gebit1Level2 = null;
					//System.out.println("gebit1Level2 null");
			}
		 }
		   if(mainUI.gebit1Level3 != null) {
			  if(mainUI.gebit1Level3.gewinner.equals("Spieler")) {
						gebit1LevelStufe++;
						//System.out.println("gebit1Level3 spiler");
						mainUI.gebit1Level3 = null;
						//System.out.println("gebit1Level3 null");
			}
		  }		
			
			if(mainUI.gebit2Level1 != null) {
				if(mainUI.gebit2Level1.gewinner.equals("Spieler")) {
					gebit2LevelStufe++;
					//System.out.println("gebit2Level1 spiler");
					mainUI.gebit2Level1 = null;
					//System.out.println("gebit2Level1 null");
				}
			}
				if(mainUI.gebit2Level2 != null) {
					if(mainUI.gebit2Level2.gewinner.equals("Spieler")) {
						gebit2LevelStufe++;
						//System.out.println("gebit2Level2 spiler");
						mainUI.gebit2Level2 = null;
						//System.out.println("gebit2Level2 null");
					}
				}
					if(mainUI.gebit2Level3 != null) {
						if(mainUI.gebit2Level3.gewinner.equals("Spieler")) {
							gebit2LevelStufe++;
							//System.out.println("gebit2Level3 spiler");
							mainUI.gebit2Level3 = null;
							//System.out.println("gebit2Level3 null");
						}
					}
			if(mainUI.gebit3Level1 != null) {
				if(mainUI.gebit3Level1.gewinner.equals("Spieler")) {
					gebit3LevelStufe++;
					//System.out.println("gebit3Level1 spiler");
					mainUI.gebit3Level1 = null;
					//System.out.println("gebit3Level1 null");
				}
			}
			
				if(mainUI.gebit3Level2 != null) {
					if(mainUI.gebit3Level2.gewinner.equals("Spieler")) {
						gebit3LevelStufe++;
						//System.out.println("gebit3Level2 spiler");
						mainUI.gebit3Level2 = null;
						//System.out.println("gebit3Level2 null");
					}
				}
					if(mainUI.gebit3Level3 != null) {
						if(mainUI.gebit3Level3.gewinner.equals("Spieler")) {
							gebit3LevelStufe++;
							//System.out.println("gebit3Level3 spiler");
							mainUI.gebit3Level3 = null;
							//System.out.println("gebit3Level3 null");
						}
					}
			if(mainUI.gebit4Level1 != null) {
				if(mainUI.gebit4Level1.gewinner.equals("Spieler")) {
					gebit4LevelStufe++;
					//System.out.println("gebit4Level1 spiler");
					mainUI.gebit4Level1 = null;
					//System.out.println("gebit4Level1 null");
				}
			}
				if(mainUI.gebit4Level2 != null) {
					if(mainUI.gebit4Level2.gewinner.equals("Spieler")) {
						gebit4LevelStufe++;
						//System.out.println("gebit4Level2 spiler");
						mainUI.gebit4Level2 = null;
						//System.out.println("gebit4Level2 null");
					}
				}
					if(mainUI.gebit4Level3 != null) {
						if(mainUI.gebit4Level3.gewinner.equals("Spieler")) {
							gebit4LevelStufe++;
							//System.out.println("gebit4Level3 spiler");
							mainUI.gebit4Level3 = null;
							//System.out.println("gebit4Level3 null");
						}
					}
			 if(mainUI.gebit5Level != null) {
				if(mainUI.gebit5Level.gewinner.equals("Spieler")) {
					gebit5beendet = true;
					//System.out.println("gebit5Level spiler");
				 }		
			 }
	}
	

	public void aktualisiereLevelStufe() {
		
		if(gebit1LevelStufe == 1) {
			mainUI.gebiet1Button.setText("1 Gebite Level 1");
		}
		if(gebit1LevelStufe == 2) {
			mainUI.gebiet1Button.setText("1 Gebite Level 2");
		}
		if(gebit1LevelStufe == 3) {
			mainUI.gebiet1Button.setText("1 Gebite Level 3");
		}
		
		
		if(gebit2LevelStufe == 1) {
			mainUI.gebiet2Button.setText("2 Gebite Level 1");
		}
		if(gebit2LevelStufe == 2) {
			mainUI.gebiet2Button.setText("2 Gebite Level 2");
		}
		if(gebit2LevelStufe == 3) {
			mainUI.gebiet2Button.setText("2 Gebite Level 3");
		}
		
		
		if(gebit3LevelStufe == 1) {
			mainUI.gebiet3Button.setText("3 Gebite Level 1");
		}
		if(gebit3LevelStufe == 2) {
			mainUI.gebiet3Button.setText("3 Gebite Level 2");
		}
		if(gebit3LevelStufe == 3) {
			mainUI.gebiet3Button.setText("3 Gebite Level 3");
		}
		
		
		if(gebit4LevelStufe == 1) {
			mainUI.gebiet4Button.setText("4 Gebite Level 1");
		}
		if(gebit4LevelStufe == 2) {
			mainUI.gebiet4Button.setText("4 Gebite Level 2");
		}
		if(gebit4LevelStufe == 3) {
			mainUI.gebiet4Button.setText("4 Gebite Level 3");
		}
		
	}

		public void setzteLevelDetails()
	
		{
			
			if(mainUI.gebit1Level1 != null) {
				
				if(mainUI.gebit1Level1.details != null) {
					
					mainUI.gebit1Level1.details.spielerLabel.setText("<html> Spieler armee: "+mainUI.gm.spielerLand.meineArmee.gibArmeegröße()
	                                                          +"<p/> Spieler Armee angriff: " +mainUI.gm.spielerLand.meineArmee.gibArmeeangriff()
	                                                          +"<p/> Spieler Armee verteidigung: "+ mainUI.gm.spielerLand.meineArmee.gibArmeeVerteidigung());
					
					mainUI.gebit1Level1.details.gegnerLabel.setText("<html> Gegner armee: "+mainUI.gebit1Level1.gegnerArmee.gibArmeegröße()
	                        +"<p/> Gegner Armee angriff: " +mainUI.gebit1Level1.gegnerArmee.gibArmeeAngriff()
	                        +"<p/> Gegner Armee verteidigung: "+ mainUI.gebit1Level1.gegnerArmee.gibArmeeVerteidigung());

				}
			}
				
				if(mainUI.gebit1Level2 != null) {
					if(mainUI.gebit1Level2.details != null) {
						mainUI.gebit1Level2.details.spielerLabel.setText("<html> Spieler armee: "+mainUI.gm.spielerLand.meineArmee.gibArmeegröße()
		                                                          +"<p/> Spieler Armee angriff: " +mainUI.gm.spielerLand.meineArmee.gibArmeeangriff()
		                                                          +"<p/> Spieler Armee verteidigung: "+ mainUI.gm.spielerLand.meineArmee.gibArmeeVerteidigung());
						mainUI.gebit1Level2.details.gegnerLabel.setText("<html> Gegner armee: "+mainUI.gebit1Level2.gegnerArmee.gibArmeegröße()
		                        +"<p/> Gegner Armee angriff: " +mainUI.gebit1Level2.gegnerArmee.gibArmeeAngriff()
		                        +"<p/> Gegner Armee verteidigung: "+ mainUI.gebit1Level2.gegnerArmee.gibArmeeVerteidigung());
					}
		}
				
              if(mainUI.gebit1Level3 != null) {
					if(mainUI.gebit1Level3.details != null) {
						mainUI.gebit1Level3.details.spielerLabel.setText("<html> Spieler armee: "+mainUI.gm.spielerLand.meineArmee.gibArmeegröße()
		                                                          +"<p/> Spieler Armee angriff: " +mainUI.gm.spielerLand.meineArmee.gibArmeeangriff()
		                                                          +"<p/> Spieler Armee verteidigung: "+ mainUI.gm.spielerLand.meineArmee.gibArmeeVerteidigung());
						mainUI.gebit1Level3.details.gegnerLabel.setText("<html> Gegner armee: "+mainUI.gebit1Level3.gegnerArmee.gibArmeegröße()
		                        +"<p/> Gegner Armee angriff: " +mainUI.gebit1Level3.gegnerArmee.gibArmeeAngriff()
		                        +"<p/> Gegner Armee verteidigung: "+ mainUI.gebit1Level3.gegnerArmee.gibArmeeVerteidigung());
					}
		}
              if(mainUI.gebit2Level1 != null) {
					if(mainUI.gebit2Level1.details != null) {
						mainUI.gebit2Level1.details.spielerLabel.setText("<html> Spieler armee: "+mainUI.gm.spielerLand.meineArmee.gibArmeegröße()
		                                                          +"<p/> Spieler Armee angriff: " +mainUI.gm.spielerLand.meineArmee.gibArmeeangriff()
		                                                          +"<p/> Spieler Armee verteidigung: "+ mainUI.gm.spielerLand.meineArmee.gibArmeeVerteidigung());
						mainUI.gebit2Level1.details.gegnerLabel.setText("<html> Gegner armee: "+mainUI.gebit2Level1.gegnerArmee.gibArmeegröße()
		                        +"<p/> Gegner Armee angriff: " +mainUI.gebit2Level1.gegnerArmee.gibArmeeAngriff()
		                        +"<p/> Gegner Armee verteidigung: "+ mainUI.gebit2Level1.gegnerArmee.gibArmeeVerteidigung());
					}
		}
              if(mainUI.gebit2Level2 != null) {
					if(mainUI.gebit2Level2.details != null) {
						mainUI.gebit2Level2.details.spielerLabel.setText("<html> Spieler armee: "+mainUI.gm.spielerLand.meineArmee.gibArmeegröße()
		                                                          +"<p/> Spieler Armee angriff: " +mainUI.gm.spielerLand.meineArmee.gibArmeeangriff()
		                                                          +"<p/> Spieler Armee verteidigung: "+ mainUI.gm.spielerLand.meineArmee.gibArmeeVerteidigung());
						mainUI.gebit2Level2.details.gegnerLabel.setText("<html> Gegner armee: "+mainUI.gebit2Level2.gegnerArmee.gibArmeegröße()
		                        +"<p/> Gegner Armee angriff: " +mainUI.gebit2Level2.gegnerArmee.gibArmeeAngriff()
		                        +"<p/> Gegner Armee verteidigung: "+ mainUI.gebit2Level2.gegnerArmee.gibArmeeVerteidigung());
					}
		}
              if(mainUI.gebit2Level3 != null) {
					if(mainUI.gebit2Level3.details != null) {
						mainUI.gebit2Level3.details.spielerLabel.setText("<html> Spieler armee: "+mainUI.gm.spielerLand.meineArmee.gibArmeegröße()
		                                                          +"<p/> Spieler Armee angriff: " +mainUI.gm.spielerLand.meineArmee.gibArmeeangriff()
		                                                          +"<p/> Spieler Armee verteidigung: "+ mainUI.gm.spielerLand.meineArmee.gibArmeeVerteidigung());
						mainUI.gebit2Level3.details.gegnerLabel.setText("<html> Gegner armee: "+mainUI.gebit2Level3.gegnerArmee.gibArmeegröße()
		                        +"<p/> Gegner Armee angriff: " +mainUI.gebit2Level3.gegnerArmee.gibArmeeAngriff()
		                        +"<p/> Gegner Armee verteidigung: "+ mainUI.gebit2Level3.gegnerArmee.gibArmeeVerteidigung());
					}
		}
              if(mainUI.gebit3Level1 != null) {
					if(mainUI.gebit3Level1.details != null) {
						
						mainUI.gebit3Level1.details.spielerLabel.setText("<html> Spieler armee: "+mainUI.gm.spielerLand.meineArmee.gibArmeegröße()
		                                                          +"<p/> Spieler Armee angriff: " +mainUI.gm.spielerLand.meineArmee.gibArmeeangriff()
		                                                          +"<p/> Spieler Armee verteidigung: "+ mainUI.gm.spielerLand.meineArmee.gibArmeeVerteidigung());
						
						mainUI.gebit3Level1.details.gegnerLabel.setText("<html> Gegner armee: "+mainUI.gebit3Level1.gegnerArmee.gibArmeegröße()
		                        +"<p/> Gegner Armee angriff: " +mainUI.gebit3Level1.gegnerArmee.gibArmeeAngriff()
		                        +"<p/> Gegner Armee verteidigung: "+ mainUI.gebit3Level1.gegnerArmee.gibArmeeVerteidigung());
					}
		}
              if(mainUI.gebit3Level2 != null) {
					
					if(mainUI.gebit3Level2.details != null) {
						
						mainUI.gebit3Level2.details.spielerLabel.setText("<html> Spieler armee: "+mainUI.gm.spielerLand.meineArmee.gibArmeegröße()
		                                                          +"<p/> Spieler Armee angriff: " +mainUI.gm.spielerLand.meineArmee.gibArmeeangriff()
		                                                          +"<p/> Spieler Armee verteidigung: "+ mainUI.gm.spielerLand.meineArmee.gibArmeeVerteidigung());
						
						mainUI.gebit3Level2.details.gegnerLabel.setText("<html> Gegner armee: "+mainUI.gebit3Level2.gegnerArmee.gibArmeegröße()
		                        +"<p/> Gegner Armee angriff: " +mainUI.gebit3Level2.gegnerArmee.gibArmeeAngriff()
		                        +"<p/> Gegner Armee verteidigung: "+ mainUI.gebit3Level2.gegnerArmee.gibArmeeVerteidigung());
				
					}
			
		}
              if(mainUI.gebit3Level3 != null) {
					
					if(mainUI.gebit3Level3.details != null) {
						
						mainUI.gebit3Level3.details.spielerLabel.setText("<html> Spieler armee: "+mainUI.gm.spielerLand.meineArmee.gibArmeegröße()
		                                                          +"<p/> Spieler Armee angriff: " +mainUI.gm.spielerLand.meineArmee.gibArmeeangriff()
		                                                          +"<p/> Spieler Armee verteidigung: "+ mainUI.gm.spielerLand.meineArmee.gibArmeeVerteidigung());
						
						mainUI.gebit3Level3.details.gegnerLabel.setText("<html> Gegner armee: "+mainUI.gebit3Level3.gegnerArmee.gibArmeegröße()
		                        +"<p/> Gegner Armee angriff:: " +mainUI.gebit3Level3.gegnerArmee.gibArmeeAngriff()
		                        +"<p/> Gegner Armee verteidigung: "+ mainUI.gebit3Level3.gegnerArmee.gibArmeeVerteidigung());
					}
		}
              if(mainUI.gebit4Level1 != null) {
					
					if(mainUI.gebit4Level1.details != null) {
						
						mainUI.gebit4Level1.details.spielerLabel.setText("<html> Spieler armee: "+mainUI.gm.spielerLand.meineArmee.gibArmeegröße()
		                                                          +"<p/> Spieler Armee angriff: " +mainUI.gm.spielerLand.meineArmee.gibArmeeangriff()
		                                                          +"<p/> Spieler Armee verteidigung: "+ mainUI.gm.spielerLand.meineArmee.gibArmeeVerteidigung());
						
						mainUI.gebit4Level1.details.gegnerLabel.setText("<html> Gegner armee: "+mainUI.gebit4Level1.gegnerArmee.gibArmeegröße()
		                        +"<p/> Gegner Armee angriff: " +mainUI.gebit4Level1.gegnerArmee.gibArmeeAngriff()
		                        +"<p/> Gegner Armee verteidigung: "+ mainUI.gebit4Level1.gegnerArmee.gibArmeeVerteidigung());
					}
		}
              if(mainUI.gebit4Level2 != null) {
					
					if(mainUI.gebit4Level2.details != null) {
						
						mainUI.gebit4Level2.details.spielerLabel.setText("<html> Spieler armee: "+mainUI.gm.spielerLand.meineArmee.gibArmeegröße()
		                                                          +"<p/> Spieler Armee angriff: " +mainUI.gm.spielerLand.meineArmee.gibArmeeangriff()
		                                                          +"<p/> Spieler Armee verteidigung: "+ mainUI.gm.spielerLand.meineArmee.gibArmeeVerteidigung());
						
						mainUI.gebit4Level2.details.gegnerLabel.setText("<html> Gegner armee: "+mainUI.gebit4Level2.gegnerArmee.gibArmeegröße()
		                        +"<p/> Gegner Armee angriff: " +mainUI.gebit4Level2.gegnerArmee.gibArmeeAngriff()
		                        +"<p/> Gegner Armee verteidigung: "+ mainUI.gebit4Level2.gegnerArmee.gibArmeeVerteidigung());
					}
		}
              if(mainUI.gebit4Level3 != null) {
					
					if(mainUI.gebit4Level3.details != null) {
						
						mainUI.gebit4Level3.details.spielerLabel.setText("<html> Spieler armee: "+mainUI.gm.spielerLand.meineArmee.gibArmeegröße()
		                                                          +"<p/> Spieler Armee angriff: " +mainUI.gm.spielerLand.meineArmee.gibArmeeangriff()
		                                                          +"<p/> Spieler Armee verteidigung: "+ mainUI.gm.spielerLand.meineArmee.gibArmeeVerteidigung());
						
						mainUI.gebit4Level3.details.gegnerLabel.setText("<html> Gegner armee: "+mainUI.gebit4Level3.gegnerArmee.gibArmeegröße()
		                        +"<p/> Gegner Armee angriff: " +mainUI.gebit4Level3.gegnerArmee.gibArmeeAngriff()
		                        +"<p/> Gegner Armee verteidigung: "+ mainUI.gebit4Level3.gegnerArmee.gibArmeeVerteidigung());
					}
		}
              
              if(mainUI.gebit5Level != null) {
					
					if(mainUI.gebit5Level.details != null) {
						
						mainUI.gebit5Level.details.spielerLabel.setText("<html> Spieler armee: "+mainUI.gm.spielerLand.meineArmee.gibArmeegröße()
		                                                          +"<p/> Spieler Armee angriff: " +mainUI.gm.spielerLand.meineArmee.gibArmeeangriff()
		                                                          +"<p/> Spieler Armee verteidigung: "+ mainUI.gm.spielerLand.meineArmee.gibArmeeVerteidigung());
						
						mainUI.gebit5Level.details.gegnerLabel.setText("<html> Gegner armee: "+mainUI.gebit5Level.gegnerArmee.gibArmeegröße()
		                        +"<p/> Gegner Armee angriff: " +mainUI.gebit5Level.gegnerArmee.gibArmeeAngriff()
		                        +"<p/> Gegner Armee verteidigung: "+ mainUI.gebit5Level.gegnerArmee.gibArmeeVerteidigung());
				
					}
		}	
	}
		
	public ImageIcon ladeBild(String pPfad) {
	        BufferedImage bild = null;
	        try {
	        	bild = ImageIO.read(getClass().getResource(pPfad));
				
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return new ImageIcon(bild);
	    }
	
	public void ladeArmeeBilder() {
		
		mainUI.intanteryLabel.setIcon(this.ladeBild("/picture/infanteryBild.png"));
		mainUI.caveleryLabel.setIcon(this.ladeBild("/picture/caveleryBild.png"));
		mainUI.artilleryLabel.setIcon(this.ladeBild("/picture/artilleryBild.png"));
		
	}
	
	public void ladeMehrArmeeBilder() {

		if(iBild <= 4) {
			mainUI.bilderLabel.setIcon(this.ladeBild("/picture/infanteryBild.png"));
			iBild++;
			//System.out.println("b1");
		}
		else if(iBild > 4 && iBild <= 8) {
			mainUI.bilderLabel.setIcon(null);
			mainUI.bilderLabel.setIcon(this.ladeBild("/picture/caveleryBild.png"));
			iBild++;
			//System.out.println("b2");
		}
		else if(iBild > 8 && iBild <= 12) {
			mainUI.bilderLabel.setIcon(this.ladeBild("/picture/artilleryBild.png"));
			iBild++;
			//System.out.println("b3");
		}
		else if(iBild > 12 && iBild <= 16) {
			mainUI.bilderLabel.setIcon(this.ladeBild("/picture/caveleryBild_02.png"));
			iBild++;
			//System.out.println("b4");
		}
		else if(iBild >16 && iBild <= 20) {
			mainUI.bilderLabel.setIcon(this.ladeBild("/picture/artilleryBild_02.png"));
			iBild++;
			//System.out.println("b5");
		}
		else if(iBild > 20 && iBild <= 24) {
			mainUI.bilderLabel.setIcon(this.ladeBild("/picture/artilleryBild_03.png"));
			iBild++;
			//System.out.println("b6");
		}
		else if(iBild > 24) {
			iBild = 0;
			//System.out.println("b=0");
		}
	}

	public void ladeKartenBild() {
		
		mainUI.kartenLabel.setIcon(this.ladeBild("/picture/karte_01.png"));
		
		mainUI.spielerFlaggeLabel.setIcon(this.ladeBild("/picture/spielerFlagge.png"));
		
	}
	
	public void starteSpiel() {

		runde = 1;
		this.erstelleSpieler();

	}
	
	public void beendeRunde() {
		
		runde++;
		spielerLand.vermögen += 10;
		
		if(runde == 5) {
			
			Dialog d= new Dialog(mainUI.window, "Seekrieg");
			d.textLabel.setText("<html> Seekrieg"
					+ "<p/> Wir erhalten aus der Hauptstadt die Nachricht das unser Land England gegen Frankreich"
					+ " im Atlantischen Ozean, mit ihren Flotten kampfen. Die franzosen haben Wind"
					+ " von dieser Insel bekommen. Hoffen wir das wir gewinne werden ");
		}
       if(runde == 10) {
    	   
    	   Dialog d= new Dialog(mainUI.window, "Säbelrasseln");
			d.textLabel.setText("<html> Säbelrasseln"
					+ "<p/> Nach dem Enland den Seekrieg für sich entschieden hatte,"
					+ " stiegen die Spannungen zwischen England und Frankreich."
					+ " Aber nicht nur zwischen den, sondern auch die Spannungen mit"
					+ " Österreich-Ungarn und Russland steigen. Zu was wird das bloß führen? ");
		}

       if(runde == 15) {
    	  
    	   Dialog d= new Dialog(mainUI.window, "Weltkrieg");
			d.textLabel.setText("<html> Weltkrieg"
					+ "<p/> Nachdem alle Länder immer weiter militarisierten, sind die Spannungen nun eskaliert!"
					+ " Europa, nein die Welt steht nun in einem neuen Krieg!"
					+ " Auf der Seite unsers Landes, England, kämpfen Deutschland, Spanien,"
					+ " das Osmanische Reich und Portugal."
					+ " Auf der gegner Seite sind Frankreich, Russland, Österreich-Ungarn und Italien."
					+ " Wie wird sich die Welt nun entwickeln?");
		
    	   
	
        }
       if(runde == 20) {
    	   
    	   Dialog d= new Dialog(mainUI.window, "Kriegsschrecken");
			d.textLabel.setText("<html> Kriegsschrecken"
					+ "<p/> Der Krieg dauert immer noch an und fordert immer höhere Verluste."
					+ " Einerseteits von den der dauer des Krieges anderer seits werden"
					+ " immer neuere und Tödliche Wffen eingesetzte um nur milimetern an Land"
					+ " zu gewinnen. Wird der Krieg bald enden? ");
		
	
        }
       if(runde == 25) {
    	   Dialog d= new Dialog(mainUI.window, "Weißer Frieden");
			d.textLabel.setText("<html> Weißer Frieden"
					+ "<p/> Nun ist es offiziel, der Krieg ist vorbei!"
					+ " Es wurde ein weißer Frieden zwischen den Kriegspartein unterzeichnet."
					+ " bleibt die frage, ob die Welt nun aufatmen kann?");
		
	
       }
      if(runde == 30) {
    	  Dialog d= new Dialog(mainUI.window, "Annäherung");
			d.textLabel.setText("<html> Annäherung"
					+ "<p/> Der Weltkrieg war sehr verherrent und hatt viele Opfer(Menschen und Geld) gefordert."
					+ "Deshalb beginne nun alle europoäischen Staaten sich wieder anzunähern,"
					+ " damir nicht nochmal so ein Krieg ausbricht.");
		
	
       }
      if(runde == 35) {
    	  Dialog d= new Dialog(mainUI.window, "Vereinigte Staaten von Europa");
			d.textLabel.setText("<html> Vereinigte Staaten von Europa"
					+ "<p/> Ab heute sind wir nicht mehr eine Handelskompanie von England,"
					+ " sondern von den neu gegründeten Vereinigten Staaten von Europa!"
					+ " Alle europäischen Staaten haben sich entschieden, zusammen zu schließen"
					+ " damit sich nie mehr die europäischen Staaten untereinnander bekämpfen.");
		
	
      }
	}
	
	public void erstelleSpieler() {
		
		spielerLand = new Country();
		spielerLand.setzteName("Augustinsiche Handelskompanie");
	}
		
	public int gibRunde() {
		return runde;
	}
	
	public String gibGewinner(double pGegnerAngriff, double pGegnerverteidigung, double pSpielerAngriff, double pSpielerverteidigung) {
		
		double spielerAngriff = pSpielerAngriff;
		double spielerVerteidigung = pSpielerverteidigung;
		
		double gegnerAngriff= pGegnerAngriff;
		double gegnerverteidigung= pGegnerverteidigung;
		
		double i = Math.random();;
		
		if(i < 0.5) {
			//System.out.println("kleiner als");
			
			if(spielerAngriff > gegnerverteidigung) {
				//System.out.println("Spieler kliner als 0.5");
				//System.out.println(i);
				return "Spieler";
				
			}
			if(spielerAngriff < gegnerverteidigung) {
	        	
	        	spielerLand.meineArmee.armeeBesiegt();
	        //	System.out.println("Gegner als 0.5");
	        //	System.out.println(i);
	        	return "Gegner";
			}
		//	System.out.println("Spielerangriff: "+spielerAngriff);
		//	System.out.println("Gegnerverteidigung: " +gegnerverteidigung);
		}
		else if(i >= 0.5 && i <= 1) {
			
			
	        if(gegnerAngriff > spielerVerteidigung) {
	        	
	        	spielerLand.meineArmee.armeeBesiegt();
	        	//System.out.println("Gegner größer 0.5");
	        	//System.out.println(i);
	        	return "Gegner";
	        }
	        if(gegnerAngriff < spielerVerteidigung) {
		
	        	//System.out.println("Spieler großer 0.5");
	        	//System.out.println(i);
	        	return "Spieler";

	        }
	       // System.out.println("Spielerverteidigung: "+spielerVerteidigung);
			//System.out.println("Gegnerangriff: " +gegnerAngriff);
			
		}
		
		//System.out.println("Gegner?");
		//System.out.println(i);
		return "Gegner?";
	
	}
	
}
