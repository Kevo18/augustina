package main;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelDetailsDialog implements ActionListener {
	
	Frame f1;
	
	HauptFensterUI hf;
	
	JDialog dialog;
	
	JPanel meinPanel;
	
	JButton bestätigungButton;
	
	
	JLabel spielerLabel;
	JLabel gegnerLabel;
	

	public LevelDetailsDialog(JDialog pDialog) {
		dialog= new JDialog(pDialog);
		
		dialog.setBounds(100, 100, 1005, 696);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setLocationRelativeTo(null);
		dialog.setResizable(false);
		
		
		this.erstelleDialog();
		
		dialog.setVisible(true);
		
	}
	
	public void setztehauptFensterUI(HauptFensterUI pHf) {
		hf= pHf;
	}
	
	
	public void erstelleDialog() {
		
		meinPanel= new JPanel();
		
		meinPanel.setLayout(null);
		
		JLabel namenLabel = new JLabel("                           Level Details");
		namenLabel.setBounds(340, 11, 215, 68);
		namenLabel.setOpaque(true);
		namenLabel.setBackground(Color.LIGHT_GRAY);
		meinPanel.add(namenLabel);
		
		bestätigungButton = new JButton("OK");
		bestätigungButton.setBounds(836, 594, 143, 52);
		bestätigungButton.addActionListener(this);
		meinPanel.add(bestätigungButton);
		
		spielerLabel = new JLabel("Spieler armee: \r\nSpieler Armee angriff: \r\nSpieler Armee verteidigung: \r\n");
		spielerLabel.setBounds(10, 21, 235, 120);
		spielerLabel.setOpaque(true);
		spielerLabel.setBackground(Color.LIGHT_GRAY);
		meinPanel.add(spielerLabel);
		
		gegnerLabel = new JLabel("Gegner Armee: \r\nGegner Armee angriff: \r\nGegner Armee verteidigung: ");
		gegnerLabel.setBounds(599, 21, 250, 123);
		gegnerLabel.setOpaque(true);
		gegnerLabel.setBackground(Color.LIGHT_GRAY);
		meinPanel.add(gegnerLabel);
		
		meinPanel.setBackground(Color.GRAY);
		
        dialog.add(meinPanel);
	}

	   public void actionPerformed(ActionEvent e) {
			
             if(e.getSource()== this.bestätigungButton) {
	
	            dialog.dispose();
	           
            }
		}
}
