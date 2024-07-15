package main;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class HauptFensterUI extends WindowAdapter  implements ActionListener {

	JFrame window;
	
	AnfangDialog dialog;

	private JLayeredPane layeredPane;
	
	private JPanel menüPanel;
	private JPanel kartenPanel;
	private JPanel armeePanel;
	private JPanel forschungPanel;
	public JPanel spielEndepanel;
	JPanel einstellungsPanel;
	
	public JLabel statesLabel;
	private JLabel anzeigenLabel;
	public JLabel kartenLabel;
	public JLabel rundeenAnzahlLabel;
	
	public JLabel intanteryLabel;
	public JLabel caveleryLabel;
	public JLabel bilderLabel;
	public JLabel artilleryLabel;
	 JLabel infanteryAnzahlLabel;
	 JLabel infanteryAnzahlLabel_1;
	 JLabel infanteryAnzahlLabel_2;
	private JLabel armeeNameLabel;
	public JLabel kostenBildLabel;
	private JLabel forschungNameLabel;
	public JLabel angriffBildLabel;
	public JLabel verteidigungBildLabel;
	public JLabel kostenLevelBildLabel;
	public JLabel angriffLevelBildLabel;
	public JLabel verteidigungLevelBildLabel;
	public JLabel kostenKostenLabel;
	public JLabel angriffKostenLabel;
	public JLabel verteidigungKostenLabel;
	public JLabel spielerFlaggeLabel;
	private JLabel spielerNameLabel;
	private JLabel gewinnerLabel;
	
	private JButton speichernButton; 
	private JButton ladenButton;
	
	private JButton menüButton;
	private JButton armeeButton;
	private JButton forschungsButton;
	private JButton kartenButton;
	private JButton rundeBeendenButton;
	private JButton infanteryErhöhenButton;
	private JButton infanteryVerringernButton;
	private JButton caveleryAnzahlErhöhenButton;
	private JButton caveleryAnzahlVerringerButton;
	private JButton artilleryAnzahlErhöhenButton;
	private JButton artilleryAnzahlVerringernButton;
	private JButton kostenVerbessernButton;
	private JButton angriffVerbessernButton;
	private JButton verteidigungVerbessernButton;
	JButton gebiet1Button;
	JButton gebiet2Button;
	JButton gebiet3Button;
	JButton gebiet4Button;
	JButton gebiet5Button;
	JButton neuesSpielButton;
	
	public GameManager gm;
	

	LevelDialog gebit1Level1;
	LevelDialog gebit1Level2;
	LevelDialog gebit1Level3;
	
	LevelDialog gebit2Level1;
	LevelDialog gebit2Level2;
	LevelDialog gebit2Level3;
	

	 LevelDialog gebit3Level1;
	 LevelDialog gebit3Level2;
	 LevelDialog gebit3Level3;
	 
	 LevelDialog gebit4Level1;
	 LevelDialog gebit4Level2;
	 LevelDialog gebit4Level3;
	 
	 LevelDialog gebit5Level;
	
	SaveManager s;
	 

	// Der konstruktor der Klasse
	
	public HauptFensterUI() {

		this.createUI();
		gm = new GameManager(this);
		this.panelÄndern(kartenPanel);
		
		s= new SaveManager(this);
		
		//System.out.println("UI erstellt");
	
	}
	
	// Mit dieser methode werden die aktionen für die einzelnen JButtons festgelegt

	public void actionPerformed(ActionEvent e) {
		
		if(gm.gebit5beendet == false) {
			
			if(e.getSource()== this.kartenButton) {
				this.panelÄndern(kartenPanel);
			}
			else if(e.getSource()== this.armeeButton) {
				this.panelÄndern(armeePanel);
			}
			else if(e.getSource()== this.forschungsButton) {
				this.panelÄndern(forschungPanel);
			}

	        else if(e.getSource()== this.gebiet1Button) {
	        	
				
				if(gm.gibGebit1LevelStufe()==1) {
					
					gebit1Level1= new LevelDialog(window, this);
					
					gebit1Level1.levelBildLabel.setIcon(gm.ladeBild("/picture/legionärBild.png"));
					
					gebit1Level1.levelStufeLabel.setText("1 Stufe");
					gebit1Level1.levelNamensLabel.setText(" Gebiet 1");
					
					gebit1Level1.levelTextlabel.setText("<html>Level beschreibung: "+
					"<p/> Nach dem wir auf dieser Unbekannten Insel unser lager aufgeschalgen haben, haben unsere Erkunder angefangen die insel zu erkunden."
					+ " Nachdem wir unzählige in diese gebiet schickten kamen nur einige zurück. Sie erzählten von einer unglaublichen Entdeckung."
					+ " Sie erzählten von untoten römischen Legionären von denen sie angegrieffen wurden."
					+ " Um unsere leute zu schützen müssen wir diese ungeheuer verrnichten!");
				
					gebit1Level1.gegnerArmee.erstelleEnemy(50, 30, 10, 5, 5, 0, 0, 0, 0, 0);
					gebit1Level1.gegnerArmee.berechneArmeeGröße();
					gebit1Level1.gegnerArmee.berechneArmeeAngriff();
					gebit1Level1.gegnerArmee.berechneArmeeVerteidigung();
					
					gebit1Level1.gegnerAngriff= gebit1Level1.gegnerArmee.gibArmeeAngriff();
					gebit1Level1.gegnerVerteidigung= gebit1Level1.gegnerArmee.gibArmeeVerteidigung();
					
					gebit1Level1.spielerAngriff= gm.spielerLand.meineArmee.gibArmeeangriff();
					gebit1Level1.spielerVerteidigung= gm.spielerLand.meineArmee.gibArmeeVerteidigung();
				}
				else if(gm.gibGebit1LevelStufe()==2) {
					
					gebit1Level2= new LevelDialog(window, this);
					
					gebit1Level2.levelBildLabel.setIcon(gm.ladeBild("/picture/konquistadorBild.png"));
					
					gebit1Level2.levelTextlabel.setText("<html>Level beschreibung: "+
							"<p/> Nachdem wir die untoten Legionäre verrnichtet haben, kammen auch noch untote Konquistadoren."
							+ " Anscheinend waren nicht nur die Römer sondern auch die Spanier schon auf dieser Insel!"
							+ " Doch warum ist diese Insel unnbekannt? das muss dringent näher Untersucht wereden! "
							+ "Doch zu erst müssen wir nochmals Untote vernichten! ");
					
					gebit1Level2.levelStufeLabel.setText("2 Stufe");
					gebit1Level2.levelNamensLabel.setText(" Gebiet 2");
					
					gebit1Level2.gegnerArmee.erstelleEnemy(70, 50, 30, 25, 25, 20, 0, 0, 0, 0);
					gebit1Level2.gegnerArmee.erstelleEnemy(50, 30, 10, 5, 5, 0, 0, 0, 0, 0);
					gebit1Level2.gegnerArmee.berechneArmeeGröße();
					gebit1Level2.gegnerArmee.berechneArmeeAngriff();
					gebit1Level2.gegnerArmee.berechneArmeeVerteidigung();
					
					gebit1Level2.gegnerAngriff= gebit1Level2.gegnerArmee.gibArmeeAngriff();
					gebit1Level2.gegnerVerteidigung= gebit1Level2.gegnerArmee.gibArmeeVerteidigung();
					
					gebit1Level2.spielerAngriff= gm.spielerLand.meineArmee.gibArmeeangriff();
					gebit1Level2.spielerVerteidigung= gm.spielerLand.meineArmee.gibArmeeVerteidigung();
				}
				else if(gm.gibGebit1LevelStufe()==3) {
					
					gebit1Level3= new LevelDialog(window, this);
					
					gebit1Level3.levelBildLabel.setIcon(gm.ladeBild("/picture/golemBild.png"));
					
					gebit1Level3.levelTextlabel.setText("<html>Level beschreibung: "+
							"<p/> Nun haben wir untote Römer und Spanier verrnichtet. Doch warum leben die Toten auf dieser Insel? "
							+ " Das kann nicht mit rechten Dingen zu tun habne! Unser Pastor meint die Insel Augustus sei das Reich des Teufels, Lucifers!"
							+ "Doch kann das sein? unsere Soildaten erstrecken pötzlich als die Steine sich anfangen zu bewegen"
							+ " auf einmal entstehen Golems aus den Steinen! Was geht hier nur ab?");
					
					gebit1Level3.levelStufeLabel.setText("3 Stufe");
					gebit1Level3.levelNamensLabel.setText(" Gebiet 3");
					
					gebit1Level3.gegnerArmee.erstelleEnemy(90, 70, 50, 45, 45, 20, 0, 0, 0, 0);
					gebit1Level3.gegnerArmee.erstelleEnemy(50, 30, 10, 5, 5, 0, 0, 0, 0, 0);
					gebit1Level3.gegnerArmee.berechneArmeeGröße();
					gebit1Level3.gegnerArmee.berechneArmeeAngriff();
					gebit1Level3.gegnerArmee.berechneArmeeVerteidigung();
					

					gebit1Level3.gegnerAngriff= gebit1Level3.gegnerArmee.gibArmeeAngriff();
					gebit1Level3.gegnerVerteidigung= gebit1Level3.gegnerArmee.gibArmeeVerteidigung();
					
					gebit1Level3.spielerAngriff= gm.spielerLand.meineArmee.gibArmeeangriff();
					gebit1Level3.spielerVerteidigung= gm.spielerLand.meineArmee.gibArmeeVerteidigung();
	   				
	   			}
				else if(gm.gibGebit1LevelStufe()==4) {
	   				gebiet1Button.setText("Fertig");
	   			}
			}
	        else if(e.getSource()== this.gebiet2Button) {
	        	
				if(gm.gibGebit2LevelStufe()==1) {
					
					gebit2Level1= new LevelDialog(window, this);
					gebit2Level1.gegnerArmee.erstelleEnemy(70, 70, 50, 45, 45, 20, 0, 0, 0, 0);
					
					gebit2Level1.levelBildLabel.setIcon(gm.ladeBild("/picture/werwolfBild.png"));
					
					gebit2Level1.levelTextlabel.setText("<html>Level beschreibung: "+
							"<p/> Unsere Entdecker berichten aus diesem teil der Insel Augustus, das menschens große Wölfe sie angriffen. "
							+ "Auch noch Werwölfe sind hier unterwegs. das kann ja heiter werden! Was soll noch alles übernatürliche hier herum geistern?");
					
					gebit2Level1.levelStufeLabel.setText("1 Stufe");
					gebit2Level1.levelNamensLabel.setText(" Gebiet 2");
					
					gebit2Level1.gegnerArmee.berechneArmeeGröße();
					gebit2Level1.gegnerArmee.berechneArmeeAngriff();
					gebit2Level1.gegnerArmee.berechneArmeeVerteidigung();

					gebit2Level1.gegnerAngriff= gebit2Level1.gegnerArmee.gibArmeeAngriff();
					gebit2Level1.gegnerVerteidigung= gebit2Level1.gegnerArmee.gibArmeeVerteidigung();
					
					gebit2Level1.spielerAngriff= gm.spielerLand.meineArmee.gibArmeeangriff();
					gebit2Level1.spielerVerteidigung= gm.spielerLand.meineArmee.gibArmeeVerteidigung();
					
				}
				else if(gm.gibGebit2LevelStufe()==2) {
					
					gebit2Level2= new LevelDialog(window, this);
					gebit2Level2.gegnerArmee.erstelleEnemy(100, 100, 70, 65, 65, 40, 0, 0, 0, 0);
					
					gebit2Level2.levelBildLabel.setIcon(gm.ladeBild("/picture/vampierBild.png"));
					
					gebit2Level2.levelTextlabel.setText("<html>Level beschreibung: "+
							"<p/> Nun haben wir die Werwölfe besiegt, doch auf einmal tauchen Fledermäuse auf. Was ein Glück keine Monster"
							+ "Doch dan hören wir schreie von hinten und sehen das einer unserer Soldaten balass auf den boden liegt. direkt "
							+ "über Ihn verwandelt sich eine Fledermaus in eine art Mensch! Ein Vampier!");

					gebit2Level2.levelStufeLabel.setText("2 Stufe");
					gebit2Level2.levelNamensLabel.setText(" Gebiet 2");

					gebit2Level2.gegnerArmee.berechneArmeeGröße();
					gebit2Level2.gegnerArmee.berechneArmeeAngriff();
					gebit2Level2.gegnerArmee.berechneArmeeVerteidigung();

					gebit2Level2.gegnerAngriff= gebit2Level2.gegnerArmee.gibArmeeAngriff();
					gebit2Level2.gegnerVerteidigung= gebit2Level2.gegnerArmee.gibArmeeVerteidigung();
					
					gebit2Level2.spielerAngriff= gm.spielerLand.meineArmee.gibArmeeangriff();
					gebit2Level2.spielerVerteidigung= gm.spielerLand.meineArmee.gibArmeeVerteidigung();
				}
				else if(gm.gibGebit2LevelStufe()==3) {
					
					gebit2Level3= new LevelDialog(window, this);
					gebit2Level3.gegnerArmee.erstelleEnemy(120, 120, 100, 85, 85, 60, 0, 0, 0, 0);
					
					gebit2Level3.levelBildLabel.setIcon(gm.ladeBild("/picture/hexerBild.png"));
					
					gebit2Level3.levelTextlabel.setText("<html>Level beschreibung: "+
							"<p/> nun habne wir auch nach mühen endlich diesen trupp unter führung des Vampires besiegt."
							+ "Doch dann hören wir kein gruseliges kichern vom Himmel her. was ist jezt los? "
							+ " Wir schauen nach oben und sehen eine Hexer! ");
					
					gebit2Level3.levelStufeLabel.setText("3 Stufe");
					gebit2Level3.levelNamensLabel.setText(" Gebiet 2");

					gebit2Level3.gegnerArmee.berechneArmeeGröße();
					gebit2Level3.gegnerArmee.berechneArmeeAngriff();
					gebit2Level3.gegnerArmee.berechneArmeeVerteidigung();

					gebit2Level3.gegnerAngriff= gebit2Level3.gegnerArmee.gibArmeeAngriff();
					gebit2Level3.gegnerVerteidigung= gebit2Level3.gegnerArmee.gibArmeeVerteidigung();
					
					gebit2Level3.spielerAngriff= gm.spielerLand.meineArmee.gibArmeeangriff();
					gebit2Level3.spielerVerteidigung= gm.spielerLand.meineArmee.gibArmeeVerteidigung();
	   				
	   			}
				else if(gm.gibGebit2LevelStufe()==4) {
	   				gebiet2Button.setText("Fertig");
	   			}
			}
	        else if(e.getSource()== this.gebiet3Button) {
				
				if(gm.gibGebit3LevelStufe()==1) {
					
					gebit3Level1= new LevelDialog(window, this);
	 				gebit3Level1.gegnerArmee.erstelleEnemy(150, 150, 130, 115, 115, 90, 30, 0, 0, 0);
	 				
	 				gebit3Level1.levelBildLabel.setIcon(gm.ladeBild("/picture/schattenBild.png"));
	 				
	 				gebit3Level1.levelTextlabel.setText("<html>Level beschreibung: "+
							"<p/> Mit mühe sind wir nun in dieses gebiet vorgestoßen"
							+ "Doch dann hören wir ein gruseliges kichern vom Himmel her. Was ist jezt los? "
							+ " Wir schauen nach oben und sehen ein Schatten! ");
	 				
	 				gebit3Level1.levelStufeLabel.setText("1 Stufe");
					gebit3Level1.levelNamensLabel.setText(" Gebiet 3");

					gebit3Level1.gegnerArmee.berechneArmeeGröße();
					gebit3Level1.gegnerArmee.berechneArmeeAngriff();
					gebit3Level1.gegnerArmee.berechneArmeeVerteidigung();

					gebit3Level1.gegnerAngriff= gebit3Level1.gegnerArmee.gibArmeeAngriff();
					gebit3Level1.gegnerVerteidigung= gebit3Level1.gegnerArmee.gibArmeeVerteidigung();
					
					gebit3Level1.spielerAngriff= gm.spielerLand.meineArmee.gibArmeeangriff();
					gebit3Level1.spielerVerteidigung= gm.spielerLand.meineArmee.gibArmeeVerteidigung();
					
					
				}
				else if(gm.gibGebit3LevelStufe()==2) {
					
					gebit3Level2= new LevelDialog(window, this);
	 				gebit3Level2.gegnerArmee.erstelleEnemy(170, 170, 150,135, 135, 110, 50, 0, 0, 0);
	 				
	 				gebit3Level2.levelBildLabel.setIcon(gm.ladeBild("/picture/schattenElfBild.png"));
	 				
	 				gebit3Level2.levelTextlabel.setText("<html>Level beschreibung: "+
							"<p/> Der Hexer wurde nun besiegt, doch aus dem Schatten dauchen auf einam andere Wesen auf."
							+ " Achtung schatten Elfen!");
	 				
	 				gebit3Level2.levelStufeLabel.setText("2 Stufe");
					gebit3Level2.levelNamensLabel.setText(" Gebiet 3");

					gebit3Level2.gegnerArmee.berechneArmeeGröße();
					gebit3Level2.gegnerArmee.berechneArmeeAngriff();
					gebit3Level2.gegnerArmee.berechneArmeeVerteidigung();

					gebit3Level2.gegnerAngriff= gebit3Level2.gegnerArmee.gibArmeeAngriff();
					gebit3Level2.gegnerVerteidigung= gebit3Level2.gegnerArmee.gibArmeeVerteidigung();
					
					gebit3Level2.spielerAngriff= gm.spielerLand.meineArmee.gibArmeeangriff();
					gebit3Level2.spielerVerteidigung= gm.spielerLand.meineArmee.gibArmeeVerteidigung();
					
				}
				else if(gm.gibGebit3LevelStufe()==3) {
					
					gebit3Level3= new LevelDialog(window, this);
	 				gebit3Level3.gegnerArmee.erstelleEnemy(190, 190, 170, 155, 155, 80, 70, 0, 0, 0);
	 				
	 				gebit3Level3.levelBildLabel.setIcon(gm.ladeBild("/picture/schattenKriegerBild.png"));
	 				
	 				gebit3Level3.levelTextlabel.setText("<html>Level beschreibung: "+
							"<p/> Wir bekommen nciht einaml eine verschnaufpause, da kommen schon die nächsten Gegner!");
	 				
	 				gebit3Level3.levelStufeLabel.setText("3 Stufe");
					gebit3Level3.levelNamensLabel.setText(" Gebiet 3");

					gebit3Level3.gegnerArmee.berechneArmeeGröße();
					gebit3Level3.gegnerArmee.berechneArmeeAngriff();
					gebit3Level3.gegnerArmee.berechneArmeeVerteidigung();

					gebit3Level3.gegnerAngriff= gebit3Level3.gegnerArmee.gibArmeeAngriff();
					gebit3Level3.gegnerVerteidigung= gebit3Level3.gegnerArmee.gibArmeeVerteidigung();
					
					gebit3Level3.spielerAngriff= gm.spielerLand.meineArmee.gibArmeeangriff();
					gebit3Level3.spielerVerteidigung= gm.spielerLand.meineArmee.gibArmeeVerteidigung();
	   				
	   			}
				else if(gm.gibGebit3LevelStufe()==4) {
	   				gebiet3Button.setText("Fertig");
	   			}
			}
	         else if(e.getSource()== this.gebiet4Button) {

	 			if(gm.gibGebit4LevelStufe()==1) {
	 				
	 			    gebit4Level1= new LevelDialog(window, this);
	 				gebit4Level1.gegnerArmee.erstelleEnemy(210, 210, 190, 175, 175, 100, 90, 20, 0, 0);
	 				
	 				gebit4Level1.levelBildLabel.setIcon(gm.ladeBild("/picture/automatronBild.png"));
	 				
	 				gebit4Level1.levelTextlabel.setText("<html>Level beschreibung: "+
							"<p/> Endlich haben wir es nun auch noch in diese neue gebiet geschafft. "
							+ "Vor uns sehen wir eine Gestalt die in der vor einen Menschen ähnelt."
							+ " Als wir näher kommen sehen wor das dies kein echter mensch ist, sondern ein Automatron."
							+ "Uns bekommt ein vertrautes Gefühl, aus unsere Heimat."
							+ " Doch wie kann es sein das Automatronen aus unserer heimat hier sind, obwohl diese Insele (Augustina)"
							+ "unbekannt ist? Wir haben auch keine Automatronen mit genohmen"
							+ " Auf einmal dreht sich der automatrin zu uns und greift an!");
						
	 				
	 				gebit4Level1.levelStufeLabel.setText("1 Stufe");
					gebit4Level1.levelNamensLabel.setText(" Gebiet 4");

					gebit4Level1.gegnerArmee.berechneArmeeGröße();
					gebit4Level1.gegnerArmee.berechneArmeeAngriff();
					gebit4Level1.gegnerArmee.berechneArmeeVerteidigung();

					gebit4Level1.gegnerAngriff= gebit4Level1.gegnerArmee.gibArmeeAngriff();
					gebit4Level1.gegnerVerteidigung= gebit4Level1.gegnerArmee.gibArmeeVerteidigung();
					
					gebit4Level1.spielerAngriff= gm.spielerLand.meineArmee.gibArmeeangriff();
					gebit4Level1.spielerVerteidigung= gm.spielerLand.meineArmee.gibArmeeVerteidigung();
	 				
	 			}
	 			else if(gm.gibGebit4LevelStufe()==2) {
	 			    
	 				gebit4Level2= new LevelDialog(window, this);
	 				gebit4Level2.gegnerArmee.erstelleEnemy(230, 230, 210, 195, 195, 120, 110, 40, 0, 0);
	 				
	 				gebit4Level2.levelBildLabel.setIcon(gm.ladeBild("/picture/pestDoktorBild.png"));
	 				
	 				gebit4Level2.levelTextlabel.setText("<html>Level beschreibung: "+
							"<p/> Uns stellen sich immer mehr fragen! Warum sind hier Monstern? Warum sind hier Automatronen?"
							+ " Warum greifen uns Automatronen uns an? eigentlich dürfen diese das nicht. da sehen wir aufeinaml"
							+ "eine schwarze Gestalt auf uns zu kommen! es sieht wie ein... Pestdoktor aus!"
							+ " Uns bekommt die Angst. wir erinnern uns an die alten geschichten vom Schwarzen Tod! "
							+ " Das Wesen greift an!  ");
	 				
	 				gebit4Level2.levelStufeLabel.setText("2 Stufe");
					gebit4Level2.levelNamensLabel.setText(" Gebiet 4");

					gebit4Level2.gegnerArmee.berechneArmeeGröße();
					gebit4Level2.gegnerArmee.berechneArmeeAngriff();
					gebit4Level2.gegnerArmee.berechneArmeeVerteidigung();

					gebit4Level2.gegnerAngriff= gebit4Level2.gegnerArmee.gibArmeeAngriff();
					gebit4Level2.gegnerVerteidigung= gebit4Level2.gegnerArmee.gibArmeeVerteidigung();
					
					gebit4Level2.spielerAngriff= gm.spielerLand.meineArmee.gibArmeeangriff();
					gebit4Level2.spielerVerteidigung= gm.spielerLand.meineArmee.gibArmeeVerteidigung();
	 				
	 			}
	 			else if(gm.gibGebit4LevelStufe()==3) {
	 				
	 				gebit4Level3= new LevelDialog(window, this);
	 				gebit4Level3.gegnerArmee.erstelleEnemy(250, 250, 230, 215, 215, 140, 130, 60, 0, 0);
	 				
	 				gebit4Level3.levelBildLabel.setIcon(gm.ladeBild("/picture/necromancerBild.png"));
	 				
	 				gebit4Level3.levelTextlabel.setText("<html>Level beschreibung: "+
							"<p/> Nun haben wir auch noch diesen Trupp besiegt. Hoffentlich ist es jetzt vorbei!"
							+ "Doch da erschein abermals ein mennschenänliches Wesen."
							+ " Auf einmal erscheinen skelette an den stellen der Toten und greifen uns an!"
							+ "Scheinabr ist das Wesen ein Totenbeschwörer, ein Necromancer!"
							+ "Wir müssen ihn schnells mölich vernichten!");
	 				
	 				gebit4Level3.levelStufeLabel.setText("3 Stufe");
					gebit4Level3.levelNamensLabel.setText(" Gebiet 4");
	 				

					gebit4Level3.gegnerArmee.berechneArmeeGröße();
					gebit4Level3.gegnerArmee.berechneArmeeAngriff();
					gebit4Level3.gegnerArmee.berechneArmeeVerteidigung();

					gebit4Level3.gegnerAngriff= gebit4Level3.gegnerArmee.gibArmeeAngriff();
					gebit4Level3.gegnerVerteidigung= gebit4Level3.gegnerArmee.gibArmeeVerteidigung();
					
					gebit4Level3.spielerAngriff= gm.spielerLand.meineArmee.gibArmeeangriff();
					gebit4Level3.spielerVerteidigung= gm.spielerLand.meineArmee.gibArmeeVerteidigung();
	 				
	    			}
	 			else if(gm.gibGebit4LevelStufe()==4) {
	    				gebiet4Button.setText("Fertig");
	    			}

			}
	         else if(e.getSource()== this.gebiet5Button) {
	 			
	 			if(gm.gibGebit5Freigeschalten() == true && gm.gibGebit5beendet() == false) {
	 				
	 			    gebit5Level= new LevelDialog(window, this);
	 			    
	 			   gebit5Level.levelBildLabel.setIcon(gm.ladeBild("/picture/verrückterWissenschaftlerBild.png"));
	 			   
	 			  gebit5Level.levelTextlabel.setText("<html>Level beschreibung: "+
							"<p/> Nun sind wir endlich in der Mitte der Insel angelangt. Da finden wir eine Tür im Berg."
							+ "warum ist hier eine Tür? Wir treten hinein und finden uns in ein riesigen endlos scheinenden Raum wieder!"
							+ " Überall stehen komsiche Maschiene herum und nicht nur das auch sind endlos viele Monster hier! "
							+ " Scheinabr sind wir am Ursprung der Monster angelangt! "
							+ " An einer Maschinen arbeiten ein... Wissenschaftler!"
							+ " Als er uns sieht schreit er: Nun werdet ihr von meiner Armee endlich besiegt! Davei lacht er auch noch verrückt. "
							+ "Nun sind wir uns sicher wen wir die Armee des verückten Wissenschaftlers vernichten und diesen Ort zerstören "
							+ " sind die Monster weg und kommen nicht mehr wieder."
							+ " Damit könne wir endlich Augustian für Ihre Majestät die Königin sichern! Also los Leute, zum Angriff! ");
	 			    
	 			   gebit5Level.levelStufeLabel.setText("Max");
	 			  gebit5Level.levelNamensLabel.setText(" Gebiet 5");
	 			    
	 				gebit5Level.gegnerArmee.erstelleEnemy(300, 300, 250, 250, 250, 150, 150, 100, 50, 50);
	 				
					gebit5Level.gegnerArmee.berechneArmeeGröße();
					gebit5Level.gegnerArmee.berechneArmeeAngriff();
					gebit5Level.gegnerArmee.berechneArmeeVerteidigung();

					gebit5Level.gegnerAngriff= gebit5Level.gegnerArmee.gibArmeeAngriff();
					gebit5Level.gegnerVerteidigung= gebit5Level.gegnerArmee.gibArmeeVerteidigung();
					
					gebit5Level.spielerAngriff= gm.spielerLand.meineArmee.gibArmeeangriff();
					gebit5Level.spielerVerteidigung= gm.spielerLand.meineArmee.gibArmeeVerteidigung();
	 				
	 			}
	 			else if( gm.gibGebit5beendet() == true) {
	 				gebiet5Button.setText("Beendet");
	 			}
	 		}

	        else if(e.getSource()== this.menüButton) {
				
	        	this.panelÄndern(einstellungsPanel);
	        	
			}
	       else if(e.getSource()== this.rundeBeendenButton) {
				
	    	   gm.beendeRunde();
	    	
			}
	       else if(e.getSource()== this.infanteryErhöhenButton) {

	    	   if(gm.spielerLand.gibVermögen() >= gm.spielerLand.meineArmee.meineInfantery.gibKosten()) {
	    		   gm.spielerLand.meineArmee.infanteryErhöhen(1); 
	    		   gm.spielerLand.vermögen-=gm.spielerLand.meineArmee.meineInfantery.gibKosten();
	    	   }
	
			}
	       else if(e.getSource()== this.infanteryVerringernButton) {
				
	    	   if(gm.spielerLand.meineArmee.gibAnzahlInfantery() > 0) {
	    		   gm.spielerLand.meineArmee.infanteryVerringern(1);
	    		   gm.spielerLand.vermögen+=gm.spielerLand.meineArmee.meineInfantery.gibKosten();
	    	   }	
			}
	       else if(e.getSource()== this.caveleryAnzahlErhöhenButton) {
				
	    	   if(gm.spielerLand.gibVermögen() >= gm.spielerLand.meineArmee.meineCavalry.gibKosten()) {
	    		   gm.spielerLand.meineArmee.cavalryErhöhen(1);
	    		   gm.spielerLand.vermögen-=gm.spielerLand.meineArmee.meineCavalry.gibKosten();
	    	   }
				
			}
	       else if(e.getSource()== this.caveleryAnzahlVerringerButton) {

	    	   if(gm.spielerLand.meineArmee.gibAnzahlCavalry() > 0) {
	    		   gm.spielerLand.meineArmee.cavalryVerringern(1);
	    		   gm.spielerLand.vermögen+=gm.spielerLand.meineArmee.meineCavalry.gibKosten();
	    	   }
			}
	       else if(e.getSource()== this.artilleryAnzahlErhöhenButton) {
				
	    	   if(gm.spielerLand.gibVermögen() >= gm.spielerLand.meineArmee.meineArtillery.gibKosten()) {
	    		   gm.spielerLand.meineArmee.artilleryErhöhen(1); 
	    		   gm.spielerLand.vermögen-=gm.spielerLand.meineArmee.meineArtillery.gibKosten();
	    	   }
			}
	       else if(e.getSource()== this.artilleryAnzahlVerringernButton) {
				
	    	   if(gm.spielerLand.meineArmee.gibAnzahlArtillery() > 0) {
	    		   gm.spielerLand.meineArmee.artilleryVerringern(1);
	    		   gm.spielerLand.vermögen+=gm.spielerLand.meineArmee.meineArtillery.gibKosten();
	    	   }
			}
	       else if(e.getSource()== this.kostenVerbessernButton) {

	    	   if(gm.spielerLand.gibVermögen()>= gm.gibKostenKosten() && gm.gibKostenLevel() < 4) {
                    
	    		   gm.spielerLand.vermögen-=gm.gibKostenKosten();
	    		   gm.setzteKostenLevel(1);
	    		   
	    	   }	
			}
	       else if(e.getSource()== this.angriffVerbessernButton) {
				
               if(gm.spielerLand.gibVermögen()>= gm.gibAngriffsLevelKosten() && gm.gibAngriffsLevel() < 4) {
            	   gm.spielerLand.vermögen-=gm.gibAngriffsLevelKosten();
            	   gm.setzteAngriffsLevel(1);

	    	   }
			}
	       else if(e.getSource()== this.verteidigungVerbessernButton) {
	    	   
               if(gm.spielerLand.gibVermögen()>= gm.gibVerteidigungslevelkosten() && gm.gibVerteidigungsLevel() < 4 ) {
            	   gm.spielerLand.vermögen-=gm.gibVerteidigungslevelkosten();
            	   gm.setzteVerteidigungsLevel(1);
	    	   }	
			}
	       else if(e.getSource()== this.speichernButton) {
				
				s.erstelleDatei();

			}
	       else if(e.getSource()== this.ladenButton) {

	    	   JFileChooser chooser = new JFileChooser();

	    	   int rueckgabe = chooser.showOpenDialog(null);
	    	   
	    	   if(rueckgabe == JFileChooser.APPROVE_OPTION)
	           {
	               
	               System.out.println("Die zu öffnende Datei ist: " +
	                     chooser.getSelectedFile().getName());
	               
	               s.laden(chooser.getSelectedFile());
	               
	               System.out.println(gm.spielerLand.gibVermögen());
	               
	           }

			}	
		}	
	}
	
	
	// Diese Methode ist dafür um ein LayeredPane zu erstellen 
	
	public void erstelleLayeredPane() {
		
		 layeredPane = new JLayeredPane();
		 layeredPane.setBounds(182, 0, 1602, 961);
		 window.getContentPane().add(layeredPane);
		
	}
	
	// hier wird die Fläche, wenn man den Einstellungs JButton drückt, erstellt
	
	public void erstelleeinstellungsbereich() {
		
		einstellungsPanel = new JPanel();
		einstellungsPanel.setLayout(null);
		einstellungsPanel.setBounds(0, 0, 1592, 961);
		einstellungsPanel.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(einstellungsPanel);
		
		speichernButton= new JButton("Speichern");
		
		speichernButton.setBounds(500, 400, 112, 50);
		einstellungsPanel.add(speichernButton);
		speichernButton.setToolTipText("Klicke um zu speichern");
		speichernButton.addActionListener(this);
		
		ladenButton= new JButton("Laden");
		ladenButton.setBounds(800, 400, 112, 50);
		einstellungsPanel.add(ladenButton);
		ladenButton.setToolTipText("Klicke um Spielstand zu Laden");
		ladenButton.addActionListener(this);
		
		JLabel name= new JLabel("Einstellungen");
		name.setBounds(600, 30, 100, 30);
		einstellungsPanel.add(name);
		
		
	}
	
	
	// Diese Methode ist für den Linken bereich des Jframes dar, die einzelene JButton zu erstellen
	
	public void erstelleMenüLeiste() {
		
		menüPanel = new JPanel();
		menüPanel.setBounds(0, 0, 182, 961);
		window.getContentPane().add(menüPanel);
		menüPanel.setLayout(null);
		
		menüButton = new JButton("Menü");
		menüButton.setToolTipText("Klicke um Menü zu öffnen");
		menüButton.setBounds(23, 11, 112, 50);
		menüPanel.add(menüButton);
		menüButton.addActionListener(this);
		
	    armeeButton = new JButton("Armee");
	    armeeButton.setToolTipText("Klicke um Armee zu öffnen");
		armeeButton.addActionListener(this);
			
		armeeButton.setBounds(23, 200, 112, 50);
		menüPanel.add(armeeButton);
		
		forschungsButton = new JButton("Forschung");
		forschungsButton.setToolTipText("Klicke um Forschung zu öffnen");
		forschungsButton.setBounds(23, 289, 112, 50);
		menüPanel.add(forschungsButton);
		forschungsButton.addActionListener(this);
		
		kartenButton = new JButton("Karte");
		kartenButton.setToolTipText("Klicke um Karte zu öffnen");
		kartenButton.setBounds(23, 88, 127, 71);
		kartenButton.addActionListener(this);
		menüPanel.add(kartenButton);
		
	    gebiet1Button = new JButton("1 Gebite Level 1");
		gebiet1Button.setToolTipText("Klicke um Gebiet Nr. 1 zu öffnen");
		gebiet1Button.setBounds(10, 426, 125, 23);
		gebiet1Button.addActionListener(this);
		menüPanel.add(gebiet1Button);
		
		gebiet2Button = new JButton("2 Gebiet Level 1");
		gebiet2Button.setToolTipText("Klicke um Gebiet Nr. 2 zu öffnen");
		gebiet2Button.setBounds(10, 469, 125, 23);
		gebiet2Button.addActionListener(this);
		menüPanel.add(gebiet2Button);
		
		gebiet3Button = new JButton("3 Gebiet Level 1");
		gebiet3Button.setToolTipText("Klicke um Gebiet Nr. 3 zu öffnen");
		gebiet3Button.setBounds(10, 513, 125, 23);
		gebiet3Button.addActionListener(this);
		menüPanel.add(gebiet3Button);
		
		gebiet4Button = new JButton("4 Gebiet Level 1");
		gebiet4Button.setToolTipText("Klicke um Gebiet Nr. 4 zu öffnen");
		gebiet4Button.setBounds(10, 561, 125, 23);
		gebiet4Button.addActionListener(this);
		menüPanel.add(gebiet4Button);
		
		gebiet5Button = new JButton("5 Gebiet");
		gebiet5Button.setToolTipText("Klicke um Gebiet Nr. 5 zu öffnen");
		gebiet5Button.setBounds(10, 605, 125, 23);
		gebiet5Button.addActionListener(this);
		menüPanel.add(gebiet5Button);
		
		
	   
		
	}
	
	// Hier wird der Anzeigenbereich erstellt der erscheint wenn man auf dem JButton namens " Karte " drückt

	public void erstelleKartenBereich() {
		
		kartenPanel = new JPanel();
		kartenPanel.setLayout(null);
		kartenPanel.setBounds(0, 0, 1602, 961);
		layeredPane.add(kartenPanel);
		
		statesLabel = new JLabel("Werte: ");
		statesLabel.setOpaque(true);
		//statesLabel.setBackground(Color.LIGHT_GRAY);
		statesLabel.setBounds(10, 0, 1267, 58);
		kartenPanel.add(statesLabel);
		
		rundeBeendenButton = new JButton("Runde beednen");
		rundeBeendenButton.setToolTipText("Klicke um Runde zu beendem");
		rundeBeendenButton.setBounds(1421, 891, 140, 48);
		kartenPanel.add(rundeBeendenButton);
		rundeBeendenButton.addActionListener(this);
		
		anzeigenLabel = new JLabel("<html> Baue eine Armee und schließe die Level ab um zu siegen!");
		anzeigenLabel.setOpaque(true);
		//anzeigenLabel.setBackground(Color.LIGHT_GRAY);
		anzeigenLabel.setBounds(1341, 550, 250, 300);
		kartenPanel.add(anzeigenLabel);
		
		 spielerFlaggeLabel= new JLabel("Flagge");
		 spielerFlaggeLabel.setOpaque(true);
		 spielerFlaggeLabel.setBackground(Color.LIGHT_GRAY);
		 spielerFlaggeLabel.setBounds(1341, 300, 245, 200);
		 kartenPanel.add(spielerFlaggeLabel);

		 spielerNameLabel= new JLabel("Augustinsiche Handelskompanie");
		 spielerNameLabel.setOpaque(true);
		 //spielerNameLabel.setBackground(Color.LIGHT_GRAY);
		 spielerNameLabel.setBounds(1360, 250, 200, 30);
		 kartenPanel.add(spielerNameLabel);
		 
		kartenLabel = new JLabel("Karte");
		kartenLabel.setOpaque(true);
		kartenLabel.setBackground(Color.LIGHT_GRAY);
		kartenLabel.setBounds(10, 80, 1267, 859);
		kartenPanel.add(kartenLabel);
		
		rundeenAnzahlLabel = new JLabel("Runde: ");
		rundeenAnzahlLabel.setOpaque(true);
		//rundeenAnzahlLabel.setBackground(Color.LIGHT_GRAY);
		rundeenAnzahlLabel.setBounds(1421, 11, 140, 78);
		kartenPanel.add(rundeenAnzahlLabel);
		

	}
	
	// der bereich für den JButton " Armee"
	
	public void erstelleArmeebereich() {
		
		armeePanel = new JPanel();
		armeePanel.setLayout(null);
		armeePanel.setBounds(0, 0, 1602, 961);
		armeePanel.setBackground(Color.gray);
		layeredPane.add(armeePanel);
		
		intanteryLabel = new JLabel("infanteryBild");
		intanteryLabel.setOpaque(true);
		intanteryLabel.setBackground(Color.LIGHT_GRAY);
		intanteryLabel.setBounds(52, 122, 278, 438);
		armeePanel.add(intanteryLabel);
		
		caveleryLabel = new JLabel("caveleryBild");
		caveleryLabel.setOpaque(true);
		caveleryLabel.setBackground(Color.LIGHT_GRAY);
		caveleryLabel.setBounds(407, 122, 278, 438);
		armeePanel.add(caveleryLabel);
		
		bilderLabel = new JLabel("bilderBilder");
		bilderLabel.setOpaque(true);
		bilderLabel.setBackground(Color.LIGHT_GRAY);
		bilderLabel.setBounds(1227, 122, 278, 438);
		armeePanel.add(bilderLabel);
		
		artilleryLabel = new JLabel("artilleryBild");
		artilleryLabel.setOpaque(true);
		artilleryLabel.setBackground(Color.LIGHT_GRAY);
		artilleryLabel.setBounds(879, 122, 278, 438);
		armeePanel.add(artilleryLabel);
		
		infanteryAnzahlLabel = new JLabel("Anzahl: ");
		infanteryAnzahlLabel.setOpaque(true);
		infanteryAnzahlLabel.setBackground(Color.gray);
		infanteryAnzahlLabel.setBounds(74, 579, 236, 75);
		armeePanel.add(infanteryAnzahlLabel);
		
		infanteryAnzahlLabel_1 = new JLabel("Anzahl: ");
		infanteryAnzahlLabel_1.setOpaque(true);
		infanteryAnzahlLabel_1.setBackground(Color.gray);
		infanteryAnzahlLabel_1.setBounds(427, 579, 236, 75);
		armeePanel.add(infanteryAnzahlLabel_1);
		
		infanteryAnzahlLabel_2 = new JLabel("Anzahl: ");
		infanteryAnzahlLabel_2.setOpaque(true);
		infanteryAnzahlLabel_2.setBackground(Color.gray);
		infanteryAnzahlLabel_2.setBounds(904, 591, 236, 75);
		armeePanel.add(infanteryAnzahlLabel_2);
		
		infanteryErhöhenButton = new JButton("Anzahl erhöhen");
		infanteryErhöhenButton.setBounds(117, 685, 153, 50);
		armeePanel.add(infanteryErhöhenButton);
		infanteryErhöhenButton.addActionListener(this);
		
		infanteryVerringernButton = new JButton("Anzahl verringern\r\n");
		infanteryVerringernButton.setBounds(117, 750, 153, 50);
		armeePanel.add(infanteryVerringernButton);
		infanteryVerringernButton.addActionListener(this);
		
		caveleryAnzahlErhöhenButton = new JButton("Anzahl erhöhen");
		caveleryAnzahlErhöhenButton.setBounds(471, 685, 153, 50);
		armeePanel.add(caveleryAnzahlErhöhenButton);
		caveleryAnzahlErhöhenButton.addActionListener(this);
		
		caveleryAnzahlVerringerButton = new JButton("Anzahl verringern");
		caveleryAnzahlVerringerButton.setBounds(471, 750, 153, 50);
		armeePanel.add(caveleryAnzahlVerringerButton);
		caveleryAnzahlVerringerButton.addActionListener(this);
		
		artilleryAnzahlErhöhenButton = new JButton("Anzahl erhöhen");
		artilleryAnzahlErhöhenButton.setBounds(962, 685, 153, 50);
		armeePanel.add(artilleryAnzahlErhöhenButton);
		artilleryAnzahlErhöhenButton.addActionListener(this);
		
		artilleryAnzahlVerringernButton = new JButton("Anzahl verringern");
		artilleryAnzahlVerringernButton.setBounds(962, 750, 153, 50);
		armeePanel.add(artilleryAnzahlVerringernButton);
		artilleryAnzahlVerringernButton.addActionListener(this);
		
		armeeNameLabel = new JLabel("Armee");
		armeeNameLabel.setBounds(264, 24, 975, 75);
		armeePanel.add(armeeNameLabel);
	}
	
	// Diese Methode erstellt die Fläche für das Spiel Ende
	
	public void erstelleEndepanel() {
		
		spielEndepanel= new JPanel();
		spielEndepanel.setLayout(null);
		spielEndepanel.setSize(1792, 1000);
		spielEndepanel.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(spielEndepanel);
		
		
		gewinnerLabel= new JLabel("<html>Spiel zu Ende: Du hast gewonnen :)"
				+ "<p/> "
				+ "<p/> Der verückte Wissenschaftler wurde besiget und die Insel wurde gesichtert.");
		gewinnerLabel.setOpaque(true);
		gewinnerLabel.setBackground(Color.LIGHT_GRAY);
		gewinnerLabel.setBounds(500, 500, 200, 100);

		spielEndepanel.add(gewinnerLabel);

	}
	
	// Erstellung der Fläache für den Jbutton "Forschung"

	public void erstelleForschungsBereich() {
		forschungPanel = new JPanel();
		forschungPanel.setLayout(null);
		forschungPanel.setBounds(0, 0, 1592, 961);
		forschungPanel.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(forschungPanel);
		
		kostenBildLabel = new JLabel("kostenBild");
		kostenBildLabel.setOpaque(true);
		kostenBildLabel.setBackground(Color.LIGHT_GRAY);
		kostenBildLabel.setBounds(40, 122, 90, 80);
		forschungPanel.add(kostenBildLabel);
		
		forschungNameLabel = new JLabel("Forschung");
		forschungNameLabel.setOpaque(true);
		forschungNameLabel.setBackground(Color.LIGHT_GRAY);
		forschungNameLabel.setBounds(343, 22, 276, 60);
		forschungPanel.add(forschungNameLabel);
		
		angriffBildLabel = new JLabel("angriffBild");
		angriffBildLabel.setOpaque(true);
		angriffBildLabel.setBackground(Color.LIGHT_GRAY);
		angriffBildLabel.setBounds(40, 358, 90, 80);
		forschungPanel.add(angriffBildLabel);
		
		verteidigungBildLabel = new JLabel("verteidigungBild");
		verteidigungBildLabel.setOpaque(true);
		verteidigungBildLabel.setBackground(Color.LIGHT_GRAY);
		verteidigungBildLabel.setBounds(40, 603, 90, 80);
		forschungPanel.add(verteidigungBildLabel);
		
		kostenVerbessernButton = new JButton("Verbessern");
		kostenVerbessernButton.setToolTipText("Klicke um Kosten zu verbessern\r\n");
		kostenVerbessernButton.setBounds(210, 151, 89, 23);
		forschungPanel.add(kostenVerbessernButton);
		kostenVerbessernButton.addActionListener(this);
		
		angriffVerbessernButton = new JButton("Verbessern");
		angriffVerbessernButton.setToolTipText("Klicke um Angriff zu verbessern");
		angriffVerbessernButton.setBounds(210, 387, 89, 23);
		forschungPanel.add(angriffVerbessernButton);
		angriffVerbessernButton.addActionListener(this);
		
		verteidigungVerbessernButton = new JButton("Verbessern");
		verteidigungVerbessernButton.setToolTipText("Klicke um Verteidigung zu verbessern");
		verteidigungVerbessernButton.setBounds(210, 632, 89, 23);
		forschungPanel.add(verteidigungVerbessernButton);
		verteidigungVerbessernButton.addActionListener(this);
		
		kostenLevelBildLabel = new JLabel("kostenLevel");
		kostenLevelBildLabel.setOpaque(true);
		kostenLevelBildLabel.setBackground(Color.LIGHT_GRAY);
		kostenLevelBildLabel.setBounds(343, 155, 276, 50);
		forschungPanel.add(kostenLevelBildLabel);
		
		angriffLevelBildLabel = new JLabel("angriffLevel");
		angriffLevelBildLabel.setOpaque(true);
		angriffLevelBildLabel.setBackground(Color.LIGHT_GRAY);
		angriffLevelBildLabel.setBounds(343, 391, 276, 50);
		forschungPanel.add(angriffLevelBildLabel);
		
		verteidigungLevelBildLabel = new JLabel("verteidigungLevel");
		verteidigungLevelBildLabel.setOpaque(true);
		verteidigungLevelBildLabel.setBackground(Color.LIGHT_GRAY);
		verteidigungLevelBildLabel.setBounds(343, 636, 276, 50);
		forschungPanel.add(verteidigungLevelBildLabel);
		
		kostenKostenLabel = new JLabel("Kosten: ");
		kostenKostenLabel.setOpaque(true);
		kostenKostenLabel.setBackground(Color.LIGHT_GRAY);
		kostenKostenLabel.setBounds(210, 237, 94, 14);
		forschungPanel.add(kostenKostenLabel);
		
		angriffKostenLabel = new JLabel("Kosten: ");
		angriffKostenLabel.setOpaque(true);
		angriffKostenLabel.setBackground(Color.LIGHT_GRAY);
		angriffKostenLabel.setBounds(210, 470, 94, 14);
		forschungPanel.add(angriffKostenLabel);
		
		verteidigungKostenLabel = new JLabel("Kosten: ");
		verteidigungKostenLabel.setOpaque(true);
		verteidigungKostenLabel.setBackground(Color.LIGHT_GRAY);
		verteidigungKostenLabel.setBounds(210, 693, 94, 14);
		forschungPanel.add(verteidigungKostenLabel);
	}

	
	// erstellung des gesamten JFrames
	
	private void createUI() {
		window = new JFrame();
		window.setTitle("Augustina");
		window.setSize(1792, 1000);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		window.getContentPane().setLayout(null);
		window.setVisible(true);
		window.addWindowListener(this);
		
		this.erstelleLayeredPane();
		this.erstelleMenüLeiste();
		this.erstelleKartenBereich();
		this.erstelleArmeebereich();
		this.erstelleForschungsBereich();
		this.erstelleEndepanel();
		this.erstelleeinstellungsbereich();
		
		dialog= new AnfangDialog(window);
		
	}
	
	// festlegung was passiert, wen man das rote X am oberen rechten Rand drückt
	
	public void windowClosing(WindowEvent e){
        int a=JOptionPane.showConfirmDialog(window,"Willst du das Spiel ohne Speichern verlassen?"); 
       
        if(a==JOptionPane.YES_OPTION){
        	window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        	
        }
        else if(a==JOptionPane.NO_OPTION){
        	
        	s.erstelleDatei();
        	window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);

        }
    }
	
	// Methode um zwischen den JPanels zu wechseln
	
	public void panelÄndern(JPanel p) {
		
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
}
