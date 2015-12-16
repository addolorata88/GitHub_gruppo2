package it.uniclam.progettoOfficinaMeccanica;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import it.uniclam.progettoOfficinaMeccanica.gui.*;

/*Di seguito è stato sviluppato il codice per il Client che avvia le interfacce che permettono 
 * la gestione della tabella "meccanico" del db creato in MySql, "officina_meccanica". 
 * In seguito all'avvio del Server, si avvia il presente Client e comparirà l'interfaccia 
 * riferita alla tabella "meccanico"*/

public class ClientGUI extends JFrame{
	JPanel lastPanel = null;

	public static String CERCA_DIPENDENTI_PANEL = "Cerca Dipendenti";
	public static String INSERISCI_DIPENDENTI_PANEL = "Inserisci Dipendenti";
	public static String UPDATE_DIPENDENTI_PANEL = "Modifica Dipendenti";
	public static String DELETE_DIPENDENTI_PANEL = "Cancella Dipendenti";
	public static String SETTINGS_PANEL = "Settings";

	private CercaDipendentiPanel cercaDipendentiPanel;
	private InserisciDipendentiPanel inserisciDipendentiPanel;
	private UpdateDipendentiPanel updateDipendentiPanel;
	private DeleteDipendentiPanel deleteDipendentiPanel;
	private NavigationPanel navigationPanel;
	private SettingsPanel settingsPanel;

	public ClientGUI(){
		super();

		cercaDipendentiPanel = new CercaDipendentiPanel(this);
		inserisciDipendentiPanel = new InserisciDipendentiPanel(this);
		updateDipendentiPanel = new UpdateDipendentiPanel(this);
		deleteDipendentiPanel = new DeleteDipendentiPanel(this);
		navigationPanel = new NavigationPanel(this);
		settingsPanel = new SettingsPanel(this);

		changePanel(ClientGUI.CERCA_DIPENDENTI_PANEL);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(800,600);		//aggiunto 04-12-2015
	}

	public void changePanel(String panelName){
		getContentPane().removeAll();

		if (panelName.equals(ClientGUI.CERCA_DIPENDENTI_PANEL)){
			cercaDipendentiPanel = new CercaDipendentiPanel(this);
			lastPanel = cercaDipendentiPanel;
		} else if (panelName.equals(ClientGUI.INSERISCI_DIPENDENTI_PANEL)){
			inserisciDipendentiPanel = new InserisciDipendentiPanel(this);
			lastPanel = inserisciDipendentiPanel;
		} else if (panelName.equals(ClientGUI.UPDATE_DIPENDENTI_PANEL)){
			updateDipendentiPanel = new UpdateDipendentiPanel(this);
			lastPanel = updateDipendentiPanel;
		} else if (panelName.equals(ClientGUI.DELETE_DIPENDENTI_PANEL)){
			deleteDipendentiPanel = new DeleteDipendentiPanel(this);
			lastPanel = deleteDipendentiPanel;
		} else if (panelName.equals(ClientGUI.SETTINGS_PANEL)){
			settingsPanel = new SettingsPanel(this);
			lastPanel = settingsPanel;
		}

		navigationPanel = new NavigationPanel(this);

		getContentPane().add(lastPanel, BorderLayout.CENTER);
		getContentPane().add(navigationPanel, BorderLayout.SOUTH);

		getContentPane().revalidate();

	}	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		/* Turn off metal's use of bold fonts */
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		//Schedule a job for the event dispatch thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ClientGUI frame = new ClientGUI();
			}
		});
	}
}
