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

import it.uniclam.progettoOfficinaMeccanica.*;
import it.uniclam.progettoOfficinaMeccanica.interfaces.getDataPanel;

/*In questa parte del programma si � creata l'interfaccia vera e propria del pannello. 
 * In particolare da qui � possibile, utilizzando opportune query, richiedere la 
 * restituzione dei dati relativi a un dato intervento di riparazione, presente all'interno 
 * della tabella "scheda_riparazione". Ovviamente a questo scopo si � provveduto a 
 * introdurre un campo di testo per ognuno degli attributi della tabella*/


public class CercaSchedaRiparazionePanel extends JPanel {
	private JTextField marca_veicolo			= new JTextField("", 20);
	private JTextField modello_veicolo			= new JTextField("", 20);
	private JTextField data_entrata				= new JTextField("", 20);
	private JTextField data_immatricolazione	= new JTextField("", 20);
	private JTextField descrizione_intervento	= new JTextField("", 20);
	private JTextField data_evasione			= new JTextField("", 20);
	private JTextField nome_cliente				= new JTextField("", 20);
	private JTextField cognome_cliente			= new JTextField("", 20);
	private JTextField tel_cliente				= new JTextField("", 20);
	private JTextField email_cliente			= new JTextField("", 20);
	private JTextField id_meccanico				= new JTextField("1", 20);

	private JButton cerca = new JButton("Cerca");//Pulsante che permette di avviare 
	//l'operazione di ricerca dei valori 
	//all'interno della tabella
	private JButton clear = new JButton("Clear");//Pulsante che ha la funzionalit� di 'pulire' 
	//la textArea di seguito definita

	private JTextArea ta = new JTextArea(12, 12);//In questa parte del pannello verr� visualizzato 
	//l'eventuale esito positivo dell'operazione 
	//appena effettuata, o, in caso contrario, 
	//il corrispondente messaggio di errore.

	public CercaSchedaRiparazionePanel(GestioneSchedeGUI ammGestSchedeGUI){ 

		// Definisci un oggetto gridbagconstraints per la specifica 
		// dei vincoli dell'interfaccia
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());

		// Campo marca_veicolo
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		this.add(new JLabel("marca_veicolo:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		this.add(marca_veicolo, c);

		// Campo modello_veicolo
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		this.add(new JLabel("modello_veicolo:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		this.add(modello_veicolo, c);

		// Campo data_entrata
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		this.add(new JLabel("data_entrata:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		this.add(data_entrata, c);

		// Campo data_immatricolazione
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		this.add(new JLabel("data_immatricolazione:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		this.add(data_immatricolazione, c);

		// Campo descrizione_intervento
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		this.add(new JLabel("descrizione_intervento:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		this.add(descrizione_intervento, c);

		// Campo data_evasione
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		this.add(new JLabel("data_evasione:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 5;
		this.add(data_evasione, c);

		// Campo nome_cliente
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		this.add(new JLabel("nome_cliente:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 6;
		this.add(nome_cliente, c);

		// Campo cognome_cliente
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 7;
		this.add(new JLabel("cognome_cliente:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 7;
		this.add(cognome_cliente, c);


		// Campo tel_cliente
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 8;
		this.add(new JLabel("tel_cliente:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 8;
		this.add(tel_cliente, c);

		// Campo emeil_cliente
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 9;
		this.add(new JLabel("email_cliente:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 9;
		this.add(email_cliente, c);

		// Campo id_meccanico
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 10;
		this.add(new JLabel("id_meccanico:"), c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 10;
		this.add(id_meccanico, c);
		// Campo cerca
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 11;
		c.gridwidth = 4;   //2 columns wide
		this.add(cerca, c);

		// Campo clear
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 11;
		c.gridwidth = 4;   //2 columns wide
		this.add(clear, c);

		// Campo risposta (label)
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 12;
		c.gridwidth = 4;   //2 columns wide
		this.add(new JLabel("Risposta:"), c);

		// Campo risposta text area
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 	12;
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

					/*Viene adesso riportata la query sql che che avvier� la 
					 * ricerca dei dati desiderati all'interno della tabella*/

					String req = Server.QUERY_SCHEDA + "\n" + 
							"marca_veicolo:" + marca_veicolo.getText() + "\n" +
							"modello_veicolo:" + modello_veicolo.getText() + "\n" +
							"data_entrata:" + data_entrata.getText() + "\n" +
							"data_immatricolazione:" + data_immatricolazione.getText() + "\n" +
							"descrizione_intervento:" + descrizione_intervento.getText() + "\n" +
							"data_evasione:" + data_evasione.getText() + "\n" +
							"nome_cliente:" + nome_cliente.getText() + "\n" +
							"cognome_cliente:" + cognome_cliente.getText() + "\n" +
							"tel_cliente:" + tel_cliente.getText() + "\n" +
							"email_cliente:" + email_cliente.getText() + "\n" +
							"id_meccanico:" + id_meccanico.getText() + "\n" + 
							"\n";

					out.println(req);
					System.out.println("DEBUG: req Inviata: " + req);
					String line = in.readLine();
					if (line.equalsIgnoreCase(Server.OK)){
						line = in.readLine();
						while(line.length() > 0){
							ta.append(line + "\n");
							line = in.readLine();
						}
						ta.append("\n");
					} else {
						ta.append("RICERCA SCHEDA: Si � verificato un errore nel server!" + "\n");
					}
					s.close();
				} catch (IOException ioe){
					JOptionPane.showMessageDialog(CercaSchedaRiparazionePanel.this, "CercaSchedaRiparazione: Error in communication with server!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
