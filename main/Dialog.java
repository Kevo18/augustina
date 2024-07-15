package main;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dialog implements ActionListener {
	

	 JDialog meinJDialog;
	 
	 JLabel textLabel;
	 JButton dialogButton;
	 
	
	
	public Dialog(Frame hauptFensterUI, String pName) {
		meinJDialog = new JDialog(hauptFensterUI);
		this.erstelleDialog(pName);
		
	}

	public void erstelleDialog(String pS) {
		
		meinJDialog.setTitle(pS);
        meinJDialog.setBounds(100, 100, 600, 700);
        meinJDialog.setResizable(false);
        meinJDialog.setVisible(true);
        meinJDialog.setModal(true);
        meinJDialog.setLocationRelativeTo(null);
        
        
       this.erstellePanel();
       
	}
	
	public void erstellePanel() {
		JPanel panel = new JPanel();
        panel.setLayout(null);
        
        
	    dialogButton = new JButton("OK");
		dialogButton.setToolTipText("Klicke um Fortzufahren");
		dialogButton.setBounds(463, 611, 111, 39);
		dialogButton.addActionListener(this);
		panel.add(dialogButton);
        
		textLabel = new JLabel("");
				
		textLabel.setBounds(10, 239, 564, 361);
		panel.add(textLabel);

        meinJDialog.add(panel); 
        
       
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== this.dialogButton) {
			
			
			meinJDialog.dispose();
		}

	}
}

