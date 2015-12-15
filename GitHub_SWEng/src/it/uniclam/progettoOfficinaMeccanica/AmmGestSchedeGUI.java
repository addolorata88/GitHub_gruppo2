package it.uniclam.progettoOfficinaMeccanica;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import it.uniclam.progettoOfficinaMeccanica.gui.*;

/*Di seguito � stato sviluppato il codice per il Client che avvia le interfacce che permettono 
 * la gestione della tabella "schede_riparazione" del db creato in MySql, "officina_meccanica". 
 * In seguito all'avvio del Server, si avvia il presente Client e comparir� l'interfaccia 
 * riferita alla tabella "scheda di riparazione"*/

public class AmmGestSchedeGUI extends JFrame{
	JPanel lastPanel = null;
	
	public static String INSERISCI_SCHEDA_PANEL = "Inserisci Scheda Rip.";   
	public static String CERCA_SCHEDA_PANEL = "Ricerca Scheda Rip.";
	public static String UPDATE_SCHEDA_PANEL = "Modifica Scheda Rip.";
	
	private CercaSchedaRiparazionePanel cercaSchedaRiparazionePanel;
	private InserisciSchedaRiparazionePanel inserisciSchedaRiparazionePanel;
	//private UpdateSchedaRiparazionePanel updateSchedaRiparazionePanel;
	private NavigationPanel navigationPanel;

	public AmmGestSchedeGUI(){
		super();
	
		cercaSchedaRiparazionePanel = new CercaSchedaRiparazionePanel(this);
		inserisciSchedaRiparazionePanel = new InserisciSchedaRiparazionePanel(this);
		//updateSchedaRiparazionePanel = new UpdateSchedaRiparazionePanel(this);
		
		changePanel(AmmGestSchedeGUI.INSERISCI_SCHEDA_PANEL);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		setSize(800,600);
	}
	
	public void changePanel(String panelName){
		getContentPane().removeAll();
		
		if (panelName.equals(AmmGestSchedeGUI.INSERISCI_SCHEDA_PANEL)){
			inserisciSchedaRiparazionePanel = new InserisciSchedaRiparazionePanel(this);
			lastPanel = inserisciSchedaRiparazionePanel;
		} else if (panelName.equals(AmmGestSchedeGUI.CERCA_SCHEDA_PANEL)){
			cercaSchedaRiparazionePanel = new CercaSchedaRiparazionePanel(this);
			lastPanel = cercaSchedaRiparazionePanel;
		} /*else if (panelName.equals(AmmGestSchedeGUI.UPDATE_SCHEDA_PANEL)){
			updateSchedaRipPanel = new UpdateSchedaRipPanel(this);
			lastPanel = updateSchedaRiparazionePanel;
		}*/
		
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
            	AmmGestSchedeGUI frame = new AmmGestSchedeGUI();
            }
        });
	}
}
