package it.uniclam.progettoOfficinaMeccanica.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.uniclam.progettoOfficinaMeccanica.ClientGUI;
import it.uniclam.progettoOfficinaMeccanica.Server;

public class InserisciDipendentiPanel extends JPanel{
	private JTextField nome = new JTextField("n", 20);
	private JTextField cognome = new JTextField("c", 20);	
	private JTextField telefono = new JTextField("t", 20);
	private JTextField email = new JTextField("e", 20);
	private JTextField data_assunzione = new JTextField("d", 20);
	private JTextField scadenza_contratto = new JTextField("s", 20);
	
	private JButton invia = new JButton("Inserisci");
	private JButton clear = new JButton("Clear");
	
	private JTextArea ta = new JTextArea(12, 12);
	
	public InserisciDipendentiPanel(ClientGUI clientGUI){
		//JPanel pane = new JPanel(new GridBagLayout());

		// Definisci un oggetto gridbagconstraints per la specifica 
		// dei vincoli dell'interfaccia
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
		// Campo nome
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		this.add(new JLabel("nome:"), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		this.add(nome, c);
		
		// Campo cognome
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		this.add(new JLabel("cognome:"), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		this.add(cognome, c);
		
		
		// Campo telefono
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		this.add(new JLabel("telefono:"), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		this.add(telefono, c);

		// Campo telefono
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		this.add(new JLabel("email:"), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		this.add(email, c);
	
		// Campo invia
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 5;   //2 columns wide
		this.add(invia, c);
		
		// Campo clear
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 4;
		c.gridwidth = 4;   //2 columns wide
		this.add(clear, c);
		
		// Campo risposta (label)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 4;   //2 columns wide
		this.add(new JLabel("Risposta:"), c);
		
		// Campo risposta
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 8;   //2 columns wide
		JScrollPane jp = new JScrollPane(ta);
		this.add(jp, c);
		
		clear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
			}
		});
				
		invia.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Socket s = new Socket(Server.HOST, Server.PORT);
					BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					PrintWriter out = new PrintWriter(s.getOutputStream(), true);
					
					String req = Server.INSERT_DIPENDENTI + "\n" + 
							"nome:" + nome.getText() + "\n" +
							"cognome:" + cognome.getText() + "\n" + 
							"telefono:" + telefono.getText() + "\n" + 
							"email:" + email.getText() + "\n" +
							"data_assunzione:01-01-2015\n" +
							"scadenza_contratto:31-12-2015\n" + 
							//"data_assunzione:" + data_assunzione.getText() + "\n" + 
							//"scadenza_contratto:" + scadenza_contratto.getText() + "\n" + 
							"\n";
					
					out.println(req);
					//System.out.println("Inviato: " + req);
					String line = in.readLine();
					if (line.equalsIgnoreCase("OK")){	//Forse qui possiamo usare Server.OK
						line = in.readLine();
						while(line.length() > 0){
							ta.append(line + "\n");
							line = in.readLine();
						}
						ta.append("\n");
					} else {
						ta.append("Si � verificato un errore nel server!" + "\n");
					}
					s.close();
				} catch (IOException ioe){
					JOptionPane.showMessageDialog(InserisciDipendentiPanel.this, "Error in communication with server!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});	
	}
}
