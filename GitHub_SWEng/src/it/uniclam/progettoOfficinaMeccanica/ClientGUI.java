package it.uniclam.progettoOfficinaMeccanica;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import it.uniclam.progettoOfficinaMeccanica.gui.*;

public class ClientGUI extends JFrame{
	JPanel lastPanel = null;
	
	public static String CERCA_DIPENDENTI_PANEL = "Cerca Dipendenti";
	public static String INSERISCI_DIPENDENTI_PANEL = "Inserisci Dipendenti";
	public static String UPDATE_DIPENDENTI_PANEL = "Modifica Dipendenti";
	public static String SETTINGS_PANEL = "Settings";
	
	private CercaDipendentiPanel CercaDipendentiPanel;
	private InserisciDipendentiPanel InserisciDipendentiPanel;
	private UpdateDipendentiPanel UpdateDipendentiPanel;
	private NavigationPanel navigationPanel;
	private SettingsPanel settingsPanel;

	public ClientGUI(){
		super();
	
		CercaDipendentiPanel = new CercaDipendentiPanel(this);
		InserisciDipendentiPanel = new InserisciDipendentiPanel(this);
		UpdateDipendentiPanel = new UpdateDipendentiPanel(this);
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
			CercaDipendentiPanel = new CercaDipendentiPanel(this);
			lastPanel = CercaDipendentiPanel;
		} else if (panelName.equals(ClientGUI.INSERISCI_DIPENDENTI_PANEL)){
			InserisciDipendentiPanel = new InserisciDipendentiPanel(this);
			lastPanel = InserisciDipendentiPanel;
		} else if (panelName.equals(ClientGUI.UPDATE_DIPENDENTI_PANEL)){
			UpdateDipendentiPanel = new UpdateDipendentiPanel(this);
			lastPanel = UpdateDipendentiPanel;
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
