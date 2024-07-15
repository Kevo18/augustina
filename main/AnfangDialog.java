package main;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnfangDialog implements ActionListener {
	

	 JDialog meinJDialog;
	 
	 JLabel bildLabel;
	 JLabel textLabel;
	 JButton dialogButton;
	 
	
	
	public AnfangDialog(Frame hauptFensterUI) {
		meinJDialog = new JDialog(hauptFensterUI);
		this.erstelleDialog();
		
		//System.out.println("Dialog erstellt");
	}

	public void erstelleDialog() {
		
		meinJDialog.setTitle("Brief");
        meinJDialog.setBounds(100, 100, 600, 700);
        meinJDialog.setResizable(false);
        meinJDialog.setVisible(true);
        meinJDialog.setModal(true);
        meinJDialog.setLocationRelativeTo(null);
        
       this.erstellePanel();
       
      // System.out.println("erstelleDialog erstellt");
	}
	
	public void erstellePanel() {
		JPanel panel = new JPanel();
        panel.setLayout(null);
        
        bildLabel = new JLabel("Bild");
		bildLabel.setBounds(10, 11, 564, 217);
		bildLabel.setOpaque(true);
		bildLabel.setBackground(Color.LIGHT_GRAY);
		bildLabel.setIcon(this.ladeBild("/picture/anfangsDialogBildpng.png"));
		panel.add(bildLabel);
        
	    dialogButton = new JButton("OK");
		dialogButton.setToolTipText("Klicke um Fortzufahren");
		dialogButton.setBounds(463, 611, 111, 39);
		dialogButton.addActionListener(this);
		panel.add(dialogButton);
        
		textLabel = new JLabel("<html>Willkomen auf Augustina,<p/> "
				+ " <p/> Nach dem unsere Entdecker dies Mysteriöse Insel, in dem Atlantischen Ocenan, gefunden haben"
				+ " wurden Sie als neuen und ersten Govenor dieser neuen Kolonie bestimmt. Mit der Aufgabe diese Insel "
				+ " zu erkunden und zu sichern. "
				+ "<p/> Es ist von stategisch wichtigem Interesse das diese insel in unsere Kontrolle fählt, damit wir den Zugang zu unseren Kolonien besser kontolieren können"
				+ " und auch den Zugang zu den Kolonien unserer Feinde kontrollieren können. Es ist absolut wichtig das diese neu Entdeckte Insel auf keine Fall"
				+ " in die Hände unseres Rivalen, Frankreich fällt. "
				+ "<p/> Sie haben den Auftrag die Insel zu sichern, damit wir die See besser kontollieren könne und somit die absolute Seemacht bleiben."
				+ " Sobald wir Mittel haben, werden wir Ihnen diese zukommen lassen."
				+ "<p/> "
				+ "<p/> Ihre Majestät die Königin");
				
		textLabel.setBounds(10, 239, 564, 361);
		panel.add(textLabel);

        meinJDialog.add(panel); 
        
        //System.out.println("panel erstellt");
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== this.dialogButton) {
			
			//System.out.println("Dialog Button benutzt");
			
			meinJDialog.dispose();
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
}
