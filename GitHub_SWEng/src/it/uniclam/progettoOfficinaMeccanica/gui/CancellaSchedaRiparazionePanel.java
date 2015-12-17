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
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.uniclam.progettoOfficinaMeccanica.GestioneSchedeGUI;
import it.uniclam.progettoOfficinaMeccanica.Server;
import it.uniclam.progettoOfficinaMeccanica.entity.SchedaRiparazione;

public class CancellaSchedaRiparazionePanel extends JPanel{
	private JTextField emailSchedaDaCancellare 	= new JTextField("", 20);

	private JTextField marca_veicolo		 	= new JTextField("", 20);
	private JTextField modello_veicolo		 	= new JTextField("", 20);
	private JTextField data_entrata			 	= new JTextField("", 20);
	private JTextField data_immatricolazione 	= new JTextField("", 20);
	private JTextField descrizione_intervento	= new JTextField("", 20);
	private JTextField data_evasione		 	= new JTextField("", 20);
	private JTextField nome_cliente			 	= new JTextField("", 20);
	private JTextField cognome_cliente		 	= new JTextField("", 20);
	private JTextField tel_cliente			 	= new JTextField("", 20);
	private JTextField email_cliente			= new JTextField("", 20);
	private JTextField id_meccanico			 	= new JTextField("", 20);

	private JButton cancella = new JButton("Cancella");//Pulsante che permette di Cancellare

	private JButton clear = new JButton("Clear");    //Pulsante che ha la funzionalità di 'pulire' la ta
	private JButton cerca = new JButton("Cerca");
	private JTextArea ta = new JTextArea(12, 12);    //In questa parte del pannello verrà visualizzato 
	//l'eventuale esito positivo dell'operazione 
	//appena effettuata, o, in caso contrario, 
	//il corrispondente messaggio di errore.

	public CancellaSchedaRiparazionePanel(GestioneSchedeGUI gestioneSchedeGUI){

		// Si definisce un oggetto gridbagconstraints per  
		// la specifica dei vincoli dell'interfaccia
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());

