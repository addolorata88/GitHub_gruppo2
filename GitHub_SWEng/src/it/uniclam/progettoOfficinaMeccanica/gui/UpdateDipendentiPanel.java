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

public class UpdateDipendentiPanel extends JPanel{
	// Usato per cercare via chiave primaria un dipendente (uso l'email)
	private JTextField emailDipendenteDaModificare = new JTextField("", 20);

	private JTextField nome = new JTextField("", 20);
	private JTextField cognome = new JTextField("", 20);	
	private JTextField telefono = new JTextField("", 20);
	private JTextField email = new JTextField("", 20);
	private JTextField data_assunzione = new JTextField("", 20);
	private JTextField scadenza_contratto = new JTextField("", 20);

	private JButton modifica = new JButton("Modifica");//Pulsante per modificare i dati
	private JButton cerca = new JButton("Cerca");
	private JButton clear = new JButton("Clear");

	private JTextArea ta = new JTextArea(12, 12);

	public UpdateDipendentiPanel(ClientGUI clientGUI){ 

		// Definisci un oggetto gridbagconstraints per la specifica 
		// dei vincoli dell'interfaccia
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());

		// Campo email da modificare
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		this.add(new JLabel("email Dipendente da Modificare:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		this.add(emailDipendenteDaModificare, c);

		// Campo cerca
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		c.gridwidth = 4;   //2 columns wide
		this.add(cerca, c);		

		// ********************************
		// Campo nome
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		this.add(new JLabel("nome:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		this.add(nome, c);

		// Campo cognome
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		this.add(new JLabel("cognome:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		this.add(cognome, c);		

		// Campo telefono
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		this.add(new JLabel("telefono:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		this.add(telefono, c);

		// Campo email
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		this.add(new JLabel("email (chiave primaria):"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		this.add(email, c);
		email.setEnabled(false);

		// Campo data assunzione
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		this.add(new JLabel("data assunz.:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 5;
		this.add(data_assunzione, c);

		// Campo scadenza contratto
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		this.add(new JLabel("scad. contratto:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 6;
		this.add(scadenza_contratto, c);

		// Campo modifica
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 7;
		c.gridwidth = 4;   //4 columns wide
		this.add(modifica, c);		

		// Campo clear
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 7;
		c.gridwidth = 4;   //4 columns wide
		this.add(clear, c);

		// Campo risposta (label)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 4;   //2 columns wide
		this.add(new JLabel("Risposta:"), c);

		// Campo risposta text area
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 	9;
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

					String req = Server.QUERY_DIPENDENTI + "\n" + 
							"nome:\n" + 
							"cognome:\n" + 							
							"telefono:\n" + 
							"email:" + emailDipendenteDaModificare.getText() + "\n" + 
							"data_assunzione:\n" + 
							"scadenza_contratto:\n" + 
							"\n";

					out.println(req);
					System.out.println("DEBUG: req Cerca Dip by email Inviata: " + req);
					String line = in.readLine();
					if (line.equalsIgnoreCase(Server.OK)){
						line = in.readLine();
						//Se ho trovato almeno un elemento popolo i campi
						if (line.length() > 0) {
							// Separo tutti i campi in un array, e successivamente popolo le JTextField
							String delims = "[,]";
							String[] arrayCampi = line.split(delims);

							// Uso il metodo .replaceAll("^\\s+", "") per eliminare eventuali spazi ad inizio stringa
							nome.setText(arrayCampi[0].replaceAll("^\\s+", ""));
							cognome.setText(arrayCampi[1].replaceAll("^\\s+", ""));
							telefono.setText(arrayCampi[2].replaceAll("^\\s+", ""));
							email.setText(arrayCampi[3].replaceAll("^\\s+", ""));
							data_assunzione.setText(arrayCampi[4].replaceAll("^\\s+", ""));
							scadenza_contratto.setText(arrayCampi[5].replaceAll("^\\s+", ""));
						}
					} else {
						ta.append("CERCA Dip. da Update: Si � verificato un errore nel server!" + "\n");
					}
					s.close();
				} catch (IOException ioe){
					JOptionPane.showMessageDialog(UpdateDipendentiPanel.this, "Error in communication with server!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		modifica.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Socket s = new Socket(Server.HOST, Server.PORT);

					BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					PrintWriter out = new PrintWriter(s.getOutputStream(), true);

					String req = Server.UPDATE_DIPENDENTI + "\n" + 
							"nome:" + nome.getText() + "\n" +
							"cognome:" + cognome.getText() + "\n" + 
							"telefono:" + telefono.getText() + "\n" + 
							"email:" + email.getText() + "\n" +
							"data_assunzione:" + data_assunzione.getText() + "\n" +
							"scadenza_contratto:" + scadenza_contratto.getText() + "\n" + 
							"\n";

					out.println(req);
					System.out.println("DEBUG: req Update Inviata: " + req);
					String line = in.readLine();
					if (line.equalsIgnoreCase(Server.OK)){
						ta.append("Modifica Effettuata con Successo:\n");
						line = in.readLine();
						ta.append(line);
						ta.append("\n");
					} else {
						ta.append("CHIAMATA UPDATE: Si � verificato un errore nel server!" + "\n");
					}
					s.close();
				} catch (IOException ioe){
					JOptionPane.showMessageDialog(UpdateDipendentiPanel.this, "Error in communication with server!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
