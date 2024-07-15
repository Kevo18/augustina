package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveManager {
	
	HauptFensterUI h;
	
	int z = 0;
	
	File ordner;
	
	public SaveManager(HauptFensterUI pH) {
		h = pH;
		
		ordner= new File("Files/saves");
		
		if(ordner.exists()) {
			System.out.println("Ordner gibt es");
		}
		else {
			System.out.println("ordner gibt es nicht");
		}
		
		
	}
	

	
	
	
	public void erstelleDatei() {
		try {

			File meineDatei= new File("Files/saves/test_"+ z+".txt");
			if(meineDatei.createNewFile()) {
				this.speichern(meineDatei);
			}
			else {
				z+=1;
				this.erstelleDatei();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		z=0;
		  System.out.println("z "+z);
		
	}

	public void speichern(File pF) {
        try{
        	
        	//Runde
        	 String s= String.valueOf(h.gm.gibRunde());
        	 
        	//Spieler

        	 String s1= String.valueOf(h.gm.spielerLand.gibVermögen());
        	 
        	 
        	 System.out.println("Vermögen: "+h.gm.spielerLand.gibVermögen());
        	 System.out.println("Vermögen: "+s1);
        	 
        	 String s2= String.valueOf(h.gm.spielerLand.meineArmee.gibAnzahlArtillery());
        	 String s3= String.valueOf(h.gm.spielerLand.meineArmee.gibAnzahlCavalry());
             String s4= String.valueOf(h.gm.spielerLand.meineArmee.gibAnzahlInfantery());
             
           //Level
             String s5= String.valueOf(h.gm.gibGebit1LevelStufe());
             String s6= String.valueOf(h.gm.gibGebit2LevelStufe());
             String s7= String.valueOf(h.gm.gibGebit3LevelStufe());
             String s8= String.valueOf(h.gm.gibGebit4LevelStufe());
             String s9 = String. valueOf(h.gm.gibGebit5Freigeschalten());
            
             
             //Forschung
             String s11= String.valueOf(h.gm.gibKostenLevel());
             String s12= String.valueOf(h.gm.gibAngriffsLevelKosten());
             String s13= String.valueOf(h.gm.gibVerteidigungslevelkosten());
            

            BufferedWriter writer = new BufferedWriter(new FileWriter(pF));

           //Runde
            writer.write(s);
            writer.newLine();
            
            // Spieler
            writer.write(s1);
            writer.newLine();
            writer.write(s2);
            writer.newLine();
            writer.write(s3);
            writer.newLine();
            writer.write(s4);
            writer.newLine();
            
            //Level
            writer.write(s5);
            writer.newLine();
            writer.write(s6);
            writer.newLine();
            writer.write(s7);
            writer.newLine();
            writer.write(s8);
            writer.newLine();
            writer.write(s9);
            writer.newLine();   
        
            //Forschung
            writer.write(s11);
            writer.newLine();
            writer.write(s12);
            writer.newLine();
            writer.write(s13);
            
            writer.flush();
            writer.close();
        } catch (IOException e){
            System.out.println("Datei konnte nicht erstellt werden");
	}         
  }

	public void laden(File pF) {
		
		Scanner scan= null;

        try{
            scan = new Scanner(pF);
        }catch(FileNotFoundException e){
            System.out.println("Datei nicht gefunden");
        }
        while(scan.hasNext()){
        	
        	//Runde
        	String runde = scan.nextLine();
        	
        	System.out.println(runde);
        	
        	int runde2 = Integer.valueOf(runde);
        	h.gm.runde = runde2;
        	
        	//Spieler
        	
        	String vermögen = scan.nextLine();
        	double vermögen2 = Double.valueOf(vermögen);
        	h.gm.spielerLand.setzteVermögen(vermögen2);
        	
        	String anzahlArtillery = scan.nextLine();
        	int anzahlArtillery2 = Integer.valueOf(anzahlArtillery);
        	h.gm.spielerLand.meineArmee.anzahlArtillery = anzahlArtillery2;
        	
        	String anzahlCavalry = scan.nextLine();
        	int anzahlCavalry2 = Integer.valueOf(anzahlCavalry);
        	h.gm.spielerLand.meineArmee.anzahlCavalry = anzahlCavalry2;
        	
        	String anzahlinfantery = scan.nextLine();
        	int anzahlinfantery2 = Integer.valueOf(anzahlinfantery);
        	h.gm.spielerLand.meineArmee.anzahlInfantery = anzahlinfantery2;
        	
        	//Level
        	
        	String gebit1Level = scan.nextLine();
        	int gebiet1Level2 = Integer.valueOf(gebit1Level);
        	h.gm.gebit1LevelStufe = gebiet1Level2;
        	
        	String gebit2Level = scan.nextLine();
        	int gebiet2Level2 = Integer.valueOf(gebit2Level);
        	h.gm.gebit2LevelStufe = gebiet2Level2;
        	
        	String gebit3Level = scan.nextLine();
        	int gebiet3Level2 = Integer.valueOf(gebit3Level);
        	h.gm.gebit3LevelStufe = gebiet3Level2;
        	
        	String gebit4Level = scan.nextLine();
        	
        	System.out.println(gebit4Level);
        	
        	int gebiet4Level2 = Integer.valueOf(gebit4Level);
        	h.gm.gebit4LevelStufe = gebiet4Level2;
        	
        	String gebit5Level = scan.nextLine();
        	Boolean gebiet5Level2 = Boolean.valueOf(gebit5Level);
        	h.gm.gebit5Freigeschalten = gebiet5Level2;
        	
        	//Forschung
        	
        	String kostenLevel = scan.nextLine();
        	int kostenLevel2 = Integer.valueOf(kostenLevel);
        	h.gm.kostenLevel = kostenLevel2;
        	
        	String angriffsLevel = scan.nextLine();
        	int angriffsLevel2 = Integer.valueOf(angriffsLevel);
        	h.gm.angriffsLevel = angriffsLevel2;
        	
        	String verteidigungsLevel = scan.nextLine();
        	int verteidigungsLevel2 = Integer.valueOf(verteidigungsLevel);
        	h.gm.verteidigungsLevel = verteidigungsLevel2;

        }
	}
}
