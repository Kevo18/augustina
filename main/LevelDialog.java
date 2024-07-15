package main;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelDialog implements ActionListener {
	
	Frame hauptFensterUI;
	
	HauptFensterUI hfui;
	
	LevelDetailsDialog details;
	
	JDialog dialog;
	
	JPanel meinPanel;
	
	JLabel levelBildLabel;
	JLabel levelTextlabel;
	JLabel levelStufeLabel;
	JLabel levelNamensLabel;
	
	JButton levelBeginnenButton;
	JButton detailsButton;
	
	GegnerArmee gegnerArmee;

	double spielerAngriff; 
	double spielerVerteidigung;
	
	double gegnerAngriff;
	double gegnerVerteidigung;
	
	String gewinner="KA";
	

	public LevelDialog(Frame pFrame, HauptFensterUI pHf) {
		
	    dialog = new JDialog(pFrame);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setBounds(100, 100, 1000, 700);
		dialog.setLocationRelativeTo(null);
		dialog.setResizable(false);
		
		this.erstelleLevelDialog();
		
		hfui=pHf;
		//hauptFensterUI= pFrame;
		dialog.setVisible(true);
		
		gegnerArmee= new GegnerArmee();
		
	}
	
	public void erstelleLevelDialog() {
		
		meinPanel= new JPanel();
		meinPanel.setLayout(null);
		
		
	    levelNamensLabel = new JLabel("Name");
		levelNamensLabel.setBounds(10, 0, 235, 57);
		levelNamensLabel.setOpaque(true);
		meinPanel.add(levelNamensLabel);
		
		levelBildLabel = new JLabel("Bild");
		levelBildLabel.setBounds(612, 0, 372, 463);
		levelBildLabel.setOpaque(true);
		levelBildLabel.setBackground(Color.LIGHT_GRAY);
		meinPanel.add(levelBildLabel);
		
		levelTextlabel = new JLabel("Level Text");
		levelTextlabel.setBounds(10, 198, 414, 463);
		levelTextlabel.setOpaque(true);
		meinPanel.add(levelTextlabel);
		
		levelStufeLabel = new JLabel("Level Stufe");
		levelStufeLabel.setBounds(10, 66, 398, 99);
		levelStufeLabel.setOpaque(true);
		meinPanel.add(levelStufeLabel);
		
	    levelBeginnenButton = new JButton("Start");
		levelBeginnenButton.setBounds(782, 568, 192, 82);
		levelBeginnenButton.addActionListener(this);
		meinPanel.add(levelBeginnenButton);
		
	    detailsButton = new JButton("Details");
		detailsButton.setBounds(834, 493, 140, 64);
		detailsButton.addActionListener(this);
		meinPanel.add(detailsButton);
		
		dialog.add(meinPanel);
	}
	
        public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== this.levelBeginnenButton) {
			
			spielerAngriff=hfui.gm.spielerLand.meineArmee.gibArmeeangriff();
			spielerVerteidigung=hfui.gm.spielerLand.meineArmee.gibArmeeVerteidigung();
			
			gewinner= hfui.gm.gibGewinner(gegnerAngriff, gegnerVerteidigung, spielerAngriff, spielerVerteidigung);
			
			//System.out.println(spielerAngriff);
			//System.out.println(gegnerVerteidigung);
			
			
		}
		else if(e.getSource()== this.detailsButton) {
			
			details= new LevelDetailsDialog(dialog);
			//details.setzetWerte(hauptFensterUI);
			
			//System.out.println("Details Dialog erstellt");
		}

	}
        
}
