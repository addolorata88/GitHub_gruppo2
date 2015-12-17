package it.uniclam.progettoOfficinaMeccanica.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.uniclam.progettoOfficinaMeccanica.*;
public class NavigationPanel extends JPanel {
	
	/*Dichiarazione dei pulsanti necessari all'interfaccia che gestisce le operazione sulla tabella dipendenti*/
	
	private JButton cercaDipendenti = new JButton(ClientGUI.CERCA_DIPENDENTI_PANEL);
	private JButton inserisciDipendenti = new JButton(ClientGUI.INSERISCI_DIPENDENTI_PANEL);
	private JButton updateDipendenti = new JButton(ClientGUI.UPDATE_DIPENDENTI_PANEL);	
	private JButton deleteDipendenti = new JButton(ClientGUI.DELETE_DIPENDENTI_PANEL);	
	private JButton settings = new JButton(ClientGUI.SETTINGS_PANEL);
	private ClientGUI clientGUI = null;
	
	/*Dichiarazione dei pulsanti necessari all'interfaccia che gestisce le operazione sulla tabella scheda_riparazione*/
	
	private JButton inserisciSchedaRiparazione = new JButton(GestioneSchedeGUI.INSERISCI_SCHEDA_PANEL);
	private JButton cercaSchedaRiparazione = new JButton(GestioneSchedeGUI.CERCA_SCHEDA_PANEL);
	private JButton cancellaSchedaRiparazione = new JButton(GestioneSchedeGUI.DELETE_SCHEDA_PANEL);
	private JButton updateSchedaRiparazione = new JButton(GestioneSchedeGUI.UPDATE_SCHEDA_PANEL);
	
	
	private GestioneSchedeGUI gestioneSchedeGUI = null;
	
	/*A questo punto si gestisce la navcigazione fra i pannelli riferiti alle operazioni sui dipendenti*/
	
	public NavigationPanel(ClientGUI clientGUI){
		setLayout(new FlowLayout());
		add(cercaDipendenti);
		add(inserisciDipendenti);
		add(updateDipendenti);
		add(deleteDipendenti);
		add(settings);
		this.clientGUI = clientGUI;
		
		cercaDipendenti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientGUI.changePanel(ClientGUI.CERCA_DIPENDENTI_PANEL);
			}
		});
		
		inserisciDipendenti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientGUI.changePanel(ClientGUI.INSERISCI_DIPENDENTI_PANEL);
			}
		});
		
		updateDipendenti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientGUI.changePanel(ClientGUI.UPDATE_DIPENDENTI_PANEL);
			}
		});

		deleteDipendenti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientGUI.changePanel(ClientGUI.DELETE_DIPENDENTI_PANEL);
			}
		});
		
		settings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientGUI.changePanel(ClientGUI.SETTINGS_PANEL);
			}
		});
	}

	/*A questo punto si gestisce la navigazione fra i pannelli riferiti alle operazioni sulle schede di riparazione*/
	
	public NavigationPanel(GestioneSchedeGUI gestioneSchedeGUI) {
		setLayout(new FlowLayout());
		add(inserisciSchedaRiparazione);
		add(cercaSchedaRiparazione);
		add(cancellaSchedaRiparazione);
		add(updateSchedaRiparazione);
		this.gestioneSchedeGUI = gestioneSchedeGUI;
		
		inserisciSchedaRiparazione.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestioneSchedeGUI.changePanel(GestioneSchedeGUI.INSERISCI_SCHEDA_PANEL);
			}
		});
		
		cercaSchedaRiparazione.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestioneSchedeGUI.changePanel(GestioneSchedeGUI.CERCA_SCHEDA_PANEL);
			}
		});
		
		cancellaSchedaRiparazione.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestioneSchedeGUI.changePanel(GestioneSchedeGUI.DELETE_SCHEDA_PANEL);
			}
		});
		
		updateSchedaRiparazione.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestioneSchedeGUI.changePanel(GestioneSchedeGUI.UPDATE_SCHEDA_PANEL);
			}
		});
	}
}