		// Campo email Cliente Scheda da Cancellare
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		this.add(new JLabel("email Cliente scheda:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		this.add(emailSchedaDaCancellare, c);

		// Pulsante Cerca Scheda da Cancellare
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		c.gridwidth = 4;
		this.add(cerca, c);

		// Campo marca_veicolo
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		this.add(new JLabel("marca_veicolo:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		this.add(marca_veicolo, c);
		marca_veicolo.setEnabled(false);

		// Campo modello_veicolo
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		this.add(new JLabel("modello_veicolo:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		this.add(modello_veicolo, c);
		modello_veicolo.setEnabled(false);

		// Campo data_entrata
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		this.add(new JLabel("data_entrata:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		this.add(data_entrata, c);
		data_entrata.setEnabled(false);

		// Campo data_immatricolazione
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		this.add(new JLabel("data_immatricolazione:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		this.add(data_immatricolazione, c);
		data_immatricolazione.setEnabled(false);

		// Campo descrizione_intervento
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		this.add(new JLabel("descrizione_intervento:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 5;
		this.add(descrizione_intervento, c);
		descrizione_intervento.setEnabled(false);

		// Campo data_evasione
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		this.add(new JLabel("data_evasione:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 6;
		this.add(data_evasione, c);
		data_evasione.setEnabled(false);

		// Campo nome_cliente
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 7;
		this.add(new JLabel("nome_cliente:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 7;
		this.add(nome_cliente, c);
		nome_cliente.setEnabled(false);

		// Campo cognome_cliente
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 8;
		this.add(new JLabel("cognome_cliente:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 8;
		this.add(cognome_cliente, c);
		cognome_cliente.setEnabled(false);

		// Campo tel_cliente
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 9;
		this.add(new JLabel("tel_cliente:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 9;
		this.add(tel_cliente, c);
		tel_cliente.setEnabled(false);

		// Campo email_cliente
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 10;
		this.add(new JLabel("email_cliente:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 10;
		this.add(email_cliente, c);
		email_cliente.setEnabled(false);

		// Campo id_meccanico
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 11;
		this.add(new JLabel("id_meccanico:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 11;
		this.add(id_meccanico, c);
		id_meccanico.setEnabled(false);

		// Campo Cancella
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 12;
		c.gridwidth = 4;   //2 columns wide
		this.add(cancella, c);

		// Campo clear
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 12;
		c.gridwidth = 4;   //2 columns wide
		this.add(clear, c);

		// Campo risposta (label)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 13;
		c.gridwidth = 4;   //2 columns wide          
		this.add(new JLabel("Risposta:"), c);

		// Campo risposta text area
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 	13;
		c.gridwidth = 4;   //2 columns wide  era 8
		JScrollPane jp = new JScrollPane(ta);
		this.add(jp, c);

		clear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
			}
		});

		cerca.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Socket s = new Socket(Server.HOST, Server.PORT);

					BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					PrintWriter out = new PrintWriter(s.getOutputStream(), true);

					String req = 
							Server.FIND_BY_EMAIL_SCHEDA + "\n" + 
									"email_cliente:" + emailSchedaDaCancellare.getText() + "\n" +
									"\n";
					out.println(req);
					System.out.println("DEBUG: req cerca by email Inviata: " + req);

					String line = in.readLine();
					if (line.equalsIgnoreCase(Server.OK)){
						line = in.readLine();
						if (line.length()>0) {
							String delimitatore = "[,]";
							String[] arrayCampi = line.split(delimitatore);
							
							marca_veicolo.setText(arrayCampi[0].replaceAll("^\\s+", ""));
							modello_veicolo.setText(arrayCampi[1].replaceAll("^\\s+", ""));
							data_entrata.setText(arrayCampi[2].replaceAll("^\\s+", ""));
							data_immatricolazione.setText(arrayCampi[3].replaceAll("^\\s+", ""));
							descrizione_intervento.setText(arrayCampi[4].replaceAll("^\\s+", ""));
							data_evasione.setText(arrayCampi[5].replaceAll("^\\s+", ""));
							nome_cliente.setText(arrayCampi[6].replaceAll("^\\s+", ""));
							cognome_cliente.setText(arrayCampi[7].replaceAll("^\\s+", ""));
							tel_cliente.setText(arrayCampi[8].replaceAll("^\\s+", ""));
							email_cliente.setText(arrayCampi[9].replaceAll("^\\s+", ""));
							id_meccanico.setText(arrayCampi[10].replaceAll("^\\s+", ""));
						}
					} else {
						ta.append("RICERCA SCHEDA: Si è verificato un errore nel server!" + "\n");
					}
					s.close();
				} catch (IOException ioe){
					JOptionPane.showMessageDialog(CancellaSchedaRiparazionePanel.this, "CancellaSchedaRiparazione: Error in communication with server!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cancella.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Socket s = new Socket(Server.HOST, Server.PORT);
					BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					PrintWriter out = new PrintWriter(s.getOutputStream(), true);

					/*Viene adesso riportata la query sql che che permetterà l'inserimento dei dati nella tabella*/

					String req = Server.INSERT_SCHEDA + "\n" + 
							"marca_veicolo:" + marca_veicolo.getText() + "\n" +
							"modello_veicolo:" + modello_veicolo.getText() + "\n" +
							"data_entrata:" + data_entrata.getText() + "\n" +
							"data_immatricolazione:" + data_immatricolazione.getText() + "\n" +
							"descrizione_intervento:" + descrizione_intervento.getText() + "\n" +
							"data_evasione:" + data_evasione.getText() + "\n" +
							"nome_cliente:" + nome_cliente.getText() + "\n" +
							"cognome_cliente:" + cognome_cliente.getText() + "\n" +
							"tel_cliente:" + tel_cliente.getText() + "\n" +
							"id_meccanico:" + id_meccanico.getText() + "\n" + 
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
						ta.append("Dati inseriti correttamente nella scheda!");
					} else {
						ta.append("Si è verificato un errore nel server!" + "\n");
						ta.append(line);
					}
					s.close();
				} catch (IOException ioe){
					JOptionPane.showMessageDialog(CancellaSchedaRiparazionePanel.this, "Error in communication with server!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});	
	}

}
