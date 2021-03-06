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

/*In questa classe viene realizzata la GUI attraverso la quale sar� possibile inserire dipendenti all'interno
 * della tabella "dipendenti" del database "officina_meccanica". vengono a tale scopo gestiti tutti i campi 
 * della tabella "dipendenti"*/

public class InserisciDipendentiPanel extends JPanel{
	private JTextField nome 				= new JTextField("n", 20);
	private JTextField cognome 				= new JTextField("c", 20);	
	private JTextField telefono 			= new JTextField("t", 20);
	private JTextField email 				= new JTextField("e", 20);
	private JTextField data_assunzione 		= new JTextField("1970-01-01", 20);
	private JTextField scadenza_contratto 	= new JTextField("xxxx-xx-xx", 20);
	
	private JButton invia = new JButton("Inserisci");//Pulsante per completare l'inserimento in tabella
	private JButton clear = new JButton("Clear");    //Pulsante che permette di pulire la textArea
	
	private JTextArea ta = new JTextArea(12, 12);    //Area di testo che visualizza l'esito 
	               									 //dell'operazione effettuata
	public InserisciDipendentiPanel(ClientGUI clientGUI){
	
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

		// Campo email
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		this.add(new JLabel("email:"), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		this.add(email, c);

		// Campo data assunzione
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		this.add(new JLabel("data assunz.:"), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		this.add(data_assunzione, c);
		
		// Campo scadenza_contratto
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		this.add(new JLabel("scad. contratto:"), c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 5;
		this.add(scadenza_contratto, c);
		
		// Campo cerca
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 4;   //2 columns wide
		this.add(invia, c);
		
		// Campo clear
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 6;
		c.gridwidth = 4;   //2 columns wide
		this.add(clear, c);

		// Campo risposta (label)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 7;
		c.gridwidth = 4;   //2 columns wide
		this.add(new JLabel("Risposta:"), c);
		
		// Campo risposta (text area)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 	8;
		c.gridwidth = 4;   //2 columns wide  era 8
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
					
					/*Viene adesso riportata la query sql che che permetter� l'inserimento dei dati nella tabella*/

					String req = Server.INSERT_DIPENDENTI + "\n" + 
							"nome:" + nome.getText() + "\n" +
							"cognome:" + cognome.getText() + "\n" + 
							"telefono:" + telefono.getText() + "\n" + 
							"email:" + email.getText() + "\n" +
							"data_assunzione:" + data_assunzione.getText() + "\n" +
							"scadenza_contratto:" + scadenza_contratto.getText() + "\n" + 
							"\n";
					
					out.println(req);
					System.out.println("DEBUG: Inviato dal Pannello: " + req);
					String line = in.readLine();
					if (line.equalsIgnoreCase(Server.OK)){
						line = in.readLine();
						while(line.length() > 0){
							ta.append(line + "\n");
							line = in.readLine();
						}
						ta.append("Dati dipendente inseriti con successo!");
					} 
					else {
						ta.append("Si � verificato un errore nel server!" + "\n");
						ta.append(line);
					}
					s.close();
				} catch (IOException ioe){
					JOptionPane.showMessageDialog(InserisciDipendentiPanel.this, "Error in communication with server!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});	
	}
}
