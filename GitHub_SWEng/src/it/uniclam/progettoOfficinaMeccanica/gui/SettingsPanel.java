package it.uniclam.progettoOfficinaMeccanica.gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.uniclam.progettoEsame.*;

public class SettingsPanel extends JPanel {
	private JTextField host = new JTextField("localhost");
	private JTextField port = new JTextField("3306", 20);
	
	private JButton salva = new JButton("Salva");
	
	public SettingsPanel(ClientGUI clientGUI){

		// Definisci un oggetto gridbagconstraints per la specifica 
		// dei vincoli dell'interfaccia
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
		// Campo host
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		this.add(new JLabel("host:"), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		this.add(host, c);
		
		// Campo port
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		c.gridwidth = 2;
		this.add(new JLabel("port:"), c);
	
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 0;
		this.add(port, c);
		
		// Campo salva
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 5;   //2 columns wide
		this.add(salva, c);
		
		salva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Server.HOST = host.getText();
				Server.PORT = Integer.parseInt(port.getText());
			}
		});
	}
}
