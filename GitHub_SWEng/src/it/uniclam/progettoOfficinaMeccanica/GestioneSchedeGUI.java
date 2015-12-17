package it.uniclam.progettoOfficinaMeccanica;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import it.uniclam.progettoOfficinaMeccanica.gui.*;

/*Di seguito è stato sviluppato il codice per il Client che avvia le interfacce che permettono 
 * la gestione della tabella "schede_riparazione" del db creato in MySql, "officina_meccanica". 
 * In seguito all'avvio del Server, si avvia il presente Client e comparirà l'interfaccia 
 * riferita alla tabella "scheda di riparazione"*/

public class GestioneSchedeGUI extends JFrame{
	JPanel lastPanel = null;
	
	public static String INSERISCI_SCHEDA_PANEL = "Inserisci Scheda Rip.";   
	public static String CERCA_SCHEDA_PANEL = "Ricerca Scheda Rip.";
	public static String UPDATE_SCHEDA_PANEL = "Modifica Scheda Rip.";
	public static String DELETE_SCHEDA_PANEL = "Cancella Scheda Rip.";
	
	private CercaSchedaRiparazionePanel cercaSchedaRiparazionePanel;
	private InserisciSchedaRiparazionePanel inserisciSchedaRiparazionePanel;
	private UpdateSchedaRiparazionePanel updateSchedaRiparazionePanel;
	private CancellaSchedaRiparazionePanel cancellaSchedaRiparazionePanel;
	private NavigationPanel navigationPanel;

	public GestioneSchedeGUI(){
		super();
	
		//Creo gli oggetti di tipo Panel per ogni pannello utilizzato
		cercaSchedaRiparazionePanel = new CercaSchedaRiparazionePanel(this);
		inserisciSchedaRiparazionePanel = new InserisciSchedaRiparazionePanel(this);
		updateSchedaRiparazionePanel = new UpdateSchedaRiparazionePanel(this);
		cancellaSchedaRiparazionePanel = new CancellaSchedaRiparazionePanel(this);
		
		//Di dafault uso il Pannello di inserimento
		changePanel(GestioneSchedeGUI.INSERISCI_SCHEDA_PANEL);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(800,600);
	}
	
	//Routine utilizzata per cambio pannello.
	public void changePanel(String panelName){
		getContentPane().removeAll();
		
		if (panelName.equals(GestioneSchedeGUI.INSERISCI_SCHEDA_PANEL)){
			inserisciSchedaRiparazionePanel = new InserisciSchedaRiparazionePanel(this);
			lastPanel = inserisciSchedaRiparazionePanel;
		} else if (panelName.equals(GestioneSchedeGUI.CERCA_SCHEDA_PANEL)){
			cercaSchedaRiparazionePanel = new CercaSchedaRiparazionePanel(this);
			lastPanel = cercaSchedaRiparazionePanel;
		} else if (panelName.equals(GestioneSchedeGUI.UPDATE_SCHEDA_PANEL)){
			updateSchedaRiparazionePanel = new UpdateSchedaRiparazionePanel(this);
			lastPanel = updateSchedaRiparazionePanel;
		} else if (panelName.equals(GestioneSchedeGUI.DELETE_SCHEDA_PANEL)){
			cancellaSchedaRiparazionePanel = new CancellaSchedaRiparazionePanel(this);
			lastPanel = cancellaSchedaRiparazionePanel;
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
            	GestioneSchedeGUI frame = new GestioneSchedeGUI();
            }
        });
	}
}
